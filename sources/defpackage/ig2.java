package defpackage;

import defpackage.ug2;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/* renamed from: ig2  reason: default package */
public final class ig2 extends hg2<ug2.d> {
    @Override // defpackage.hg2
    public final int a(Map.Entry<?, ?> entry) {
        Objects.requireNonNull((ug2.d) entry.getKey());
        return 0;
    }

    @Override // defpackage.hg2
    public final lg2<ug2.d> b(Object obj) {
        return ((ug2.c) obj).zzjv;
    }

    @Override // defpackage.hg2
    public final void c(xj2 xj2, Map.Entry<?, ?> entry) throws IOException {
        int[] iArr = jg2.f1921a;
        Objects.requireNonNull((ug2.d) entry.getKey());
        throw null;
    }

    @Override // defpackage.hg2
    public final lg2<ug2.d> d(Object obj) {
        ug2.c cVar = (ug2.c) obj;
        lg2<ug2.d> lg2 = cVar.zzjv;
        if (!lg2.b) {
            return lg2;
        }
        lg2<ug2.d> lg22 = (lg2) lg2.clone();
        cVar.zzjv = lg22;
        return lg22;
    }

    @Override // defpackage.hg2
    public final void e(Object obj) {
        lg2<ug2.d> lg2 = ((ug2.c) obj).zzjv;
        if (!lg2.b) {
            lg2.f2212a.i();
            lg2.b = true;
        }
    }

    @Override // defpackage.hg2
    public final boolean f(zh2 zh2) {
        return zh2 instanceof ug2.c;
    }
}
