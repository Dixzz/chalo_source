package defpackage;

/* renamed from: nr5  reason: default package */
/* compiled from: InAppMessageManager */
public class nr5 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ wq5 g;
    public final /* synthetic */ jr5 h;

    public nr5(jr5 jr5, String str, wq5 wq5) {
        this.h = jr5;
        this.f = str;
        this.g = wq5;
    }

    public void run() {
        this.h.i.a(this.f, this.g.b);
    }
}
