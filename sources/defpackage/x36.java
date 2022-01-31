package defpackage;

/* renamed from: x36  reason: default package */
/* compiled from: Socket */
public class x36 implements Runnable {
    public final /* synthetic */ byte[] f;
    public final /* synthetic */ Runnable g;
    public final /* synthetic */ u36 h;

    public x36(u36 u36, byte[] bArr, Runnable runnable) {
        this.h = u36;
        this.f = bArr;
        this.g = runnable;
    }

    public void run() {
        u36 u36 = this.h;
        byte[] bArr = this.f;
        u36.l(new s46("message", bArr), this.g);
    }
}
