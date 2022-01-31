package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.crashlytics.android.answers.SessionEvent;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000firebaseauthapi.zzxg;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.q5;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

@KeepName
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class GenericIdpActivity extends ve implements a53 {
    private static long zzc;
    private static final zzbm zze = zzbm.zza();
    private final Executor zzb = iu2.b.a(1);
    private boolean zzd = false;

    private final void zzh() {
        zzc = 0;
        this.zzd = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!ni.a(this).c(intent)) {
            zze.zzg(this, zzai.zza("WEB_CONTEXT_CANCELED"));
        } else {
            zze.zzh(this);
        }
        finish();
    }

    private final void zzi(Status status) {
        zzc = 0;
        this.zzd = false;
        Intent intent = new Intent();
        zzbl.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!ni.a(this).c(intent)) {
            zze.zzg(getApplicationContext(), status);
        } else {
            zze.zzh(this);
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve, defpackage.y4
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - zzc >= 30000) {
                zzc = currentTimeMillis;
                if (bundle != null) {
                    this.zzd = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
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
        zzh();
    }

    @Override // defpackage.ve
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // defpackage.ve
    public final void onResume() {
        r63 r63;
        super.onResume();
        String str = null;
        if ("android.intent.action.VIEW".equals(getIntent().getAction())) {
            Intent intent = getIntent();
            if (intent.hasExtra("firebaseError")) {
                zzi(zzbl.zzd(intent.getStringExtra("firebaseError")));
            } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                zzh();
            } else {
                String stringExtra = intent.getStringExtra("link");
                String stringExtra2 = intent.getStringExtra("eventId");
                String packageName = getPackageName();
                boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
                zzi zzd2 = zzj.zza().zzd(this, packageName, stringExtra2);
                if (zzd2 == null) {
                    zzh();
                }
                if (booleanExtra) {
                    stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zzd2.zze()).getPersistenceKey()).zzc(stringExtra);
                }
                zzxg zzxg = new zzxg(zzd2, stringExtra);
                String zzd3 = zzd2.zzd();
                String zzb2 = zzd2.zzb();
                zzxg.s = zzd3;
                if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(zzb2)) {
                    zzc = 0;
                    this.zzd = false;
                    Intent intent2 = new Intent();
                    gj1.l0(zzxg, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                    intent2.putExtra("com.google.firebase.auth.internal.OPERATION", zzb2);
                    intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                    if (!ni.a(this).c(intent2)) {
                        SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                        Parcel obtain = Parcel.obtain();
                        zzxg.writeToParcel(obtain, 0);
                        byte[] marshall = obtain.marshall();
                        obtain.recycle();
                        if (marshall != null) {
                            str = Base64.encodeToString(marshall, 10);
                        }
                        edit.putString("verifyAssertionRequest", str);
                        edit.putString("operation", zzb2);
                        edit.putString("tenantId", zzd3);
                        edit.putLong("timestamp", System.currentTimeMillis());
                        edit.commit();
                    } else {
                        zze.zzh(this);
                    }
                    finish();
                    return;
                }
                if (zzb2.length() != 0) {
                    "unsupported operation: ".concat(zzb2);
                } else {
                    new String("unsupported operation: ");
                }
                zzh();
            }
        } else if (!this.zzd) {
            String packageName2 = getPackageName();
            try {
                String lowerCase = eb2.a(ab2.a(this, packageName2), false).toLowerCase(Locale.US);
                FirebaseApp instance = FirebaseApp.getInstance(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                if (!t63.a(instance)) {
                    new z43(packageName2, lowerCase, getIntent(), this).executeOnExecutor(this.zzb, new Void[0]);
                } else {
                    String apiKey = instance.getOptions().getApiKey();
                    Map<String, r63> map = t63.f3313a;
                    synchronized (map) {
                        r63 = (r63) ((u2) map).get(apiKey);
                    }
                    if (r63 != null) {
                        String str2 = r63.f3048a;
                        zza(zzg(Uri.parse(String.valueOf(t63.c(str2, r63.b, str2.contains(ProductDiscountsObject.KEY_DELIMITER))).concat("emulator/auth/handler")).buildUpon(), getIntent(), packageName2, lowerCase).build(), packageName2);
                    } else {
                        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                String.valueOf(packageName2).length();
                valueOf.length();
                zze(packageName2, null);
            }
            this.zzd = true;
        } else {
            zzh();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzd);
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
            return null;
        }
    }

    @Override // defpackage.a53
    public final String zzc(String str) {
        return t63.b(str);
    }

    @Override // defpackage.a53
    public final Uri.Builder zzd(Intent intent, String str, String str2) {
        return zzg(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    @Override // defpackage.a53
    public final void zze(String str, Status status) {
        if (status == null) {
            zzh();
        } else {
            zzi(status);
        }
    }

    @Override // defpackage.a53
    public final Context zzf() {
        return getApplicationContext();
    }

    public final Uri.Builder zzg(Uri.Builder builder, Intent intent, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        Bundle bundleExtra = intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        if (bundleExtra == null) {
            str3 = null;
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str6 : bundleExtra.keySet()) {
                    String string = bundleExtra.getString(str6);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(str6, string);
                    }
                }
            } catch (JSONException unused) {
            }
            str3 = jSONObject.toString();
        }
        String uuid = UUID.randomUUID().toString();
        try {
            String str7 = new String(MessageDigest.getInstance("SHA-256").digest(UUID.randomUUID().toString().getBytes()));
            int length = str7.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                char charAt = str7.charAt(i);
                if (charAt >= 'A' && charAt <= 'Z') {
                    char[] charArray = str7.toCharArray();
                    while (i < length) {
                        char c = charArray[i];
                        if (c >= 'A' && c <= 'Z') {
                            charArray[i] = (char) (c ^ ' ');
                        }
                        i++;
                    }
                    str7 = String.valueOf(charArray);
                } else {
                    i++;
                }
            }
            str4 = str7;
        } catch (NoSuchAlgorithmException unused2) {
            a53.b.b("Failed to get SHA-256 MessageDigest", new Object[0]);
            str4 = null;
        }
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        zzj.zza().zzb(getApplicationContext(), str, uuid, str4, action, stringExtra2, stringExtra3, stringExtra4);
        String zzb2 = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra4).getPersistenceKey()).zzb();
        if (TextUtils.isEmpty(zzb2)) {
            zzi(zzai.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        } else if (str4 == null) {
            return null;
        } else {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("eid", "p");
            String valueOf = String.valueOf(stringExtra5);
            if (valueOf.length() != 0) {
                str5 = "X".concat(valueOf);
            } else {
                str5 = new String("X");
            }
            appendQueryParameter.appendQueryParameter("v", str5).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter(SessionEvent.SESSION_ID_KEY, str4).appendQueryParameter("eventId", uuid).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzb2);
            if (!TextUtils.isEmpty(join)) {
                builder.appendQueryParameter("scopes", join);
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.appendQueryParameter("customParameters", str3);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                builder.appendQueryParameter("tid", stringExtra3);
            }
            return builder;
        }
    }
}
