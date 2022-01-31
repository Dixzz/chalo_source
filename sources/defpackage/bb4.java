package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: bb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class bb4 {
    public long A;
    public long B;
    public long C;
    public String D;
    public boolean E;
    public long F;
    public long G;

    /* renamed from: a  reason: collision with root package name */
    public final vb4 f405a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;
    public long h;
    public long i;
    public String j;
    public long k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    public long p;
    public boolean q;
    public boolean r;
    public String s;
    public Boolean t;
    public long u;
    public List<String> v;
    public String w;
    public long x;
    public long y;
    public long z;

    public bb4(vb4 vb4, String str) {
        Objects.requireNonNull(vb4, "null reference");
        gj1.j(str);
        this.f405a = vb4;
        this.b = str;
        vb4.f().b();
    }

    public final void A(String str) {
        this.f405a.f().b();
        this.E |= !ug4.p0(this.f, str);
        this.f = str;
    }

    public final String B() {
        this.f405a.f().b();
        return this.w;
    }

    public final void C(long j2) {
        boolean z2 = true;
        gj1.b(j2 >= 0);
        this.f405a.f().b();
        boolean z3 = this.E;
        if (this.g == j2) {
            z2 = false;
        }
        this.E = z2 | z3;
        this.g = j2;
    }

    public final void D(String str) {
        this.f405a.f().b();
        this.E |= !ug4.p0(this.j, str);
        this.j = str;
    }

    public final String E() {
        this.f405a.f().b();
        return this.e;
    }

    public final void F(long j2) {
        this.f405a.f().b();
        this.E |= this.F != j2;
        this.F = j2;
    }

    public final void G(String str) {
        this.f405a.f().b();
        this.E |= !ug4.p0(this.l, str);
        this.l = str;
    }

    public final String H() {
        this.f405a.f().b();
        return this.f;
    }

    public final void I(long j2) {
        this.f405a.f().b();
        this.E |= this.G != j2;
        this.G = j2;
    }

    public final void J(String str) {
        this.f405a.f().b();
        this.E |= !ug4.p0(this.D, str);
        this.D = str;
    }

    public final long K() {
        this.f405a.f().b();
        return this.h;
    }

    public final long L() {
        this.f405a.f().b();
        return this.i;
    }

    public final String M() {
        this.f405a.f().b();
        return this.j;
    }

    public final long N() {
        this.f405a.f().b();
        return this.k;
    }

    public final String O() {
        this.f405a.f().b();
        return this.l;
    }

    public final long P() {
        this.f405a.f().b();
        return this.m;
    }

    public final long Q() {
        this.f405a.f().b();
        return this.n;
    }

    public final void R(long j2) {
        this.f405a.f().b();
        this.E |= this.p != j2;
        this.p = j2;
    }

    public final long S() {
        this.f405a.f().b();
        return this.u;
    }

    public final boolean T() {
        this.f405a.f().b();
        return this.o;
    }

    public final long U() {
        this.f405a.f().b();
        return this.g;
    }

    public final long V() {
        this.f405a.f().b();
        return this.F;
    }

    public final long W() {
        this.f405a.f().b();
        return this.G;
    }

    public final void X() {
        this.f405a.f().b();
        long j2 = this.g + 1;
        if (j2 > 2147483647L) {
            this.f405a.g().i.b("Bundle index overflow. appId", ra4.q(this.b));
            j2 = 0;
        }
        this.E = true;
        this.g = j2;
    }

    public final void a(long j2) {
        this.f405a.f().b();
        this.E |= this.h != j2;
        this.h = j2;
    }

    public final void b(Boolean bool) {
        this.f405a.f().b();
        boolean z2 = this.E;
        Boolean bool2 = this.t;
        this.E = z2 | (!((bool2 == null && bool == null) ? true : bool2 == null ? false : bool2.equals(bool)));
        this.t = bool;
    }

    public final void c(String str) {
        this.f405a.f().b();
        this.E |= !ug4.p0(this.c, str);
        this.c = str;
    }

    public final void d(List<String> list) {
        this.f405a.f().b();
        List<String> list2 = this.v;
        if (!((list2 == null && list == null) ? true : list2 == null ? false : list2.equals(list))) {
            this.E = true;
            this.v = list != null ? new ArrayList(list) : null;
        }
    }

    public final void e(boolean z2) {
        this.f405a.f().b();
        this.E |= this.o != z2;
        this.o = z2;
    }

    public final String f() {
        this.f405a.f().b();
        String str = this.D;
        J(null);
        return str;
    }

    public final long g() {
        this.f405a.f().b();
        return this.p;
    }

    public final boolean h() {
        this.f405a.f().b();
        return this.q;
    }

    public final boolean i() {
        this.f405a.f().b();
        return this.r;
    }

    public final Boolean j() {
        this.f405a.f().b();
        return this.t;
    }

    public final List<String> k() {
        this.f405a.f().b();
        return this.v;
    }

    public final void l(long j2) {
        this.f405a.f().b();
        this.E |= this.i != j2;
        this.i = j2;
    }

    public final void m(String str) {
        this.f405a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !ug4.p0(this.d, str);
        this.d = str;
    }

    public final void n(boolean z2) {
        this.f405a.f().b();
        this.E |= this.q != z2;
        this.q = z2;
    }

    public final String o() {
        this.f405a.f().b();
        return this.b;
    }

    public final void p(long j2) {
        this.f405a.f().b();
        this.E |= this.k != j2;
        this.k = j2;
    }

    public final void q(String str) {
        this.f405a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !ug4.p0(this.s, str);
        this.s = str;
    }

    public final void r(boolean z2) {
        this.f405a.f().b();
        this.E |= this.r != z2;
        this.r = z2;
    }

    public final String s() {
        this.f405a.f().b();
        return this.c;
    }

    public final void t(long j2) {
        this.f405a.f().b();
        this.E |= this.m != j2;
        this.m = j2;
    }

    public final void u(String str) {
        this.f405a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !ug4.p0(this.w, str);
        this.w = str;
    }

    public final String v() {
        this.f405a.f().b();
        return this.d;
    }

    public final void w(long j2) {
        this.f405a.f().b();
        this.E |= this.n != j2;
        this.n = j2;
    }

    public final void x(String str) {
        this.f405a.f().b();
        this.E |= !ug4.p0(this.e, str);
        this.e = str;
    }

    public final String y() {
        this.f405a.f().b();
        return this.s;
    }

    public final void z(long j2) {
        this.f405a.f().b();
        this.E |= this.u != j2;
        this.u = j2;
    }
}
