package defpackage;

import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;
import java.util.Objects;

/* renamed from: jz2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class jz2 implements e63<zzwg> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmailAuthCredential f2000a;
    public final /* synthetic */ t43 b;
    public final /* synthetic */ y03 c;

    public jz2(y03 y03, EmailAuthCredential emailAuthCredential, t43 t43) {
        this.c = y03;
        this.f2000a = emailAuthCredential;
        this.b = t43;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.e63
    public final void c(zzwg zzwg) {
        z63 z63 = new z63(this.f2000a, zzwg.g);
        y03 y03 = this.c;
        t43 t43 = this.b;
        Objects.requireNonNull(y03);
        Objects.requireNonNull(t43, "null reference");
        y03.f3986a.o(z63, new kz2(y03, t43));
    }

    @Override // defpackage.e63
    public final void zza(String str) {
        this.b.d(zzai.zza(str));
    }
}
