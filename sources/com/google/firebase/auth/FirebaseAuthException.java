package com.google.firebase.auth;

import com.google.firebase.FirebaseException;

/* compiled from: com.google.firebase:firebase-auth-interop@@19.0.0 */
public class FirebaseAuthException extends FirebaseException {
    private final String zza;

    public FirebaseAuthException(String str, String str2) {
        super(str2);
        gj1.j(str);
        this.zza = str;
    }

    public String getErrorCode() {
        return this.zza;
    }
}
