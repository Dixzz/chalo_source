package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: vw5  reason: default package */
/* compiled from: Observable */
public final class vw5 implements qw5<hx5<T>, nx5> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ sw5 f3687a;
    public final /* synthetic */ sw5 b;

    public vw5(sw5 sw5, sw5 sw52) {
        this.f3687a = sw5;
        this.b = sw52;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.qw5
    public nx5 apply(Object obj) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        pw5 pw5 = new pw5();
        uw5 uw5 = new uw5(this, (hx5) obj, atomicInteger, pw5);
        pw5.c(this.f3687a.g(uw5));
        pw5.c(this.b.g(uw5));
        return pw5;
    }
}
