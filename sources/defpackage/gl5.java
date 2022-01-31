package defpackage;

/* renamed from: gl5  reason: default package */
/* compiled from: Analytics */
public class gl5 implements Runnable {
    public final /* synthetic */ fl5 f;

    public gl5(fl5 fl5) {
        this.f = fl5;
    }

    public void run() {
        yj5.f("Deleting all analytic events.", new Object[0]);
        ql5 ql5 = this.f.f;
        synchronized (ql5.g) {
            rl5 rl5 = ql5.d;
            rl5.a(rl5.b, null, null);
        }
    }
}
