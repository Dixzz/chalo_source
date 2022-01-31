package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.oo3;

/* renamed from: wp3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public final class wp3 extends oo3.b {
    public final /* synthetic */ Bundle j;
    public final /* synthetic */ Activity k;
    public final /* synthetic */ oo3.c l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wp3(oo3.c cVar, Bundle bundle, Activity activity) {
        super(true);
        this.l = cVar;
        this.j = bundle;
        this.k = activity;
    }

    @Override // defpackage.oo3.b
    public final void a() throws RemoteException {
        Bundle bundle;
        if (this.j != null) {
            bundle = new Bundle();
            if (this.j.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.j.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        oo3.this.h.onActivityCreated(new kc2(this.k), bundle, this.g);
    }
}
