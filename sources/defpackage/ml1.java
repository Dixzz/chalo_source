package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import defpackage.ts1;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* renamed from: ml1  reason: default package */
/* compiled from: RequestBuilder */
public class ml1<TranscodeType> implements Cloneable {
    public static final rs1 q = new rs1().d(gn1.b).k(kl1.LOW).p(true);
    public final il1 f;
    public final nl1 g;
    public final Class<TranscodeType> h;
    public final rs1 i;
    public final gl1 j;
    public rs1 k;
    public ol1<?, ? super TranscodeType> l;
    public Object m;
    public qs1<TranscodeType> n;
    public boolean o = true;
    public boolean p;

    /* renamed from: ml1$a */
    /* compiled from: RequestBuilder */
    public class a implements Runnable {
        public final /* synthetic */ ps1 f;

        public a(ps1 ps1) {
            this.f = ps1;
        }

        public void run() {
            if (!this.f.isCancelled()) {
                ml1.this.f(this.f);
            }
        }
    }

    /* renamed from: ml1$b */
    /* compiled from: RequestBuilder */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2395a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|8|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        static {
            /*
            // Method dump skipped, instructions count: 127
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ml1.b.<clinit>():void");
        }
    }

    public ml1(gl1 gl1, nl1 nl1, Class<TranscodeType> cls) {
        this.j = gl1;
        this.g = nl1;
        this.f = gl1.h;
        this.h = cls;
        this.i = nl1.n;
        il1 il1 = nl1.f.h;
        ol1<?, ?> ol1 = il1.e.get(cls);
        if (ol1 == null) {
            for (Map.Entry<Class<?>, ol1<?, ?>> entry : il1.e.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    ol1 = (ol1<?, ? super TranscodeType>) entry.getValue();
                }
            }
        }
        this.l = (ol1<?, ? super TranscodeType>) (ol1 == null ? (ol1<?, ? super TranscodeType>) il1.h : ol1);
        this.k = this.i;
    }

    public ml1<TranscodeType> a(rs1 rs1) {
        Objects.requireNonNull(rs1, "Argument must not be null");
        rs1 rs12 = this.i;
        rs1 rs13 = this.k;
        if (rs12 == rs13) {
            rs13 = rs13.clone();
        }
        this.k = rs13.a(rs1);
        return this;
    }

    public final os1 b(ct1<TranscodeType> ct1, us1 us1, ol1<?, ? super TranscodeType> ol1, kl1 kl1, int i2, int i3) {
        return i(ct1, this.k, null, ol1, kl1, i2, i3);
    }

    /* renamed from: c */
    public ml1<TranscodeType> clone() {
        try {
            ml1<TranscodeType> ml1 = (ml1) super.clone();
            ml1.k = ml1.k.clone();
            ml1.l = ml1.l.a();
            return ml1;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public ns1<File> d(int i2, int i3) {
        ml1 ml1 = new ml1(this.j, this.g, File.class);
        ml1.m = this.m;
        ml1.p = this.p;
        ml1.k = this.k;
        ml1.a(q);
        return ml1.j(i2, i3);
    }

    public ct1<TranscodeType> e(ImageView imageView) {
        ct1<TranscodeType> ct1;
        jq1 jq1 = jq1.d;
        rt1.a();
        Objects.requireNonNull(imageView, "Argument must not be null");
        if (!rs1.e(this.k.f, 2048) && this.k.s && imageView.getScaleType() != null) {
            rs1 rs1 = this.k;
            if (rs1.y) {
                this.k = rs1.clone();
            }
            switch (b.f2395a[imageView.getScaleType().ordinal()]) {
                case 1:
                    rs1 rs12 = this.k;
                    Objects.requireNonNull(rs12);
                    rs12.g(jq1.b, new gq1());
                    break;
                case 2:
                    rs1 rs13 = this.k;
                    Objects.requireNonNull(rs13);
                    rs13.g(jq1, new hq1()).D = true;
                    break;
                case 3:
                case 4:
                case 5:
                    rs1 rs14 = this.k;
                    Objects.requireNonNull(rs14);
                    rs14.g(jq1.f1969a, new lq1()).D = true;
                    break;
                case 6:
                    rs1 rs15 = this.k;
                    Objects.requireNonNull(rs15);
                    rs15.g(jq1, new hq1()).D = true;
                    break;
            }
        }
        il1 il1 = this.f;
        Class<TranscodeType> cls = this.h;
        Objects.requireNonNull(il1.c);
        if (Bitmap.class.equals(cls)) {
            ct1 = new ws1(imageView);
        } else if (Drawable.class.isAssignableFrom(cls)) {
            ct1 = new xs1(imageView);
        } else {
            throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
        }
        f(ct1);
        return ct1;
    }

    public <Y extends ct1<TranscodeType>> Y f(Y y) {
        rt1.a();
        Objects.requireNonNull(y, "Argument must not be null");
        if (this.p) {
            rs1 rs1 = this.k;
            rs1.y = true;
            os1 b2 = b(y, null, this.l, rs1.i, rs1.p, rs1.o);
            os1 g2 = y.g();
            ts1 ts1 = (ts1) b2;
            if (ts1.k(g2)) {
                Objects.requireNonNull(g2, "Argument must not be null");
                if (g2.f() || g2.isRunning()) {
                    ts1.a();
                    if (!g2.isRunning()) {
                        g2.e();
                    }
                    return y;
                }
            }
            this.g.o(y);
            y.d(b2);
            nl1 nl1 = this.g;
            nl1.j.f.add(y);
            zr1 zr1 = nl1.h;
            zr1.f4203a.add(b2);
            if (!zr1.c) {
                ts1.e();
            } else {
                zr1.b.add(b2);
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public ml1<TranscodeType> g(Integer num) {
        PackageInfo packageInfo;
        String str;
        this.m = num;
        this.p = true;
        il1 il1 = this.f;
        ConcurrentHashMap<String, dm1> concurrentHashMap = ht1.f1423a;
        String packageName = il1.getPackageName();
        dm1 dm1 = (dm1) ht1.f1423a.get(packageName);
        if (dm1 == null) {
            try {
                packageInfo = il1.getPackageManager().getPackageInfo(il1.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                packageInfo = null;
            }
            if (packageInfo != null) {
                str = String.valueOf(packageInfo.versionCode);
            } else {
                str = UUID.randomUUID().toString();
            }
            dm1 = new jt1(str);
            dm1 dm12 = (dm1) ht1.f1423a.putIfAbsent(packageName, dm1);
            if (dm12 != null) {
                dm1 = dm12;
            }
        }
        a(new rs1().o(dm1));
        return this;
    }

    public ml1<TranscodeType> h(String str) {
        this.m = str;
        this.p = true;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: ct1<TranscodeType> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: java.lang.Class<TranscodeType>, java.lang.Class<R> */
    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: qs1<TranscodeType>, qs1<R> */
    public final os1 i(ct1<TranscodeType> ct1, rs1 rs1, us1 us1, ol1<?, ? super TranscodeType> ol1, kl1 kl1, int i2, int i3) {
        rs1.y = true;
        il1 il1 = this.f;
        Object obj = this.m;
        Class cls = (Class<TranscodeType>) this.h;
        qs1 qs1 = (qs1<TranscodeType>) this.n;
        hn1 hn1 = il1.f;
        Objects.requireNonNull(ol1);
        gt1<? super R> gt1 = (gt1<? super R>) et1.b;
        ts1<?> b2 = ts1.C.b();
        if (b2 == null) {
            b2 = new ts1<>();
        }
        b2.i = il1;
        b2.j = obj;
        b2.k = cls;
        b2.l = rs1;
        b2.m = i2;
        b2.n = i3;
        b2.o = kl1;
        b2.p = ct1;
        b2.q = qs1;
        b2.h = us1;
        b2.r = hn1;
        b2.s = gt1;
        b2.w = ts1.b.PENDING;
        return b2;
    }

    public ns1<TranscodeType> j(int i2, int i3) {
        ps1 ps1 = new ps1(this.f.f1531a, i2, i3);
        if (rt1.g()) {
            this.f.f1531a.post(new a(ps1));
        } else {
            f(ps1);
        }
        return ps1;
    }
}
