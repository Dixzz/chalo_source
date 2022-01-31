package defpackage;

/* renamed from: nh2  reason: default package */
public final class nh2 extends kh2 {
    public nh2(lh2 lh2) {
        super(null);
    }

    public static <E> zg2<E> c(Object obj, long j) {
        return (zg2) jj2.t(obj, j);
    }

    @Override // defpackage.kh2
    public final void a(Object obj, long j) {
        c(obj, j).p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // defpackage.kh2
    public final <E> void b(Object obj, Object obj2, long j) {
        zg2<E> c = c(obj, j);
        zg2<E> c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        zg2<E> zg2 = c;
        zg2 = c;
        if (size > 0 && size2 > 0) {
            boolean o = c.o();
            zg2<E> zg22 = c;
            if (!o) {
                zg22 = c.y0(size2 + size);
            }
            zg22.addAll(c2);
            zg2 = zg22;
        }
        if (size > 0) {
            c2 = zg2;
        }
        jj2.f(obj, j, c2);
    }
}
