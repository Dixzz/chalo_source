package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbg {
    private final Context zza;
    private final String zzb;
    private final SharedPreferences zzc;
    private final wa2 zzd = new wa2("StorageHelpers", new String[0]);

    public zzbg(Context context, String str) {
        Objects.requireNonNull(context, "null reference");
        gj1.j(str);
        this.zzb = str;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzc = applicationContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", str), 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0085, code lost:
        throw new defpackage.xx2(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0134, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0135, code lost:
        android.util.Log.wtf(r26.zzd.f3751a, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013f, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012e A[ExcHandler: ArrayIndexOutOfBoundsException | IllegalArgumentException | xx2 (e java.lang.Throwable), Splitter:B:1:0x000a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.auth.internal.zzx zzf(org.json.JSONObject r27) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbg.zzf(org.json.JSONObject):com.google.firebase.auth.internal.zzx");
    }

    public final void zza(FirebaseUser firebaseUser) {
        String str;
        Objects.requireNonNull(firebaseUser, "null reference");
        JSONObject jSONObject = new JSONObject();
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            zzx zzx = (zzx) firebaseUser;
            try {
                jSONObject.put("cachedTokenState", zzx.zzg());
                jSONObject.put("applicationName", zzx.zzd().getName());
                jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzx.zzl() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List<zzt> zzl = zzx.zzl();
                    for (int i = 0; i < zzl.size(); i++) {
                        jSONArray.put(zzl.get(i).zzb());
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put("anonymous", zzx.isAnonymous());
                jSONObject.put("version", "2");
                if (zzx.getMetadata() != null) {
                    jSONObject.put("userMetadata", ((zzz) zzx.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = new zzac(zzx).getEnrolledFactors();
                if (!enrolledFactors.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < enrolledFactors.size(); i2++) {
                        jSONArray2.put(enrolledFactors.get(i2).toJson());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                str = jSONObject.toString();
            } catch (Exception e) {
                wa2 wa2 = this.zzd;
                Log.wtf(wa2.f3751a, wa2.b("Failed to turn object into JSON", new Object[0]), e);
                throw new xx2(e);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", str).apply();
        }
    }

    public final FirebaseUser zzb() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                    return zzf(jSONObject);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void zzc(FirebaseUser firebaseUser, zzwg zzwg) {
        Objects.requireNonNull(firebaseUser, "null reference");
        Objects.requireNonNull(zzwg, "null reference");
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), zzwg.l1()).apply();
    }

    public final zzwg zzd(FirebaseUser firebaseUser) {
        Objects.requireNonNull(firebaseUser, "null reference");
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), null);
        if (string != null) {
            return zzwg.m1(string);
        }
        return null;
    }

    public final void zze(String str) {
        this.zzc.edit().remove(str).apply();
    }
}
