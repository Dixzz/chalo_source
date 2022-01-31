package defpackage;

/* renamed from: z12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class z12 implements Runnable {
    public final t12 f;
    public final e22 g;

    public z12(t12 t12, e22 e22) {
        this.f = t12;
        this.g = e22;
    }

    public final void run() {
        t12 t12 = this.f;
        int i = this.g.f915a;
        synchronized (t12) {
            e22<?> e22 = t12.e.get(i);
            if (e22 != null) {
                t12.e.remove(i);
                e22.b(new d22(3, "Timed out waiting for response"));
                t12.c();
            }
        }
    }
}
