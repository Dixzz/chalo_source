package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.p000firebaseauthapi.zzwk;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzba {
    public static MultiFactorInfo zza(zzwk zzwk) {
        if (zzwk != null && !TextUtils.isEmpty(zzwk.f)) {
            return new PhoneMultiFactorInfo(zzwk.g, zzwk.h, zzwk.i, zzwk.f);
        }
        return null;
    }

    public static List<MultiFactorInfo> zzb(List<zzwk> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (zzwk zzwk : list) {
            MultiFactorInfo zza = zza(zzwk);
            if (zza != null) {
                arrayList.add(zza);
            }
        }
        return arrayList;
    }
}
