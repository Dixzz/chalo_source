package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.a32;

/* renamed from: z24  reason: default package */
public final class z24 extends z72<t24> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4111a;

    public z24(Context context, Looper looper, x72 x72, a32.b bVar, a32.c cVar) {
        super(context, looper, 45, x72, bVar, cVar);
        this.f4111a = context;
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        return queryLocalInterface instanceof t24 ? (t24) queryLocalInterface : new u24(iBinder);
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return 12200000;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.safetynet.service.START";
    }
}
