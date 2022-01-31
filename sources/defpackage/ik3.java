package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: ik3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ik3 extends gk3<jk3, jk3> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, al3] */
    @Override // defpackage.gk3
    public final /* synthetic */ void a(jk3 jk3, al3 al3) throws IOException {
        jk3.b(al3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, al3] */
    @Override // defpackage.gk3
    public final void b(jk3 jk3, al3 al3) throws IOException {
        jk3 jk32 = jk3;
        Objects.requireNonNull(jk32);
        Objects.requireNonNull(al3);
        for (int i = 0; i < jk32.f1947a; i++) {
            ((jh3) al3).c(jk32.b[i] >>> 3, jk32.c[i]);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.gk3
    public final /* synthetic */ void c(Object obj, jk3 jk3) {
        ((uh3) obj).zzkc = jk3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.gk3
    public final jk3 d(jk3 jk3, jk3 jk32) {
        jk3 jk33 = jk3;
        jk3 jk34 = jk32;
        if (jk34.equals(jk3.e)) {
            return jk33;
        }
        int i = jk33.f1947a + jk34.f1947a;
        int[] copyOf = Arrays.copyOf(jk33.b, i);
        System.arraycopy(jk34.b, 0, copyOf, jk33.f1947a, jk34.f1947a);
        Object[] copyOf2 = Arrays.copyOf(jk33.c, i);
        System.arraycopy(jk34.c, 0, copyOf2, jk33.f1947a, jk34.f1947a);
        return new jk3(i, copyOf, copyOf2, true);
    }

    @Override // defpackage.gk3
    public final void e(Object obj) {
        Objects.requireNonNull(((uh3) obj).zzkc);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.gk3
    public final /* synthetic */ int f(jk3 jk3) {
        return jk3.c();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.gk3
    public final /* synthetic */ jk3 g(Object obj) {
        return ((uh3) obj).zzkc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.gk3
    public final int h(jk3 jk3) {
        jk3 jk32 = jk3;
        int i = jk32.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < jk32.f1947a; i3++) {
            int G = hh3.G(2, jk32.b[i3] >>> 3);
            i2 += hh3.q(3, (xg3) jk32.c[i3]) + G + (hh3.Q(1) << 1);
        }
        jk32.d = i2;
        return i2;
    }
}
