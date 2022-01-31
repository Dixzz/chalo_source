package defpackage;

import defpackage.m66;
import defpackage.m66.a;

/* renamed from: i66  reason: default package */
/* compiled from: CoroutineContextImpl.kt */
public abstract class i66<B extends m66.a, E extends B> implements m66.b<E> {
    public final m66.b<?> f;
    public final s76<m66.a, E> g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: m66$b<?> */
    /* JADX WARN: Type inference failed for: r3v0, types: [s76<? super m66$a, ? extends E extends B>, java.lang.Object, s76<m66$a, E extends B>] */
    public i66(m66.b<B> bVar, s76<? super m66.a, ? extends E> s76) {
        n86.e(bVar, "baseKey");
        n86.e(s76, "safeCast");
        this.g = s76;
        this.f = bVar instanceof i66 ? (m66.b<B>) ((i66) bVar).f : bVar;
    }
}
