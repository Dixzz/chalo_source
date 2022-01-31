package defpackage;

/* renamed from: nx5  reason: default package */
/* compiled from: Subscription */
public class nx5 {

    /* renamed from: a  reason: collision with root package name */
    public Runnable f2618a;
    public boolean b = false;

    public nx5() {
    }

    public synchronized void a() {
        Runnable runnable = this.f2618a;
        if (runnable != null) {
            runnable.run();
            this.f2618a = null;
        }
        this.b = true;
    }

    public synchronized boolean b() {
        return this.b;
    }

    public nx5(Runnable runnable) {
        this.f2618a = runnable;
    }
}
