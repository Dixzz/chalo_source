package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzr implements qi4<Void, yi4<Void>> {
    public zzr(FirebaseAuth firebaseAuth) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [yi4] */
    @Override // defpackage.qi4
    public final /* bridge */ /* synthetic */ yi4<Void> then(yi4<Void> yi4) throws Exception {
        return (yi4.q() || !(yi4.l() instanceof FirebaseAuthException) || !((FirebaseAuthException) yi4.l()).getErrorCode().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) ? yi4 : hd3.W0(null);
    }
}
