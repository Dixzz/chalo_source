package defpackage;

import defpackage.x22;

/* renamed from: n52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class n52 implements Runnable {
    public final /* synthetic */ o52 f;

    public n52(o52 o52) {
        this.f = o52;
    }

    public final void run() {
        x22.f fVar = this.f.f2652a.g;
        fVar.disconnect(fVar.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
