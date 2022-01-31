package defpackage;

/* renamed from: qi3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class qi3 extends pi3 {
    public qi3(oi3 oi3) {
        super(null);
    }

    public static <E> ci3<E> c(Object obj, long j) {
        return (ci3) mk3.r(obj, j);
    }

    @Override // defpackage.pi3
    public final void a(Object obj, long j) {
        c(obj, j).a1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // defpackage.pi3
    public final <E> void b(Object obj, Object obj2, long j) {
        ci3<E> c = c(obj, j);
        ci3<E> c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        ci3<E> ci3 = c;
        ci3 = c;
        if (size > 0 && size2 > 0) {
            boolean V = c.V();
            ci3<E> ci32 = c;
            if (!V) {
                ci32 = c.H0(size2 + size);
            }
            ci32.addAll(c2);
            ci3 = ci32;
        }
        if (size > 0) {
            c2 = ci3;
        }
        mk3.d(obj, j, c2);
    }
}
