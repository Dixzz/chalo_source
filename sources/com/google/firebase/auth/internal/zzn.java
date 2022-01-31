package com.google.firebase.auth.internal;

import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzn extends ActionCodeMultiFactorInfo {
    private final MultiFactorInfo zza;

    public zzn(String str, MultiFactorInfo multiFactorInfo) {
        gj1.j(str);
        this.email = str;
        Objects.requireNonNull(multiFactorInfo, "null reference");
        this.zza = multiFactorInfo;
    }

    @Override // com.google.firebase.auth.ActionCodeMultiFactorInfo
    public final MultiFactorInfo getMultiFactorInfo() {
        return this.zza;
    }
}
