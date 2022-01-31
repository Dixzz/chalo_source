package defpackage;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: v53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class v53 implements b63 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3603a;

    public v53(String str) {
        this.f3603a = str;
    }

    @Override // defpackage.b63
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.f3603a, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
