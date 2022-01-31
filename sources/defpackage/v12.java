package defpackage;

/* renamed from: v12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class v12 implements Runnable {
    public final t12 f;

    public v12(t12 t12) {
        this.f = t12;
    }

    public final void run() {
        t12 t12 = this.f;
        synchronized (t12) {
            if (t12.f3294a == 1) {
                t12.a(1, "Timed out while binding");
            }
        }
    }
}
