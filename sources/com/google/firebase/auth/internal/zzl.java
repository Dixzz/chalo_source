package com.google.firebase.auth.internal;

import com.google.firebase.auth.ActionCodeEmailInfo;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzl extends ActionCodeEmailInfo {
    private final String zza;

    public zzl(String str, String str2) {
        gj1.j(str);
        this.email = str;
        gj1.j(str2);
        this.zza = str2;
    }

    @Override // com.google.firebase.auth.ActionCodeEmailInfo
    public final String getPreviousEmail() {
        return this.zza;
    }
}
