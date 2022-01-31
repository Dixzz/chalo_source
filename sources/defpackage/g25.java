package defpackage;

import defpackage.n25;
import java.io.IOException;
import java.util.Objects;

/* renamed from: g25  reason: default package */
/* compiled from: UnknownFieldSetLiteSchema */
public class g25 extends e25<f25, f25> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // defpackage.e25
    public void a(f25 f25, int i, int i2) {
        f25.f((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.e25
    public void b(f25 f25, int i, long j) {
        f25.f((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // defpackage.e25
    public void c(f25 f25, int i, f25 f252) {
        f25.f((i << 3) | 3, f252);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, a05] */
    @Override // defpackage.e25
    public void d(f25 f25, int i, a05 a05) {
        f25.f((i << 3) | 2, a05);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // defpackage.e25
    public void e(f25 f25, int i, long j) {
        f25.f((i << 3) | 0, Long.valueOf(j));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.e25
    public f25 f(Object obj) {
        q05 q05 = (q05) obj;
        f25 f25 = q05.unknownFields;
        if (f25 != f25.f) {
            return f25;
        }
        f25 e = f25.e();
        q05.unknownFields = e;
        return e;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.e25
    public f25 g(Object obj) {
        return ((q05) obj).unknownFields;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e25
    public int h(f25 f25) {
        return f25.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e25
    public int i(f25 f25) {
        f25 f252 = f25;
        int i = f252.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < f252.f1064a; i3++) {
            int y = d05.y(2, f252.b[i3] >>> 3);
            i2 += d05.c(3, (a05) f252.c[i3]) + y + (d05.x(1) * 2);
        }
        f252.d = i2;
        return i2;
    }

    @Override // defpackage.e25
    public void j(Object obj) {
        ((q05) obj).unknownFields.e = false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.e25
    public f25 k(f25 f25, f25 f252) {
        f25 f253 = f25;
        f25 f254 = f252;
        return f254.equals(f25.f) ? f253 : f25.d(f253, f254);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.e25
    public f25 m() {
        return f25.e();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.e25
    public void n(Object obj, f25 f25) {
        ((q05) obj).unknownFields = f25;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.e25
    public void o(Object obj, f25 f25) {
        ((q05) obj).unknownFields = f25;
    }

    @Override // defpackage.e25
    public boolean p(w15 w15) {
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e25
    public f25 q(f25 f25) {
        f25 f252 = f25;
        f252.e = false;
        return f252;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, n25] */
    @Override // defpackage.e25
    public void r(f25 f25, n25 n25) throws IOException {
        f25 f252 = f25;
        Objects.requireNonNull(f252);
        e05 e05 = (e05) n25;
        Objects.requireNonNull(e05);
        if (n25.a.ASCENDING == n25.a.DESCENDING) {
            int i = f252.f1064a;
            while (true) {
                i--;
                if (i >= 0) {
                    e05.e(f252.b[i] >>> 3, f252.c[i]);
                } else {
                    return;
                }
            }
        } else {
            for (int i2 = 0; i2 < f252.f1064a; i2++) {
                e05.e(f252.b[i2] >>> 3, f252.c[i2]);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, n25] */
    @Override // defpackage.e25
    public void s(f25 f25, n25 n25) throws IOException {
        f25.h(n25);
    }
}
