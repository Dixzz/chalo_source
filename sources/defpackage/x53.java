package defpackage;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: x53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class x53 implements b63 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3888a;

    public x53(String str) {
        this.f3888a = str;
    }

    @Override // defpackage.b63
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeAutoRetrievalTimeOut(this.f3888a);
    }
}
