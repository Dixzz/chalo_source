package defpackage;

/* renamed from: ov4  reason: default package */
public abstract class ov4 implements Runnable {
    public final ay4<?> f;

    public ov4() {
        this.f = null;
    }

    public ov4(ay4<?> ay4) {
        this.f = ay4;
    }

    public abstract void a();

    public final void run() {
        try {
            a();
        } catch (Exception e) {
            ay4<?> ay4 = this.f;
            if (ay4 != null) {
                ay4.a(e);
            }
        }
    }
}
