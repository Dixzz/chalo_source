package defpackage;

import defpackage.sw5;

/* renamed from: ax5  reason: default package */
/* compiled from: Observable */
public class ax5 extends mx5<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ sw5.g f345a;
    public final /* synthetic */ kx5 b;
    public final /* synthetic */ hx5 c;
    public final /* synthetic */ bx5 d;

    public ax5(bx5 bx5, sw5.g gVar, kx5 kx5, hx5 hx5) {
        this.d = bx5;
        this.f345a = gVar;
        this.b = kx5;
        this.c = hx5;
    }

    @Override // defpackage.hx5, defpackage.mx5
    public void a() {
        this.f345a.a(this.b);
    }

    @Override // defpackage.hx5
    public void b(T t) {
        if (!this.d.f488a.b()) {
            sw5.g gVar = this.f345a;
            gVar.c.getAndIncrement();
            kx5 kx5 = new kx5();
            kx5.c(((sw5) this.d.c.apply(t)).g(new gx5(gVar, kx5)));
            return;
        }
        this.b.a();
        this.f345a.a(this.b);
    }
}
