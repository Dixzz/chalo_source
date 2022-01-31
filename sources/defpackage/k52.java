package defpackage;

import android.os.Handler;
import defpackage.k32;

/* renamed from: k52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class k52 implements k32.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o32 f2025a;

    public k52(o32 o32) {
        this.f2025a = o32;
    }

    @Override // defpackage.k32.a
    public final void onBackgroundStateChanged(boolean z) {
        Handler handler = this.f2025a.n;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
