package defpackage;

/* renamed from: ce3  reason: default package */
public final class ce3 implements gd3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f557a;
    public final /* synthetic */ zd3 b;

    public ce3(zd3 zd3, Runnable runnable) {
        this.b = zd3;
        this.f557a = runnable;
    }

    @Override // defpackage.gd3
    public final void a(Throwable th) {
        this.b.f4160a.post(this.f557a);
    }
}
