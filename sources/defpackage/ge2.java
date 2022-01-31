package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.a32;
import defpackage.uz1;
import java.util.Objects;

/* renamed from: ge2  reason: default package */
public final class ge2 extends z72<je2> {

    /* renamed from: a  reason: collision with root package name */
    public final uz1.a f1244a;

    public ge2(Context context, Looper looper, x72 x72, uz1.a aVar, a32.b bVar, a32.c cVar) {
        super(context, looper, 68, x72, bVar, cVar);
        this.f1244a = aVar;
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof je2) {
            return (je2) queryLocalInterface;
        }
        return new ke2(iBinder);
    }

    @Override // defpackage.w72
    public final Bundle getGetServiceRequestExtraArgs() {
        uz1.a aVar = this.f1244a;
        if (aVar == null) {
            return new Bundle();
        }
        Objects.requireNonNull(aVar);
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", false);
        return bundle;
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
