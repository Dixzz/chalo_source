package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import defpackage.ik5;
import defpackage.rt5;
import defpackage.tp5;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: kp5  reason: default package */
/* compiled from: AirshipChannel */
public class kp5 extends oj5 {
    public final sp5 e;
    public final qt5 f;
    public final ku5 g;
    public final hy5 h;
    public final ik5 i;
    public final List<mp5> j = new CopyOnWriteArrayList();
    public final List<d> k = new CopyOnWriteArrayList();
    public final Object l = new Object();
    public final hq5 m;
    public final rp5 n;
    public final kq5 o;
    public boolean p = true;
    public boolean q;

    /* renamed from: kp5$a */
    /* compiled from: AirshipChannel */
    public class a implements ik5.a {
        public a() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            if (!kp5.this.i.d(32)) {
                synchronized (kp5.this.l) {
                    kp5.this.f2698a.l("com.urbanairship.push.TAGS");
                }
                kp5.this.m.d.e();
                kp5.this.n.c.e();
            }
            kp5.this.s();
        }
    }

    /* renamed from: kp5$b */
    /* compiled from: AirshipChannel */
    public class b implements ju5 {
        public b() {
        }

        @Override // defpackage.ju5
        public void a(Locale locale) {
            kp5.this.i();
        }
    }

    /* renamed from: kp5$c */
    /* compiled from: AirshipChannel */
    public class c extends op5 {
        public c(hy5 hy5) {
            super(hy5);
        }

        @Override // defpackage.op5
        public void c(List<qp5> list) {
            if (!kp5.this.i.d(32)) {
                yj5.i("AirshipChannel - Unable to apply attribute edits when opted out of tags and attributes.", new Object[0]);
            } else if (!list.isEmpty()) {
                kp5.this.n.a(list);
                kp5.this.i();
            }
        }
    }

    /* renamed from: kp5$d */
    /* compiled from: AirshipChannel */
    public interface d {
        tp5.b a(tp5.b bVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kp5(Context context, hk5 hk5, kq5 kq5, ik5 ik5, ku5 ku5) {
        super(context, hk5);
        qt5 c2 = qt5.c(context);
        hy5 hy5 = hy5.f1445a;
        sp5 sp5 = new sp5(kq5);
        sq5 sq5 = sq5.f3245a;
        rp5 rp5 = new rp5(new np5(kq5, sq5, np5.d), new zp5(hk5, "com.urbanairship.push.ATTRIBUTE_DATA_STORE"));
        hq5 hq5 = new hq5(new fq5(kq5, sq5, new eq5(kq5), "api/channels/tags/"), new bq5(hk5, "com.urbanairship.push.PENDING_TAG_GROUP_MUTATIONS"));
        this.o = kq5;
        this.g = ku5;
        this.i = ik5;
        this.f = c2;
        this.e = sp5;
        this.n = rp5;
        this.m = hq5;
        this.h = hy5;
    }

    @Override // defpackage.oj5
    public int a() {
        return 7;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        boolean z = false;
        this.m.b(l(), false);
        this.n.c(l(), false);
        if (yj5.f4059a.b < 7 && !hd3.G1(l())) {
            UAirship.b();
            l();
        }
        if (l() == null && this.o.b.t) {
            z = true;
        }
        this.q = z;
        ik5 ik5 = this.i;
        ik5.b.add(new a());
    }

    @Override // defpackage.oj5
    public void d(UAirship uAirship) {
        ku5 ku5 = this.g;
        ku5.c.add(new b());
        if (l() != null || !this.q) {
            i();
        }
    }

    @Override // defpackage.oj5
    public void e(boolean z) {
        if (z && this.i.c()) {
            i();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be  */
    @Override // defpackage.oj5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g(com.urbanairship.UAirship r18, defpackage.rt5 r19) {
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kp5.g(com.urbanairship.UAirship, rt5):int");
    }

    @Override // defpackage.oj5
    public void h() {
        if (this.i.c()) {
            j(true);
        }
    }

    public final void i() {
        if (l() != null || this.i.c()) {
            j(false);
        }
    }

    public final void j(boolean z) {
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_UPDATE_CHANNEL";
        a2.e = zt5.s().g("EXTRA_FORCE_FULL_UPDATE", z).a();
        a2.c = true;
        a2.b(kp5.class);
        this.f.a(a2.a());
    }

    public op5 k() {
        return new c(this.h);
    }

    public String l() {
        return this.f2698a.g("com.urbanairship.push.CHANNEL_ID", null);
    }

    public final tp5 m() {
        JsonValue d2 = this.f2698a.d("com.urbanairship.push.LAST_REGISTRATION_PAYLOAD");
        if (d2.l()) {
            return null;
        }
        try {
            return tp5.a(d2);
        } catch (xt5 e2) {
            yj5.e(e2, "AirshipChannel - Failed to parse payload from JSON.", new Object[0]);
            return null;
        }
    }

    public final tp5 n() {
        boolean z = this.p;
        tp5.b bVar = new tp5.b();
        Set<String> o2 = z ? o() : null;
        bVar.e = z;
        bVar.f = o2;
        int a2 = this.o.a();
        if (a2 == 1) {
            bVar.c = "amazon";
        } else if (a2 == 2) {
            bVar.c = "android";
        } else {
            throw new IllegalStateException("Unable to get platform");
        }
        if (this.i.d(16)) {
            if (UAirship.e() != null) {
                bVar.m = UAirship.e().versionName;
            }
            bVar.q = hd3.d1();
            bVar.o = Build.MODEL;
            bVar.p = Integer.valueOf(Build.VERSION.SDK_INT);
        }
        if (this.i.c()) {
            bVar.i = TimeZone.getDefault().getID();
            Locale a3 = this.g.a();
            if (!hd3.G1(a3.getCountry())) {
                bVar.k = a3.getCountry();
            }
            if (!hd3.G1(a3.getLanguage())) {
                bVar.j = a3.getLanguage();
            }
            Object obj = UAirship.t;
            bVar.n = "14.6.0";
            for (d dVar : this.k) {
                bVar = dVar.a(bVar);
            }
        }
        return bVar.a();
    }

    public Set<String> o() {
        synchronized (this.l) {
            if (!this.i.d(32)) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet();
            JsonValue d2 = this.f2698a.d("com.urbanairship.push.TAGS");
            if (d2.f instanceof yt5) {
                Iterator<JsonValue> it = d2.m().iterator();
                while (it.hasNext()) {
                    JsonValue next = it.next();
                    if (next.f instanceof String) {
                        hashSet.add(next.i());
                    }
                }
            }
            Set<String> l2 = hd3.l2(hashSet);
            if (hashSet.size() != ((HashSet) l2).size()) {
                r(l2);
            }
            return l2;
        }
    }

    public final int p() {
        tp5 n2 = n();
        try {
            tq5<String> a2 = this.e.a(n2);
            if (a2.c()) {
                T t = a2.e;
                yj5.f("Airship channel created: %s", t);
                hk5 hk5 = this.f2698a;
                if (t == null) {
                    hk5.l("com.urbanairship.push.CHANNEL_ID");
                } else {
                    hk5.f("com.urbanairship.push.CHANNEL_ID").b(t);
                }
                this.m.b(t, false);
                this.n.c(t, false);
                q(n2);
                for (mp5 mp5 : this.j) {
                    mp5.a(t);
                }
                if (this.o.b.w) {
                    Intent addCategory = new Intent("com.urbanairship.CHANNEL_CREATED").setPackage(UAirship.g()).addCategory(UAirship.g());
                    addCategory.putExtra("channel_id", (String) t);
                    this.c.sendBroadcast(addCategory);
                }
                return 0;
            } else if (a2.b() || a2.d()) {
                yj5.a("Channel registration failed with status: %s, will retry", Integer.valueOf(a2.c));
                return 1;
            } else {
                yj5.a("Channel registration failed with status: %s", Integer.valueOf(a2.c));
                return 0;
            }
        } catch (rq5 e2) {
            yj5.b(e2, "Channel registration failed, will retry", new Object[0]);
            return 1;
        }
    }

    public final void q(tp5 tp5) {
        this.f2698a.i("com.urbanairship.push.LAST_REGISTRATION_PAYLOAD", tp5);
        this.f2698a.f("com.urbanairship.push.LAST_REGISTRATION_TIME").b(String.valueOf(System.currentTimeMillis()));
    }

    public void r(Set<String> set) {
        synchronized (this.l) {
            if (!this.i.d(32)) {
                yj5.i("AirshipChannel - Unable to apply attribute edits when opted out of tags and attributes.", new Object[0]);
                return;
            }
            this.f2698a.j("com.urbanairship.push.TAGS", JsonValue.x(hd3.l2(set)));
            i();
        }
    }

    public void s() {
        if (l() != null || this.i.c()) {
            i();
        }
    }
}
