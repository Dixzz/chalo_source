package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.w72;

/* renamed from: sa4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class sa4 extends w72<ja4> {
    public sa4(Context context, Looper looper, w72.a aVar, w72.b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    /* Return type fixed from 'android.os.IInterface' to match base method */
    @Override // defpackage.w72
    public final /* synthetic */ ja4 createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof ja4) {
            return (ja4) queryLocalInterface;
        }
        return new la4(iBinder);
    }

    @Override // defpackage.w72
    public final int getMinApkVersion() {
        return u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.measurement.START";
    }
}
