package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import defpackage.w72;
import defpackage.x22;
import java.util.Set;

/* renamed from: s52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class s52 implements w72.c, h62 {

    /* renamed from: a  reason: collision with root package name */
    public final x22.f f3187a;
    public final j32<?> b;
    public c82 c = null;
    public Set<Scope> d = null;
    public boolean e = false;
    public final /* synthetic */ o32 f;

    public s52(o32 o32, x22.f fVar, j32<?> j32) {
        this.f = o32;
        this.f3187a = fVar;
        this.b = j32;
    }

    @Override // defpackage.w72.c
    public final void a(ConnectionResult connectionResult) {
        this.f.n.post(new r52(this, connectionResult));
    }

    public final void b(ConnectionResult connectionResult) {
        p52<?> p52 = this.f.j.get(this.b);
        if (p52 != null) {
            gj1.f(p52.r.n);
            x22.f fVar = p52.g;
            String name = fVar.getClass().getName();
            String valueOf = String.valueOf(connectionResult);
            fVar.disconnect(hj1.c0(new StringBuilder(name.length() + 25 + valueOf.length()), "onSignInFailed for ", name, " with ", valueOf));
            p52.n(connectionResult, null);
        }
    }
}
