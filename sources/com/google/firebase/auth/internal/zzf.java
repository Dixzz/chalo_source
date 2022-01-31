package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.rabbitmq.client.StringRpcServer;
import defpackage.x22;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzf {
    private static final String zza = "zzf";
    private static final zzf zzb = new zzf();

    private zzf() {
    }

    public static zzf zza() {
        return zzb;
    }

    /* access modifiers changed from: private */
    public final void zze(FirebaseAuth firebaseAuth, zzbm zzbm, Activity activity, zi4<zze> zi4) {
        wj4<TResult> wj4;
        zzbm.zzb(firebaseAuth.zze().getApplicationContext(), firebaseAuth);
        Objects.requireNonNull(activity, "null reference");
        zi4<String> zi42 = new zi4<>();
        if (!zzax.zza().zzb(activity, zi42)) {
            wj4 = (wj4<TResult>) hd3.V0(w43.a(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass(activity, RecaptchaActivity.class);
            intent.setPackage(activity.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.zze().getOptions().getApiKey());
            if (!TextUtils.isEmpty(firebaseAuth.getTenantId())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", r53.b().a());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.zze().getName());
            activity.startActivity(intent);
            wj4 = zi42.f4178a;
        }
        zzd zzd = new zzd(this, zi4);
        wj4<TResult> wj42 = wj4;
        Objects.requireNonNull(wj42);
        Executor executor = aj4.f170a;
        wj42.g(executor, zzd);
        wj42.e(executor, new zzc(this, zi4));
    }

    public final yi4<zze> zzb(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z) {
        qh4 qh4;
        zzw zzw = (zzw) firebaseAuth.getFirebaseAuthSettings();
        if (z) {
            Context applicationContext = firebaseAuth.zze().getApplicationContext();
            x22.g<z24> gVar = nh4.f2553a;
            qh4 = new qh4(applicationContext);
        } else {
            qh4 = null;
        }
        zzbm zza2 = zzbm.zza();
        if (t63.a(firebaseAuth.zze()) || zzw.zzd()) {
            return hd3.W0(new zze(null, null));
        }
        zi4<zze> zi4 = new zi4<>();
        yi4<String> zze = zza2.zze();
        if (zze != null) {
            if (zze.q()) {
                return hd3.W0(new zze(null, zze.m()));
            }
            String valueOf = String.valueOf(zze.l().getMessage());
            if (valueOf.length() != 0) {
                "Error in previous reCAPTCHA flow: ".concat(valueOf);
            } else {
                new String("Error in previous reCAPTCHA flow: ");
            }
        }
        if (qh4 == null || zzw.zze()) {
            zze(firebaseAuth, zza2, activity, zi4);
        } else {
            FirebaseApp zze2 = firebaseAuth.zze();
            byte[] bArr = new byte[0];
            if (str != null) {
                try {
                    bArr = str.getBytes(StringRpcServer.STRING_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    String valueOf2 = String.valueOf(e.getMessage());
                    if (valueOf2.length() != 0) {
                        "Failed to getBytes with exception: ".concat(valueOf2);
                    } else {
                        new String("Failed to getBytes with exception: ");
                    }
                }
            }
            String apiKey = zze2.getOptions().getApiKey();
            a32 asGoogleApiClient = qh4.asGoogleApiClient();
            l32 i = asGoogleApiClient.i(new x24(asGoogleApiClient, bArr, apiKey));
            q92 q92 = new q92(new oh4());
            o92 o92 = h82.f1346a;
            zi4 zi42 = new zi4();
            i.c(new p92(i, zi42, q92, o92));
            wj4<TResult> wj4 = zi42.f4178a;
            zzb zzb2 = new zzb(this, zi4, firebaseAuth, zza2, activity);
            Objects.requireNonNull(wj4);
            Executor executor = aj4.f170a;
            wj4.g(executor, zzb2);
            wj4.e(executor, new zza(this, firebaseAuth, zza2, activity, zi4));
        }
        return zi4.f4178a;
    }
}
