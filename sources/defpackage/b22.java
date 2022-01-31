package defpackage;

import android.os.Bundle;

/* renamed from: b22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class b22 extends e22<Void> {
    public b22(int i, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // defpackage.e22
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            c(null);
        } else {
            b(new d22(4, "Invalid response to one way request"));
        }
    }

    @Override // defpackage.e22
    public final boolean d() {
        return true;
    }
}
