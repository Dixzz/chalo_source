package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: rs1  reason: default package */
/* compiled from: RequestOptions */
public class rs1 implements Cloneable {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int f;
    public float g = 1.0f;
    public gn1 h = gn1.c;
    public kl1 i = kl1.NORMAL;
    public Drawable j;
    public int k;
    public Drawable l;
    public int m;
    public boolean n = true;
    public int o = -1;
    public int p = -1;
    public dm1 q;
    public boolean r;
    public boolean s;
    public Drawable t;
    public int u;
    public fm1 v;
    public Map<Class<?>, im1<?>> w;
    public Class<?> x;
    public boolean y;
    public Resources.Theme z;

    public rs1() {
        it1 it1 = it1.b;
        this.q = it1.b;
        this.s = true;
        this.v = new fm1();
        this.w = new HashMap();
        this.x = Object.class;
        this.D = true;
    }

    public static boolean e(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public rs1 a(rs1 rs1) {
        if (this.A) {
            return clone().a(rs1);
        }
        if (e(rs1.f, 2)) {
            this.g = rs1.g;
        }
        if (e(rs1.f, 262144)) {
            this.B = rs1.B;
        }
        if (e(rs1.f, 4)) {
            this.h = rs1.h;
        }
        if (e(rs1.f, 8)) {
            this.i = rs1.i;
        }
        if (e(rs1.f, 16)) {
            this.j = rs1.j;
        }
        if (e(rs1.f, 32)) {
            this.k = rs1.k;
        }
        if (e(rs1.f, 64)) {
            this.l = rs1.l;
        }
        if (e(rs1.f, 128)) {
            this.m = rs1.m;
        }
        if (e(rs1.f, 256)) {
            this.n = rs1.n;
        }
        if (e(rs1.f, 512)) {
            this.p = rs1.p;
            this.o = rs1.o;
        }
        if (e(rs1.f, 1024)) {
            this.q = rs1.q;
        }
        if (e(rs1.f, 4096)) {
            this.x = rs1.x;
        }
        if (e(rs1.f, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST)) {
            this.t = rs1.t;
        }
        if (e(rs1.f, 16384)) {
            this.u = rs1.u;
        }
        if (e(rs1.f, 32768)) {
            this.z = rs1.z;
        }
        if (e(rs1.f, 65536)) {
            this.s = rs1.s;
        }
        if (e(rs1.f, 131072)) {
            this.r = rs1.r;
        }
        if (e(rs1.f, 2048)) {
            this.w.putAll(rs1.w);
            this.D = rs1.D;
        }
        if (e(rs1.f, 524288)) {
            this.C = rs1.C;
        }
        if (!this.s) {
            this.w.clear();
            int i2 = this.f & -2049;
            this.f = i2;
            this.r = false;
            this.f = i2 & -131073;
            this.D = true;
        }
        this.f |= rs1.f;
        this.v.d(rs1.v);
        l();
        return this;
    }

    /* renamed from: b */
    public rs1 clone() {
        try {
            rs1 rs1 = (rs1) super.clone();
            fm1 fm1 = new fm1();
            rs1.v = fm1;
            fm1.d(this.v);
            HashMap hashMap = new HashMap();
            rs1.w = hashMap;
            hashMap.putAll(this.w);
            rs1.y = false;
            rs1.A = false;
            return rs1;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public rs1 c(Class<?> cls) {
        if (this.A) {
            return clone().c(cls);
        }
        Objects.requireNonNull(cls, "Argument must not be null");
        this.x = cls;
        this.f |= 4096;
        l();
        return this;
    }

    public rs1 d(gn1 gn1) {
        if (this.A) {
            return clone().d(gn1);
        }
        Objects.requireNonNull(gn1, "Argument must not be null");
        this.h = gn1;
        this.f |= 4;
        l();
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof rs1)) {
            return false;
        }
        rs1 rs1 = (rs1) obj;
        if (Float.compare(rs1.g, this.g) == 0 && this.k == rs1.k && rt1.b(this.j, rs1.j) && this.m == rs1.m && rt1.b(this.l, rs1.l) && this.u == rs1.u && rt1.b(this.t, rs1.t) && this.n == rs1.n && this.o == rs1.o && this.p == rs1.p && this.r == rs1.r && this.s == rs1.s && this.B == rs1.B && this.C == rs1.C && this.h.equals(rs1.h) && this.i == rs1.i && this.v.equals(rs1.v) && this.w.equals(rs1.w) && this.x.equals(rs1.x) && rt1.b(this.q, rs1.q) && rt1.b(this.z, rs1.z)) {
            return true;
        }
        return false;
    }

    public rs1 f(im1<Bitmap> im1) {
        if (this.A) {
            return clone().f(im1);
        }
        h(Bitmap.class, im1);
        h(BitmapDrawable.class, new bq1(im1));
        h(zq1.class, new cr1(im1));
        l();
        return this;
    }

    public final rs1 g(jq1 jq1, im1<Bitmap> im1) {
        if (this.A) {
            return clone().g(jq1, im1);
        }
        em1<jq1> em1 = kq1.g;
        Objects.requireNonNull(jq1, "Argument must not be null");
        m(em1, jq1);
        return f(im1);
    }

    public <T> rs1 h(Class<T> cls, im1<T> im1) {
        if (this.A) {
            return clone().h(cls, im1);
        }
        Objects.requireNonNull(cls, "Argument must not be null");
        Objects.requireNonNull(im1, "Argument must not be null");
        this.w.put(cls, im1);
        int i2 = this.f | 2048;
        this.f = i2;
        this.s = true;
        this.f = i2 | 65536;
        this.D = false;
        l();
        return this;
    }

    public int hashCode() {
        float f2 = this.g;
        char[] cArr = rt1.f3126a;
        return rt1.f(this.z, rt1.f(this.q, rt1.f(this.x, rt1.f(this.w, rt1.f(this.v, rt1.f(this.i, rt1.f(this.h, (((((((((((((rt1.f(this.t, (rt1.f(this.l, (rt1.f(this.j, ((Float.floatToIntBits(f2) + 527) * 31) + this.k) * 31) + this.m) * 31) + this.u) * 31) + (this.n ? 1 : 0)) * 31) + this.o) * 31) + this.p) * 31) + (this.r ? 1 : 0)) * 31) + (this.s ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0))))))));
    }

    public rs1 i(int i2, int i3) {
        if (this.A) {
            return clone().i(i2, i3);
        }
        this.p = i2;
        this.o = i3;
        this.f |= 512;
        l();
        return this;
    }

    public rs1 j(int i2) {
        if (this.A) {
            return clone().j(i2);
        }
        this.m = i2;
        this.f |= 128;
        l();
        return this;
    }

    public rs1 k(kl1 kl1) {
        if (this.A) {
            return clone().k(kl1);
        }
        Objects.requireNonNull(kl1, "Argument must not be null");
        this.i = kl1;
        this.f |= 8;
        l();
        return this;
    }

    public final rs1 l() {
        if (!this.y) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    public <T> rs1 m(em1<T> em1, T t2) {
        if (this.A) {
            return clone().m(em1, t2);
        }
        Objects.requireNonNull(em1, "Argument must not be null");
        Objects.requireNonNull(t2, "Argument must not be null");
        this.v.b.put(em1, t2);
        l();
        return this;
    }

    public rs1 o(dm1 dm1) {
        if (this.A) {
            return clone().o(dm1);
        }
        Objects.requireNonNull(dm1, "Argument must not be null");
        this.q = dm1;
        this.f |= 1024;
        l();
        return this;
    }

    public rs1 p(boolean z2) {
        if (this.A) {
            return clone().p(true);
        }
        this.n = !z2;
        this.f |= 256;
        l();
        return this;
    }

    public rs1 q(int i2) {
        return m(tp1.b, Integer.valueOf(i2));
    }

    public rs1 r(im1<Bitmap> im1) {
        if (this.A) {
            return clone().r(im1);
        }
        f(im1);
        this.r = true;
        this.f |= 131072;
        l();
        return this;
    }
}
