package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.a32;

/* renamed from: vk2  reason: default package */
public final class vk2 extends z72<yk2> {
    public vk2(Context context, Looper looper, x72 x72, a32.b bVar, a32.c cVar) {
        super(context, looper, 40, x72, bVar, cVar);
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return queryLocalInterface instanceof yk2 ? (yk2) queryLocalInterface : new zk2(iBinder);
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return 11925000;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.clearcut.service.START";
    }
}
