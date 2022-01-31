package defpackage;

import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.Callable;

/* renamed from: pg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class pg4 implements Callable<String> {
    public final /* synthetic */ zzn f;
    public final /* synthetic */ lg4 g;

    public pg4(lg4 lg4, zzn zzn) {
        this.g = lg4;
        this.f = zzn;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final String call() throws Exception {
        if (!uy3.a() || !this.g.j.g.l(q64.J0) || (this.g.a(this.f.f).k() && e64.b(this.f.B).k())) {
            return this.g.G(this.f).s();
        }
        this.g.g().n.a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
