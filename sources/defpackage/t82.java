package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.a32;

/* renamed from: t82  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class t82 extends z72<v82> {
    public t82(Context context, Looper looper, x72 x72, a32.b bVar, a32.c cVar) {
        super(context, looper, 39, x72, bVar, cVar);
    }

    @Override // defpackage.w72
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        return queryLocalInterface instanceof v82 ? (v82) queryLocalInterface : new v82(iBinder);
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.service.START";
    }
}
