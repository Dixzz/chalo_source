package defpackage;

import android.os.Bundle;
import android.os.IBinder;

/* renamed from: fa2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class fa2 extends v92 {
    public w72 f;
    public final int g;

    public fa2(w72 w72, int i) {
        this.f = w72;
        this.g = i;
    }

    @Override // defpackage.d82
    public final void J1(int i, IBinder iBinder, Bundle bundle) {
        gj1.l(this.f, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f.onPostInitHandler(i, iBinder, bundle, this.g);
        this.f = null;
    }
}
