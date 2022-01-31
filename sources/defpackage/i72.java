package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.Objects;

/* renamed from: i72  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class i72 implements Runnable {
    public final /* synthetic */ LifecycleCallback f;
    public final /* synthetic */ String g;
    public final /* synthetic */ j72 h;

    public i72(j72 j72, LifecycleCallback lifecycleCallback, String str) {
        this.h = j72;
        this.f = lifecycleCallback;
        this.g = str;
    }

    public final void run() {
        j72 j72 = this.h;
        if (j72.g > 0) {
            LifecycleCallback lifecycleCallback = this.f;
            Bundle bundle = j72.h;
            lifecycleCallback.e(bundle != null ? bundle.getBundle(this.g) : null);
        }
        if (this.h.g >= 2) {
            this.f.h();
        }
        if (this.h.g >= 3) {
            this.f.f();
        }
        if (this.h.g >= 4) {
            this.f.i();
        }
        if (this.h.g >= 5) {
            Objects.requireNonNull(this.f);
        }
    }
}
