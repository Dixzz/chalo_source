package com.google.firebase.auth.internal;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbl {
    public static final Map<String, String> zza;

    static {
        HashMap hashMap = new HashMap();
        zza = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        hashMap.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        hashMap.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        hashMap.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        hashMap.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static void zza(Intent intent, Status status) {
        gj1.l0(status, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean zzb(Intent intent) {
        Objects.requireNonNull(intent, "null reference");
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }

    public static Status zzc(Intent intent) {
        SafeParcelable safeParcelable;
        Objects.requireNonNull(intent, "null reference");
        gj1.b(zzb(intent));
        Parcelable.Creator<Status> creator = Status.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("com.google.firebase.auth.internal.STATUS");
        if (byteArrayExtra == null) {
            safeParcelable = null;
        } else {
            safeParcelable = gj1.D(byteArrayExtra, creator);
        }
        return (Status) safeParcelable;
    }

    public static Status zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("code");
            String string2 = jSONObject.getString("message");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map<String, String> map = zza;
                if (map.containsKey(string)) {
                    String str2 = map.get(string);
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(string2).length());
                    sb.append(str2);
                    sb.append(ProductDiscountsObject.KEY_DELIMITER);
                    sb.append(string2);
                    return zzai.zza(sb.toString());
                }
            }
            String valueOf = String.valueOf(str);
            return zzai.zza(valueOf.length() != 0 ? "WEB_INTERNAL_ERROR:".concat(valueOf) : new String("WEB_INTERNAL_ERROR:"));
        } catch (JSONException e) {
            String localizedMessage = e.getLocalizedMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(localizedMessage).length());
            hj1.V0(sb2, "WEB_INTERNAL_ERROR:", str, "[ ", localizedMessage);
            sb2.append(" ]");
            return zzai.zza(sb2.toString());
        }
    }
}
