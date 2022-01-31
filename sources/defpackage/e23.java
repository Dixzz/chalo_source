package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzmw;
import com.google.firebase.auth.EmailAuthCredential;

/* renamed from: e23  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final /* synthetic */ class e23 implements z32 {

    /* renamed from: a  reason: collision with root package name */
    public final f23 f916a;

    public e23(f23 f23) {
        this.f916a = f23;
    }

    @Override // defpackage.z32
    public final void accept(Object obj, Object obj2) {
        f23 f23 = this.f916a;
        f23.s = new c63(f23, (zi4) obj2);
        EmailAuthCredential emailAuthCredential = f23.t;
        emailAuthCredential.zzg(f23.d);
        ((u43) obj).d().S1(new zzmw(emailAuthCredential), f23.b);
    }
}
