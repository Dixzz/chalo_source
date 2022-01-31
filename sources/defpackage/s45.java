package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: s45  reason: default package */
/* compiled from: ReedSolomonEncoder */
public final class s45 {

    /* renamed from: a  reason: collision with root package name */
    public final p45 f3184a;
    public final List<q45> b;

    public s45(p45 p45) {
        this.f3184a = p45;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new q45(p45, new int[]{1}));
    }

    public void a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                if (i >= this.b.size()) {
                    q45 q45 = (q45) hj1.u(this.b, 1);
                    for (int size = this.b.size(); size <= i; size++) {
                        p45 p45 = this.f3184a;
                        q45 = q45.g(new q45(p45, new int[]{1, p45.f2767a[(size - 1) + p45.g]}));
                        this.b.add(q45);
                    }
                }
                q45 q452 = this.b.get(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                q45 h = new q45(this.f3184a, iArr2).h(i, 1);
                if (!h.f2895a.equals(q452.f2895a)) {
                    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                } else if (!q452.e()) {
                    q45 q453 = h.f2895a.c;
                    int b2 = h.f2895a.b(q452.c(q452.d()));
                    q45 q454 = h;
                    while (q454.d() >= q452.d() && !q454.e()) {
                        int d = q454.d() - q452.d();
                        int c = h.f2895a.c(q454.c(q454.d()), b2);
                        q45 h2 = q452.h(d, c);
                        q453 = q453.a(h.f2895a.a(d, c));
                        q454 = q454.a(h2);
                    }
                    int[] iArr3 = new q45[]{q453, q454}[1].b;
                    int length2 = i - iArr3.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        iArr[length + i2] = 0;
                    }
                    System.arraycopy(iArr3, 0, iArr, length + length2, iArr3.length);
                } else {
                    throw new IllegalArgumentException("Divide by 0");
                }
            } else {
                throw new IllegalArgumentException("No data bytes provided");
            }
        } else {
            throw new IllegalArgumentException("No error correction bytes");
        }
    }
}
