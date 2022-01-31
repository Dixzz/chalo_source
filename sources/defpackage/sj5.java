package defpackage;

import android.content.Context;
import com.urbanairship.UAirship;
import defpackage.ik5;

@Deprecated
/* renamed from: sj5  reason: default package */
/* compiled from: ApplicationMetrics */
public class sj5 extends oj5 {
    public final xl5 e;
    public final wl5 f;
    public final ik5 g;
    public boolean h = false;

    /* renamed from: sj5$a */
    /* compiled from: ApplicationMetrics */
    public class a implements ik5.a {
        public a() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            sj5.this.i();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sj5(Context context, hk5 hk5, ik5 ik5) {
        super(context, hk5);
        bm5 f2 = bm5.f(context);
        this.f = f2;
        this.g = ik5;
        this.e = new rj5(this, ik5);
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        i();
        ik5 ik5 = this.g;
        ik5.b.add(new a());
        this.f.a(this.e);
    }

    public final void i() {
        if (this.g.b(1, 16)) {
            long c = UAirship.c();
            long e2 = this.f2698a.e("com.urbanairship.application.metrics.APP_VERSION", -1);
            if (e2 > -1 && c > e2) {
                this.h = true;
            }
            this.f2698a.f("com.urbanairship.application.metrics.APP_VERSION").b(String.valueOf(c));
            return;
        }
        this.f2698a.l("com.urbanairship.application.metrics.APP_VERSION");
        this.f2698a.l("com.urbanairship.application.metrics.LAST_OPEN");
    }
}
