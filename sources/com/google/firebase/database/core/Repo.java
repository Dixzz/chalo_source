package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.EventRaiser;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Repo implements PersistentConnection.Delegate {
    private static final String INTERRUPT_REASON = "repo_interrupt";
    private static final int TRANSACTION_MAX_RETRIES = 25;
    private static final String TRANSACTION_OVERRIDE_BY_SET = "overriddenBySet";
    private static final String TRANSACTION_TOO_MANY_RETRIES = "maxretries";
    private PersistentConnection connection;
    private final Context ctx;
    private final LogWrapper dataLogger;
    public long dataUpdateCount = 0;
    private FirebaseDatabase database;
    private final EventRaiser eventRaiser;
    private boolean hijackHash = false;
    private SnapshotHolder infoData;
    private SyncTree infoSyncTree;
    private boolean loggedTransactionPersistenceWarning = false;
    private long nextWriteId = 1;
    private SparseSnapshotTree onDisconnect;
    private final LogWrapper operationLogger;
    private final RepoInfo repoInfo;
    private final OffsetClock serverClock = new OffsetClock(new DefaultClock(), 0);
    private SyncTree serverSyncTree;
    private final LogWrapper transactionLogger;
    private long transactionOrder = 0;
    private Tree<List<TransactionData>> transactionQueueTree;

    public static class TransactionData implements Comparable<TransactionData> {
        private DatabaseError abortReason;
        private boolean applyLocally;
        private Node currentInputSnapshot;
        private Node currentOutputSnapshotRaw;
        private Node currentOutputSnapshotResolved;
        private long currentWriteId;
        private Transaction.Handler handler;
        private long order;
        private ValueEventListener outstandingListener;
        private Path path;
        private int retryCount;
        private TransactionStatus status;

        public static /* synthetic */ int access$2008(TransactionData transactionData) {
            int i = transactionData.retryCount;
            transactionData.retryCount = i + 1;
            return i;
        }

        private TransactionData(Path path2, Transaction.Handler handler2, ValueEventListener valueEventListener, TransactionStatus transactionStatus, boolean z, long j) {
            this.path = path2;
            this.handler = handler2;
            this.outstandingListener = valueEventListener;
            this.status = transactionStatus;
            this.retryCount = 0;
            this.applyLocally = z;
            this.order = j;
            this.abortReason = null;
            this.currentInputSnapshot = null;
            this.currentOutputSnapshotRaw = null;
            this.currentOutputSnapshotResolved = null;
        }

        public int compareTo(TransactionData transactionData) {
            long j = this.order;
            long j2 = transactionData.order;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    public enum TransactionStatus {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    public Repo(RepoInfo repoInfo2, Context context, FirebaseDatabase firebaseDatabase) {
        this.repoInfo = repoInfo2;
        this.ctx = context;
        this.database = firebaseDatabase;
        this.operationLogger = context.getLogger("RepoOperation");
        this.transactionLogger = context.getLogger("Transaction");
        this.dataLogger = context.getLogger("DataOperation");
        this.eventRaiser = new EventRaiser(context);
        scheduleNow(new Runnable() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass1 */

            public void run() {
                Repo.this.deferredInitialization();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Path abortTransactions(Path path, final int i) {
        Path path2 = getAncestorTransactionNode(path).getPath();
        if (this.transactionLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("Aborting transactions for path: " + path + ". Affected: " + path2, new Object[0]);
        }
        Tree<List<TransactionData>> subTree = this.transactionQueueTree.subTree(path);
        subTree.forEachAncestor(new Tree.TreeFilter<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass21 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeFilter
            public boolean filterTreeNode(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, i);
                return false;
            }
        });
        abortTransactionsAtNode(subTree, i);
        subTree.forEachDescendant(new Tree.TreeVisitor<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass22 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, i);
            }
        });
        return path2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void abortTransactionsAtNode(Tree<List<TransactionData>> tree, int i) {
        final DatabaseError databaseError;
        List<TransactionData> value = tree.getValue();
        ArrayList arrayList = new ArrayList();
        if (value != null) {
            ArrayList arrayList2 = new ArrayList();
            if (i == -9) {
                databaseError = DatabaseError.fromStatus(TRANSACTION_OVERRIDE_BY_SET);
            } else {
                boolean z = i == -25;
                Utilities.hardAssert(z, "Unknown transaction abort reason: " + i);
                databaseError = DatabaseError.fromCode(-25);
            }
            int i2 = -1;
            for (int i3 = 0; i3 < value.size(); i3++) {
                final TransactionData transactionData = value.get(i3);
                TransactionStatus transactionStatus = transactionData.status;
                TransactionStatus transactionStatus2 = TransactionStatus.SENT_NEEDS_ABORT;
                if (transactionStatus != transactionStatus2) {
                    if (transactionData.status == TransactionStatus.SENT) {
                        Utilities.hardAssert(i2 == i3 + -1);
                        transactionData.status = transactionStatus2;
                        transactionData.abortReason = databaseError;
                        i2 = i3;
                    } else {
                        Utilities.hardAssert(transactionData.status == TransactionStatus.RUN);
                        removeEventCallback(new ValueEventRegistration(this, transactionData.outstandingListener, QuerySpec.defaultQueryAtPath(transactionData.path)));
                        if (i == -9) {
                            arrayList.addAll(this.serverSyncTree.ackUserWrite(transactionData.currentWriteId, true, false, this.serverClock));
                        } else {
                            boolean z2 = i == -25;
                            Utilities.hardAssert(z2, "Unknown transaction abort reason: " + i);
                        }
                        arrayList2.add(new Runnable() {
                            /* class com.google.firebase.database.core.Repo.AnonymousClass23 */

                            public void run() {
                                transactionData.handler.onComplete(databaseError, false, null);
                            }
                        });
                    }
                }
            }
            if (i2 == -1) {
                tree.setValue(null);
            } else {
                tree.setValue(value.subList(0, i2 + 1));
            }
            postEvents(arrayList);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                postEvent((Runnable) it.next());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ackWriteAndRerunTransactions(long j, Path path, DatabaseError databaseError) {
        if (databaseError == null || databaseError.getCode() != -25) {
            List<? extends Event> ackUserWrite = this.serverSyncTree.ackUserWrite(j, !(databaseError == null), true, this.serverClock);
            if (ackUserWrite.size() > 0) {
                rerunTransactions(path);
            }
            postEvents(ackUserWrite);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void aggregateTransactionQueues(final List<TransactionData> list, Tree<List<TransactionData>> tree) {
        List<TransactionData> value = tree.getValue();
        if (value != null) {
            list.addAll(value);
        }
        tree.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass20 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.aggregateTransactionQueues(list, tree);
            }
        });
    }

    private List<TransactionData> buildTransactionQueue(Tree<List<TransactionData>> tree) {
        ArrayList arrayList = new ArrayList();
        aggregateTransactionQueues(arrayList, tree);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void deferredInitialization() {
        RepoInfo repoInfo2 = this.repoInfo;
        this.connection = this.ctx.newPersistentConnection(new HostInfo(repoInfo2.host, repoInfo2.namespace, repoInfo2.secure), this);
        this.ctx.getAuthTokenProvider().addTokenChangeListener(((DefaultRunLoop) this.ctx.getRunLoop()).getExecutorService(), new AuthTokenProvider.TokenChangeListener() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass2 */

            @Override // com.google.firebase.database.core.AuthTokenProvider.TokenChangeListener
            public void onTokenChange() {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken();
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider.TokenChangeListener
            public void onTokenChange(String str) {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken(str);
            }
        });
        this.connection.initialize();
        PersistenceManager persistenceManager = this.ctx.getPersistenceManager(this.repoInfo.host);
        this.infoData = new SnapshotHolder();
        this.onDisconnect = new SparseSnapshotTree();
        this.transactionQueueTree = new Tree<>();
        this.infoSyncTree = new SyncTree(this.ctx, new NoopPersistenceManager(), new SyncTree.ListenProvider() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass3 */

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void startListening(final QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, final SyncTree.CompletionListener completionListener) {
                Repo.this.scheduleNow(new Runnable() {
                    /* class com.google.firebase.database.core.Repo.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        Node node = Repo.this.infoData.getNode(querySpec.getPath());
                        if (!node.isEmpty()) {
                            Repo.this.postEvents(Repo.this.infoSyncTree.applyServerOverwrite(querySpec.getPath(), node));
                            completionListener.onListenComplete(null);
                        }
                    }
                });
            }

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void stopListening(QuerySpec querySpec, Tag tag) {
            }
        });
        this.serverSyncTree = new SyncTree(this.ctx, persistenceManager, new SyncTree.ListenProvider() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass4 */

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void startListening(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, final SyncTree.CompletionListener completionListener) {
                Repo.this.connection.listen(querySpec.getPath().asList(), querySpec.getParams().getWireProtocolParams(), listenHashProvider, tag != null ? Long.valueOf(tag.getTagNumber()) : null, new RequestResultCallback() {
                    /* class com.google.firebase.database.core.Repo.AnonymousClass4.AnonymousClass1 */

                    @Override // com.google.firebase.database.connection.RequestResultCallback
                    public void onRequestResult(String str, String str2) {
                        Repo.this.postEvents(completionListener.onListenComplete(Repo.fromErrorCode(str, str2)));
                    }
                });
            }

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void stopListening(QuerySpec querySpec, Tag tag) {
                Repo.this.connection.unlisten(querySpec.getPath().asList(), querySpec.getParams().getWireProtocolParams());
            }
        });
        restoreWrites(persistenceManager);
        ChildKey childKey = Constants.DOT_INFO_AUTHENTICATED;
        Boolean bool = Boolean.FALSE;
        updateInfo(childKey, bool);
        updateInfo(Constants.DOT_INFO_CONNECTED, bool);
    }

    /* access modifiers changed from: private */
    public static DatabaseError fromErrorCode(String str, String str2) {
        if (str != null) {
            return DatabaseError.fromStatus(str, str2);
        }
        return null;
    }

    private Tree<List<TransactionData>> getAncestorTransactionNode(Path path) {
        Tree<List<TransactionData>> tree = this.transactionQueueTree;
        while (!path.isEmpty() && tree.getValue() == null) {
            tree = tree.subTree(new Path(path.getFront()));
            path = path.popFront();
        }
        return tree;
    }

    private Node getLatestState(Path path) {
        return getLatestState(path, new ArrayList());
    }

    private long getNextWriteId() {
        long j = this.nextWriteId;
        this.nextWriteId = 1 + j;
        return j;
    }

    private long nextTransactionOrder() {
        long j = this.transactionOrder;
        this.transactionOrder = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void postEvents(List<? extends Event> list) {
        if (!list.isEmpty()) {
            this.eventRaiser.raiseEvents(list);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pruneCompletedTransactions(Tree<List<TransactionData>> tree) {
        List<TransactionData> value = tree.getValue();
        if (value != null) {
            int i = 0;
            while (i < value.size()) {
                if (value.get(i).status == TransactionStatus.COMPLETED) {
                    value.remove(i);
                } else {
                    i++;
                }
            }
            if (value.size() > 0) {
                tree.setValue(value);
            } else {
                tree.setValue(null);
            }
        }
        tree.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass17 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.pruneCompletedTransactions(tree);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0033 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void rerunTransactionQueue(java.util.List<com.google.firebase.database.core.Repo.TransactionData> r23, com.google.firebase.database.core.Path r24) {
        /*
        // Method dump skipped, instructions count: 411
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.Repo.rerunTransactionQueue(java.util.List, com.google.firebase.database.core.Path):void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Path rerunTransactions(Path path) {
        Tree<List<TransactionData>> ancestorTransactionNode = getAncestorTransactionNode(path);
        Path path2 = ancestorTransactionNode.getPath();
        rerunTransactionQueue(buildTransactionQueue(ancestorTransactionNode), path2);
        return path2;
    }

    private void restoreWrites(PersistenceManager persistenceManager) {
        List<UserWriteRecord> loadUserWrites = persistenceManager.loadUserWrites();
        Map<String, Object> generateServerValues = ServerValues.generateServerValues(this.serverClock);
        long j = Long.MIN_VALUE;
        for (final UserWriteRecord userWriteRecord : loadUserWrites) {
            AnonymousClass5 r6 = new RequestResultCallback() {
                /* class com.google.firebase.database.core.Repo.AnonymousClass5 */

                @Override // com.google.firebase.database.connection.RequestResultCallback
                public void onRequestResult(String str, String str2) {
                    DatabaseError fromErrorCode = Repo.fromErrorCode(str, str2);
                    Repo.this.warnIfWriteFailed("Persisted write", userWriteRecord.getPath(), fromErrorCode);
                    Repo.this.ackWriteAndRerunTransactions(userWriteRecord.getWriteId(), userWriteRecord.getPath(), fromErrorCode);
                }
            };
            if (j < userWriteRecord.getWriteId()) {
                j = userWriteRecord.getWriteId();
                this.nextWriteId = userWriteRecord.getWriteId() + 1;
                if (userWriteRecord.isOverwrite()) {
                    if (this.operationLogger.logsDebug()) {
                        LogWrapper logWrapper = this.operationLogger;
                        StringBuilder i0 = hj1.i0("Restoring overwrite with id ");
                        i0.append(userWriteRecord.getWriteId());
                        logWrapper.debug(i0.toString(), new Object[0]);
                    }
                    this.connection.put(userWriteRecord.getPath().asList(), userWriteRecord.getOverwrite().getValue(true), r6);
                    this.serverSyncTree.applyUserOverwrite(userWriteRecord.getPath(), userWriteRecord.getOverwrite(), ServerValues.resolveDeferredValueSnapshot(userWriteRecord.getOverwrite(), this.serverSyncTree, userWriteRecord.getPath(), generateServerValues), userWriteRecord.getWriteId(), true, false);
                } else {
                    if (this.operationLogger.logsDebug()) {
                        LogWrapper logWrapper2 = this.operationLogger;
                        StringBuilder i02 = hj1.i0("Restoring merge with id ");
                        i02.append(userWriteRecord.getWriteId());
                        logWrapper2.debug(i02.toString(), new Object[0]);
                    }
                    this.connection.merge(userWriteRecord.getPath().asList(), userWriteRecord.getMerge().getValue(true), r6);
                    this.serverSyncTree.applyUserMerge(userWriteRecord.getPath(), userWriteRecord.getMerge(), ServerValues.resolveDeferredValueMerge(userWriteRecord.getMerge(), this.serverSyncTree, userWriteRecord.getPath(), generateServerValues), userWriteRecord.getWriteId(), false);
                }
            } else {
                throw new IllegalStateException("Write ids were not in order.");
            }
        }
    }

    private void runOnDisconnectEvents() {
        final Map<String, Object> generateServerValues = ServerValues.generateServerValues(this.serverClock);
        final ArrayList arrayList = new ArrayList();
        this.onDisconnect.forEachTree(Path.getEmptyPath(), new SparseSnapshotTree.SparseSnapshotTreeVisitor() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass12 */

            @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor
            public void visitTree(Path path, Node node) {
                arrayList.addAll(Repo.this.serverSyncTree.applyServerOverwrite(path, ServerValues.resolveDeferredValueSnapshot(node, Repo.this.serverSyncTree.calcCompleteEventCache(path, new ArrayList()), generateServerValues)));
                Repo.this.rerunTransactions(Repo.this.abortTransactions(path, -9));
            }
        });
        this.onDisconnect = new SparseSnapshotTree();
        postEvents(arrayList);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendAllReadyTransactions() {
        Tree<List<TransactionData>> tree = this.transactionQueueTree;
        pruneCompletedTransactions(tree);
        sendReadyTransactions(tree);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendReadyTransactions(Tree<List<TransactionData>> tree) {
        if (tree.getValue() != null) {
            List<TransactionData> buildTransactionQueue = buildTransactionQueue(tree);
            Utilities.hardAssert(buildTransactionQueue.size() > 0);
            Boolean bool = Boolean.TRUE;
            Iterator<TransactionData> it = buildTransactionQueue.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().status != TransactionStatus.RUN) {
                        bool = Boolean.FALSE;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (bool.booleanValue()) {
                sendTransactionQueue(buildTransactionQueue, tree.getPath());
            }
        } else if (tree.hasChildren()) {
            tree.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
                /* class com.google.firebase.database.core.Repo.AnonymousClass15 */

                @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
                public void visitTree(Tree<List<TransactionData>> tree) {
                    Repo.this.sendReadyTransactions(tree);
                }
            });
        }
    }

    private void sendTransactionQueue(final List<TransactionData> list, final Path path) {
        ArrayList arrayList = new ArrayList();
        for (TransactionData transactionData : list) {
            arrayList.add(Long.valueOf(transactionData.currentWriteId));
        }
        Node latestState = getLatestState(path, arrayList);
        String hash = !this.hijackHash ? latestState.getHash() : "badhash";
        Iterator<TransactionData> it = list.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                TransactionData next = it.next();
                if (next.status != TransactionStatus.RUN) {
                    z = false;
                }
                Utilities.hardAssert(z);
                next.status = TransactionStatus.SENT;
                TransactionData.access$2008(next);
                latestState = latestState.updateChild(Path.getRelative(path, next.path), next.currentOutputSnapshotRaw);
            } else {
                this.connection.compareAndPut(path.asList(), latestState.getValue(true), hash, new RequestResultCallback() {
                    /* class com.google.firebase.database.core.Repo.AnonymousClass16 */

                    @Override // com.google.firebase.database.connection.RequestResultCallback
                    public void onRequestResult(String str, String str2) {
                        DatabaseError fromErrorCode = Repo.fromErrorCode(str, str2);
                        Repo.this.warnIfWriteFailed("Transaction", path, fromErrorCode);
                        ArrayList arrayList = new ArrayList();
                        if (fromErrorCode == null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (final TransactionData transactionData : list) {
                                transactionData.status = TransactionStatus.COMPLETED;
                                arrayList.addAll(Repo.this.serverSyncTree.ackUserWrite(transactionData.currentWriteId, false, false, Repo.this.serverClock));
                                final DataSnapshot createDataSnapshot = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this, transactionData.path), IndexedNode.from(transactionData.currentOutputSnapshotResolved));
                                arrayList2.add(new Runnable() {
                                    /* class com.google.firebase.database.core.Repo.AnonymousClass16.AnonymousClass1 */

                                    public void run() {
                                        transactionData.handler.onComplete(null, true, createDataSnapshot);
                                    }
                                });
                                Repo repo = Repo.this;
                                repo.removeEventCallback(new ValueEventRegistration(repo, transactionData.outstandingListener, QuerySpec.defaultQueryAtPath(transactionData.path)));
                            }
                            Repo repo2 = Repo.this;
                            repo2.pruneCompletedTransactions(repo2.transactionQueueTree.subTree(path));
                            Repo.this.sendAllReadyTransactions();
                            this.postEvents(arrayList);
                            for (int i = 0; i < arrayList2.size(); i++) {
                                Repo.this.postEvent((Runnable) arrayList2.get(i));
                            }
                            return;
                        }
                        if (fromErrorCode.getCode() == -1) {
                            for (TransactionData transactionData2 : list) {
                                if (transactionData2.status == TransactionStatus.SENT_NEEDS_ABORT) {
                                    transactionData2.status = TransactionStatus.NEEDS_ABORT;
                                } else {
                                    transactionData2.status = TransactionStatus.RUN;
                                }
                            }
                        } else {
                            for (TransactionData transactionData3 : list) {
                                transactionData3.status = TransactionStatus.NEEDS_ABORT;
                                transactionData3.abortReason = fromErrorCode;
                            }
                        }
                        Repo.this.rerunTransactions(path);
                    }
                });
                return;
            }
        }
    }

    private void updateInfo(ChildKey childKey, Object obj) {
        if (childKey.equals(Constants.DOT_INFO_SERVERTIME_OFFSET)) {
            this.serverClock.setOffset(((Long) obj).longValue());
        }
        Path path = new Path(Constants.DOT_INFO, childKey);
        try {
            Node NodeFromJSON = NodeUtilities.NodeFromJSON(obj);
            this.infoData.update(path, NodeFromJSON);
            postEvents(this.infoSyncTree.applyServerOverwrite(path, NodeFromJSON));
        } catch (DatabaseException e) {
            this.operationLogger.error("Failed to parse info update", e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void warnIfWriteFailed(String str, Path path, DatabaseError databaseError) {
        if (databaseError != null && databaseError.getCode() != -1 && databaseError.getCode() != -25) {
            LogWrapper logWrapper = this.operationLogger;
            StringBuilder k0 = hj1.k0(str, " at ");
            k0.append(path.toString());
            k0.append(" failed: ");
            k0.append(databaseError.toString());
            logWrapper.warn(k0.toString());
        }
    }

    public void addEventCallback(@NotNull EventRegistration eventRegistration) {
        List<? extends Event> list;
        ChildKey front = eventRegistration.getQuerySpec().getPath().getFront();
        if (front == null || !front.equals(Constants.DOT_INFO)) {
            list = this.serverSyncTree.addEventRegistration(eventRegistration);
        } else {
            list = this.infoSyncTree.addEventRegistration(eventRegistration);
        }
        postEvents(list);
    }

    public void callOnComplete(final DatabaseReference.CompletionListener completionListener, final DatabaseError databaseError, Path path) {
        final DatabaseReference databaseReference;
        if (completionListener != null) {
            ChildKey back = path.getBack();
            if (back == null || !back.isPriorityChildName()) {
                databaseReference = InternalHelpers.createReference(this, path);
            } else {
                databaseReference = InternalHelpers.createReference(this, path.getParent());
            }
            postEvent(new Runnable() {
                /* class com.google.firebase.database.core.Repo.AnonymousClass6 */

                public void run() {
                    completionListener.onComplete(databaseError, databaseReference);
                }
            });
        }
    }

    public PersistentConnection getConnection() {
        return this.connection;
    }

    public FirebaseDatabase getDatabase() {
        return this.database;
    }

    public SyncTree getInfoSyncTree() {
        return this.infoSyncTree;
    }

    public RepoInfo getRepoInfo() {
        return this.repoInfo;
    }

    public SyncTree getServerSyncTree() {
        return this.serverSyncTree;
    }

    public long getServerTime() {
        return this.serverClock.millis();
    }

    public boolean hasListeners() {
        return !this.infoSyncTree.isEmpty() || !this.serverSyncTree.isEmpty();
    }

    public void interrupt() {
        this.connection.interrupt(INTERRUPT_REASON);
    }

    public void keepSynced(QuerySpec querySpec, boolean z) {
        Utilities.hardAssert(querySpec.getPath().isEmpty() || !querySpec.getPath().getFront().equals(Constants.DOT_INFO));
        this.serverSyncTree.keepSynced(querySpec, z);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onAuthStatus(boolean z) {
        onServerInfoUpdate(Constants.DOT_INFO_AUTHENTICATED, Boolean.valueOf(z));
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onConnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, Boolean.TRUE);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onDataUpdate(List<String> list, Object obj, boolean z, Long l) {
        List<? extends Event> list2;
        Path path = new Path(list);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path + " " + obj, new Object[0]);
        }
        this.dataUpdateCount++;
        if (l != null) {
            try {
                Tag tag = new Tag(l.longValue());
                if (z) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new Path((String) entry.getKey()), NodeUtilities.NodeFromJSON(entry.getValue()));
                    }
                    list2 = this.serverSyncTree.applyTaggedQueryMerge(path, hashMap, tag);
                } else {
                    list2 = this.serverSyncTree.applyTaggedQueryOverwrite(path, NodeUtilities.NodeFromJSON(obj), tag);
                }
            } catch (DatabaseException e) {
                this.operationLogger.error("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new Path((String) entry2.getKey()), NodeUtilities.NodeFromJSON(entry2.getValue()));
            }
            list2 = this.serverSyncTree.applyServerMerge(path, hashMap2);
        } else {
            list2 = this.serverSyncTree.applyServerOverwrite(path, NodeUtilities.NodeFromJSON(obj));
        }
        if (list2.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(list2);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onDisconnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, Boolean.FALSE);
        runOnDisconnectEvents();
    }

    public void onDisconnectCancel(final Path path, final DatabaseReference.CompletionListener completionListener) {
        this.connection.onDisconnectCancel(path.asList(), new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass11 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String str, String str2) {
                DatabaseError fromErrorCode = Repo.fromErrorCode(str, str2);
                if (fromErrorCode == null) {
                    Repo.this.onDisconnect.forget(path);
                }
                Repo.this.callOnComplete(completionListener, fromErrorCode, path);
            }
        });
    }

    public void onDisconnectSetValue(final Path path, final Node node, final DatabaseReference.CompletionListener completionListener) {
        this.connection.onDisconnectPut(path.asList(), node.getValue(true), new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass9 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String str, String str2) {
                DatabaseError fromErrorCode = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("onDisconnect().setValue", path, fromErrorCode);
                if (fromErrorCode == null) {
                    Repo.this.onDisconnect.remember(path, node);
                }
                Repo.this.callOnComplete(completionListener, fromErrorCode, path);
            }
        });
    }

    public void onDisconnectUpdate(final Path path, final Map<Path, Node> map, final DatabaseReference.CompletionListener completionListener, Map<String, Object> map2) {
        this.connection.onDisconnectMerge(path.asList(), map2, new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass10 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String str, String str2) {
                DatabaseError fromErrorCode = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("onDisconnect().updateChildren", path, fromErrorCode);
                if (fromErrorCode == null) {
                    for (Map.Entry entry : map.entrySet()) {
                        Repo.this.onDisconnect.remember(path.child((Path) entry.getKey()), (Node) entry.getValue());
                    }
                }
                Repo.this.callOnComplete(completionListener, fromErrorCode, path);
            }
        });
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onRangeMergeUpdate(List<String> list, List<RangeMerge> list2, Long l) {
        List<? extends Event> list3;
        Path path = new Path(list);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path + " " + list2, new Object[0]);
        }
        this.dataUpdateCount++;
        ArrayList arrayList = new ArrayList(list2.size());
        for (RangeMerge rangeMerge : list2) {
            arrayList.add(new com.google.firebase.database.snapshot.RangeMerge(rangeMerge));
        }
        if (l != null) {
            list3 = this.serverSyncTree.applyTaggedRangeMerges(path, arrayList, new Tag(l.longValue()));
        } else {
            list3 = this.serverSyncTree.applyServerRangeMerges(path, arrayList);
        }
        if (list3.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(list3);
    }

    public void onServerInfoUpdate(ChildKey childKey, Object obj) {
        updateInfo(childKey, obj);
    }

    public void postEvent(Runnable runnable) {
        this.ctx.requireStarted();
        this.ctx.getEventTarget().postEvent(runnable);
    }

    public void purgeOutstandingWrites() {
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("Purging writes", new Object[0]);
        }
        postEvents(this.serverSyncTree.removeAllWrites());
        abortTransactions(Path.getEmptyPath(), -25);
        this.connection.purgeOutstandingWrites();
    }

    public void removeEventCallback(@NotNull EventRegistration eventRegistration) {
        List<Event> list;
        if (Constants.DOT_INFO.equals(eventRegistration.getQuerySpec().getPath().getFront())) {
            list = this.infoSyncTree.removeEventRegistration(eventRegistration);
        } else {
            list = this.serverSyncTree.removeEventRegistration(eventRegistration);
        }
        postEvents(list);
    }

    public void resume() {
        this.connection.resume(INTERRUPT_REASON);
    }

    public void scheduleNow(Runnable runnable) {
        this.ctx.requireStarted();
        this.ctx.getRunLoop().scheduleNow(runnable);
    }

    public void setHijackHash(boolean z) {
        this.hijackHash = z;
    }

    public void setValue(final Path path, Node node, final DatabaseReference.CompletionListener completionListener) {
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("set: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            logWrapper2.debug("set: " + path + " " + node, new Object[0]);
        }
        Node resolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(node, this.serverSyncTree.calcCompleteEventCache(path, new ArrayList()), ServerValues.generateServerValues(this.serverClock));
        final long nextWriteId2 = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserOverwrite(path, node, resolveDeferredValueSnapshot, nextWriteId2, true, true));
        this.connection.put(path.asList(), node.getValue(true), new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass7 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String str, String str2) {
                DatabaseError fromErrorCode = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("setValue", path, fromErrorCode);
                Repo.this.ackWriteAndRerunTransactions(nextWriteId2, path, fromErrorCode);
                Repo.this.callOnComplete(completionListener, fromErrorCode, path);
            }
        });
        rerunTransactions(abortTransactions(path, -9));
    }

    public void startTransaction(Path path, final Transaction.Handler handler, boolean z) {
        final DatabaseError databaseError;
        Transaction.Result result;
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path, new Object[0]);
        }
        if (this.ctx.isPersistenceEnabled() && !this.loggedTransactionPersistenceWarning) {
            this.loggedTransactionPersistenceWarning = true;
            this.transactionLogger.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference createReference = InternalHelpers.createReference(this, path);
        AnonymousClass13 r4 = new ValueEventListener() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass13 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
            }
        };
        addEventCallback(new ValueEventRegistration(this, r4, createReference.getSpec()));
        TransactionData transactionData = new TransactionData(path, handler, r4, TransactionStatus.INITIALIZING, z, nextTransactionOrder());
        Node latestState = getLatestState(path);
        transactionData.currentInputSnapshot = latestState;
        try {
            result = handler.doTransaction(InternalHelpers.createMutableData(latestState));
            if (result != null) {
                databaseError = null;
                if (!result.isSuccess()) {
                    transactionData.currentOutputSnapshotRaw = null;
                    transactionData.currentOutputSnapshotResolved = null;
                    final DataSnapshot createDataSnapshot = InternalHelpers.createDataSnapshot(createReference, IndexedNode.from(transactionData.currentInputSnapshot));
                    postEvent(new Runnable() {
                        /* class com.google.firebase.database.core.Repo.AnonymousClass14 */

                        public void run() {
                            handler.onComplete(databaseError, false, createDataSnapshot);
                        }
                    });
                    return;
                }
                transactionData.status = TransactionStatus.RUN;
                Tree<List<TransactionData>> subTree = this.transactionQueueTree.subTree(path);
                List<TransactionData> value = subTree.getValue();
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(transactionData);
                subTree.setValue(value);
                Map<String, Object> generateServerValues = ServerValues.generateServerValues(this.serverClock);
                Node node = result.getNode();
                Node resolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(node, transactionData.currentInputSnapshot, generateServerValues);
                transactionData.currentOutputSnapshotRaw = node;
                transactionData.currentOutputSnapshotResolved = resolveDeferredValueSnapshot;
                transactionData.currentWriteId = getNextWriteId();
                postEvents(this.serverSyncTree.applyUserOverwrite(path, node, resolveDeferredValueSnapshot, transactionData.currentWriteId, z, false));
                sendAllReadyTransactions();
                return;
            }
            throw new NullPointerException("Transaction returned null as result");
        } catch (Throwable th) {
            this.operationLogger.error("Caught Throwable.", th);
            databaseError = DatabaseError.fromException(th);
            result = Transaction.abort();
        }
    }

    public String toString() {
        return this.repoInfo.toString();
    }

    public void updateChildren(final Path path, CompoundWrite compoundWrite, final DatabaseReference.CompletionListener completionListener, Map<String, Object> map) {
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("update: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            logWrapper2.debug("update: " + path + " " + map, new Object[0]);
        }
        if (compoundWrite.isEmpty()) {
            if (this.operationLogger.logsDebug()) {
                this.operationLogger.debug("update called with no changes. No-op", new Object[0]);
            }
            callOnComplete(completionListener, null, path);
            return;
        }
        CompoundWrite resolveDeferredValueMerge = ServerValues.resolveDeferredValueMerge(compoundWrite, this.serverSyncTree, path, ServerValues.generateServerValues(this.serverClock));
        final long nextWriteId2 = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserMerge(path, compoundWrite, resolveDeferredValueMerge, nextWriteId2, true));
        this.connection.merge(path.asList(), map, new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass8 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String str, String str2) {
                DatabaseError fromErrorCode = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("updateChildren", path, fromErrorCode);
                Repo.this.ackWriteAndRerunTransactions(nextWriteId2, path, fromErrorCode);
                Repo.this.callOnComplete(completionListener, fromErrorCode, path);
            }
        });
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        while (it.hasNext()) {
            rerunTransactions(abortTransactions(path.child(it.next().getKey()), -9));
        }
    }

    private Node getLatestState(Path path, List<Long> list) {
        Node calcCompleteEventCache = this.serverSyncTree.calcCompleteEventCache(path, list);
        return calcCompleteEventCache == null ? EmptyNode.Empty() : calcCompleteEventCache;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onServerInfoUpdate(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            updateInfo(ChildKey.fromString(entry.getKey()), entry.getValue());
        }
    }
}
