package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: el5  reason: default package */
/* compiled from: Analytics */
public class el5 implements xl5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fl5 f991a;

    public el5(fl5 fl5) {
        this.f991a = fl5;
    }

    @Override // defpackage.xl5
    public void a(long j) {
        this.f991a.k(j);
    }

    @Override // defpackage.xl5
    public void b(long j) {
        fl5 fl5 = this.f991a;
        fl5.l(null);
        fl5.i(new il5(j));
        yj5.a("Setting conversion send ID: %s", null);
        fl5.r = null;
        yj5.a("Setting conversion metadata: %s", null);
        fl5.s = null;
        if (fl5.l.d(16)) {
            fl5.f.b(0, TimeUnit.MILLISECONDS);
        }
    }
}
