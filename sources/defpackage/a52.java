package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;

/* renamed from: a52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class a52 implements g32<Status> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c42 f119a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ a32 c;
    public final /* synthetic */ d52 d;

    public a52(d52 d52, c42 c42, boolean z, a32 a32) {
        this.d = d52;
        this.f119a = c42;
        this.b = z;
        this.c = a32;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [f32] */
    @Override // defpackage.g32
    public final void a(Status status) {
        Status status2 = status;
        i02 a2 = i02.a(this.d.f);
        String f = a2.f("defaultGoogleSignInAccount");
        a2.g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(f)) {
            a2.g(i02.h("googleSignInAccount", f));
            a2.g(i02.h("googleSignInOptions", f));
        }
        if (status2.m1() && this.d.n()) {
            d52 d52 = this.d;
            d52.g();
            d52.f();
        }
        this.f119a.setResult(status2);
        if (this.b) {
            this.c.g();
        }
    }
}
