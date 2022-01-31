package defpackage;

import android.os.Bundle;

/* renamed from: g22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class g22 extends e22<Bundle> {
    public g22(int i, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // defpackage.e22
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        c(bundle2);
    }

    @Override // defpackage.e22
    public final boolean d() {
        return false;
    }
}
