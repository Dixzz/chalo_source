package defpackage;

import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* renamed from: s42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class s42 extends ci4 {
    public final WeakReference<v42> f;

    public s42(v42 v42) {
        this.f = new WeakReference<>(v42);
    }

    @Override // defpackage.ei4
    public final void x0(zak zak) {
        v42 v42 = this.f.get();
        if (v42 != null) {
            h52 h52 = v42.f3596a;
            h52.j.sendMessage(h52.j.obtainMessage(1, new r42(v42, v42, zak)));
        }
    }
}
