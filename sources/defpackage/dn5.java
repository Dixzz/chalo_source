package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import defpackage.dp5;
import defpackage.ik5;
import defpackage.in5;
import defpackage.jn5;
import defpackage.jr5;
import defpackage.mm5;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: dn5  reason: default package */
/* compiled from: InAppAutomation */
public class dn5 extends oj5 {
    public final jn5 e;
    public final Handler f;
    public final kp5 g;
    public final mm5 h;
    public final jr5 i;
    public final dp5 j;
    public final bz5 k;
    public final do5 l;
    public final jo5 m;
    public final ik5 n;
    public final em5 o;
    public final hn5 p;
    public final Map<String, nn5<?>> q = new HashMap();
    public final Map<String, fo5> r = new HashMap();
    public final AtomicBoolean s = new AtomicBoolean(false);
    public nx5 t;
    public final gm5 u = new a();
    public final jn5.c v = new b();
    public final ik5.a w = new c();

    /* renamed from: dn5$a */
    /* compiled from: InAppAutomation */
    public class a implements gm5 {
        public a() {
        }

        public int a(ln5 ln5) {
            dn5 dn5 = dn5.this;
            Objects.requireNonNull(dn5);
            yj5.h("onCheckExecutionReadiness schedule: %s", ln5.f2243a);
            if (dn5.f2698a.b("com.urbanairship.iam.paused", false)) {
                return 0;
            }
            if (dn5.n(ln5)) {
                nn5<?> remove = dn5.q.remove(ln5.f2243a);
                if (remove != null) {
                    remove.f(ln5);
                }
                return -1;
            }
            fo5 remove2 = dn5.r.remove(ln5.f2243a);
            if (remove2 == null || remove2.a()) {
                nn5<?> nn5 = dn5.q.get(ln5.f2243a);
                if (nn5 == null) {
                    return 0;
                }
                return nn5.c(ln5);
            }
            nn5<?> remove3 = dn5.q.remove(ln5.f2243a);
            if (remove3 != null) {
                remove3.f(ln5);
            }
            return 2;
        }
    }

    /* renamed from: dn5$b */
    /* compiled from: InAppAutomation */
    public class b implements jn5.c {
        public b() {
        }

        public ck5<Boolean> a(String str, on5<? extends mn5> on5) {
            dn5 dn5 = dn5.this;
            dn5.l();
            mm5 mm5 = dn5.h;
            Objects.requireNonNull(mm5);
            ck5<Boolean> ck5 = new ck5<>();
            mm5.i.post(new jm5(mm5, str, ck5, on5));
            return ck5;
        }
    }

    /* renamed from: dn5$c */
    /* compiled from: InAppAutomation */
    public class c implements ik5.a {
        public c() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            dn5.this.j();
            dn5.this.p();
        }
    }

    /* renamed from: dn5$d */
    /* compiled from: InAppAutomation */
    public class d implements jr5.b {
        public d() {
        }
    }

    /* renamed from: dn5$e */
    /* compiled from: InAppAutomation */
    public class e implements dp5.a {
        public e() {
        }
    }

    /* renamed from: dn5$f */
    /* compiled from: InAppAutomation */
    public class f implements mm5.s {
        public f() {
        }
    }

    public dn5(Context context, hk5 hk5, kq5 kq5, ik5 ik5, fl5 fl5, wx5 wx5, kp5 kp5, up5 up5) {
        super(context, hk5);
        this.n = ik5;
        this.h = new mm5(context, kq5, fl5, hk5);
        this.g = kp5;
        this.j = new dp5(kq5, kp5, up5, hk5);
        this.e = new jn5(hk5, wx5);
        jr5 jr5 = new jr5(context, hk5, fl5, new d());
        this.i = jr5;
        this.f = new Handler(qj5.a());
        this.k = new bz5(new Handler(Looper.getMainLooper()), pj5.a());
        this.l = new do5(kq5, new ao5(kq5, kp5));
        this.o = new em5();
        this.p = new hn5(jr5);
        this.m = new jo5(context, kq5);
    }

    @Override // defpackage.oj5
    public int a() {
        return 3;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        this.j.h = new e();
        mm5 mm5 = this.h;
        f fVar = new f();
        synchronized (mm5) {
            mm5.k = fVar;
        }
        p();
    }

    @Override // defpackage.oj5
    public void d(UAirship uAirship) {
        this.i.b.a(false);
        ik5 ik5 = this.n;
        ik5.b.add(this.w);
        j();
    }

    @Override // defpackage.oj5
    public void e(boolean z) {
        p();
    }

    @Override // defpackage.oj5
    public void f(zt5 zt5) {
        in5 in5;
        if (zt5 == null) {
            in5 = new in5(new in5.a(true, in5.a.e, in5.a.f, in5.a.g));
        } else {
            in5.a aVar = null;
            if (zt5.f.containsKey("tag_groups")) {
                JsonValue u2 = zt5.u("tag_groups");
                int i2 = in5.a.h;
                zt5 n2 = u2.n();
                aVar = new in5.a(n2.u("enabled").a(true), n2.u("cache_max_age_seconds").g(in5.a.e), n2.u("cache_stale_read_age_seconds").g(in5.a.f), n2.u("cache_prefer_local_until_seconds").g(in5.a.g));
            }
            if (aVar != null) {
                in5 = new in5(aVar);
            } else {
                in5 = new in5(new in5.a(true, in5.a.e, in5.a.f, in5.a.g));
            }
        }
        this.j.f878a.f("com.urbanairship.iam.tags.FETCH_ENABLED").b(String.valueOf(in5.f1540a.f1541a));
        dp5 dp5 = this.j;
        long j2 = in5.f1540a.c;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        dp5.g.f1157a.f("com.urbanairship.iam.tags.TAG_STALE_READ_TIME").b(String.valueOf(timeUnit.toMillis(j2)));
        dp5 dp52 = this.j;
        long j3 = in5.f1540a.d;
        dp52.f878a.f("com.urbanairship.iam.tags.TAG_PREFER_LOCAL_DATA_TIME").b(String.valueOf(timeUnit.toMillis(j3)));
        dp5 dp53 = this.j;
        long j4 = in5.f1540a.b;
        dp53.g.f1157a.f("com.urbanairship.iam.tags.TAG_CACHE_MAX_AGE_TIME").b(String.valueOf(timeUnit.toMillis(j4)));
    }

    public ck5<Boolean> i(String str) {
        l();
        mm5 mm5 = this.h;
        List singletonList = Collections.singletonList(str);
        Objects.requireNonNull(mm5);
        ck5<Boolean> ck5 = new ck5<>();
        mm5.i.post(new zm5(mm5, singletonList, ck5));
        return ck5;
    }

    public final void j() {
        long j2;
        synchronized (this.v) {
            if (this.n.d(1)) {
                l();
                if (this.t == null) {
                    if (this.e.f1959a.e("com.urbanairship.iam.data.NEW_USER_TIME", -1) == -1) {
                        jn5 jn5 = this.e;
                        try {
                            j2 = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0).firstInstallTime;
                        } catch (Exception e2) {
                            yj5.i("Unable to get install date", e2);
                            j2 = this.g.l() == null ? System.currentTimeMillis() : 0;
                        }
                        jn5.f1959a.f("com.urbanairship.iam.data.NEW_USER_TIME").b(String.valueOf(j2));
                    }
                    this.t = this.e.k(this.f.getLooper(), this.v);
                }
            } else {
                nx5 nx5 = this.t;
                if (nx5 != null) {
                    nx5.a();
                    this.t = null;
                }
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final nn5<? extends mn5> k(ln5<? extends mn5> ln5) {
        String str = ln5.o;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1161803523:
                if (str.equals("actions")) {
                    c2 = 0;
                    break;
                }
                break;
            case -379237425:
                if (str.equals("in_app_message")) {
                    c2 = 1;
                    break;
                }
                break;
            case 647890911:
                if (str.equals("deferred")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return this.o;
            case 1:
                return this.p;
            case 2:
                if ("in_app_message".equals(((co5) ln5.a()).h)) {
                    return this.p;
                }
                break;
        }
        return null;
    }

    public final void l() {
        if (!this.s.getAndSet(true)) {
            yj5.h("Starting In-App automation", new Object[0]);
            this.h.s(this.u);
        }
    }

    public final int m(ln5<? extends mn5> ln5) {
        fm5 fm5 = ln5.l;
        if (fm5 != null) {
            String str = fm5.m;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1367724422:
                    if (str.equals("cancel")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3532159:
                    if (str.equals("skip")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 311930832:
                    if (str.equals("penalize")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return 1;
                case 1:
                    return 3;
            }
        }
        return 2;
    }

    public final boolean n(ln5<? extends mn5> ln5) {
        return this.e.d(ln5) && !this.e.b.j(ln5.b.u("com.urbanairship.iaa.REMOTE_DATA_METADATA").n());
    }

    public ck5<Boolean> o(ln5<? extends mn5> ln5) {
        l();
        mm5 mm5 = this.h;
        Objects.requireNonNull(mm5);
        ck5<Boolean> ck5 = new ck5<>();
        mm5.i.post(new xm5(mm5, ck5, ln5));
        return ck5;
    }

    public final void p() {
        boolean z = false;
        if (this.n.d(1) && c()) {
            z = true;
        }
        mm5 mm5 = this.h;
        boolean z2 = true ^ z;
        mm5.l.set(z2);
        if (!z2 && mm5.h) {
            mm5.m();
        }
    }
}
