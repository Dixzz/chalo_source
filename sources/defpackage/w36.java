package defpackage;

/* renamed from: w36  reason: default package */
/* compiled from: Socket */
public class w36 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ Runnable g;
    public final /* synthetic */ u36 h;

    public w36(u36 u36, String str, Runnable runnable) {
        this.h = u36;
        this.f = str;
        this.g = runnable;
    }

    public void run() {
        u36 u36 = this.h;
        String str = this.f;
        u36.l(new s46("message", str), this.g);
    }
}
