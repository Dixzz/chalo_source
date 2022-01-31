package defpackage;

/* renamed from: qe4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class qe4 extends j64 {
    public final /* synthetic */ re4 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qe4(re4 re4, uc4 uc4) {
        super(uc4);
        this.e = re4;
    }

    @Override // defpackage.j64
    public final void a() {
        re4 re4 = this.e;
        re4.b();
        if (re4.A()) {
            re4.g().n.a("Inactivity, disconnecting from the service");
            re4.C();
        }
    }
}
