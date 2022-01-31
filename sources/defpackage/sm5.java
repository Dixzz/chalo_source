package defpackage;

import defpackage.dn5;
import defpackage.mm5;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* renamed from: sm5  reason: default package */
/* compiled from: AutomationEngine */
public class sm5 extends mm5.u<Integer> {
    public final /* synthetic */ so5 h;
    public final /* synthetic */ CountDownLatch i;
    public final /* synthetic */ mm5 j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sm5(mm5 mm5, String str, String str2, so5 so5, CountDownLatch countDownLatch) {
        super(str, str2);
        this.j = mm5;
        this.h = so5;
        this.i = countDownLatch;
    }

    public void run() {
        String str;
        int i2;
        this.f = (T) 0;
        if (!this.j.l.get()) {
            mm5 mm5 = this.j;
            so5 so5 = this.h;
            Objects.requireNonNull(mm5);
            List<String> list = so5.f3238a.r;
            boolean z = (list == null || list.isEmpty() || so5.f3238a.r.contains(mm5.s)) && ((str = so5.f3238a.t) == null || str.equals(mm5.t)) && ((i2 = so5.f3238a.q) == 2 ? mm5.d.d() : i2 != 3 || !mm5.d.d());
            ln5<? extends mn5> ln5 = null;
            if (z) {
                try {
                    ln5 = hd3.O(this.h);
                    this.f = (T) Integer.valueOf(((dn5.a) this.j.e).a(ln5));
                } catch (Exception e) {
                    yj5.e(e, "Unable to create schedule.", new Object[0]);
                    this.g = e;
                }
            }
            this.i.countDown();
            if (1 == this.f.intValue() && ln5 != null) {
                mm5 mm52 = this.j;
                gm5 gm5 = mm52.e;
                mm5.r rVar = new mm5.r(this.h.f3238a.b);
                dn5 dn5 = dn5.this;
                Objects.requireNonNull(dn5);
                yj5.h("onExecuteTriggeredSchedule schedule: %s", ln5.f2243a);
                nn5<?> remove = dn5.q.remove(ln5.f2243a);
                if (remove != null) {
                    remove.e(ln5, rVar);
                    return;
                }
                yj5.c("Unexpected schedule type: %s", ln5.o);
                rVar.a();
            }
        }
    }
}
