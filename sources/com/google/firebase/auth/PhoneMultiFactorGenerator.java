package com.google.firebase.auth;

import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class PhoneMultiFactorGenerator {
    public static final String FACTOR_ID = "phone";

    public static PhoneMultiFactorAssertion getAssertion(PhoneAuthCredential phoneAuthCredential) {
        Objects.requireNonNull(phoneAuthCredential, "null reference");
        return new PhoneMultiFactorAssertion(phoneAuthCredential);
    }
}
