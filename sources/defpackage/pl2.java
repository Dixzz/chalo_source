package defpackage;

import java.util.List;

/* renamed from: pl2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class pl2 extends ql2 {
    @Override // defpackage.ql2
    public final <L> List<L> a(Object obj, long j) {
        ja3 ja3 = (ja3) ln2.t(obj, j);
        if (ja3.zza()) {
            return ja3;
        }
        int size = ja3.size();
        ja3 D = ja3.D(size == 0 ? 10 : size + size);
        ln2.e.o(obj, j, D);
        return D;
    }

    @Override // defpackage.ql2
    public final void b(Object obj, long j) {
        ((ja3) ln2.t(obj, j)).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    @Override // defpackage.ql2
    public final <E> void c(Object obj, Object obj2, long j) {
        ja3<E> ja3 = (ja3) ln2.t(obj, j);
        ja3<E> ja32 = (ja3) ln2.t(obj2, j);
        int size = ja3.size();
        int size2 = ja32.size();
        ja3<E> ja33 = ja3;
        ja33 = ja3;
        if (size > 0 && size2 > 0) {
            boolean zza = ja3.zza();
            ja3<E> ja34 = ja3;
            if (!zza) {
                ja34 = ja3.D(size2 + size);
            }
            ja34.addAll(ja32);
            ja33 = ja34;
        }
        if (size > 0) {
            ja32 = ja33;
        }
        ln2.e.o(obj, j, ja32);
    }
}
