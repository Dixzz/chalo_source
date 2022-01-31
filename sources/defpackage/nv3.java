package defpackage;

/* renamed from: nv3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class nv3 extends mv3 {
    public nv3(lv3 lv3) {
        super(null);
    }

    public static <E> zu3<E> c(Object obj, long j) {
        return (zu3) kx3.r(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // defpackage.mv3
    public final <E> void a(Object obj, Object obj2, long j) {
        zu3<E> c = c(obj, j);
        zu3<E> c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        zu3<E> zu3 = c;
        zu3 = c;
        if (size > 0 && size2 > 0) {
            boolean zza = c.zza();
            zu3<E> zu32 = c;
            if (!zza) {
                zu32 = c.j(size2 + size);
            }
            zu32.addAll(c2);
            zu3 = zu32;
        }
        if (size > 0) {
            c2 = zu3;
        }
        kx3.f(obj, j, c2);
    }

    @Override // defpackage.mv3
    public final void b(Object obj, long j) {
        c(obj, j).S0();
    }
}
