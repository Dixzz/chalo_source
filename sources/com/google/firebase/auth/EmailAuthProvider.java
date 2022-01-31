package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class EmailAuthProvider {
    public static final String EMAIL_LINK_SIGN_IN_METHOD = "emailLink";
    public static final String EMAIL_PASSWORD_SIGN_IN_METHOD = "password";
    public static final String PROVIDER_ID = "password";

    private EmailAuthProvider() {
    }

    public static AuthCredential getCredential(String str, String str2) {
        gj1.j(str);
        gj1.j(str2);
        return new EmailAuthCredential(str, str2, null, null, false);
    }

    public static AuthCredential getCredentialWithLink(String str, String str2) {
        if (EmailAuthCredential.zzi(str2)) {
            return new EmailAuthCredential(str, null, str2, null, false);
        }
        throw new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
    }
}
