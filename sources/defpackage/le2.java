package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import defpackage.a32;

/* renamed from: le2  reason: default package */
public final class le2 extends z72<me2> {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f2202a;

    public le2(Context context, Looper looper, x72 x72, wz1 wz1, a32.b bVar, a32.c cVar) {
        super(context, looper, 16, x72, bVar, cVar);
        if (wz1 == null) {
            this.f2202a = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof me2) {
            return (me2) queryLocalInterface;
        }
        return new ne2(iBinder);
    }

    @Override // defpackage.w72
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.f2202a;
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final boolean requiresSignIn() {
        x72 clientSettings = getClientSettings();
        Account account = clientSettings.f3896a;
        if (TextUtils.isEmpty(account != null ? account.name : null)) {
            return false;
        }
        if (clientSettings.d.get(vz1.c) != null) {
            throw null;
        } else if (!clientSettings.b.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
