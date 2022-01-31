package com.google.firebase.auth;

import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class PhoneMultiFactorAssertion extends MultiFactorAssertion {
    private final PhoneAuthCredential zza;

    public PhoneMultiFactorAssertion(PhoneAuthCredential phoneAuthCredential) {
        Objects.requireNonNull(phoneAuthCredential, "null reference");
        this.zza = phoneAuthCredential;
    }

    @Override // com.google.firebase.auth.MultiFactorAssertion
    public String getFactorId() {
        return "phone";
    }

    public final PhoneAuthCredential zza() {
        return this.zza;
    }
}
