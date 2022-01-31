package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: gx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class gx3 extends ex3<dx3, dx3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ex3
    public final /* synthetic */ dx3 a() {
        return dx3.c();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.ex3
    public final /* synthetic */ void b(dx3 dx3, int i, long j) {
        dx3.a(i << 3, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, wx3] */
    @Override // defpackage.ex3
    public final /* synthetic */ void c(dx3 dx3, wx3 wx3) throws IOException {
        dx3.d(wx3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.ex3
    public final void d(Object obj, dx3 dx3) {
        ((ru3) obj).zzb = dx3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ex3
    public final /* synthetic */ dx3 e(Object obj) {
        return ((ru3) obj).zzb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, wx3] */
    @Override // defpackage.ex3
    public final void f(dx3 dx3, wx3 wx3) throws IOException {
        dx3 dx32 = dx3;
        Objects.requireNonNull(dx32);
        Objects.requireNonNull(wx3);
        for (int i = 0; i < dx32.f900a; i++) {
            ((du3) wx3).c(dx32.b[i] >>> 3, dx32.c[i]);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.ex3
    public final dx3 g(dx3 dx3, dx3 dx32) {
        dx3 dx33 = dx3;
        dx3 dx34 = dx32;
        if (dx34.equals(dx3.f)) {
            return dx33;
        }
        int i = dx33.f900a + dx34.f900a;
        int[] copyOf = Arrays.copyOf(dx33.b, i);
        System.arraycopy(dx34.b, 0, copyOf, dx33.f900a, dx34.f900a);
        Object[] copyOf2 = Arrays.copyOf(dx33.c, i);
        System.arraycopy(dx34.c, 0, copyOf2, dx33.f900a, dx34.f900a);
        return new dx3(i, copyOf, copyOf2, true);
    }

    @Override // defpackage.ex3
    public final void h(Object obj) {
        ((ru3) obj).zzb.e = false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ex3
    public final int i(dx3 dx3) {
        dx3 dx32 = dx3;
        int i = dx32.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < dx32.f900a; i3++) {
            int M = bu3.M(2, dx32.b[i3] >>> 3);
            i2 += bu3.w(3, (qt3) dx32.c[i3]) + M + (bu3.L(8) << 1);
        }
        dx32.d = i2;
        return i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ex3
    public final /* synthetic */ int j(dx3 dx3) {
        return dx3.e();
    }
}
