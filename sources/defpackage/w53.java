package defpackage;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: w53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class w53 implements b63 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneAuthCredential f3734a;

    public w53(PhoneAuthCredential phoneAuthCredential) {
        this.f3734a = phoneAuthCredential;
    }

    @Override // defpackage.b63
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.f3734a);
    }
}
