package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import defpackage.ii;
import java.util.Set;

@KeepName
public class SignInHubActivity extends ve {
    public static boolean k = false;
    public boolean f = false;
    public SignInConfiguration g;
    public boolean h;
    public int i;
    public Intent j;

    public class a implements ii.a<Void> {
        public a(z02 z02) {
        }

        @Override // defpackage.ii.a
        public final li<Void> onCreateLoader(int i, Bundle bundle) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            Set<a32> set = a32.f103a;
            synchronized (set) {
            }
            return new k02(signInHubActivity, set);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [li, java.lang.Object] */
        @Override // defpackage.ii.a
        public final /* synthetic */ void onLoadFinished(li<Void> liVar, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.i, signInHubActivity.j);
            SignInHubActivity.this.finish();
        }

        @Override // defpackage.ii.a
        public final void onLoaderReset(li<Void> liVar) {
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final void e(int i2) {
        Status status = new Status(i2, null);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        k = false;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i2, int i3, Intent intent) {
        GoogleSignInAccount googleSignInAccount;
        if (!this.f) {
            setResult(0);
            if (i2 == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && (googleSignInAccount = signInAccount.g) != null) {
                        r02 b = r02.b(this);
                        GoogleSignInOptions googleSignInOptions = this.g.g;
                        synchronized (b) {
                            b.f3019a.d(googleSignInAccount, googleSignInOptions);
                        }
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.h = true;
                        this.i = i3;
                        this.j = intent;
                        getSupportLoaderManager().c(0, null, new a(null));
                        k = false;
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        int intExtra = intent.getIntExtra("errorCode", 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        e(intExtra);
                        return;
                    }
                }
                e(8);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve, defpackage.y4
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            e(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            SignInConfiguration signInConfiguration = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
            this.g = signInConfiguration;
            if (signInConfiguration == null) {
                setResult(0);
                finish();
                return;
            }
            if (!(bundle == null)) {
                boolean z = bundle.getBoolean("signingInGoogleApiClients");
                this.h = z;
                if (z) {
                    this.i = bundle.getInt("signInResultCode");
                    this.j = (Intent) bundle.getParcelable("signInResultData");
                    getSupportLoaderManager().c(0, null, new a(null));
                    k = false;
                }
            } else if (k) {
                setResult(0);
                e(12502);
            } else {
                k = true;
                Intent intent2 = new Intent(action);
                if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra("config", this.g);
                try {
                    startActivityForResult(intent2, 40962);
                } catch (ActivityNotFoundException unused) {
                    this.f = true;
                    e(17);
                }
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown action: ".concat(valueOf);
            } else {
                new String("Unknown action: ");
            }
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.h);
        if (this.h) {
            bundle.putInt("signInResultCode", this.i);
            bundle.putParcelable("signInResultData", this.j);
        }
    }
}
