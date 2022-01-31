package defpackage;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: x62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class x62 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    public volatile boolean g;
    public final AtomicReference<u62> h = new AtomicReference<>(null);
    public final Handler i = new ve2(Looper.getMainLooper());
    public final q22 j;

    public x62(s32 s32, q22 q22) {
        super(s32);
        this.j = q22;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void d(int i2, int i3, Intent intent) {
        u62 u62 = this.h.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int e = this.j.e(b());
                if (e == 0) {
                    j();
                    return;
                } else if (u62 != null) {
                    if (u62.b.g == 18 && e == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i3 == -1) {
            j();
            return;
        } else if (i3 == 0) {
            if (u62 != null) {
                int i4 = 13;
                if (intent != null) {
                    i4 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                ConnectionResult connectionResult = new ConnectionResult(i4, null, u62.b.toString());
                int i5 = u62.f3461a;
                this.h.set(null);
                l(connectionResult, i5);
                return;
            }
            return;
        }
        if (u62 != null) {
            k(u62.b, u62.f3461a);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(Bundle bundle) {
        if (bundle != null) {
            this.h.set(bundle.getBoolean("resolving_error", false) ? new u62(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void g(Bundle bundle) {
        u62 u62 = this.h.get();
        if (u62 != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", u62.f3461a);
            bundle.putInt("failed_status", u62.b.g);
            bundle.putParcelable("failed_resolution", u62.b.h);
        }
    }

    public final void j() {
        this.h.set(null);
        m();
    }

    public final void k(ConnectionResult connectionResult, int i2) {
        this.h.set(null);
        l(connectionResult, i2);
    }

    public abstract void l(ConnectionResult connectionResult, int i2);

    public abstract void m();

    public final void n(ConnectionResult connectionResult, int i2) {
        u62 u62 = new u62(connectionResult, i2);
        if (this.h.compareAndSet(null, u62)) {
            this.i.post(new w62(this, u62));
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        int i2;
        ConnectionResult connectionResult = new ConnectionResult(13, null);
        u62 u62 = this.h.get();
        if (u62 == null) {
            i2 = -1;
        } else {
            i2 = u62.f3461a;
        }
        this.h.set(null);
        l(connectionResult, i2);
    }
}
