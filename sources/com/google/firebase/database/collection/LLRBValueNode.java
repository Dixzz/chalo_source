package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V> {
    private final K key;
    private LLRBNode<K, V> left;
    private final LLRBNode<K, V> right;
    private final V value;

    public LLRBValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        this.key = k;
        this.value = v;
        this.left = lLRBNode == null ? LLRBEmptyNode.getInstance() : lLRBNode;
        this.right = lLRBNode2 == null ? LLRBEmptyNode.getInstance() : lLRBNode2;
    }

    private LLRBValueNode<K, V> colorFlip() {
        LLRBNode<K, V> lLRBNode = this.left;
        LLRBNode<K, V> copy = lLRBNode.copy(null, null, oppositeColor(lLRBNode), null, null);
        LLRBNode<K, V> lLRBNode2 = this.right;
        return copy((Object) null, (Object) null, oppositeColor(this), (LLRBNode) copy, (LLRBNode) lLRBNode2.copy(null, null, oppositeColor(lLRBNode2), null, null));
    }

    private LLRBValueNode<K, V> fixUp() {
        LLRBValueNode<K, V> rotateLeft = (!this.right.isRed() || this.left.isRed()) ? this : rotateLeft();
        if (rotateLeft.left.isRed() && ((LLRBValueNode) rotateLeft.left).left.isRed()) {
            rotateLeft = rotateLeft.rotateRight();
        }
        return (!rotateLeft.left.isRed() || !rotateLeft.right.isRed()) ? rotateLeft : rotateLeft.colorFlip();
    }

    private LLRBValueNode<K, V> moveRedLeft() {
        LLRBValueNode<K, V> colorFlip = colorFlip();
        return colorFlip.getRight().getLeft().isRed() ? colorFlip.copy(null, null, null, ((LLRBValueNode) colorFlip.getRight()).rotateRight()).rotateLeft().colorFlip() : colorFlip;
    }

    private LLRBValueNode<K, V> moveRedRight() {
        LLRBValueNode<K, V> colorFlip = colorFlip();
        return colorFlip.getLeft().getLeft().isRed() ? colorFlip.rotateRight().colorFlip() : colorFlip;
    }

    private static LLRBNode.Color oppositeColor(LLRBNode lLRBNode) {
        return lLRBNode.isRed() ? LLRBNode.Color.BLACK : LLRBNode.Color.RED;
    }

    private LLRBNode<K, V> removeMin() {
        if (this.left.isEmpty()) {
            return LLRBEmptyNode.getInstance();
        }
        LLRBValueNode<K, V> moveRedLeft = (getLeft().isRed() || getLeft().getLeft().isRed()) ? this : moveRedLeft();
        return moveRedLeft.copy(null, null, ((LLRBValueNode) moveRedLeft.left).removeMin(), null).fixUp();
    }

    private LLRBValueNode<K, V> rotateLeft() {
        return (LLRBValueNode) this.right.copy(null, null, getColor(), copy((Object) null, (Object) null, LLRBNode.Color.RED, (LLRBNode) null, (LLRBNode) ((LLRBValueNode) this.right).left), null);
    }

    private LLRBValueNode<K, V> rotateRight() {
        return (LLRBValueNode) this.left.copy(null, null, getColor(), null, copy((Object) null, (Object) null, LLRBNode.Color.RED, (LLRBNode) ((LLRBValueNode) this.left).right, (LLRBNode) null));
    }

    public abstract LLRBValueNode<K, V> copy(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    public abstract LLRBNode.Color getColor();

    @Override // com.google.firebase.database.collection.LLRBNode
    public K getKey() {
        return this.key;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getLeft() {
        return this.left;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getMax() {
        if (this.right.isEmpty()) {
            return this;
        }
        return this.right.getMax();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getMin() {
        if (this.left.isEmpty()) {
            return this;
        }
        return this.left.getMin();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getRight() {
        return this.right;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public V getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.left.inOrderTraversal(nodeVisitor);
        nodeVisitor.visitEntry(this.key, this.value);
        this.right.inOrderTraversal(nodeVisitor);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> insert(K k, V v, Comparator<K> comparator) {
        LLRBValueNode<K, V> lLRBValueNode;
        int compare = comparator.compare(k, this.key);
        if (compare < 0) {
            lLRBValueNode = copy(null, null, this.left.insert(k, v, comparator), null);
        } else if (compare == 0) {
            lLRBValueNode = copy(k, v, null, null);
        } else {
            lLRBValueNode = copy(null, null, null, this.right.insert(k, v, comparator));
        }
        return lLRBValueNode.fixUp();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> remove(K k, Comparator<K> comparator) {
        LLRBValueNode<K, V> lLRBValueNode;
        if (comparator.compare(k, this.key) < 0) {
            LLRBValueNode<K, V> moveRedLeft = (this.left.isEmpty() || this.left.isRed() || ((LLRBValueNode) this.left).left.isRed()) ? this : moveRedLeft();
            lLRBValueNode = moveRedLeft.copy(null, null, moveRedLeft.left.remove(k, comparator), null);
        } else {
            LLRBValueNode<K, V> rotateRight = this.left.isRed() ? rotateRight() : this;
            if (!rotateRight.right.isEmpty() && !rotateRight.right.isRed() && !((LLRBValueNode) rotateRight.right).left.isRed()) {
                rotateRight = rotateRight.moveRedRight();
            }
            if (comparator.compare(k, rotateRight.key) == 0) {
                if (rotateRight.right.isEmpty()) {
                    return LLRBEmptyNode.getInstance();
                }
                LLRBNode<K, V> min = rotateRight.right.getMin();
                rotateRight = rotateRight.copy(min.getKey(), min.getValue(), null, ((LLRBValueNode) rotateRight.right).removeMin());
            }
            lLRBValueNode = rotateRight.copy(null, null, null, rotateRight.right.remove(k, comparator));
        }
        return lLRBValueNode.fixUp();
    }

    public void setLeft(LLRBNode<K, V> lLRBNode) {
        this.left = lLRBNode;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (!this.left.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor) || !shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
            return false;
        }
        return this.right.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (!this.right.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor) || !shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
            return false;
        }
        return this.left.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBValueNode<K, V> copy(K k, V v, LLRBNode.Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k == null) {
            k = this.key;
        }
        if (v == null) {
            v = this.value;
        }
        if (lLRBNode == null) {
            lLRBNode = this.left;
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = this.right;
        }
        if (color == LLRBNode.Color.RED) {
            return new LLRBRedValueNode(k, v, lLRBNode, lLRBNode2);
        }
        return new LLRBBlackValueNode(k, v, lLRBNode, lLRBNode2);
    }
}
