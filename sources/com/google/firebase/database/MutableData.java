package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

public class MutableData {
    private final SnapshotHolder holder;
    private final Path prefixPath;

    public MutableData child(String str) {
        Validation.validatePathString(str);
        return new MutableData(this.holder, this.prefixPath.child(new Path(str)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableData) {
            MutableData mutableData = (MutableData) obj;
            return this.holder.equals(mutableData.holder) && this.prefixPath.equals(mutableData.prefixPath);
        }
    }

    public Iterable<MutableData> getChildren() {
        Node node = getNode();
        if (node.isEmpty() || node.isLeafNode()) {
            return new Object() {
                /* class com.google.firebase.database.MutableData.AnonymousClass1 */

                @Override // j$.lang.Iterable
                public /* synthetic */ void forEach(Consumer consumer) {
                    Iterable.CC.$default$forEach(this, consumer);
                }

                @Override // j$.lang.Iterable, java.lang.Iterable
                public Iterator<MutableData> iterator() {
                    return new Object() {
                        /* class com.google.firebase.database.MutableData.AnonymousClass1.AnonymousClass1 */

                        @Override // j$.util.Iterator
                        public /* synthetic */ void forEachRemaining(Consumer consumer) {
                            Iterator.CC.$default$forEachRemaining(this, consumer);
                        }

                        @Override // j$.util.Iterator
                        public boolean hasNext() {
                            return false;
                        }

                        @Override // j$.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove called on immutable collection");
                        }

                        @Override // j$.util.Iterator, java.util.Iterator
                        public MutableData next() {
                            throw new NoSuchElementException();
                        }
                    };
                }

                /* Return type fixed from 'j$.util.Spliterator' to match base method */
                @Override // j$.lang.Iterable, java.lang.Iterable
                public /* synthetic */ Spliterator<MutableData> spliterator() {
                    return Iterable.CC.$default$spliterator(this);
                }
            };
        }
        final java.util.Iterator<NamedNode> it = IndexedNode.from(node).iterator();
        return new Object() {
            /* class com.google.firebase.database.MutableData.AnonymousClass2 */

            @Override // j$.lang.Iterable
            public /* synthetic */ void forEach(Consumer consumer) {
                Iterable.CC.$default$forEach(this, consumer);
            }

            @Override // j$.lang.Iterable, java.lang.Iterable
            public java.util.Iterator<MutableData> iterator() {
                return new Object() {
                    /* class com.google.firebase.database.MutableData.AnonymousClass2.AnonymousClass1 */

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
                    public MutableData next() {
                        return new MutableData(MutableData.this.holder, MutableData.this.prefixPath.child(((NamedNode) it.next()).getName()));
                    }
                };
            }

            /* Return type fixed from 'j$.util.Spliterator' to match base method */
            @Override // j$.lang.Iterable, java.lang.Iterable
            public /* synthetic */ Spliterator<MutableData> spliterator() {
                return Iterable.CC.$default$spliterator(this);
            }
        };
    }

    public long getChildrenCount() {
        return (long) getNode().getChildCount();
    }

    public String getKey() {
        if (this.prefixPath.getBack() != null) {
            return this.prefixPath.getBack().asString();
        }
        return null;
    }

    public Node getNode() {
        return this.holder.getNode(this.prefixPath);
    }

    public Object getPriority() {
        return getNode().getPriority().getValue();
    }

    public Object getValue() {
        return getNode().getValue();
    }

    public boolean hasChild(String str) {
        return !getNode().getChild(new Path(str)).isEmpty();
    }

    public boolean hasChildren() {
        Node node = getNode();
        return !node.isLeafNode() && !node.isEmpty();
    }

    public void setPriority(Object obj) {
        this.holder.update(this.prefixPath, getNode().updatePriority(PriorityUtilities.parsePriority(this.prefixPath, obj)));
    }

    public void setValue(Object obj) throws DatabaseException {
        ValidationPath.validateWithObject(this.prefixPath, obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        this.holder.update(this.prefixPath, NodeUtilities.NodeFromJSON(convertToPlainJavaTypes));
    }

    public String toString() {
        ChildKey front = this.prefixPath.getFront();
        StringBuilder i0 = hj1.i0("MutableData { key = ");
        i0.append(front != null ? front.asString() : "<none>");
        i0.append(", value = ");
        i0.append(this.holder.getRootNode().getValue(true));
        i0.append(" }");
        return i0.toString();
    }

    public MutableData(Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }

    public <T> T getValue(Class<T> cls) {
        return (T) CustomClassMapper.convertToCustomClass(getNode().getValue(), cls);
    }

    private MutableData(SnapshotHolder snapshotHolder, Path path) {
        this.holder = snapshotHolder;
        this.prefixPath = path;
        ValidationPath.validateWithObject(path, getValue());
    }

    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return (T) CustomClassMapper.convertToCustomClass(getNode().getValue(), genericTypeIndicator);
    }
}
