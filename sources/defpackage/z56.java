package defpackage;

import java.util.Iterator;

/* renamed from: z56  reason: default package */
/* compiled from: Sequences.kt */
public final class z56 implements w96<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Iterable f4133a;

    public z56(Iterable iterable) {
        this.f4133a = iterable;
    }

    @Override // defpackage.w96
    public Iterator<T> iterator() {
        return this.f4133a.iterator();
    }
}
