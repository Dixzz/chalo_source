package defpackage;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* renamed from: le4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class le4 implements Runnable {
    public final /* synthetic */ Bundle f;
    public final /* synthetic */ je4 g;
    public final /* synthetic */ je4 h;
    public final /* synthetic */ long i;
    public final /* synthetic */ ie4 j;

    public le4(ie4 ie4, Bundle bundle, je4 je4, je4 je42, long j2) {
        this.j = ie4;
        this.f = bundle;
        this.g = je4;
        this.h = je42;
        this.i = j2;
    }

    public final void run() {
        ie4 ie4 = this.j;
        Bundle bundle = this.f;
        je4 je4 = this.g;
        je4 je42 = this.h;
        long j2 = this.i;
        Objects.requireNonNull(ie4);
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        ie4.A(je4, je42, j2, true, ie4.h().y(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, true));
    }
}
