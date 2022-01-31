package defpackage;

/* renamed from: ij4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class ij4 implements Runnable {
    public final /* synthetic */ jj4 f;

    public ij4(jj4 jj4) {
        this.f = jj4;
    }

    public final void run() {
        synchronized (this.f.b) {
            si4 si4 = this.f.c;
            if (si4 != null) {
                si4.onCanceled();
            }
        }
    }
}
