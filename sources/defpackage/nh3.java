package defpackage;

import defpackage.uh3;
import java.io.IOException;
import java.util.Map;

/* renamed from: nh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class nh3 extends kh3<uh3.c> {
    @Override // defpackage.kh3
    public final int a(Map.Entry<?, ?> entry) {
        uh3.c cVar = (uh3.c) entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // defpackage.kh3
    public final void b(al3 al3, Map.Entry<?, ?> entry) throws IOException {
        uh3.c cVar = (uh3.c) entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // defpackage.kh3
    public final ph3<uh3.c> c(Object obj) {
        return ((uh3.d) obj).zzkj;
    }

    @Override // defpackage.kh3
    public final ph3<uh3.c> d(Object obj) {
        uh3.d dVar = (uh3.d) obj;
        ph3<uh3.c> ph3 = dVar.zzkj;
        if (ph3.b) {
            dVar.zzkj = (ph3) ph3.clone();
        }
        return dVar.zzkj;
    }

    @Override // defpackage.kh3
    public final boolean e(gj3 gj3) {
        return gj3 instanceof uh3.d;
    }

    @Override // defpackage.kh3
    public final void f(Object obj) {
        ((uh3.d) obj).zzkj.g();
    }
}
