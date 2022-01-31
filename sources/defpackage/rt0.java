package defpackage;

/* renamed from: rt0  reason: default package */
/* compiled from: BusRouteFragment */
public class rt0 implements Runnable {
    public final /* synthetic */ int f;
    public final /* synthetic */ mt0 g;

    public rt0(mt0 mt0, int i) {
        this.g = mt0;
        this.f = i;
    }

    public void run() {
        mt0 mt0 = this.g;
        int i = this.f;
        mt0.p.requestFocusFromTouch();
        mt0.p.setSelection(i);
        mt0.p.requestFocus();
        this.g.h.e(this.f);
    }
}
