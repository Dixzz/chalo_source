package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import defpackage.b32;
import defpackage.h82;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: p92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class p92 implements b32.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b32 f2783a;
    public final /* synthetic */ zi4 b;
    public final /* synthetic */ h82.a c;

    public p92(b32 b32, zi4 zi4, h82.a aVar, o92 o92) {
        this.f2783a = b32;
        this.b = zi4;
        this.c = aVar;
    }

    @Override // defpackage.b32.a
    public final void a(Status status) {
        Exception exc;
        if (status.m1()) {
            b32 b32 = this.f2783a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            BasePendingResult basePendingResult = (BasePendingResult) b32;
            Objects.requireNonNull(basePendingResult);
            gj1.o(!basePendingResult.j, "Result has already been consumed.");
            gj1.o(true, "Cannot await if then() has been called.");
            try {
                if (!basePendingResult.d.await(0, timeUnit)) {
                    basePendingResult.e(Status.n);
                }
            } catch (InterruptedException unused) {
                basePendingResult.e(Status.l);
            }
            gj1.o(basePendingResult.f(), "Result is not ready.");
            f32 h = basePendingResult.h();
            zi4 zi4 = this.b;
            zi4.f4178a.t(this.c.a(h));
            return;
        }
        zi4 zi42 = this.b;
        if (status.l1()) {
            exc = new d32(status);
        } else {
            exc = new y22(status);
        }
        zi42.f4178a.u(exc);
    }
}
