package defpackage;

import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* renamed from: g42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class g42 extends x62 {
    public final p2<j32<?>> k = new p2<>(0);
    public final o32 l;

    public g42(s32 s32, o32 o32, q22 q22) {
        super(s32, q22);
        this.l = o32;
        this.f.a("ConnectionlessLifecycleHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f() {
        if (!this.k.isEmpty()) {
            this.l.f(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        this.g = true;
        if (!this.k.isEmpty()) {
            this.l.f(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i() {
        this.g = false;
        o32 o32 = this.l;
        Objects.requireNonNull(o32);
        synchronized (o32.r) {
            if (o32.k == this) {
                o32.k = null;
                o32.l.clear();
            }
        }
    }

    @Override // defpackage.x62
    public final void l(ConnectionResult connectionResult, int i) {
        this.l.i(connectionResult, i);
    }

    @Override // defpackage.x62
    public final void m() {
        Handler handler = this.l.n;
        handler.sendMessage(handler.obtainMessage(3));
    }
}
