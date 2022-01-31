package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.connection.CompoundHash;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.RangeMerge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public class SyncTree {
    private static final long SIZE_THRESHOLD_FOR_COMPOUND_HASH = 1024;
    private final Set<QuerySpec> keepSyncedQueries = new HashSet();
    private final ListenProvider listenProvider;
    private final LogWrapper logger;
    private long nextQueryTag = 1;
    private final WriteTree pendingWriteTree = new WriteTree();
    private final PersistenceManager persistenceManager;
    private final Map<QuerySpec, Tag> queryToTagMap = new HashMap();
    private ImmutableTree<SyncPoint> syncPointTree = ImmutableTree.emptyInstance();
    private final Map<Tag, QuerySpec> tagToQueryMap = new HashMap();

    public interface CompletionListener {
        List<? extends Event> onListenComplete(DatabaseError databaseError);
    }

    public static class KeepSyncedEventRegistration extends EventRegistration {
        private QuerySpec spec;

        public KeepSyncedEventRegistration(@NotNull QuerySpec querySpec) {
            this.spec = querySpec;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public EventRegistration clone(QuerySpec querySpec) {
            return new KeepSyncedEventRegistration(querySpec);
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public DataEvent createEvent(Change change, QuerySpec querySpec) {
            return null;
        }

        public boolean equals(Object obj) {
            return (obj instanceof KeepSyncedEventRegistration) && ((KeepSyncedEventRegistration) obj).spec.equals(this.spec);
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireCancelEvent(DatabaseError databaseError) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireEvent(DataEvent dataEvent) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        @NotNull
        public QuerySpec getQuerySpec() {
            return this.spec;
        }

        public int hashCode() {
            return this.spec.hashCode();
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean isSameListener(EventRegistration eventRegistration) {
            return eventRegistration instanceof KeepSyncedEventRegistration;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean respondsTo(Event.EventType eventType) {
            return false;
        }
    }

    public class ListenContainer implements ListenHashProvider, CompletionListener {
        private final Tag tag;
        private final View view;

        public ListenContainer(View view2) {
            this.view = view2;
            this.tag = SyncTree.this.tagForQuery(view2.getQuery());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public CompoundHash getCompoundHash() {
            com.google.firebase.database.snapshot.CompoundHash fromNode = com.google.firebase.database.snapshot.CompoundHash.fromNode(this.view.getServerCache());
            List<Path> posts = fromNode.getPosts();
            ArrayList arrayList = new ArrayList(posts.size());
            for (Path path : posts) {
                arrayList.add(path.asList());
            }
            return new CompoundHash(arrayList, fromNode.getHashes());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public String getSimpleHash() {
            return this.view.getServerCache().getHash();
        }

        @Override // com.google.firebase.database.core.SyncTree.CompletionListener
        public List<? extends Event> onListenComplete(DatabaseError databaseError) {
            if (databaseError == null) {
                QuerySpec query = this.view.getQuery();
                Tag tag2 = this.tag;
                if (tag2 != null) {
                    return SyncTree.this.applyTaggedListenComplete(tag2);
                }
                return SyncTree.this.applyListenComplete(query.getPath());
            }
            LogWrapper logWrapper = SyncTree.this.logger;
            StringBuilder i0 = hj1.i0("Listen at ");
            i0.append(this.view.getQuery().getPath());
            i0.append(" failed: ");
            i0.append(databaseError.toString());
            logWrapper.warn(i0.toString());
            return SyncTree.this.removeAllEventRegistrations(this.view.getQuery(), databaseError);
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public boolean shouldIncludeCompoundHash() {
            return NodeSizeEstimator.estimateSerializedNodeSize(this.view.getServerCache()) > SyncTree.SIZE_THRESHOLD_FOR_COMPOUND_HASH;
        }
    }

    public interface ListenProvider {
        void startListening(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, CompletionListener completionListener);

        void stopListening(QuerySpec querySpec, Tag tag);
    }

    public SyncTree(Context context, PersistenceManager persistenceManager2, ListenProvider listenProvider2) {
        this.listenProvider = listenProvider2;
        this.persistenceManager = persistenceManager2;
        this.logger = context.getLogger("SyncTree");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<Event> applyOperationDescendantsHelper(final Operation operation, ImmutableTree<SyncPoint> immutableTree, final Node node, final WriteTreeRef writeTreeRef) {
        SyncPoint value = immutableTree.getValue();
        if (node == null && value != null) {
            node = value.getCompleteServerCache(Path.getEmptyPath());
        }
        final ArrayList arrayList = new ArrayList();
        immutableTree.getChildren().inOrderTraversal(new LLRBNode.NodeVisitor<ChildKey, ImmutableTree<SyncPoint>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass14 */

            public void visitEntry(ChildKey childKey, ImmutableTree<SyncPoint> immutableTree) {
                Node node = node;
                Node immediateChild = node != null ? node.getImmediateChild(childKey) : null;
                WriteTreeRef child = writeTreeRef.child(childKey);
                Operation operationForChild = operation.operationForChild(childKey);
                if (operationForChild != null) {
                    arrayList.addAll(SyncTree.this.applyOperationDescendantsHelper(operationForChild, immutableTree, immediateChild, child));
                }
            }
        });
        if (value != null) {
            arrayList.addAll(value.applyOperation(operation, writeTreeRef, node));
        }
        return arrayList;
    }

    private List<Event> applyOperationHelper(Operation operation, ImmutableTree<SyncPoint> immutableTree, Node node, WriteTreeRef writeTreeRef) {
        if (operation.getPath().isEmpty()) {
            return applyOperationDescendantsHelper(operation, immutableTree, node, writeTreeRef);
        }
        SyncPoint value = immutableTree.getValue();
        if (node == null && value != null) {
            node = value.getCompleteServerCache(Path.getEmptyPath());
        }
        ArrayList arrayList = new ArrayList();
        ChildKey front = operation.getPath().getFront();
        Operation operationForChild = operation.operationForChild(front);
        ImmutableTree<SyncPoint> immutableTree2 = immutableTree.getChildren().get(front);
        if (!(immutableTree2 == null || operationForChild == null)) {
            arrayList.addAll(applyOperationHelper(operationForChild, immutableTree2, node != null ? node.getImmediateChild(front) : null, writeTreeRef.child(front)));
        }
        if (value != null) {
            arrayList.addAll(value.applyOperation(operation, writeTreeRef, node));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<Event> applyOperationToSyncPoints(Operation operation) {
        return applyOperationHelper(operation, this.syncPointTree, null, this.pendingWriteTree.childWrites(Path.getEmptyPath()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<? extends Event> applyTaggedOperation(QuerySpec querySpec, Operation operation) {
        Path path = querySpec.getPath();
        SyncPoint syncPoint = this.syncPointTree.get(path);
        Utilities.hardAssert(syncPoint != null, "Missing sync point for query tag that we're tracking");
        return syncPoint.applyOperation(operation, this.pendingWriteTree.childWrites(path), null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<View> collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> immutableTree) {
        ArrayList arrayList = new ArrayList();
        collectDistinctViewsForSubTree(immutableTree, arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Tag getNextQueryTag() {
        long j = this.nextQueryTag;
        this.nextQueryTag = 1 + j;
        return new Tag(j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private QuerySpec queryForListening(QuerySpec querySpec) {
        return (!querySpec.loadsAllData() || querySpec.isDefault()) ? querySpec : QuerySpec.defaultQueryAtPath(querySpec.getPath());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private QuerySpec queryForTag(Tag tag) {
        return this.tagToQueryMap.get(tag);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeTags(List<QuerySpec> list) {
        for (QuerySpec querySpec : list) {
            if (!querySpec.loadsAllData()) {
                Tag tagForQuery = tagForQuery(querySpec);
                Utilities.hardAssert(tagForQuery != null);
                this.queryToTagMap.remove(querySpec);
                this.tagToQueryMap.remove(tagForQuery);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setupListener(QuerySpec querySpec, View view) {
        Path path = querySpec.getPath();
        Tag tagForQuery = tagForQuery(querySpec);
        ListenContainer listenContainer = new ListenContainer(view);
        this.listenProvider.startListening(queryForListening(querySpec), tagForQuery, listenContainer, listenContainer);
        ImmutableTree<SyncPoint> subtree = this.syncPointTree.subtree(path);
        if (tagForQuery != null) {
            Utilities.hardAssert(!subtree.getValue().hasCompleteView(), "If we're adding a query, it shouldn't be shadowed");
        } else {
            subtree.foreach(new ImmutableTree.TreeVisitor<SyncPoint, Void>() {
                /* class com.google.firebase.database.core.SyncTree.AnonymousClass13 */

                public Void onNodeValue(Path path, SyncPoint syncPoint, Void r5) {
                    if (path.isEmpty() || !syncPoint.hasCompleteView()) {
                        for (View view : syncPoint.getQueryViews()) {
                            QuerySpec query = view.getQuery();
                            SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query), SyncTree.this.tagForQuery(query));
                        }
                        return null;
                    }
                    QuerySpec query2 = syncPoint.getCompleteView().getQuery();
                    SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query2), SyncTree.this.tagForQuery(query2));
                    return null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Tag tagForQuery(QuerySpec querySpec) {
        return this.queryToTagMap.get(querySpec);
    }

    public List<? extends Event> ackUserWrite(final long j, final boolean z, final boolean z2, final Clock clock) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                ImmutableTree immutableTree;
                Boolean bool = Boolean.TRUE;
                if (z2) {
                    SyncTree.this.persistenceManager.removeUserWrite(j);
                }
                UserWriteRecord write = SyncTree.this.pendingWriteTree.getWrite(j);
                boolean removeWrite = SyncTree.this.pendingWriteTree.removeWrite(j);
                if (write.isVisible() && !z) {
                    Map<String, Object> generateServerValues = ServerValues.generateServerValues(clock);
                    if (write.isOverwrite()) {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), SyncTree.this, write.getPath(), generateServerValues));
                    } else {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueMerge(write.getMerge(), SyncTree.this, write.getPath(), generateServerValues));
                    }
                }
                if (!removeWrite) {
                    return Collections.emptyList();
                }
                ImmutableTree emptyInstance = ImmutableTree.emptyInstance();
                if (write.isOverwrite()) {
                    immutableTree = emptyInstance.set(Path.getEmptyPath(), bool);
                } else {
                    Iterator<Map.Entry<Path, Node>> it = write.getMerge().iterator();
                    while (it.hasNext()) {
                        emptyInstance = emptyInstance.set(it.next().getKey(), bool);
                    }
                    immutableTree = emptyInstance;
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(write.getPath(), immutableTree, z));
            }
        });
    }

    public List<? extends Event> addEventRegistration(@NotNull final EventRegistration eventRegistration) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass11 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                CacheNode cacheNode;
                Node completeServerCache;
                QuerySpec querySpec = eventRegistration.getQuerySpec();
                Path path = querySpec.getPath();
                ImmutableTree immutableTree = SyncTree.this.syncPointTree;
                Node node = null;
                Path path2 = path;
                boolean z = false;
                while (!immutableTree.isEmpty()) {
                    SyncPoint syncPoint = (SyncPoint) immutableTree.getValue();
                    if (syncPoint != null) {
                        if (node == null) {
                            node = syncPoint.getCompleteServerCache(path2);
                        }
                        z = z || syncPoint.hasCompleteView();
                    }
                    immutableTree = immutableTree.getChild(path2.isEmpty() ? ChildKey.fromString("") : path2.getFront());
                    path2 = path2.popFront();
                }
                SyncPoint syncPoint2 = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                if (syncPoint2 == null) {
                    syncPoint2 = new SyncPoint(SyncTree.this.persistenceManager);
                    SyncTree syncTree = SyncTree.this;
                    syncTree.syncPointTree = syncTree.syncPointTree.set(path, syncPoint2);
                } else {
                    z = z || syncPoint2.hasCompleteView();
                    if (node == null) {
                        node = syncPoint2.getCompleteServerCache(Path.getEmptyPath());
                    }
                }
                SyncTree.this.persistenceManager.setQueryActive(querySpec);
                if (node != null) {
                    cacheNode = new CacheNode(IndexedNode.from(node, querySpec.getIndex()), true, false);
                } else {
                    cacheNode = SyncTree.this.persistenceManager.serverCache(querySpec);
                    if (!cacheNode.isFullyInitialized()) {
                        Node Empty = EmptyNode.Empty();
                        Iterator it = SyncTree.this.syncPointTree.subtree(path).getChildren().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            SyncPoint syncPoint3 = (SyncPoint) ((ImmutableTree) entry.getValue()).getValue();
                            if (!(syncPoint3 == null || (completeServerCache = syncPoint3.getCompleteServerCache(Path.getEmptyPath())) == null)) {
                                Empty = Empty.updateImmediateChild((ChildKey) entry.getKey(), completeServerCache);
                            }
                        }
                        for (NamedNode namedNode : cacheNode.getNode()) {
                            if (!Empty.hasChild(namedNode.getName())) {
                                Empty = Empty.updateImmediateChild(namedNode.getName(), namedNode.getNode());
                            }
                        }
                        cacheNode = new CacheNode(IndexedNode.from(Empty, querySpec.getIndex()), false, false);
                    }
                }
                boolean viewExistsForQuery = syncPoint2.viewExistsForQuery(querySpec);
                if (!viewExistsForQuery && !querySpec.loadsAllData()) {
                    Utilities.hardAssert(!SyncTree.this.queryToTagMap.containsKey(querySpec), "View does not exist but we have a tag");
                    Tag nextQueryTag = SyncTree.this.getNextQueryTag();
                    SyncTree.this.queryToTagMap.put(querySpec, nextQueryTag);
                    SyncTree.this.tagToQueryMap.put(nextQueryTag, querySpec);
                }
                List<DataEvent> addEventRegistration = syncPoint2.addEventRegistration(eventRegistration, SyncTree.this.pendingWriteTree.childWrites(path), cacheNode);
                if (!viewExistsForQuery && !z) {
                    SyncTree.this.setupListener(querySpec, syncPoint2.viewForQuery(querySpec));
                }
                return addEventRegistration;
            }
        });
    }

    public List<? extends Event> applyListenComplete(final Path path) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass7 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.setQueryComplete(QuerySpec.defaultQueryAtPath(path));
                return SyncTree.this.applyOperationToSyncPoints(new ListenComplete(OperationSource.SERVER, path));
            }
        });
    }

    public List<? extends Event> applyServerMerge(final Path path, final Map<Path, Node> map) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(map);
                SyncTree.this.persistenceManager.updateServerCache(path, fromPathMerge);
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.SERVER, path, fromPathMerge));
            }
        });
    }

    public List<? extends Event> applyServerOverwrite(final Path path, final Node node) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.updateServerCache(QuerySpec.defaultQueryAtPath(path), node);
                return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.SERVER, path, node));
            }
        });
    }

    public List<? extends Event> applyServerRangeMerges(Path path, List<RangeMerge> list) {
        SyncPoint syncPoint = this.syncPointTree.get(path);
        if (syncPoint == null) {
            return Collections.emptyList();
        }
        View completeView = syncPoint.getCompleteView();
        if (completeView == null) {
            return Collections.emptyList();
        }
        Node serverCache = completeView.getServerCache();
        for (RangeMerge rangeMerge : list) {
            serverCache = rangeMerge.applyTo(serverCache);
        }
        return applyServerOverwrite(path, serverCache);
    }

    public List<? extends Event> applyTaggedListenComplete(final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass8 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag == null) {
                    return Collections.emptyList();
                }
                SyncTree.this.persistenceManager.setQueryComplete(queryForTag);
                return SyncTree.this.applyTaggedOperation(queryForTag, new ListenComplete(OperationSource.forServerTaggedQuery(queryForTag.getParams()), Path.getEmptyPath()));
            }
        });
    }

    public List<? extends Event> applyTaggedQueryMerge(final Path path, final Map<Path, Node> map, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass10 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag == null) {
                    return Collections.emptyList();
                }
                Path relative = Path.getRelative(queryForTag.getPath(), path);
                CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(map);
                SyncTree.this.persistenceManager.updateServerCache(path, fromPathMerge);
                return SyncTree.this.applyTaggedOperation(queryForTag, new Merge(OperationSource.forServerTaggedQuery(queryForTag.getParams()), relative, fromPathMerge));
            }
        });
    }

    public List<? extends Event> applyTaggedQueryOverwrite(final Path path, final Node node, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass9 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec queryForTag = SyncTree.this.queryForTag(tag);
                if (queryForTag == null) {
                    return Collections.emptyList();
                }
                Path relative = Path.getRelative(queryForTag.getPath(), path);
                SyncTree.this.persistenceManager.updateServerCache(relative.isEmpty() ? queryForTag : QuerySpec.defaultQueryAtPath(path), node);
                return SyncTree.this.applyTaggedOperation(queryForTag, new Overwrite(OperationSource.forServerTaggedQuery(queryForTag.getParams()), relative, node));
            }
        });
    }

    public List<? extends Event> applyTaggedRangeMerges(Path path, List<RangeMerge> list, Tag tag) {
        QuerySpec queryForTag = queryForTag(tag);
        if (queryForTag == null) {
            return Collections.emptyList();
        }
        Utilities.hardAssert(path.equals(queryForTag.getPath()));
        SyncPoint syncPoint = this.syncPointTree.get(queryForTag.getPath());
        boolean z = true;
        Utilities.hardAssert(syncPoint != null, "Missing sync point for query tag that we're tracking");
        View viewForQuery = syncPoint.viewForQuery(queryForTag);
        if (viewForQuery == null) {
            z = false;
        }
        Utilities.hardAssert(z, "Missing view for query tag that we're tracking");
        Node serverCache = viewForQuery.getServerCache();
        for (RangeMerge rangeMerge : list) {
            serverCache = rangeMerge.applyTo(serverCache);
        }
        return applyTaggedQueryOverwrite(path, serverCache, tag);
    }

    public List<? extends Event> applyUserMerge(final Path path, final CompoundWrite compoundWrite, final CompoundWrite compoundWrite2, final long j, final boolean z) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() throws Exception {
                if (z) {
                    SyncTree.this.persistenceManager.saveUserMerge(path, compoundWrite, j);
                }
                SyncTree.this.pendingWriteTree.addMerge(path, compoundWrite2, Long.valueOf(j));
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.USER, path, compoundWrite2));
            }
        });
    }

    public List<? extends Event> applyUserOverwrite(final Path path, final Node node, final Node node2, final long j, final boolean z, final boolean z2) {
        Utilities.hardAssert(z || !z2, "We shouldn't be persisting non-visible writes.");
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass1 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (z2) {
                    SyncTree.this.persistenceManager.saveUserOverwrite(path, node, j);
                }
                SyncTree.this.pendingWriteTree.addOverwrite(path, node2, Long.valueOf(j), z);
                if (!z) {
                    return Collections.emptyList();
                }
                return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.USER, path, node2));
            }
        });
    }

    public Node calcCompleteEventCache(Path path, List<Long> list) {
        ImmutableTree<SyncPoint> immutableTree = this.syncPointTree;
        immutableTree.getValue();
        Path emptyPath = Path.getEmptyPath();
        Node node = null;
        Path path2 = path;
        do {
            ChildKey front = path2.getFront();
            path2 = path2.popFront();
            emptyPath = emptyPath.child(front);
            Path relative = Path.getRelative(emptyPath, path);
            immutableTree = front != null ? immutableTree.getChild(front) : ImmutableTree.emptyInstance();
            SyncPoint value = immutableTree.getValue();
            if (value != null) {
                node = value.getCompleteServerCache(relative);
            }
            if (path2.isEmpty()) {
                break;
            }
        } while (node == null);
        return this.pendingWriteTree.calcCompleteEventCache(path, node, list, true);
    }

    public ImmutableTree<SyncPoint> getSyncPointTree() {
        return this.syncPointTree;
    }

    public boolean isEmpty() {
        return this.syncPointTree.isEmpty();
    }

    public void keepSynced(QuerySpec querySpec, boolean z) {
        if (z && !this.keepSyncedQueries.contains(querySpec)) {
            addEventRegistration(new KeepSyncedEventRegistration(querySpec));
            this.keepSyncedQueries.add(querySpec);
        } else if (!z && this.keepSyncedQueries.contains(querySpec)) {
            removeEventRegistration(new KeepSyncedEventRegistration(querySpec));
            this.keepSyncedQueries.remove(querySpec);
        }
    }

    public List<Event> removeAllEventRegistrations(@NotNull QuerySpec querySpec, @NotNull DatabaseError databaseError) {
        return removeEventRegistration(querySpec, null, databaseError);
    }

    public List<? extends Event> removeAllWrites() {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() throws Exception {
                SyncTree.this.persistenceManager.removeAllUserWrites();
                if (SyncTree.this.pendingWriteTree.purgeAllWrites().isEmpty()) {
                    return Collections.emptyList();
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(Path.getEmptyPath(), new ImmutableTree(Boolean.TRUE), true));
            }
        });
    }

    public List<Event> removeEventRegistration(@NotNull EventRegistration eventRegistration) {
        return removeEventRegistration(eventRegistration.getQuerySpec(), eventRegistration, null);
    }

    private List<Event> removeEventRegistration(@NotNull final QuerySpec querySpec, @Nullable final EventRegistration eventRegistration, @Nullable final DatabaseError databaseError) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass12 */

            @Override // java.util.concurrent.Callable
            public List<Event> call() {
                boolean z;
                Path path = querySpec.getPath();
                SyncPoint syncPoint = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                List<Event> arrayList = new ArrayList<>();
                if (syncPoint != null && (querySpec.isDefault() || syncPoint.viewExistsForQuery(querySpec))) {
                    Pair<List<QuerySpec>, List<Event>> removeEventRegistration = syncPoint.removeEventRegistration(querySpec, eventRegistration, databaseError);
                    if (syncPoint.isEmpty()) {
                        SyncTree syncTree = SyncTree.this;
                        syncTree.syncPointTree = syncTree.syncPointTree.remove(path);
                    }
                    List<QuerySpec> first = removeEventRegistration.getFirst();
                    arrayList = removeEventRegistration.getSecond();
                    Iterator<QuerySpec> it = first.iterator();
                    loop0:
                    while (true) {
                        z = false;
                        while (true) {
                            if (!it.hasNext()) {
                                break loop0;
                            }
                            QuerySpec next = it.next();
                            SyncTree.this.persistenceManager.setQueryInactive(querySpec);
                            if (z || next.loadsAllData()) {
                                z = true;
                            }
                        }
                    }
                    ImmutableTree immutableTree = SyncTree.this.syncPointTree;
                    boolean z2 = immutableTree.getValue() != null && ((SyncPoint) immutableTree.getValue()).hasCompleteView();
                    Iterator<ChildKey> it2 = path.iterator();
                    while (it2.hasNext()) {
                        immutableTree = immutableTree.getChild(it2.next());
                        z2 = z2 || (immutableTree.getValue() != null && ((SyncPoint) immutableTree.getValue()).hasCompleteView());
                        if (!z2) {
                            if (immutableTree.isEmpty()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z && !z2) {
                        ImmutableTree subtree = SyncTree.this.syncPointTree.subtree(path);
                        if (!subtree.isEmpty()) {
                            for (View view : SyncTree.this.collectDistinctViewsForSubTree(subtree)) {
                                ListenContainer listenContainer = new ListenContainer(view);
                                SyncTree.this.listenProvider.startListening(SyncTree.this.queryForListening(view.getQuery()), listenContainer.tag, listenContainer, listenContainer);
                            }
                        }
                    }
                    if (!z2 && !first.isEmpty() && databaseError == null) {
                        if (z) {
                            SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(querySpec), null);
                        } else {
                            for (QuerySpec querySpec : first) {
                                Tag tagForQuery = SyncTree.this.tagForQuery(querySpec);
                                Utilities.hardAssert(tagForQuery != null);
                                SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(querySpec), tagForQuery);
                            }
                        }
                    }
                    SyncTree.this.removeTags(first);
                }
                return arrayList;
            }
        });
    }

    private void collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> immutableTree, List<View> list) {
        SyncPoint value = immutableTree.getValue();
        if (value == null || !value.hasCompleteView()) {
            if (value != null) {
                list.addAll(value.getQueryViews());
            }
            Iterator<Map.Entry<ChildKey, ImmutableTree<SyncPoint>>> it = immutableTree.getChildren().iterator();
            while (it.hasNext()) {
                collectDistinctViewsForSubTree(it.next().getValue(), list);
            }
            return;
        }
        list.add(value.getCompleteView());
    }
}
