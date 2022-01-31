package defpackage;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: i63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class i63 extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks f1482a;
    public final /* synthetic */ String b;

    public i63(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, String str) {
        this.f1482a = onVerificationStateChangedCallbacks;
        this.b = str;
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeAutoRetrievalTimeOut(String str) {
        ((u2) k63.f2030a).remove(this.b);
        this.f1482a.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.f1482a.onCodeSent(str, forceResendingToken);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        ((u2) k63.f2030a).remove(this.b);
        this.f1482a.onVerificationCompleted(phoneAuthCredential);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationFailed(FirebaseException firebaseException) {
        ((u2) k63.f2030a).remove(this.b);
        this.f1482a.onVerificationFailed(firebaseException);
    }
}
