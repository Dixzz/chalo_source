package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import defpackage.x22;

/* renamed from: o62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class o62<ResultT> extends c62 {
    public final d42<x22.b, ResultT> b;
    public final zi4<ResultT> c;
    public final b42 d;

    public o62(int i, d42<x22.b, ResultT> d42, zi4<ResultT> zi4, b42 b42) {
        super(i);
        this.c = zi4;
        this.b = d42;
        this.d = b42;
        if (i == 2 && d42.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // defpackage.q62
    public final void a(Status status) {
        this.c.a(this.d.getException(status));
    }

    @Override // defpackage.q62
    public final void b(Exception exc) {
        this.c.a(exc);
    }

    @Override // defpackage.q62
    public final void c(f42 f42, boolean z) {
        zi4<ResultT> zi4 = this.c;
        f42.b.put(zi4, Boolean.valueOf(z));
        zi4.f4178a.b(new h72(f42, zi4));
    }

    @Override // defpackage.q62
    public final void d(p52<?> p52) throws DeadObjectException {
        try {
            this.b.doExecute(p52.g, this.c);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            this.c.a(this.d.getException(q62.e(e2)));
        } catch (RuntimeException e3) {
            this.c.a(e3);
        }
    }

    @Override // defpackage.c62
    public final Feature[] f(p52<?> p52) {
        return this.b.zaa();
    }

    @Override // defpackage.c62
    public final boolean g(p52<?> p52) {
        return this.b.shouldAutoResolveMissingFeatures();
    }
}
