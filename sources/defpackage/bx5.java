package defpackage;

import defpackage.sw5;
import java.lang.ref.WeakReference;

/* renamed from: bx5  reason: default package */
/* compiled from: Observable */
public class bx5 implements qw5<hx5<R>, nx5> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ pw5 f488a;
    public final /* synthetic */ WeakReference b;
    public final /* synthetic */ qw5 c;

    public bx5(sw5 sw5, pw5 pw5, WeakReference weakReference, qw5 qw5) {
        this.f488a = pw5;
        this.b = weakReference;
        this.c = qw5;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.qw5
    public nx5 apply(Object obj) {
        hx5 hx5 = (hx5) obj;
        sw5.g gVar = new sw5.g(hx5, this.f488a);
        sw5 sw5 = (sw5) this.b.get();
        if (sw5 == null) {
            hx5.a();
            return new nx5();
        }
        kx5 kx5 = new kx5();
        this.f488a.c(kx5);
        kx5.c(sw5.g(new ax5(this, gVar, kx5, hx5)));
        return this.f488a;
    }
}
