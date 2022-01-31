package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.q5;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class RecaptchaActivity extends ve implements a53 {
    private static final String zzb = RecaptchaActivity.class.getSimpleName();
    private static final ExecutorService zzc = iu2.b.a(2);
    private static long zzd = 0;
    private static final zzbm zzf = zzbm.zza();
    private boolean zze = false;

    private final void zzg() {
        zzd = 0;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        ni.a(this).c(intent);
        zzf.zzh(this);
        finish();
    }

    private final void zzh(Status status) {
        zzd = 0;
        this.zze = false;
        Intent intent = new Intent();
        zzbl.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        ni.a(this).c(intent);
        zzf.zzh(this);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve, defpackage.y4
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - zzd >= 30000) {
                zzd = currentTimeMillis;
                if (bundle != null) {
                    this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
                    return;
                }
                return;
            }
            return;
        }
        String valueOf = String.valueOf(action);
        if (valueOf.length() != 0) {
            "Could not do operation - unknown action: ".concat(valueOf);
        } else {
            new String("Could not do operation - unknown action: ");
        }
        zzg();
    }

    @Override // defpackage.ve
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // defpackage.ve
    public final void onResume() {
        super.onResume();
        if ("android.intent.action.VIEW".equals(getIntent().getAction())) {
            Intent intent = getIntent();
            if (intent.hasExtra("firebaseError")) {
                zzh(zzbl.zzd(intent.getStringExtra("firebaseError")));
            } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                zzg();
            } else {
                String stringExtra = intent.getStringExtra("link");
                String zze2 = zzj.zza().zze(getApplicationContext(), getPackageName(), intent.getStringExtra("eventId"));
                if (TextUtils.isEmpty(zze2)) {
                    zzh(zzai.zza("Failed to find registration for this reCAPTCHA event"));
                }
                if (intent.getBooleanExtra("encryptionEnabled", true)) {
                    stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zze2).getPersistenceKey()).zzc(stringExtra);
                }
                String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
                zzd = 0;
                this.zze = false;
                Intent intent2 = new Intent();
                intent2.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!ni.a(this).c(intent2)) {
                    SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                    edit.putString("recaptchaToken", queryParameter);
                    edit.putString("operation", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                    edit.putLong("timestamp", System.currentTimeMillis());
                    edit.commit();
                } else {
                    zzf.zzh(this);
                }
                finish();
            }
        } else if (!this.zze) {
            String packageName = getPackageName();
            try {
                new z43(packageName, eb2.a(ab2.a(this, packageName), false).toLowerCase(Locale.US), getIntent(), this).executeOnExecutor(zzc, new Void[0]);
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                String.valueOf(packageName).length();
                valueOf.length();
                zze(packageName, null);
            }
            this.zze = true;
        } else {
            zzg();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zze);
    }

    @Override // defpackage.a53
    public final void zza(Uri uri, String str) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null) {
            List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                intent.putExtra("com.android.browser.application_id", str);
                intent.addFlags(CommonUtils.BYTES_IN_A_GIGABYTE);
                intent.addFlags(268435456);
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            if (!intent2.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                intent2.putExtras(bundle);
            }
            intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
            intent2.putExtras(new Bundle());
            intent2.addFlags(CommonUtils.BYTES_IN_A_GIGABYTE);
            intent2.addFlags(268435456);
            intent2.setData(uri);
            Object obj = q5.f2896a;
            q5.a.b(this, intent2, null);
            return;
        }
        zze(str, null);
    }

    @Override // defpackage.a53
    public final HttpURLConnection zzb(URL url) {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException unused) {
            a53.b.b("Error generating connection", new Object[0]);
            return null;
        }
    }

    @Override // defpackage.a53
    public final String zzc(String str) {
        return t63.b(str);
    }

    @Override // defpackage.a53
    public final Uri.Builder zzd(Intent intent, String str, String str2) {
        String str3;
        String str4;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp instance = FirebaseApp.getInstance(stringExtra3);
        FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzj.zza().zzc(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String zzb2 = zzk.zza(getApplicationContext(), instance.getPersistenceKey()).zzb();
        if (TextUtils.isEmpty(zzb2)) {
            zzh(zzai.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        if (!TextUtils.isEmpty(instance2.getLanguageCode())) {
            str3 = instance2.getLanguageCode();
        } else {
            str3 = gj1.S0();
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", str3).appendQueryParameter("eventId", uuid);
        String valueOf = String.valueOf(stringExtra2);
        if (valueOf.length() != 0) {
            str4 = "X".concat(valueOf);
        } else {
            str4 = new String("X");
        }
        return appendQueryParameter.appendQueryParameter("v", str4).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzb2);
    }

    @Override // defpackage.a53
    public final void zze(String str, Status status) {
        if (status == null) {
            zzg();
        } else {
            zzh(status);
        }
    }

    @Override // defpackage.a53
    public final Context zzf() {
        return getApplicationContext();
    }
}
