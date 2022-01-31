package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.a32;

/* renamed from: dn3  reason: default package */
public class dn3 extends z72<jm3> {

    /* renamed from: a  reason: collision with root package name */
    public final String f860a;
    public final en3<jm3> b = new en3(this);

    public dn3(Context context, Looper looper, a32.b bVar, a32.c cVar, String str, x72 x72) {
        super(context, looper, 23, x72, bVar, cVar);
        this.f860a = str;
    }

    @Override // defpackage.w72
    public /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof jm3 ? (jm3) queryLocalInterface : new km3(iBinder);
    }

    @Override // defpackage.w72
    public Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f860a);
        return bundle;
    }

    @Override // defpackage.w72, defpackage.x22.f
    public int getMinApkVersion() {
        return 11925000;
    }

    @Override // defpackage.w72
    public String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // defpackage.w72
    public String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
