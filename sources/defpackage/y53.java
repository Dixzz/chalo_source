package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: y53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class y53 implements b63 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Status f4004a;

    public y53(Status status) {
        this.f4004a = status;
    }

    @Override // defpackage.b63
    public final void a(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(w43.a(this.f4004a));
    }
}
