package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

/* compiled from: com.google.firebase:firebase-database-collection@@17.0.1 */
public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    public LLRBRedValueNode(K k, V v) {
        super(k, v, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public LLRBValueNode<K, V> copy(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k == null) {
            k = getKey();
        }
        if (v == null) {
            v = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = getLeft();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = getRight();
        }
        return new LLRBRedValueNode(k, v, lLRBNode, lLRBNode2);
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public LLRBNode.Color getColor() {
        return LLRBNode.Color.RED;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isRed() {
        return true;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        return getRight().size() + getLeft().size() + 1;
    }

    public LLRBRedValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k, v, lLRBNode, lLRBNode2);
    }
}
