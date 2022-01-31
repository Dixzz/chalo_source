package defpackage;

import defpackage.he;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: ae  reason: default package */
/* compiled from: UnknownFieldSetLiteSchema */
public class ae extends yd<zd, zd> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // defpackage.yd
    public void a(zd zdVar, int i, int i2) {
        zdVar.b((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.yd
    public void b(zd zdVar, int i, long j) {
        zdVar.b((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // defpackage.yd
    public void c(zd zdVar, int i, zd zdVar2) {
        zdVar.b((i << 3) | 3, zdVar2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, ub] */
    @Override // defpackage.yd
    public void d(zd zdVar, int i, ub ubVar) {
        zdVar.b((i << 3) | 2, ubVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.yd
    public void e(zd zdVar, int i, long j) {
        zdVar.b((i << 3) | 0, Long.valueOf(j));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.yd
    public zd f(Object obj) {
        kc kcVar = (kc) obj;
        zd zdVar = kcVar.unknownFields;
        if (zdVar != zd.f) {
            return zdVar;
        }
        zd zdVar2 = new zd(0, new int[8], new Object[8], true);
        kcVar.unknownFields = zdVar2;
        return zdVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.yd
    public zd g(Object obj) {
        return ((kc) obj).unknownFields;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yd
    public int h(zd zdVar) {
        return zdVar.a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yd
    public int i(zd zdVar) {
        zd zdVar2 = zdVar;
        int i = zdVar2.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < zdVar2.f4158a; i3++) {
            int y = xb.y(2, zdVar2.b[i3] >>> 3);
            i2 += xb.c(3, (ub) zdVar2.c[i3]) + y + (xb.x(1) * 2);
        }
        zdVar2.d = i2;
        return i2;
    }

    @Override // defpackage.yd
    public void j(Object obj) {
        ((kc) obj).unknownFields.e = false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.yd
    public zd k(zd zdVar, zd zdVar2) {
        zd zdVar3 = zdVar;
        zd zdVar4 = zdVar2;
        if (zdVar4.equals(zd.f)) {
            return zdVar3;
        }
        int i = zdVar3.f4158a + zdVar4.f4158a;
        int[] copyOf = Arrays.copyOf(zdVar3.b, i);
        System.arraycopy(zdVar4.b, 0, copyOf, zdVar3.f4158a, zdVar4.f4158a);
        Object[] copyOf2 = Arrays.copyOf(zdVar3.c, i);
        System.arraycopy(zdVar4.c, 0, copyOf2, zdVar3.f4158a, zdVar4.f4158a);
        return new zd(i, copyOf, copyOf2, true);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.yd
    public zd m() {
        return new zd(0, new int[8], new Object[8], true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.yd
    public void n(Object obj, zd zdVar) {
        ((kc) obj).unknownFields = zdVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.yd
    public void o(Object obj, zd zdVar) {
        ((kc) obj).unknownFields = zdVar;
    }

    @Override // defpackage.yd
    public boolean p(qd qdVar) {
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yd
    public zd q(zd zdVar) {
        zd zdVar2 = zdVar;
        zdVar2.e = false;
        return zdVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, he] */
    @Override // defpackage.yd
    public void r(zd zdVar, he heVar) throws IOException {
        zd zdVar2 = zdVar;
        Objects.requireNonNull(zdVar2);
        yb ybVar = (yb) heVar;
        Objects.requireNonNull(ybVar);
        if (he.a.ASCENDING == he.a.DESCENDING) {
            int i = zdVar2.f4158a;
            while (true) {
                i--;
                if (i >= 0) {
                    ybVar.e(zdVar2.b[i] >>> 3, zdVar2.c[i]);
                } else {
                    return;
                }
            }
        } else {
            for (int i2 = 0; i2 < zdVar2.f4158a; i2++) {
                ybVar.e(zdVar2.b[i2] >>> 3, zdVar2.c[i2]);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, he] */
    @Override // defpackage.yd
    public void s(zd zdVar, he heVar) throws IOException {
        zdVar.d(heVar);
    }
}
