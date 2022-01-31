package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import defpackage.a32;
import defpackage.w72;
import java.util.Objects;

/* renamed from: ai4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class ai4 extends z72<fi4> implements ni4 {
    public static final /* synthetic */ int e = 0;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f168a = true;
    public final x72 b;
    public final Bundle c;
    public final Integer d;

    public ai4(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull x72 x72, @RecentlyNonNull Bundle bundle, @RecentlyNonNull a32.b bVar, @RecentlyNonNull a32.c cVar) {
        super(context, looper, 44, x72, bVar, cVar);
        this.b = x72;
        this.c = bundle;
        this.d = x72.h;
    }

    @Override // defpackage.ni4
    public final void a(@RecentlyNonNull c82 c82, boolean z) {
        try {
            fi4 fi4 = (fi4) getService();
            Integer num = this.d;
            Objects.requireNonNull(num, "null reference");
            int intValue = num.intValue();
            Parcel C = fi4.C();
            re2.b(C, c82);
            C.writeInt(intValue);
            C.writeInt(z ? 1 : 0);
            fi4.F(9, C);
        } catch (RemoteException unused) {
        }
    }

    @Override // defpackage.ni4
    public final void b() {
        try {
            fi4 fi4 = (fi4) getService();
            Integer num = this.d;
            Objects.requireNonNull(num, "null reference");
            int intValue = num.intValue();
            Parcel C = fi4.C();
            C.writeInt(intValue);
            fi4.F(7, C);
        } catch (RemoteException unused) {
        }
    }

    @Override // defpackage.ni4
    public final void c() {
        connect(new w72.d());
    }

    @Override // defpackage.w72
    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(@RecentlyNonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof fi4 ? (fi4) queryLocalInterface : new fi4(iBinder);
    }

    @Override // defpackage.ni4
    public final void e(ei4 ei4) {
        gj1.l(ei4, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.b.f3896a;
            if (account == null) {
                account = new Account(w72.DEFAULT_ACCOUNT, "com.google");
            }
            GoogleSignInAccount b2 = w72.DEFAULT_ACCOUNT.equals(account.name) ? i02.a(getContext()).b() : null;
            Integer num = this.d;
            Objects.requireNonNull(num, "null reference");
            zat zat = new zat(account, num.intValue(), b2);
            fi4 fi4 = (fi4) getService();
            zai zai = new zai(1, zat);
            Parcel C = fi4.C();
            int i = re2.f3072a;
            C.writeInt(1);
            zai.writeToParcel(C, 0);
            re2.b(C, ei4);
            fi4.F(12, C);
        } catch (RemoteException e2) {
            try {
                ei4.x0(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // defpackage.w72
    @RecentlyNonNull
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.b.e)) {
            this.c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.b.e);
        }
        return this.c;
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // defpackage.w72
    @RecentlyNonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // defpackage.w72
    @RecentlyNonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final boolean requiresSignIn() {
        return this.f168a;
    }
}
