package defpackage;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: bn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class bn2 extends zm2<an2, an2> {
    @Override // defpackage.zm2
    public final boolean a(i93 i93) {
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void b(an2 an2, int i, long j) {
        an2.c(i << 3, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void c(an2 an2, int i, int i2) {
        an2.c((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void d(an2 an2, int i, long j) {
        an2.c((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, g93] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void e(an2 an2, int i, g93 g93) {
        an2.c((i << 3) | 2, g93);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void f(an2 an2, int i, an2 an22) {
        an2.c((i << 3) | 3, an22);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ an2 g() {
        return an2.a();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.zm2
    public final an2 h(an2 an2) {
        an2.e = false;
        return an2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void i(Object obj, an2 an2) {
        ((ea3) obj).zzc = an2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ an2 j(Object obj) {
        return ((ea3) obj).zzc;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ an2 k(Object obj) {
        ea3 ea3 = (ea3) obj;
        an2 an2 = ea3.zzc;
        if (an2 != an2.f) {
            return an2;
        }
        an2 a2 = an2.a();
        ea3.zzc = a2;
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void l(Object obj, an2 an2) {
        ((ea3) obj).zzc = an2;
    }

    @Override // defpackage.zm2
    public final void m(Object obj) {
        ((ea3) obj).zzc.e = false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.zm2
    public final an2 o(an2 an2, an2 an22) {
        an2 an23 = an22;
        if (an23.equals(an2.f)) {
            return an2;
        }
        an2 an24 = an2;
        int i = an24.f182a + an23.f182a;
        int[] copyOf = Arrays.copyOf(an24.b, i);
        System.arraycopy(an23.b, 0, copyOf, an24.f182a, an23.f182a);
        Object[] copyOf2 = Arrays.copyOf(an24.c, i);
        System.arraycopy(an23.c, 0, copyOf2, an24.f182a, an23.f182a);
        return new an2(i, copyOf, copyOf2, true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.zm2
    public final int p(an2 an2) {
        an2 an22 = an2;
        int i = an22.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < an22.f182a; i3++) {
            int i4 = an22.b[i3];
            int B = n93.B(1);
            int B2 = n93.B(2);
            int b = n93.b(i4 >>> 3);
            int B3 = n93.B(3);
            int e = ((g93) an22.c[i3]).e();
            int i5 = B2 + b;
            i2 += n93.b(e) + e + B3 + i5 + B + B;
        }
        an22.d = i2;
        return i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ int q(an2 an2) {
        return an2.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, o93] */
    @Override // defpackage.zm2
    public final /* bridge */ /* synthetic */ void r(an2 an2, o93 o93) throws IOException {
        an2.d(o93);
    }
}
