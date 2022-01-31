package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import java.util.Objects;

/* renamed from: z82  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class z82 extends z72<u82> {

    /* renamed from: a  reason: collision with root package name */
    public final k82 f4144a;

    public z82(Context context, Looper looper, x72 x72, k82 k82, n32 n32, w32 w32) {
        super(context, looper, 270, x72, n32, w32);
        this.f4144a = k82;
    }

    @Override // defpackage.w72
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof u82 ? (u82) queryLocalInterface : new u82(iBinder);
    }

    @Override // defpackage.w72
    public final Feature[] getApiFeatures() {
        return se2.b;
    }

    @Override // defpackage.w72
    public final Bundle getGetServiceRequestExtraArgs() {
        k82 k82 = this.f4144a;
        Objects.requireNonNull(k82);
        Bundle bundle = new Bundle();
        String str = k82.f;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return 203390000;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // defpackage.w72
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
