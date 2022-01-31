package com.google.firebase.database;

import com.google.firebase.database.Transaction;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.StringRpcServer;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

public class DatabaseReference extends Query {
    private static DatabaseConfig defaultConfig;

    public interface CompletionListener {
        void onComplete(DatabaseError databaseError, DatabaseReference databaseReference);
    }

    public DatabaseReference(Repo repo, Path path) {
        super(repo, path);
    }

    private static synchronized DatabaseConfig getDefaultConfig() {
        DatabaseConfig databaseConfig;
        synchronized (DatabaseReference.class) {
            if (defaultConfig == null) {
                defaultConfig = new DatabaseConfig();
            }
            databaseConfig = defaultConfig;
        }
        return databaseConfig;
    }

    public static void goOffline() {
        goOffline(getDefaultConfig());
    }

    public static void goOnline() {
        goOnline(getDefaultConfig());
    }

    private yi4<Void> setPriorityInternal(final Node node, CompletionListener completionListener) {
        Validation.validateWritablePath(getPath());
        final Pair<yi4<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.DatabaseReference.AnonymousClass2 */

            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.setValue(databaseReference.getPath().child(ChildKey.getPriorityKey()), node, (CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private yi4<Void> setValueInternal(Object obj, Node node, CompletionListener completionListener) {
        Validation.validateWritablePath(getPath());
        ValidationPath.validateWithObject(getPath(), obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        final Node NodeFromJSON = NodeUtilities.NodeFromJSON(convertToPlainJavaTypes, node);
        final Pair<yi4<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.DatabaseReference.AnonymousClass1 */

            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.setValue(databaseReference.getPath(), NodeFromJSON, (CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private yi4<Void> updateChildrenInternal(Map<String, Object> map, CompletionListener completionListener) {
        Objects.requireNonNull(map, "Can't pass null for argument 'update' in updateChildren()");
        final Map<String, Object> convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(map);
        final CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(Validation.parseAndValidateUpdate(getPath(), convertToPlainJavaTypes));
        final Pair<yi4<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.DatabaseReference.AnonymousClass3 */

            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.updateChildren(databaseReference.getPath(), fromPathMerge, (CompletionListener) wrapOnComplete.getSecond(), convertToPlainJavaTypes);
            }
        });
        return wrapOnComplete.getFirst();
    }

    public DatabaseReference child(String str) {
        Objects.requireNonNull(str, "Can't pass null for argument 'pathString' in child()");
        if (getPath().isEmpty()) {
            Validation.validateRootPathString(str);
        } else {
            Validation.validatePathString(str);
        }
        return new DatabaseReference(this.repo, getPath().child(new Path(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    public FirebaseDatabase getDatabase() {
        return this.repo.getDatabase();
    }

    public String getKey() {
        if (getPath().isEmpty()) {
            return null;
        }
        return getPath().getBack().asString();
    }

    public DatabaseReference getParent() {
        Path parent = getPath().getParent();
        if (parent != null) {
            return new DatabaseReference(this.repo, parent);
        }
        return null;
    }

    public DatabaseReference getRoot() {
        return new DatabaseReference(this.repo, new Path(""));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public OnDisconnect onDisconnect() {
        Validation.validateWritablePath(getPath());
        return new OnDisconnect(this.repo, getPath());
    }

    public DatabaseReference push() {
        return new DatabaseReference(this.repo, getPath().child(ChildKey.fromString(PushIdGenerator.generatePushChildName(this.repo.getServerTime()))));
    }

    public yi4<Void> removeValue() {
        return setValue(null);
    }

    public void runTransaction(Transaction.Handler handler) {
        runTransaction(handler, true);
    }

    public void setHijackHash(final boolean z) {
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.DatabaseReference.AnonymousClass5 */

            public void run() {
                DatabaseReference.this.repo.setHijackHash(z);
            }
        });
    }

    public yi4<Void> setPriority(Object obj) {
        return setPriorityInternal(PriorityUtilities.parsePriority(this.path, obj), null);
    }

    public yi4<Void> setValue(Object obj) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.path, null), null);
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.repo.toString();
        }
        try {
            return parent.toString() + ConnectionFactory.DEFAULT_VHOST + URLEncoder.encode(getKey(), StringRpcServer.STRING_ENCODING).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            StringBuilder i0 = hj1.i0("Failed to URLEncode key: ");
            i0.append(getKey());
            throw new DatabaseException(i0.toString(), e);
        }
    }

    public yi4<Void> updateChildren(Map<String, Object> map) {
        return updateChildrenInternal(map, null);
    }

    public DatabaseReference(String str, DatabaseConfig databaseConfig) {
        this(Utilities.parseUrl(str), databaseConfig);
    }

    public static void goOffline(DatabaseConfig databaseConfig) {
        RepoManager.interrupt(databaseConfig);
    }

    public static void goOnline(DatabaseConfig databaseConfig) {
        RepoManager.resume(databaseConfig);
    }

    public void removeValue(CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public void runTransaction(final Transaction.Handler handler, final boolean z) {
        Objects.requireNonNull(handler, "Can't pass null for argument 'handler' in runTransaction()");
        Validation.validateWritablePath(getPath());
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.DatabaseReference.AnonymousClass4 */

            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.startTransaction(databaseReference.getPath(), handler, z);
            }
        });
    }

    public void setPriority(Object obj, CompletionListener completionListener) {
        setPriorityInternal(PriorityUtilities.parsePriority(this.path, obj), completionListener);
    }

    public yi4<Void> setValue(Object obj, Object obj2) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.path, obj2), null);
    }

    public void updateChildren(Map<String, Object> map, CompletionListener completionListener) {
        updateChildrenInternal(map, completionListener);
    }

    private DatabaseReference(ParsedUrl parsedUrl, DatabaseConfig databaseConfig) {
        this(RepoManager.getRepo(databaseConfig, parsedUrl.repoInfo), parsedUrl.path);
    }

    public void setValue(Object obj, CompletionListener completionListener) {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.path, null), completionListener);
    }

    public void setValue(Object obj, Object obj2, CompletionListener completionListener) {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.path, obj2), completionListener);
    }
}
