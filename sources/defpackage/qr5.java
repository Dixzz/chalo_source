package defpackage;

/* renamed from: qr5  reason: default package */
/* compiled from: InAppMessageManager */
public class qr5 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ jr5 g;

    public qr5(jr5 jr5, String str) {
        this.g = jr5;
        this.f = str;
    }

    public void run() {
        bs5 bs5 = this.g.i;
        bs5.b.c(this.f, true);
    }
}
