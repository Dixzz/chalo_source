package defpackage;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import defpackage.l32;
import defpackage.x22;

/* renamed from: n62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class n62<A extends l32<? extends f32, x22.b>> extends q62 {
    public final A b;

    public n62(int i, A a2) {
        super(i);
        gj1.l(a2, "Null methods are not runnable.");
        this.b = a2;
    }

    @Override // defpackage.q62
    public final void a(Status status) {
        try {
            this.b.n(status);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // defpackage.q62
    public final void b(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        try {
            this.b.n(new Status(10, hj1.b0(new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length()), simpleName, ": ", localizedMessage)));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // defpackage.q62
    public final void c(f42 f42, boolean z) {
        A a2 = this.b;
        f42.f1087a.put(a2, Boolean.valueOf(z));
        a2.c(new g72(f42, a2));
    }

    @Override // defpackage.q62
    public final void d(p52<?> p52) throws DeadObjectException {
        try {
            this.b.m(p52.g);
        } catch (RuntimeException e) {
            b(e);
        }
    }
}
