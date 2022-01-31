package com.google.firebase.database.core.utilities;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ImmutableTree<T> implements Iterable<Map.Entry<Path, T>>, Iterable {
    private static final ImmutableTree EMPTY;
    private static final ImmutableSortedMap EMPTY_CHILDREN;
    private final ImmutableSortedMap<ChildKey, ImmutableTree<T>> children;
    private final T value;

    public interface TreeVisitor<T, R> {
        R onNodeValue(Path path, T t, R r);
    }

    static {
        ImmutableSortedMap emptyMap = ImmutableSortedMap.Builder.emptyMap(StandardComparator.getComparator(ChildKey.class));
        EMPTY_CHILDREN = emptyMap;
        EMPTY = new ImmutableTree(null, emptyMap);
    }

    public ImmutableTree(T t, ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap) {
        this.value = t;
        this.children = immutableSortedMap;
    }

    public static <V> ImmutableTree<V> emptyInstance() {
        return EMPTY;
    }

    public boolean containsMatchingValue(Predicate<? super T> predicate) {
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return true;
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            if (it.next().getValue().containsMatchingValue(predicate)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImmutableTree.class != obj.getClass()) {
            return false;
        }
        ImmutableTree immutableTree = (ImmutableTree) obj;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap == null ? immutableTree.children != null : !immutableSortedMap.equals(immutableTree.children)) {
            return false;
        }
        T t = this.value;
        T t2 = immutableTree.value;
        return t == null ? t2 == null : t.equals(t2);
    }

    public Path findRootMostMatchingPath(Path path, Predicate<? super T> predicate) {
        ChildKey front;
        ImmutableTree<T> immutableTree;
        Path findRootMostMatchingPath;
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return Path.getEmptyPath();
        }
        if (path.isEmpty() || (immutableTree = this.children.get((front = path.getFront()))) == null || (findRootMostMatchingPath = immutableTree.findRootMostMatchingPath(path.popFront(), predicate)) == null) {
            return null;
        }
        return new Path(front).child(findRootMostMatchingPath);
    }

    public Path findRootMostPathWithValue(Path path) {
        return findRootMostMatchingPath(path, Predicate.TRUE);
    }

    public <R> R fold(R r, TreeVisitor<? super T, R> treeVisitor) {
        return (R) fold(Path.getEmptyPath(), treeVisitor, r);
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public void foreach(TreeVisitor<T, Void> treeVisitor) {
        fold(Path.getEmptyPath(), treeVisitor, null);
    }

    public T get(Path path) {
        if (path.isEmpty()) {
            return this.value;
        }
        ImmutableTree<T> immutableTree = this.children.get(path.getFront());
        if (immutableTree != null) {
            return immutableTree.get(path.popFront());
        }
        return null;
    }

    public ImmutableTree<T> getChild(ChildKey childKey) {
        ImmutableTree<T> immutableTree = this.children.get(childKey);
        if (immutableTree != null) {
            return immutableTree;
        }
        return emptyInstance();
    }

    public ImmutableSortedMap<ChildKey, ImmutableTree<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap != null) {
            i = immutableSortedMap.hashCode();
        }
        return hashCode + i;
    }

    public boolean isEmpty() {
        return this.value == null && this.children.isEmpty();
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<Map.Entry<Path, T>> iterator() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() {
            /* class com.google.firebase.database.core.utilities.ImmutableTree.AnonymousClass2 */

            public Void onNodeValue(Path path, T t, Void r4) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(path, t));
                return null;
            }
        });
        return arrayList.iterator();
    }

    public T leafMostValue(Path path) {
        return leafMostValueMatching(path, Predicate.TRUE);
    }

    public T leafMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t = this.value;
        T t2 = (t == null || !predicate.evaluate(t)) ? null : this.value;
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext() && (immutableTree = immutableTree.children.get(it.next())) != null) {
            T t3 = immutableTree.value;
            if (t3 != null && predicate.evaluate(t3)) {
                t2 = immutableTree.value;
            }
        }
        return t2;
    }

    public ImmutableTree<T> remove(Path path) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap;
        if (!path.isEmpty()) {
            ChildKey front = path.getFront();
            ImmutableTree<T> immutableTree = this.children.get(front);
            if (immutableTree == null) {
                return this;
            }
            ImmutableTree<T> remove = immutableTree.remove(path.popFront());
            if (remove.isEmpty()) {
                immutableSortedMap = this.children.remove(front);
            } else {
                immutableSortedMap = this.children.insert(front, remove);
            }
            if (this.value != null || !immutableSortedMap.isEmpty()) {
                return new ImmutableTree<>(this.value, immutableSortedMap);
            }
            return emptyInstance();
        } else if (this.children.isEmpty()) {
            return emptyInstance();
        } else {
            return new ImmutableTree<>(null, this.children);
        }
    }

    public T rootMostValue(Path path) {
        return rootMostValueMatching(path, Predicate.TRUE);
    }

    public T rootMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t = this.value;
        if (t != null && predicate.evaluate(t)) {
            return this.value;
        }
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree<T> immutableTree = this;
        while (it.hasNext() && (immutableTree = immutableTree.children.get(it.next())) != null) {
            T t2 = immutableTree.value;
            if (t2 != null && predicate.evaluate(t2)) {
                return immutableTree.value;
            }
        }
        return null;
    }

    public ImmutableTree<T> set(Path path, T t) {
        if (path.isEmpty()) {
            return new ImmutableTree<>(t, this.children);
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTree = this.children.get(front);
        if (immutableTree == null) {
            immutableTree = emptyInstance();
        }
        return new ImmutableTree<>(this.value, this.children.insert(front, immutableTree.set(path.popFront(), t)));
    }

    public ImmutableTree<T> setTree(Path path, ImmutableTree<T> immutableTree) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap;
        if (path.isEmpty()) {
            return immutableTree;
        }
        ChildKey front = path.getFront();
        ImmutableTree<T> immutableTree2 = this.children.get(front);
        if (immutableTree2 == null) {
            immutableTree2 = emptyInstance();
        }
        ImmutableTree<T> tree = immutableTree2.setTree(path.popFront(), immutableTree);
        if (tree.isEmpty()) {
            immutableSortedMap = this.children.remove(front);
        } else {
            immutableSortedMap = this.children.insert(front, tree);
        }
        return new ImmutableTree<>(this.value, immutableSortedMap);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public ImmutableTree<T> subtree(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        ImmutableTree<T> immutableTree = this.children.get(path.getFront());
        if (immutableTree != null) {
            return immutableTree.subtree(path.popFront());
        }
        return emptyInstance();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ImmutableTree { value=");
        i0.append((Object) getValue());
        i0.append(", children={");
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            i0.append(next.getKey().asString());
            i0.append("=");
            i0.append(next.getValue());
        }
        i0.append("} }");
        return i0.toString();
    }

    public Collection<T> values() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() {
            /* class com.google.firebase.database.core.utilities.ImmutableTree.AnonymousClass1 */

            public Void onNodeValue(Path path, T t, Void r3) {
                arrayList.add(t);
                return null;
            }
        });
        return arrayList;
    }

    private <R> R fold(Path path, TreeVisitor<? super T, R> treeVisitor, R r) {
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<T>> next = it.next();
            r = (R) next.getValue().fold(path.child(next.getKey()), treeVisitor, r);
        }
        T t = this.value;
        return t != null ? treeVisitor.onNodeValue(path, t, r) : r;
    }

    public ImmutableTree(T t) {
        this(t, EMPTY_CHILDREN);
    }
}
