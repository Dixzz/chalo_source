package defpackage;

import defpackage.i46;

/* renamed from: h46  reason: default package */
/* compiled from: Transport */
public class h46 implements Runnable {
    public final /* synthetic */ i46 f;

    public h46(i46 i46) {
        this.f = i46;
    }

    public void run() {
        i46 i46 = this.f;
        i46.d dVar = i46.k;
        if (dVar == i46.d.CLOSED || dVar == null) {
            i46.k = i46.d.OPENING;
            i46.g();
        }
    }
}
