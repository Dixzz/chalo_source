package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

public abstract class Index implements Comparator<NamedNode>, j$.util.Comparator {
    public static Index fromQueryDefinition(String str) {
        if (str.equals(".value")) {
            return ValueIndex.getInstance();
        }
        if (str.equals(".key")) {
            return KeyIndex.getInstance();
        }
        if (!str.equals(".priority")) {
            return new PathIndex(new Path(str));
        }
        throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
    }

    public int compare(NamedNode namedNode, NamedNode namedNode2, boolean z) {
        if (z) {
            return compare(namedNode2, namedNode);
        }
        return compare(namedNode, namedNode2);
    }

    public abstract String getQueryDefinition();

    public boolean indexedValueChanged(Node node, Node node2) {
        return compare(new NamedNode(ChildKey.getMinName(), node), new NamedNode(ChildKey.getMinName(), node2)) != 0;
    }

    public abstract boolean isDefinedOn(Node node);

    public abstract NamedNode makePost(ChildKey childKey, Node node);

    public abstract NamedNode maxPost();

    public NamedNode minPost() {
        return NamedNode.getMinNode();
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator<NamedNode> reversed() {
        return Comparator.CC.$default$reversed(this);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.CC.$default$thenComparing(this, function);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    /* Return type fixed from 'java.util.Comparator' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ java.util.Comparator<NamedNode> thenComparing(java.util.Comparator<? super NamedNode> comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }
}
