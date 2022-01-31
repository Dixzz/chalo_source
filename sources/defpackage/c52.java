package defpackage;

import java.lang.ref.WeakReference;

/* renamed from: c52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class c52 extends u52 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<d52> f523a;

    public c52(d52 d52) {
        this.f523a = new WeakReference<>(d52);
    }

    @Override // defpackage.u52
    public final void a() {
        d52 d52 = this.f523a.get();
        if (d52 != null) {
            d52.x(d52);
        }
    }
}
