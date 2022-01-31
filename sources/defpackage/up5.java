package defpackage;

import android.content.Context;
import defpackage.ik5;
import defpackage.kp5;
import defpackage.rt5;
import defpackage.tp5;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: up5  reason: default package */
/* compiled from: NamedUser */
public class up5 extends oj5 {
    public final hk5 e;
    public final Object f = new Object();
    public final qt5 g;
    public final hy5 h;
    public final ik5 i;
    public final kp5 j;
    public final xp5 k;
    public final hq5 l;
    public final rp5 m;
    public final List<yp5> n = new CopyOnWriteArrayList();

    /* renamed from: up5$a */
    /* compiled from: NamedUser */
    public class a implements mp5 {
        public a() {
        }

        @Override // defpackage.mp5
        public void a(String str) {
            if (up5.this.i.d(64)) {
                up5 up5 = up5.this;
                Objects.requireNonNull(up5);
                yj5.a("force named user update.", new Object[0]);
                up5.m();
                up5.i();
            }
        }

        @Override // defpackage.mp5
        public void b(String str) {
        }
    }

    /* renamed from: up5$b */
    /* compiled from: NamedUser */
    public class b implements kp5.d {
        public b() {
        }

        @Override // defpackage.kp5.d
        public tp5.b a(tp5.b bVar) {
            bVar.t = up5.this.j();
            return bVar;
        }
    }

    /* renamed from: up5$c */
    /* compiled from: NamedUser */
    public class c implements ik5.a {
        public c() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            if (!up5.this.i.d(64)) {
                up5.this.l(null);
            }
            if (!up5.this.i.d(32)) {
                up5.this.l.d.e();
                up5.this.m.c.e();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public up5(Context context, hk5 hk5, kq5 kq5, ik5 ik5, kp5 kp5) {
        super(context, hk5);
        qt5 c2 = qt5.c(context);
        hy5 hy5 = hy5.f1445a;
        xp5 xp5 = new xp5(kq5);
        sq5 sq5 = sq5.f3245a;
        rp5 rp5 = new rp5(new np5(kq5, sq5, np5.c), new zp5(hk5, "com.urbanairship.nameduser.ATTRIBUTE_MUTATION_STORE_KEY"));
        hq5 hq5 = new hq5(new fq5(kq5, sq5, new dq5(), "api/named_users/tags/"), new bq5(hk5, "com.urbanairship.nameduser.PENDING_TAG_GROUP_MUTATIONS_KEY"));
        this.e = hk5;
        this.i = ik5;
        this.j = kp5;
        this.g = c2;
        this.h = hy5;
        this.k = xp5;
        this.m = rp5;
        this.l = hq5;
    }

    @Override // defpackage.oj5
    public int a() {
        return 5;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        this.l.b(j(), false);
        this.m.c(j(), false);
        kp5 kp5 = this.j;
        kp5.j.add(new a());
        kp5 kp52 = this.j;
        kp52.k.add(new b());
        if (this.j.l() != null && (!k() || j() != null)) {
            if (this.i.d(64)) {
                i();
            }
        }
        ik5 ik5 = this.i;
        ik5.b.add(new c());
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    @Override // defpackage.oj5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g(com.urbanairship.UAirship r6, defpackage.rt5 r7) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.up5.g(com.urbanairship.UAirship, rt5):int");
    }

    @Override // defpackage.oj5
    public void h() {
        boolean z = true;
        boolean z2 = this.j.l() != null;
        if (j() == null) {
            z = false;
        }
        if (z2 && z) {
            yj5.a("force named user update.", new Object[0]);
            m();
            i();
        }
    }

    public void i() {
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_UPDATE_NAMED_USER";
        a2.c = true;
        a2.b(up5.class);
        this.g.a(a2.a());
    }

    public String j() {
        return this.e.g("com.urbanairship.nameduser.NAMED_USER_ID_KEY", null);
    }

    public boolean k() {
        synchronized (this.f) {
            String g2 = this.e.g("com.urbanairship.nameduser.CHANGE_TOKEN_KEY", null);
            String g3 = this.e.g("com.urbanairship.nameduser.LAST_UPDATED_TOKEN_KEY", null);
            boolean z = true;
            if (j() == null && g2 == null) {
                return true;
            }
            if (g3 == null || !g3.equals(g2)) {
                z = false;
            }
            return z;
        }
    }

    public void l(String str) {
        if (str != null) {
            if (!this.i.d(64)) {
                yj5.a("NamedUser - Contacts is disabled, ignoring named user association.", new Object[0]);
                return;
            }
        }
        String str2 = null;
        if (!hd3.G1(str)) {
            str2 = str.trim();
            if (hd3.G1(str2) || str2.length() > 128) {
                yj5.c("Failed to set named user ID. The named user ID must be composedof non-whitespace characters and be less than 129 characters in length.", new Object[0]);
                return;
            }
        }
        synchronized (this.f) {
            if (!hd3.R0(j(), str2)) {
                hk5 hk5 = this.e;
                if (str2 == null) {
                    hk5.l("com.urbanairship.nameduser.NAMED_USER_ID_KEY");
                } else {
                    hk5.f("com.urbanairship.nameduser.NAMED_USER_ID_KEY").b(str2);
                }
                m();
                this.m.c(j(), true);
                this.l.b(j(), true);
                i();
                if (str2 != null) {
                    this.j.s();
                }
                for (yp5 yp5 : this.n) {
                    yp5.a(str2);
                }
            } else {
                yj5.a("Skipping update. Named user ID trimmed already matches existing named user: %s", j());
            }
        }
    }

    public final void m() {
        hk5 hk5 = this.e;
        String uuid = UUID.randomUUID().toString();
        if (uuid == null) {
            hk5.l("com.urbanairship.nameduser.CHANGE_TOKEN_KEY");
        } else {
            hk5.f("com.urbanairship.nameduser.CHANGE_TOKEN_KEY").b(uuid);
        }
    }
}
