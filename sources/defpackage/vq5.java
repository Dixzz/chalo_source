package defpackage;

/* renamed from: vq5  reason: default package */
/* compiled from: AdapterWrapper */
public class vq5 implements Runnable {
    public final /* synthetic */ wq5 f;

    public vq5(wq5 wq5) {
        this.f = wq5;
    }

    public void run() {
        try {
            wq5 wq5 = this.f;
            wq5.d.b(wq5.b);
        } catch (Exception e) {
            yj5.e(e, "AdapterWrapper - Exception during onDisplayFinished().", new Object[0]);
        }
    }
}
