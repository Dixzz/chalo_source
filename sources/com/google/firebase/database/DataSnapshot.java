package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Spliterator;

public class DataSnapshot {
    private final IndexedNode node;
    private final DatabaseReference query;

    public DataSnapshot(DatabaseReference databaseReference, IndexedNode indexedNode) {
        this.node = indexedNode;
        this.query = databaseReference;
    }

    public DataSnapshot child(String str) {
        return new DataSnapshot(this.query.child(str), IndexedNode.from(this.node.getNode().getChild(new Path(str))));
    }

    public boolean exists() {
        return !this.node.getNode().isEmpty();
    }

    public Iterable<DataSnapshot> getChildren() {
        final Iterator<NamedNode> it = this.node.iterator();
        return new Object() {
            /* class com.google.firebase.database.DataSnapshot.AnonymousClass1 */

            @Override // j$.lang.Iterable
            public /* synthetic */ void forEach(Consumer consumer) {
                Iterable.CC.$default$forEach(this, consumer);
            }

            @Override // j$.lang.Iterable, java.lang.Iterable
            public Iterator<DataSnapshot> iterator() {
                return new Object() {
                    /* class com.google.firebase.database.DataSnapshot.AnonymousClass1.AnonymousClass1 */

                    @Override // j$.util.Iterator
                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    @Override // j$.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // j$.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }

                    @Override // j$.util.Iterator, java.util.Iterator
                    public DataSnapshot next() {
                        NamedNode namedNode = (NamedNode) it.next();
                        return new DataSnapshot(DataSnapshot.this.query.child(namedNode.getName().asString()), IndexedNode.from(namedNode.getNode()));
                    }
                };
            }

            /* Return type fixed from 'j$.util.Spliterator' to match base method */
            @Override // j$.lang.Iterable, java.lang.Iterable
            public /* synthetic */ Spliterator<DataSnapshot> spliterator() {
                return Iterable.CC.$default$spliterator(this);
            }
        };
    }

    public long getChildrenCount() {
        return (long) this.node.getNode().getChildCount();
    }

    public String getKey() {
        return this.query.getKey();
    }

    public Object getPriority() {
        Object value = this.node.getNode().getPriority().getValue();
        return value instanceof Long ? Double.valueOf((double) ((Long) value).longValue()) : value;
    }

    public DatabaseReference getRef() {
        return this.query;
    }

    public Object getValue() {
        return this.node.getNode().getValue();
    }

    public boolean hasChild(String str) {
        if (this.query.getParent() == null) {
            Validation.validateRootPathString(str);
        } else {
            Validation.validatePathString(str);
        }
        return !this.node.getNode().getChild(new Path(str)).isEmpty();
    }

    public boolean hasChildren() {
        return this.node.getNode().getChildCount() > 0;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DataSnapshot { key = ");
        i0.append(this.query.getKey());
        i0.append(", value = ");
        i0.append(this.node.getNode().getValue(true));
        i0.append(" }");
        return i0.toString();
    }

    public Object getValue(boolean z) {
        return this.node.getNode().getValue(z);
    }

    public <T> T getValue(Class<T> cls) {
        return (T) CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), cls);
    }

    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return (T) CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), genericTypeIndicator);
    }
}
