package defpackage;

import android.app.Dialog;

/* renamed from: v62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class v62 extends u52 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dialog f3609a;
    public final /* synthetic */ w62 b;

    public v62(w62 w62, Dialog dialog) {
        this.b = w62;
        this.f3609a = dialog;
    }

    @Override // defpackage.u52
    public final void a() {
        this.b.g.j();
        if (this.f3609a.isShowing()) {
            this.f3609a.dismiss();
        }
    }
}
