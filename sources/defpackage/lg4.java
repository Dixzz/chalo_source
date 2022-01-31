package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import com.google.firebase.messaging.Constants;
import com.razorpay.AnalyticsConstants;
import defpackage.cr3;
import defpackage.uq3;
import defpackage.wq3;
import defpackage.xq3;
import defpackage.yq3;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* renamed from: lg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public class lg4 implements uc4 {
    public static volatile lg4 A;

    /* renamed from: a  reason: collision with root package name */
    public qb4 f2214a;
    public ya4 b;
    public h64 c;
    public cb4 d;
    public ig4 e;
    public ch4 f;
    public final rg4 g;
    public he4 h;
    public rf4 i;
    public final vb4 j;
    public boolean k = false;
    public boolean l;
    public long m;
    public List<Runnable> n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public FileLock t;
    public FileChannel u;
    public List<Long> v;
    public List<Long> w;
    public long x;
    public final Map<String, e64> y;
    public final wg4 z = new og4(this);

    /* renamed from: lg4$a */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public yq3 f2215a;
        public List<Long> b;
        public List<uq3> c;
        public long d;

        public a(lg4 lg4, kg4 kg4) {
        }

        public final void a(yq3 yq3) {
            this.f2215a = yq3;
        }

        public final boolean b(long j, uq3 uq3) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (this.c.size() > 0 && ((this.c.get(0).G() / 1000) / 60) / 60 != ((uq3.G() / 1000) / 60) / 60) {
                return false;
            }
            long a2 = this.d + ((long) uq3.a());
            if (a2 >= ((long) Math.max(0, q64.i.a(null).intValue()))) {
                return false;
            }
            this.d = a2;
            this.c.add(uq3);
            this.b.add(Long.valueOf(j));
            if (this.c.size() >= Math.max(1, q64.j.a(null).intValue())) {
                return false;
            }
            return true;
        }
    }

    public lg4(sg4 sg4) {
        vb4 b2 = vb4.b(sg4.f3211a, null, null);
        this.j = b2;
        this.x = -1;
        rg4 rg4 = new rg4(this);
        rg4.l();
        this.g = rg4;
        ya4 ya4 = new ya4(this);
        ya4.l();
        this.b = ya4;
        qb4 qb4 = new qb4(this);
        qb4.l();
        this.f2214a = qb4;
        this.y = new HashMap();
        b2.f().u(new kg4(this, sg4));
    }

    public static void C(jg4 jg4) {
        if (jg4 == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!jg4.c) {
            String valueOf = String.valueOf(jg4.getClass());
            throw new IllegalStateException(hj1.x(valueOf.length() + 27, "Component not initialized: ", valueOf));
        }
    }

    public static lg4 b(Context context) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (A == null) {
            synchronized (lg4.class) {
                if (A == null) {
                    A = new lg4(new sg4(context));
                }
            }
        }
        return A;
    }

    public static void d(uq3.a aVar, int i2, String str) {
        List<wq3> s2 = aVar.s();
        for (int i3 = 0; i3 < s2.size(); i3++) {
            if ("_err".equals(s2.get(i3).A())) {
                return;
            }
        }
        wq3.a P = wq3.P();
        P.o("_err");
        P.m(Long.valueOf((long) i2).longValue());
        wq3 wq3 = (wq3) ((ru3) P.k());
        wq3.a P2 = wq3.P();
        P2.o("_ev");
        P2.p(str);
        wq3 wq32 = (wq3) ((ru3) P2.k());
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        uq3.z((uq3) aVar.g, wq3);
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        uq3.z((uq3) aVar.g, wq32);
    }

    public static void h(uq3.a aVar, String str) {
        List<wq3> s2 = aVar.s();
        for (int i2 = 0; i2 < s2.size(); i2++) {
            if (str.equals(s2.get(i2).A())) {
                aVar.u(i2);
                return;
            }
        }
    }

    public final void A(uq3.a aVar, uq3.a aVar2) {
        gj1.b("_e".equals(aVar.v()));
        N();
        wq3 v2 = rg4.v((uq3) ((ru3) aVar.k()), "_et");
        if (v2.H() && v2.I() > 0) {
            long I = v2.I();
            N();
            wq3 v3 = rg4.v((uq3) ((ru3) aVar2.k()), "_et");
            if (v3 != null && v3.I() > 0) {
                I += v3.I();
            }
            N();
            rg4.D(aVar2, "_et", Long.valueOf(I));
            N();
            rg4.D(aVar, "_fr", 1L);
        }
    }

    public final void B(zzaq zzaq, zzn zzn) {
        if (f04.a() && this.j.g.l(q64.A0)) {
            va4 b2 = va4.b(zzaq);
            this.j.t().G(b2.d, K().g0(zzn.f));
            this.j.t().P(b2, this.j.g.j(zzn.f));
            zzaq = b2.a();
        }
        if (this.j.g.l(q64.e0) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaq.f) && "referrer API v2".equals(zzaq.g.f.getString("_cis"))) {
            String string = zzaq.g.f.getString("gclid");
            if (!TextUtils.isEmpty(string)) {
                n(new zzku("_lgclid", zzaq.i, string, "auto"), zzn);
            }
        }
        j(zzaq, zzn);
    }

    public final void D(zzku zzku, zzn zzn) {
        U();
        P();
        if (L(zzn)) {
            if (!zzn.m) {
                G(zzn);
            } else if (!"_npa".equals(zzku.g) || zzn.x == null) {
                this.j.g().m.b("Removing user property", this.j.u().x(zzku.g));
                K().a0();
                try {
                    G(zzn);
                    K().U(zzn.f, zzku.g);
                    K().q();
                    this.j.g().m.b("User property removed", this.j.u().x(zzku.g));
                } finally {
                    K().d0();
                }
            } else {
                this.j.g().m.a("Falling back to manifest metadata value for ad personalization");
                Objects.requireNonNull((db2) this.j.n);
                n(new zzku("_npa", System.currentTimeMillis(), Long.valueOf(zzn.x.booleanValue() ? 1 : 0), "auto"), zzn);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: android.content.pm.PackageInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r14v16, resolved type: android.content.pm.ApplicationInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r14v17, resolved type: android.content.pm.ApplicationInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r0v34, resolved type: android.content.pm.PackageInfo */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0488  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0125 A[Catch:{ all -> 0x04b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x025e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(com.google.android.gms.measurement.internal.zzn r23) {
        /*
        // Method dump skipped, instructions count: 1213
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.E(com.google.android.gms.measurement.internal.zzn):void");
    }

    public final void F(zzz zzz, zzn zzn) {
        Objects.requireNonNull(zzz, "null reference");
        gj1.j(zzz.f);
        Objects.requireNonNull(zzz.h, "null reference");
        gj1.j(zzz.h.g);
        U();
        P();
        if (L(zzn)) {
            if (!zzn.m) {
                G(zzn);
                return;
            }
            K().a0();
            try {
                G(zzn);
                zzz Y = K().Y(zzz.f, zzz.h.g);
                if (Y != null) {
                    this.j.g().m.c("Removing conditional user property", zzz.f, this.j.u().x(zzz.h.g));
                    K().Z(zzz.f, zzz.h.g);
                    if (Y.j) {
                        K().U(zzz.f, zzz.h.g);
                    }
                    zzaq zzaq = zzz.p;
                    if (zzaq != null) {
                        Bundle bundle = null;
                        zzap zzap = zzaq.g;
                        if (zzap != null) {
                            bundle = zzap.m1();
                        }
                        ug4 t2 = this.j.t();
                        String str = zzz.f;
                        zzaq zzaq2 = zzz.p;
                        I(t2.A(str, zzaq2.f, bundle, Y.g, zzaq2.i, true, yx3.a() && this.j.g.l(q64.M0)), zzn);
                    }
                } else {
                    this.j.g().i.c("Conditional user property doesn't exist", ra4.q(zzz.f), this.j.u().x(zzz.h.g));
                }
                K().q();
            } finally {
                K().d0();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0407  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.bb4 G(com.google.android.gms.measurement.internal.zzn r11) {
        /*
        // Method dump skipped, instructions count: 1039
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.G(com.google.android.gms.measurement.internal.zzn):bb4");
    }

    public final qb4 H() {
        C(this.f2214a);
        return this.f2214a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(com.google.android.gms.measurement.internal.zzaq r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
        // Method dump skipped, instructions count: 2470
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.I(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzn):void");
    }

    public final ya4 J() {
        C(this.b);
        return this.b;
    }

    public final h64 K() {
        C(this.c);
        return this.c;
    }

    public final boolean L(zzn zzn) {
        return (!e04.a() || !this.j.g.t(zzn.f, q64.j0)) ? !TextUtils.isEmpty(zzn.g) || !TextUtils.isEmpty(zzn.w) : !TextUtils.isEmpty(zzn.g) || !TextUtils.isEmpty(zzn.A) || !TextUtils.isEmpty(zzn.w);
    }

    public final ch4 M() {
        C(this.f);
        return this.f;
    }

    public final rg4 N() {
        C(this.g);
        return this.g;
    }

    public final pa4 O() {
        return this.j.u();
    }

    public final void P() {
        if (!this.k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void Q() {
        bb4 S;
        String str;
        U();
        P();
        this.s = true;
        try {
            Boolean bool = this.j.x().e;
            if (bool == null) {
                this.j.g().i.a("Upload data called on the client side before use of service was decided");
            } else if (bool.booleanValue()) {
                this.j.g().f.a("Upload called in the client side when service should be used");
                this.s = false;
                x();
            } else if (this.m > 0) {
                w();
                this.s = false;
                x();
            } else {
                U();
                if (this.v != null) {
                    this.j.g().n.a("Uploading requested multiple times");
                    this.s = false;
                    x();
                } else if (!J().t()) {
                    this.j.g().n.a("Network not connected, ignoring upload request");
                    w();
                    this.s = false;
                    x();
                } else {
                    Objects.requireNonNull((db2) this.j.n);
                    long currentTimeMillis = System.currentTimeMillis();
                    int o2 = this.j.g.o(null, q64.Q);
                    long longValue = currentTimeMillis - q64.d.a(null).longValue();
                    for (int i2 = 0; i2 < o2 && t(longValue); i2++) {
                    }
                    long a2 = this.j.n().e.a();
                    if (a2 != 0) {
                        this.j.g().m.b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - a2)));
                    }
                    String t2 = K().t();
                    if (!TextUtils.isEmpty(t2)) {
                        if (this.x == -1) {
                            this.x = K().i0();
                        }
                        List<Pair<yq3, Long>> C = K().C(t2, this.j.g.o(t2, q64.g), Math.max(0, this.j.g.o(t2, q64.h)));
                        if (!C.isEmpty()) {
                            if (!uy3.a() || !this.j.g.l(q64.J0) || a(t2).j()) {
                                Iterator<Pair<yq3, Long>> it = C.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        str = null;
                                        break;
                                    }
                                    yq3 yq3 = (yq3) it.next().first;
                                    if (!TextUtils.isEmpty(yq3.I())) {
                                        str = yq3.I();
                                        break;
                                    }
                                }
                                if (str != null) {
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= C.size()) {
                                            break;
                                        }
                                        yq3 yq32 = (yq3) C.get(i3).first;
                                        if (!(TextUtils.isEmpty(yq32.I()) || yq32.I().equals(str))) {
                                            C = C.subList(0, i3);
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                            }
                            xq3.a w2 = xq3.w();
                            int size = C.size();
                            ArrayList arrayList = new ArrayList(C.size());
                            boolean z2 = "1".equals(this.j.g.c.zza(t2, "gaia_collection_enabled")) && (!uy3.a() || !this.j.g.l(q64.J0) || a(t2).j());
                            boolean z3 = !uy3.a() || !this.j.g.l(q64.J0) || a(t2).j();
                            boolean z4 = !uy3.a() || !this.j.g.l(q64.J0) || a(t2).k();
                            int i4 = 0;
                            while (i4 < size) {
                                yq3.a aVar = (yq3.a) ((yq3) C.get(i4).first).s();
                                arrayList.add((Long) C.get(i4).second);
                                if (aVar.h) {
                                    aVar.i();
                                    aVar.h = false;
                                }
                                yq3.V0((yq3) aVar.g, 33025);
                                if (aVar.h) {
                                    aVar.i();
                                    aVar.h = false;
                                }
                                yq3.x((yq3) aVar.g, currentTimeMillis);
                                if (aVar.h) {
                                    aVar.i();
                                    aVar.h = false;
                                }
                                yq3.l0((yq3) aVar.g, false);
                                if (!z2) {
                                    if (aVar.h) {
                                        aVar.i();
                                        aVar.h = false;
                                    }
                                    yq3.h1((yq3) aVar.g);
                                }
                                if (uy3.a() && this.j.g.l(q64.J0)) {
                                    if (!z3) {
                                        if (aVar.h) {
                                            aVar.i();
                                            aVar.h = false;
                                        }
                                        yq3.E0((yq3) aVar.g);
                                        if (aVar.h) {
                                            aVar.i();
                                            aVar.h = false;
                                        }
                                        yq3.K0((yq3) aVar.g);
                                    }
                                    if (!z4) {
                                        if (aVar.h) {
                                            aVar.i();
                                            aVar.h = false;
                                        }
                                        yq3.P0((yq3) aVar.g);
                                    }
                                }
                                if (this.j.g.t(t2, q64.X)) {
                                    long s2 = N().s(((yq3) ((ru3) aVar.k())).h());
                                    if (aVar.h) {
                                        aVar.i();
                                        aVar.h = false;
                                    }
                                    yq3.o1((yq3) aVar.g, s2);
                                }
                                w2.l(aVar);
                                i4++;
                                arrayList = arrayList;
                            }
                            String y2 = this.j.g().w(2) ? N().y((xq3) ((ru3) w2.k())) : null;
                            N();
                            byte[] h2 = ((xq3) ((ru3) w2.k())).h();
                            String a3 = q64.q.a(null);
                            try {
                                URL url = new URL(a3);
                                gj1.b(!arrayList.isEmpty());
                                if (this.v != null) {
                                    this.j.g().f.a("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.v = new ArrayList(arrayList);
                                }
                                this.j.n().f.b(currentTimeMillis);
                                String str2 = "?";
                                if (size > 0) {
                                    str2 = ((xq3) w2.g).t().F1();
                                }
                                this.j.g().n.d("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(h2.length), y2);
                                this.r = true;
                                ya4 J = J();
                                ng4 ng4 = new ng4(this, t2);
                                J.b();
                                J.k();
                                J.f().w(new db4(J, t2, url, h2, null, ng4));
                            } catch (MalformedURLException unused) {
                                this.j.g().f.c("Failed to parse upload URL. Not uploading. appId", ra4.q(t2), a3);
                            }
                        }
                    } else {
                        this.x = -1;
                        String A2 = K().A(currentTimeMillis - q64.d.a(null).longValue());
                        if (!TextUtils.isEmpty(A2) && (S = K().S(A2)) != null) {
                            l(S);
                        }
                    }
                    this.s = false;
                    x();
                }
            }
        } finally {
            this.s = false;
            x();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R() {
        /*
        // Method dump skipped, instructions count: 439
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.R():void");
    }

    public final cb4 S() {
        cb4 cb4 = this.d;
        if (cb4 != null) {
            return cb4;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final ig4 T() {
        C(this.e);
        return this.e;
    }

    public final void U() {
        this.j.f().b();
    }

    public final long V() {
        Objects.requireNonNull((db2) this.j.n);
        long currentTimeMillis = System.currentTimeMillis();
        eb4 n2 = this.j.n();
        n2.l();
        n2.b();
        long a2 = n2.i.a();
        if (a2 == 0) {
            a2 = 1 + ((long) n2.h().u0().nextInt(86400000));
            n2.i.b(a2);
        }
        return ((((currentTimeMillis + a2) / 1000) / 60) / 60) / 24;
    }

    @Deprecated
    public final String W() {
        byte[] bArr = new byte[16];
        this.j.t().u0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final e64 a(String str) {
        String str2;
        e64 e64 = e64.c;
        if (!uy3.a() || !this.j.g.l(q64.J0)) {
            return e64;
        }
        U();
        P();
        e64 e642 = this.y.get(str);
        if (e642 != null) {
            return e642;
        }
        h64 K = K();
        Objects.requireNonNull(K);
        Objects.requireNonNull(str, "null reference");
        K.b();
        K.k();
        Cursor cursor = null;
        try {
            Cursor rawQuery = K.s().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                rawQuery.close();
            } else {
                rawQuery.close();
                str2 = "G1";
            }
            e64 b2 = e64.b(str2);
            s(str, b2);
            return b2;
        } catch (SQLiteException e2) {
            K.g().f.c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e2);
            throw e2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final String c(e64 e64) {
        if (!uy3.a() || !this.j.g.l(q64.J0) || e64.k()) {
            return W();
        }
        return null;
    }

    @Override // defpackage.uc4
    public final cb2 e() {
        return this.j.n;
    }

    @Override // defpackage.uc4
    public final sb4 f() {
        return this.j.f();
    }

    @Override // defpackage.uc4
    public final ra4 g() {
        return this.j.g();
    }

    public final void i(yq3.a aVar, long j2, boolean z2) {
        vg4 vg4;
        boolean z3;
        String str = z2 ? "_se" : "_lte";
        vg4 X = K().X(aVar.g0(), str);
        if (X == null || X.e == null) {
            String g0 = aVar.g0();
            Objects.requireNonNull((db2) this.j.n);
            vg4 = new vg4(g0, "auto", str, System.currentTimeMillis(), Long.valueOf(j2));
        } else {
            String g02 = aVar.g0();
            Objects.requireNonNull((db2) this.j.n);
            vg4 = new vg4(g02, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) X.e).longValue() + j2));
        }
        cr3.a K = cr3.K();
        K.m(str);
        Objects.requireNonNull((db2) this.j.n);
        K.l(System.currentTimeMillis());
        K.o(((Long) vg4.e).longValue());
        cr3 cr3 = (cr3) ((ru3) K.k());
        int q2 = rg4.q(aVar, str);
        if (q2 >= 0) {
            if (aVar.h) {
                aVar.i();
                aVar.h = false;
            }
            yq3.w((yq3) aVar.g, q2, cr3);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (aVar.h) {
                aVar.i();
                aVar.h = false;
            }
            yq3.z((yq3) aVar.g, cr3);
        }
        if (j2 > 0) {
            K().L(vg4);
            this.j.g().n.c("Updated engagement user property. scope, value", z2 ? "session-scoped" : "lifetime", vg4.e);
        }
    }

    public final void j(zzaq zzaq, zzn zzn) {
        List<zzz> list;
        List<zzz> list2;
        List<zzz> list3;
        zzaq zzaq2 = zzaq;
        Objects.requireNonNull(zzn, "null reference");
        gj1.j(zzn.f);
        U();
        P();
        String str = zzn.f;
        long j2 = zzaq2.i;
        N();
        if (rg4.N(zzaq, zzn)) {
            if (!zzn.m) {
                G(zzn);
                return;
            }
            List<String> list4 = zzn.z;
            if (list4 != null) {
                if (list4.contains(zzaq2.f)) {
                    Bundle m1 = zzaq2.g.m1();
                    m1.putLong("ga_safelisted", 1);
                    zzaq2 = new zzaq(zzaq2.f, new zzap(m1), zzaq2.h, zzaq2.i);
                } else {
                    this.j.g().m.d("Dropping non-safelisted event. appId, event name, origin", str, zzaq2.f, zzaq2.h);
                    return;
                }
            }
            K().a0();
            try {
                h64 K = K();
                gj1.j(str);
                K.b();
                K.k();
                int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i2 < 0) {
                    K.g().i.c("Invalid time querying timed out conditional properties", ra4.q(str), Long.valueOf(j2));
                    list = Collections.emptyList();
                } else {
                    list = K.E("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j2)});
                }
                for (zzz zzz : list) {
                    if (zzz != null) {
                        this.j.g().n.d("User property timed out", zzz.f, this.j.u().x(zzz.h.g), zzz.h.l1());
                        zzaq zzaq3 = zzz.l;
                        if (zzaq3 != null) {
                            I(new zzaq(zzaq3, j2), zzn);
                        }
                        K().Z(str, zzz.h.g);
                    }
                }
                h64 K2 = K();
                gj1.j(str);
                K2.b();
                K2.k();
                if (i2 < 0) {
                    K2.g().i.c("Invalid time querying expired conditional properties", ra4.q(str), Long.valueOf(j2));
                    list2 = Collections.emptyList();
                } else {
                    list2 = K2.E("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzz zzz2 : list2) {
                    if (zzz2 != null) {
                        this.j.g().n.d("User property expired", zzz2.f, this.j.u().x(zzz2.h.g), zzz2.h.l1());
                        K().U(str, zzz2.h.g);
                        zzaq zzaq4 = zzz2.p;
                        if (zzaq4 != null) {
                            arrayList.add(zzaq4);
                        }
                        K().Z(str, zzz2.h.g);
                    }
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    I(new zzaq((zzaq) obj, j2), zzn);
                }
                h64 K3 = K();
                String str2 = zzaq2.f;
                gj1.j(str);
                gj1.j(str2);
                K3.b();
                K3.k();
                if (i2 < 0) {
                    K3.g().i.d("Invalid time querying triggered conditional properties", ra4.q(str), K3.d().t(str2), Long.valueOf(j2));
                    list3 = Collections.emptyList();
                } else {
                    list3 = K3.E("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j2)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzz zzz3 : list3) {
                    if (zzz3 != null) {
                        zzku zzku = zzz3.h;
                        vg4 vg4 = new vg4(zzz3.f, zzz3.g, zzku.g, j2, zzku.l1());
                        if (K().L(vg4)) {
                            this.j.g().n.d("User property triggered", zzz3.f, this.j.u().x(vg4.c), vg4.e);
                        } else {
                            this.j.g().f.d("Too many active user properties, ignoring", ra4.q(zzz3.f), this.j.u().x(vg4.c), vg4.e);
                        }
                        zzaq zzaq5 = zzz3.n;
                        if (zzaq5 != null) {
                            arrayList2.add(zzaq5);
                        }
                        zzz3.h = new zzku(vg4);
                        zzz3.j = true;
                        K().M(zzz3);
                    }
                }
                I(zzaq2, zzn);
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    I(new zzaq((zzaq) obj2, j2), zzn);
                }
                K().q();
            } finally {
                K().d0();
            }
        }
    }

    public final void k(zzaq zzaq, String str) {
        boolean z2;
        String str2;
        bb4 S = K().S(str);
        if (S == null || TextUtils.isEmpty(S.M())) {
            this.j.g().m.b("No app data available; dropping event", str);
            return;
        }
        Boolean z3 = z(S);
        if (z3 == null) {
            if (!"_ui".equals(zzaq.f)) {
                this.j.g().i.b("Could not find package. appId", ra4.q(str));
            }
        } else if (!z3.booleanValue()) {
            this.j.g().f.b("App version does not match; dropping event. appId", ra4.q(str));
            return;
        }
        String v2 = S.v();
        String M = S.M();
        long N = S.N();
        String O = S.O();
        long P = S.P();
        long Q = S.Q();
        boolean T = S.T();
        String H = S.H();
        long g2 = S.g();
        boolean h2 = S.h();
        boolean i2 = S.i();
        String y2 = S.y();
        Boolean j2 = S.j();
        long S2 = S.S();
        List<String> k2 = S.k();
        if (e04.a()) {
            z2 = T;
            if (this.j.g.t(S.o(), q64.j0)) {
                str2 = S.B();
                B(zzaq, new zzn(str, v2, M, N, O, P, Q, (String) null, z2, false, H, g2, 0L, 0, h2, i2, false, y2, j2, S2, k2, str2, (uy3.a() || !this.j.g.l(q64.J0)) ? "" : a(str).d()));
            }
        } else {
            z2 = T;
        }
        str2 = null;
        B(zzaq, new zzn(str, v2, M, N, O, P, Q, (String) null, z2, false, H, g2, 0L, 0, h2, i2, false, y2, j2, S2, k2, str2, (uy3.a() || !this.j.g.l(q64.J0)) ? "" : a(str).d()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(defpackage.bb4 r12) {
        /*
        // Method dump skipped, instructions count: 376
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.l(bb4):void");
    }

    @Override // defpackage.uc4
    public final Context m() {
        return this.j.f3627a;
    }

    public final void n(zzku zzku, zzn zzn) {
        U();
        P();
        if (L(zzn)) {
            if (!zzn.m) {
                G(zzn);
                return;
            }
            int g0 = this.j.t().g0(zzku.g);
            if (g0 != 0) {
                this.j.t();
                String D = ug4.D(zzku.g, 24, true);
                String str = zzku.g;
                this.j.t().R(this.z, zzn.f, g0, "_ev", D, str != null ? str.length() : 0);
                return;
            }
            int h0 = this.j.t().h0(zzku.g, zzku.l1());
            if (h0 != 0) {
                this.j.t();
                String D2 = ug4.D(zzku.g, 24, true);
                Object l1 = zzku.l1();
                this.j.t().R(this.z, zzn.f, h0, "_ev", D2, (l1 == null || (!(l1 instanceof String) && !(l1 instanceof CharSequence))) ? 0 : String.valueOf(l1).length());
                return;
            }
            Object m0 = this.j.t().m0(zzku.g, zzku.l1());
            if (m0 != null) {
                if ("_sid".equals(zzku.g)) {
                    long j2 = zzku.h;
                    String str2 = zzku.k;
                    long j3 = 0;
                    vg4 X = K().X(zzn.f, "_sno");
                    if (X != null) {
                        Object obj = X.e;
                        if (obj instanceof Long) {
                            j3 = ((Long) obj).longValue();
                            n(new zzku("_sno", j2, Long.valueOf(j3 + 1), str2), zzn);
                        }
                    }
                    if (X != null) {
                        this.j.g().i.b("Retrieved last session number from database does not contain a valid (long) value", X.e);
                    }
                    m64 y2 = K().y(zzn.f, "_s");
                    if (y2 != null) {
                        j3 = y2.c;
                        this.j.g().n.b("Backfill the session number. Last used session number", Long.valueOf(j3));
                    }
                    n(new zzku("_sno", j2, Long.valueOf(j3 + 1), str2), zzn);
                }
                vg4 vg4 = new vg4(zzn.f, zzku.k, zzku.g, zzku.h, m0);
                this.j.g().n.c("Setting user property", this.j.u().x(vg4.c), m0);
                K().a0();
                try {
                    G(zzn);
                    boolean L = K().L(vg4);
                    K().q();
                    if (!L) {
                        this.j.g().f.c("Too many unique user properties are set. Ignoring user property", this.j.u().x(vg4.c), vg4.e);
                        this.j.t().R(this.z, zzn.f, 9, null, null, 0);
                    }
                } finally {
                    K().d0();
                }
            }
        }
    }

    public final void o(zzn zzn) {
        if (this.v != null) {
            ArrayList arrayList = new ArrayList();
            this.w = arrayList;
            arrayList.addAll(this.v);
        }
        h64 K = K();
        String str = zzn.f;
        gj1.j(str);
        K.b();
        K.k();
        try {
            SQLiteDatabase s2 = K.s();
            String[] strArr = {str};
            int delete = s2.delete("apps", "app_id=?", strArr) + 0 + s2.delete(AnalyticsConstants.EVENTS, "app_id=?", strArr) + s2.delete("user_attributes", "app_id=?", strArr) + s2.delete("conditional_properties", "app_id=?", strArr) + s2.delete("raw_events", "app_id=?", strArr) + s2.delete("raw_events_metadata", "app_id=?", strArr) + s2.delete(server.zophop.Constants.QUEUE, "app_id=?", strArr) + s2.delete("audience_filter_values", "app_id=?", strArr) + s2.delete("main_event_params", "app_id=?", strArr) + s2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                K.g().n.c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            K.g().f.c("Error resetting analytics data. appId, error", ra4.q(str), e2);
        }
        if (zzn.m) {
            E(zzn);
        }
    }

    public final void p(zzz zzz, zzn zzn) {
        zzaq zzaq;
        boolean z2;
        Objects.requireNonNull(zzz, "null reference");
        gj1.j(zzz.f);
        Objects.requireNonNull(zzz.g, "null reference");
        Objects.requireNonNull(zzz.h, "null reference");
        gj1.j(zzz.h.g);
        U();
        P();
        if (L(zzn)) {
            if (!zzn.m) {
                G(zzn);
                return;
            }
            zzz zzz2 = new zzz(zzz);
            boolean z3 = false;
            zzz2.j = false;
            K().a0();
            try {
                zzz Y = K().Y(zzz2.f, zzz2.h.g);
                if (Y != null && !Y.g.equals(zzz2.g)) {
                    this.j.g().i.d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.j.u().x(zzz2.h.g), zzz2.g, Y.g);
                }
                if (Y != null && (z2 = Y.j)) {
                    zzz2.g = Y.g;
                    zzz2.i = Y.i;
                    zzz2.m = Y.m;
                    zzz2.k = Y.k;
                    zzz2.n = Y.n;
                    zzz2.j = z2;
                    zzku zzku = zzz2.h;
                    zzz2.h = new zzku(zzku.g, Y.h.h, zzku.l1(), Y.h.k);
                } else if (TextUtils.isEmpty(zzz2.k)) {
                    zzku zzku2 = zzz2.h;
                    zzz2.h = new zzku(zzku2.g, zzz2.i, zzku2.l1(), zzz2.h.k);
                    zzz2.j = true;
                    z3 = true;
                }
                if (zzz2.j) {
                    zzku zzku3 = zzz2.h;
                    vg4 vg4 = new vg4(zzz2.f, zzz2.g, zzku3.g, zzku3.h, zzku3.l1());
                    if (K().L(vg4)) {
                        this.j.g().m.d("User property updated immediately", zzz2.f, this.j.u().x(vg4.c), vg4.e);
                    } else {
                        this.j.g().f.d("(2)Too many active user properties, ignoring", ra4.q(zzz2.f), this.j.u().x(vg4.c), vg4.e);
                    }
                    if (z3 && (zzaq = zzz2.n) != null) {
                        I(new zzaq(zzaq, zzz2.i), zzn);
                    }
                }
                if (K().M(zzz2)) {
                    this.j.g().m.d("Conditional property added", zzz2.f, this.j.u().x(zzz2.h.g), zzz2.h.l1());
                } else {
                    this.j.g().f.d("Too many conditional properties, ignoring", ra4.q(zzz2.f), this.j.u().x(zzz2.h.g), zzz2.h.l1());
                }
                K().q();
            } finally {
                K().d0();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126 A[Catch:{ all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0134 A[Catch:{ all -> 0x0175 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12) {
        /*
        // Method dump skipped, instructions count: 389
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.q(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    @Override // defpackage.uc4
    public final hh4 r() {
        return this.j.f;
    }

    public final void s(String str, e64 e64) {
        if (uy3.a() && this.j.g.l(q64.J0)) {
            U();
            P();
            this.y.put(str, e64);
            h64 K = K();
            if (uy3.a() && K.f3331a.g.l(q64.J0)) {
                Objects.requireNonNull(str, "null reference");
                K.b();
                K.k();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", e64.d());
                try {
                    if (K.s().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        K.g().f.b("Failed to insert/update consent setting (got -1). appId", ra4.q(str));
                    }
                } catch (SQLiteException e2) {
                    K.g().f.c("Error storing consent setting. appId, error", ra4.q(str), e2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x025f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0261, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0262, code lost:
        r9 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0283, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0284, code lost:
        r28 = "_si";
        r29 = "_sc";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ab, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02af, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02b0, code lost:
        r28 = "_si";
        r29 = "_sc";
        r9 = r4;
        r27 = "_npa";
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ba, code lost:
        r28 = "_si";
        r29 = "_sc";
        r9 = r4;
        r27 = "_npa";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02c2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c3, code lost:
        r2 = r0;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02c9, code lost:
        r28 = "_si";
        r29 = "_sc";
        r9 = r4;
        r27 = "_npa";
        r26 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02d2, code lost:
        r2 = r0;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02d4, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a9, code lost:
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        r26 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d1, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
        r28 = "_si";
        r29 = "_sc";
        r27 = "_npa";
        r2 = r9;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0190, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0191, code lost:
        r28 = "_si";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0193, code lost:
        r29 = "_sc";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0201, code lost:
        r0 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0084, B:50:0x00fe] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02aa A[ExcHandler: all (r0v9 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r7 
      PHI: (r7v42 android.database.Cursor) = (r7v49 android.database.Cursor), (r7v49 android.database.Cursor), (r7v54 android.database.Cursor), (r7v54 android.database.Cursor) binds: [B:97:0x0224, B:98:?, B:50:0x00fe, B:51:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:23:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02c2 A[ExcHandler: all (r0v8 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04d1  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x058f  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x05e8  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x064c  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0673 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x067c  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0699  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x078d  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0934  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0955  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x096f  */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0ce2  */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x0cf5  */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x0cf8  */
    /* JADX WARNING: Removed duplicated region for block: B:476:0x0d1f  */
    /* JADX WARNING: Removed duplicated region for block: B:590:0x1083  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x109a  */
    /* JADX WARNING: Removed duplicated region for block: B:610:0x055b A[EDGE_INSN: B:610:0x055b->B:221:0x055b ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t(long r44) {
        /*
        // Method dump skipped, instructions count: 4262
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.t(long):boolean");
    }

    public final boolean u(uq3.a aVar, uq3.a aVar2) {
        String str;
        gj1.b("_e".equals(aVar.v()));
        N();
        wq3 v2 = rg4.v((uq3) ((ru3) aVar.k()), "_sc");
        String str2 = null;
        if (v2 == null) {
            str = null;
        } else {
            str = v2.F();
        }
        N();
        wq3 v3 = rg4.v((uq3) ((ru3) aVar2.k()), "_pc");
        if (v3 != null) {
            str2 = v3.F();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        A(aVar, aVar2);
        return true;
    }

    public final boolean v() {
        U();
        P();
        return ((K().R("select count(1) > 0 from raw_events", null) > 0 ? 1 : (K().R("select count(1) > 0 from raw_events", null) == 0 ? 0 : -1)) != 0) || !TextUtils.isEmpty(K().t());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0385  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w() {
        /*
        // Method dump skipped, instructions count: 993
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lg4.w():void");
    }

    public final void x() {
        U();
        if (this.q || this.r || this.s) {
            this.j.g().n.d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.q), Boolean.valueOf(this.r), Boolean.valueOf(this.s));
            return;
        }
        this.j.g().n.a("Stopping uploading service(s)");
        List<Runnable> list = this.n;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.n.clear();
        }
    }

    public final zzn y(String str) {
        bb4 S = K().S(str);
        if (S == null || TextUtils.isEmpty(S.M())) {
            this.j.g().m.b("No app data available; dropping", str);
            return null;
        }
        Boolean z2 = z(S);
        if (z2 == null || z2.booleanValue()) {
            return new zzn(str, S.v(), S.M(), S.N(), S.O(), S.P(), S.Q(), (String) null, S.T(), false, S.H(), S.g(), 0L, 0, S.h(), S.i(), false, S.y(), S.j(), S.S(), S.k(), (!e04.a() || !this.j.g.t(str, q64.j0)) ? null : S.B(), (!uy3.a() || !this.j.g.l(q64.J0)) ? "" : a(str).d());
        }
        this.j.g().f.b("App version does not match; dropping. appId", ra4.q(str));
        return null;
    }

    public final Boolean z(bb4 bb4) {
        Boolean bool = Boolean.TRUE;
        try {
            if (bb4.N() != -2147483648L) {
                if (bb4.N() == ((long) ob2.a(this.j.f3627a).b(bb4.o(), 0).versionCode)) {
                    return bool;
                }
            } else {
                String str = ob2.a(this.j.f3627a).b(bb4.o(), 0).versionName;
                if (bb4.M() != null && bb4.M().equals(str)) {
                    return bool;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
