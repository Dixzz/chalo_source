package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.Objects;

/* renamed from: k72  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class k72 implements Runnable {
    public final /* synthetic */ LifecycleCallback f;
    public final /* synthetic */ String g;
    public final /* synthetic */ l72 h;

    public k72(l72 l72, LifecycleCallback lifecycleCallback, String str) {
        this.h = l72;
        this.f = lifecycleCallback;
        this.g = str;
    }

    public final void run() {
        l72 l72 = this.h;
        if (l72.g > 0) {
            LifecycleCallback lifecycleCallback = this.f;
            Bundle bundle = l72.h;
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
