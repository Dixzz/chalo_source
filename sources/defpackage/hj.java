package defpackage;

import android.os.Bundle;
import defpackage.mj;

@mj.b("navigation")
/* renamed from: hj  reason: default package */
/* compiled from: NavGraphNavigator */
public class hj extends mj<gj> {

    /* renamed from: a  reason: collision with root package name */
    public final nj f1379a;

    public hj(nj njVar) {
        this.f1379a = njVar;
    }

    /* Return type fixed from 'ej' to match base method */
    @Override // defpackage.mj
    public gj a() {
        return new gj(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [ej, android.os.Bundle, kj, mj$a] */
    @Override // defpackage.mj
    public ej b(gj gjVar, Bundle bundle, kj kjVar, mj.a aVar) {
        String str;
        gj gjVar2 = gjVar;
        int i = gjVar2.o;
        if (i == 0) {
            StringBuilder i0 = hj1.i0("no start destination defined via app:startDestination for ");
            int i2 = gjVar2.h;
            if (i2 != 0) {
                if (gjVar2.i == null) {
                    gjVar2.i = Integer.toString(i2);
                }
                str = gjVar2.i;
            } else {
                str = "the root navigation";
            }
            i0.append(str);
            throw new IllegalStateException(i0.toString());
        }
        ej z = gjVar2.z(i, false);
        if (z != null) {
            return this.f1379a.c(z.f).b(z, z.b(bundle), kjVar, aVar);
        }
        if (gjVar2.p == null) {
            gjVar2.p = Integer.toString(gjVar2.o);
        }
        throw new IllegalArgumentException(hj1.T("navigation destination ", gjVar2.p, " is not a direct child of this NavGraph"));
    }

    @Override // defpackage.mj
    public boolean e() {
        return true;
    }
}
