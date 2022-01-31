package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;

/* renamed from: td2  reason: default package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
public final class td2 extends z72<pd2> {
    public td2(Context context, Looper looper, x72 x72, n32 n32, w32 w32) {
        super(context, looper, 126, x72, n32, w32);
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        if (queryLocalInterface instanceof pd2) {
            return (pd2) queryLocalInterface;
        }
        return new od2(iBinder);
    }

    @Override // defpackage.w72
    public final Feature[] getApiFeatures() {
        return md2.d;
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }
}
