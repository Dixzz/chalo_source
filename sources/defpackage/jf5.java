package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: jf5  reason: default package */
/* compiled from: Request */
public final class jf5 {
    public static final long s = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    public int f1917a;
    public long b;
    public final Uri c;
    public final int d;
    public final List<pf5> e;
    public final int f;
    public final int g;
    public final boolean h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final float l;
    public final float m;
    public final float n;
    public final boolean o;
    public final boolean p;
    public final Bitmap.Config q;
    public final Picasso.e r;

    /* renamed from: jf5$b */
    /* compiled from: Request */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Uri f1918a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public List<pf5> f;
        public Bitmap.Config g;
        public Picasso.e h;

        public b(Uri uri, int i, Bitmap.Config config) {
            this.f1918a = uri;
            this.b = i;
            this.g = config;
        }

        public boolean a() {
            return (this.f1918a == null && this.b == 0) ? false : true;
        }

        public b b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.c = i;
                this.d = i2;
                return this;
            }
        }
    }

    public jf5(Uri uri, int i2, String str, List list, int i3, int i4, boolean z, boolean z2, int i5, boolean z3, float f2, float f3, float f4, boolean z4, boolean z5, Bitmap.Config config, Picasso.e eVar, a aVar) {
        this.c = uri;
        this.d = i2;
        if (list == null) {
            this.e = null;
        } else {
            this.e = Collections.unmodifiableList(list);
        }
        this.f = i3;
        this.g = i4;
        this.h = z;
        this.j = z2;
        this.i = i5;
        this.k = z3;
        this.l = f2;
        this.m = f3;
        this.n = f4;
        this.o = z4;
        this.p = z5;
        this.q = config;
        this.r = eVar;
    }

    public boolean a() {
        return (this.f == 0 && this.g == 0) ? false : true;
    }

    public String b() {
        long nanoTime = System.nanoTime() - this.b;
        if (nanoTime > s) {
            return d() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return d() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    public boolean c() {
        return a() || this.l != 0.0f;
    }

    public String d() {
        return hj1.W(hj1.i0("[R"), this.f1917a, ']');
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i2 = this.d;
        if (i2 > 0) {
            sb.append(i2);
        } else {
            sb.append(this.c);
        }
        List<pf5> list = this.e;
        if (list != null && !list.isEmpty()) {
            for (pf5 pf5 : this.e) {
                sb.append(' ');
                sb.append(pf5.key());
            }
        }
        if (this.f > 0) {
            sb.append(" resize(");
            sb.append(this.f);
            sb.append(',');
            sb.append(this.g);
            sb.append(')');
        }
        if (this.h) {
            sb.append(" centerCrop");
        }
        if (this.j) {
            sb.append(" centerInside");
        }
        if (this.l != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.l);
            if (this.o) {
                sb.append(" @ ");
                sb.append(this.m);
                sb.append(',');
                sb.append(this.n);
            }
            sb.append(')');
        }
        if (this.p) {
            sb.append(" purgeable");
        }
        if (this.q != null) {
            sb.append(' ');
            sb.append(this.q);
        }
        sb.append('}');
        return sb.toString();
    }
}
