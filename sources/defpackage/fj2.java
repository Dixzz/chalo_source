package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: fj2  reason: default package */
public final class fj2 extends dj2<ej2, ej2> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.dj2
    public final /* synthetic */ void a(ej2 ej2, int i, long j) {
        ej2.b(i << 3, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, xj2] */
    @Override // defpackage.dj2
    public final /* synthetic */ void b(ej2 ej2, xj2 xj2) throws IOException {
        ej2.d(xj2);
    }

    @Override // defpackage.dj2
    public final void c(Object obj) {
        ((ug2) obj).zzjp.e = false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, xj2] */
    @Override // defpackage.dj2
    public final void d(ej2 ej2, xj2 xj2) throws IOException {
        ej2 ej22 = ej2;
        Objects.requireNonNull(ej22);
        Objects.requireNonNull(xj2);
        for (int i = 0; i < ej22.f979a; i++) {
            ((dg2) xj2).c(ej22.b[i] >>> 3, ej22.c[i]);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.dj2
    public final /* synthetic */ ej2 e() {
        return ej2.e();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.dj2
    public final void f(Object obj, ej2 ej2) {
        ((ug2) obj).zzjp = ej2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.dj2
    public final ej2 g(ej2 ej2, ej2 ej22) {
        ej2 ej23 = ej2;
        ej2 ej24 = ej22;
        if (ej24.equals(ej2.f)) {
            return ej23;
        }
        int i = ej23.f979a + ej24.f979a;
        int[] copyOf = Arrays.copyOf(ej23.b, i);
        System.arraycopy(ej24.b, 0, copyOf, ej23.f979a, ej24.f979a);
        Object[] copyOf2 = Arrays.copyOf(ej23.c, i);
        System.arraycopy(ej24.c, 0, copyOf2, ej23.f979a, ej24.f979a);
        return new ej2(i, copyOf, copyOf2, true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.dj2
    public final /* synthetic */ int h(ej2 ej2) {
        return ej2.a();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.dj2
    public final /* synthetic */ ej2 i(Object obj) {
        return ((ug2) obj).zzjp;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.dj2
    public final int j(ej2 ej2) {
        ej2 ej22 = ej2;
        int i = ej22.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < ej22.f979a; i3++) {
            int N = bg2.N(2, ej22.b[i3] >>> 3);
            i2 += bg2.w(3, (uf2) ej22.c[i3]) + N + (bg2.X(1) << 1);
        }
        ej22.d = i2;
        return i2;
    }
}
