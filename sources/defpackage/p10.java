package defpackage;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import defpackage.q20;

/* renamed from: p10  reason: default package */
/* compiled from: FirebaseOTPVerifier */
public class p10 implements ti4<AuthResult> {
    public final /* synthetic */ q20.a f;

    public p10(o10 o10, q20.a aVar) {
        this.f = aVar;
    }

    @Override // defpackage.ti4
    public void onComplete(yi4<AuthResult> yi4) {
        if (yi4.q()) {
            this.f.c(yi4.m().getUser());
            return;
        }
        yi4.l();
        if (yi4.l() instanceof FirebaseAuthInvalidCredentialsException) {
            b00 b00 = b00.f358a;
            b00.a().b(yi4.l());
        }
    }
}
