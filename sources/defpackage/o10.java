package defpackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import defpackage.q20;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: o10  reason: default package */
/* compiled from: FirebaseOTPVerifier */
public class o10 implements q20 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2630a = false;
    public boolean b = false;
    public String c;

    /* renamed from: o10$a */
    /* compiled from: FirebaseOTPVerifier */
    public class a extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q20.a f2631a;

        public a(q20.a aVar) {
            this.f2631a = aVar;
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onCodeAutoRetrievalTimeOut(String str) {
            super.onCodeAutoRetrievalTimeOut(str);
            this.f2631a.d();
            o10.this.f2630a = false;
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(str, forceResendingToken);
            o10.this.c = str;
            this.f2631a.a();
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            o10 o10 = o10.this;
            q20.a aVar = this.f2631a;
            Objects.requireNonNull(o10);
            FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).b(new p10(o10, aVar));
            o10.this.f2630a = false;
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onVerificationFailed(FirebaseException firebaseException) {
            this.f2631a.b();
            o10.this.f2630a = false;
        }
    }

    /* renamed from: o10$b */
    /* compiled from: FirebaseOTPVerifier */
    public class b implements ti4<AuthResult> {
        public final /* synthetic */ q20.a f;

        public b(q20.a aVar) {
            this.f = aVar;
        }

        @Override // defpackage.ti4
        public void onComplete(yi4<AuthResult> yi4) {
            if (yi4.q()) {
                this.f.c(yi4.m().getUser());
            } else {
                this.f.b();
            }
            o10.this.b = false;
        }
    }

    public o10(Context context) {
    }

    @Override // defpackage.q20
    public boolean a() {
        return this.f2630a || this.b;
    }

    @Override // defpackage.q20
    public void b(String str, q20.a aVar, Activity activity) {
        if (TextUtils.isDigitsOnly(str) && str.length() == 10) {
            PhoneAuthProvider.verifyPhoneNumber(PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance()).setPhoneNumber("+91".concat(str)).setTimeout(5L, TimeUnit.SECONDS).setActivity(activity).setCallbacks(new a(aVar)).build());
            this.f2630a = true;
        }
    }

    @Override // defpackage.q20
    public void c(String str, q20.a aVar, Activity activity) {
        this.b = true;
        FirebaseAuth.getInstance().signInWithCredential(PhoneAuthProvider.getCredential(this.c, str)).b(new b(aVar));
    }
}
