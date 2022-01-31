package com.google.firebase.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Map;

public class OnDisconnect {
    private Path path;
    private Repo repo;

    public OnDisconnect(Repo repo2, Path path2) {
        this.repo = repo2;
        this.path = path2;
    }

    private yi4<Void> cancelInternal(DatabaseReference.CompletionListener completionListener) {
        final Pair<yi4<Void>, DatabaseReference.CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.OnDisconnect.AnonymousClass3 */

            public void run() {
                OnDisconnect.this.repo.onDisconnectCancel(OnDisconnect.this.path, (DatabaseReference.CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private yi4<Void> onDisconnectSetInternal(Object obj, Node node, DatabaseReference.CompletionListener completionListener) {
        Validation.validateWritablePath(this.path);
        ValidationPath.validateWithObject(this.path, obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        final Node NodeFromJSON = NodeUtilities.NodeFromJSON(convertToPlainJavaTypes, node);
        final Pair<yi4<Void>, DatabaseReference.CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.OnDisconnect.AnonymousClass1 */

            public void run() {
                OnDisconnect.this.repo.onDisconnectSetValue(OnDisconnect.this.path, NodeFromJSON, (DatabaseReference.CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private yi4<Void> updateChildrenInternal(final Map<String, Object> map, DatabaseReference.CompletionListener completionListener) {
        final Map<Path, Node> parseAndValidateUpdate = Validation.parseAndValidateUpdate(this.path, map);
        final Pair<yi4<Void>, DatabaseReference.CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.OnDisconnect.AnonymousClass2 */

            public void run() {
                OnDisconnect.this.repo.onDisconnectUpdate(OnDisconnect.this.path, parseAndValidateUpdate, (DatabaseReference.CompletionListener) wrapOnComplete.getSecond(), map);
            }
        });
        return wrapOnComplete.getFirst();
    }

    public yi4<Void> cancel() {
        return cancelInternal(null);
    }

    public yi4<Void> removeValue() {
        return setValue(null);
    }

    public yi4<Void> setValue(Object obj) {
        return onDisconnectSetInternal(obj, PriorityUtilities.NullPriority(), null);
    }

    public yi4<Void> updateChildren(Map<String, Object> map) {
        return updateChildrenInternal(map, null);
    }

    public void cancel(DatabaseReference.CompletionListener completionListener) {
        cancelInternal(completionListener);
    }

    public void removeValue(DatabaseReference.CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public yi4<Void> setValue(Object obj, String str) {
        return onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, str), null);
    }

    public void updateChildren(Map<String, Object> map, DatabaseReference.CompletionListener completionListener) {
        updateChildrenInternal(map, completionListener);
    }

    public yi4<Void> setValue(Object obj, double d) {
        return onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, Double.valueOf(d)), null);
    }

    public void setValue(Object obj, DatabaseReference.CompletionListener completionListener) {
        onDisconnectSetInternal(obj, PriorityUtilities.NullPriority(), completionListener);
    }

    public void setValue(Object obj, String str, DatabaseReference.CompletionListener completionListener) {
        onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, str), completionListener);
    }

    public void setValue(Object obj, double d, DatabaseReference.CompletionListener completionListener) {
        onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, Double.valueOf(d)), completionListener);
    }

    public void setValue(Object obj, Map map, DatabaseReference.CompletionListener completionListener) {
        onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, map), completionListener);
    }
}
