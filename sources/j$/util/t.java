package j$.util;

import j$.util.u;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/* access modifiers changed from: package-private */
public class t extends u.i<E> {
    final /* synthetic */ SortedSet f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    t(SortedSet sortedSet, Collection collection, int i) {
        super(collection, i);
        this.f = sortedSet;
    }

    @Override // j$.util.u.i, j$.util.Spliterator
    public Comparator getComparator() {
        return this.f.comparator();
    }
}
