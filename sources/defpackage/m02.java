package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Scope;
import defpackage.a32;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: m02  reason: default package */
public final class m02 extends z72<v02> {

    /* renamed from: a  reason: collision with root package name */
    public final GoogleSignInOptions f2301a;

    public m02(Context context, Looper looper, x72 x72, GoogleSignInOptions googleSignInOptions, a32.b bVar, a32.c cVar) {
        super(context, looper, 91, x72, bVar, cVar);
        GoogleSignInOptions googleSignInOptions2;
        if (googleSignInOptions != null) {
            googleSignInOptions2 = googleSignInOptions;
        } else {
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            if (hashSet.contains(GoogleSignInOptions.t)) {
                Scope scope = GoogleSignInOptions.s;
                if (hashSet.contains(scope)) {
                    hashSet.remove(scope);
                }
            }
            googleSignInOptions2 = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, hashMap, null);
        }
        if (!x72.c.isEmpty()) {
            new HashSet();
            new HashMap();
            HashSet hashSet2 = new HashSet(googleSignInOptions2.g);
            boolean z = googleSignInOptions2.j;
            boolean z2 = googleSignInOptions2.k;
            boolean z3 = googleSignInOptions2.i;
            String str = googleSignInOptions2.l;
            Account account = googleSignInOptions2.h;
            String str2 = googleSignInOptions2.m;
            Map<Integer, GoogleSignInOptionsExtensionParcelable> n1 = GoogleSignInOptions.n1(googleSignInOptions2.n);
            String str3 = googleSignInOptions2.o;
            for (Scope scope2 : x72.c) {
                hashSet2.add(scope2);
                hashSet2.addAll(Arrays.asList(new Scope[0]));
            }
            if (hashSet2.contains(GoogleSignInOptions.t)) {
                Scope scope3 = GoogleSignInOptions.s;
                if (hashSet2.contains(scope3)) {
                    hashSet2.remove(scope3);
                }
            }
            if (z3 && (account == null || !hashSet2.isEmpty())) {
                hashSet2.add(GoogleSignInOptions.r);
            }
            googleSignInOptions2 = new GoogleSignInOptions(3, new ArrayList(hashSet2), account, z3, z, z2, str, str2, n1, str3);
        }
        this.f2301a = googleSignInOptions2;
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof v02) {
            return (v02) queryLocalInterface;
        }
        return new w02(iBinder);
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final Intent getSignInIntent() {
        Context context = getContext();
        GoogleSignInOptions googleSignInOptions = this.f2301a;
        n02.f2502a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final boolean providesSignIn() {
        return true;
    }
}
