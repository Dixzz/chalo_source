package defpackage;

import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.List;

/* renamed from: u53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class u53 extends LifecycleCallback {
    public final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> g;

    public u53(s32 s32, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
        super(s32);
        s32.a("PhoneAuthActivityStopCallback", this);
        this.g = list;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i() {
        synchronized (this.g) {
            this.g.clear();
        }
    }
}
