package defpackage;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.internal.p000firebaseauthapi.zznq;
import com.google.android.gms.internal.p000firebaseauthapi.zzvl;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.android.gms.internal.p000firebaseauthapi.zzwr;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: d63 */
public abstract class d63<ResultT, CallbackT> implements c13<u43, ResultT> {

    /* renamed from: a */
    public final int f798a;
    public final a63 b = new a63(this);
    public FirebaseApp c;
    public FirebaseUser d;
    public CallbackT e;
    public zzao f;
    public final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> g = new ArrayList();
    public Executor h;
    public zzwg i;
    public zzvz j;
    public zzvl k;
    public zzwr l;
    public AuthCredential m;
    public String n;
    public String o;
    public zznq p;
    public boolean q;
    public ResultT r;
    public c63 s;

    public d63(int i2) {
        this.f798a = i2;
    }

    public static /* synthetic */ void i(d63 d63) {
        d63.a();
        gj1.o(d63.q, "no success or failure set on method implementation");
    }

    public abstract void a();

    public final d63<ResultT, CallbackT> b(FirebaseApp firebaseApp) {
        gj1.l(firebaseApp, "firebaseApp cannot be null");
        this.c = firebaseApp;
        return this;
    }

    public final d63<ResultT, CallbackT> c(FirebaseUser firebaseUser) {
        gj1.l(firebaseUser, "firebaseUser cannot be null");
        this.d = firebaseUser;
        return this;
    }

    public final d63<ResultT, CallbackT> d(CallbackT callbackt) {
        gj1.l(callbackt, "external callback cannot be null");
        this.e = callbackt;
        return this;
    }

    public final d63<ResultT, CallbackT> e(zzao zzao) {
        gj1.l(zzao, "external failure callback cannot be null");
        this.f = zzao;
        return this;
    }

    public final d63<ResultT, CallbackT> f(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        k63.d(str, this);
        i63 i63 = new i63(onVerificationStateChangedCallbacks, str);
        synchronized (this.g) {
            this.g.add(i63);
        }
        if (activity != null) {
            List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list = this.g;
            s32 c2 = LifecycleCallback.c(new r32(activity));
            if (((u53) c2.b("PhoneAuthActivityStopCallback", u53.class)) == null) {
                new u53(c2, list);
            }
        }
        Objects.requireNonNull(executor, "null reference");
        this.h = executor;
        return this;
    }

    public final void g(ResultT resultt) {
        this.q = true;
        this.r = resultt;
        this.s.a(resultt, null);
    }

    public final void h(Status status) {
        this.q = true;
        this.s.a(null, status);
    }
}
