package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.firebase.auth.ModuleDescriptor;
import java.util.Objects;

/* renamed from: v43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class v43 extends z72<h53> implements u43 {
    public static final wa2 c = new wa2("FirebaseAuth", "FirebaseAuth:");

    /* renamed from: a  reason: collision with root package name */
    public final Context f3597a;
    public final l53 b;

    public v43(Context context, Looper looper, x72 x72, l53 l53, n32 n32, w32 w32) {
        super(context, looper, 112, x72, n32, w32);
        Objects.requireNonNull(context, "null reference");
        this.f3597a = context;
        this.b = l53;
    }

    @Override // defpackage.w72
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        return queryLocalInterface instanceof h53 ? (h53) queryLocalInterface : new f53(iBinder);
    }

    @Override // defpackage.u43
    public final /* bridge */ /* synthetic */ h53 d() throws DeadObjectException {
        return (h53) super.getService();
    }

    @Override // defpackage.w72
    public final Feature[] getApiFeatures() {
        return nq2.d;
    }

    @Override // defpackage.w72
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        if (getServiceRequestExtraArgs == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        l53 l53 = this.b;
        if (l53 != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", l53.g);
        }
        getServiceRequestExtraArgs.putString("com.google.firebase.auth.LIBRARY_VERSION", r53.c());
        return getServiceRequestExtraArgs;
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    @Override // defpackage.w72
    public final String getStartServicePackage() {
        if (this.b.f) {
            c.b("Preparing to create service connection to fallback implementation", new Object[0]);
            return this.f3597a.getPackageName();
        }
        c.b("Preparing to create service connection to gms implementation", new Object[0]);
        return "com.google.android.gms";
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final boolean requiresGooglePlayServices() {
        return DynamiteModule.a(this.f3597a, ModuleDescriptor.MODULE_ID) == 0;
    }
}
