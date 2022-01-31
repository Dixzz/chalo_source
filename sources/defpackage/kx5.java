package defpackage;

/* renamed from: kx5  reason: default package */
/* compiled from: SerialSubscription */
public class kx5 extends nx5 {
    public nx5 c;

    @Override // defpackage.nx5
    public synchronized void a() {
        nx5 nx5 = this.c;
        if (!b()) {
            super.a();
            this.c = null;
        }
        if (nx5 != null) {
            nx5.a();
        }
    }

    public synchronized void c(nx5 nx5) {
        if (!b()) {
            this.c = nx5;
        } else {
            nx5.a();
        }
    }
}
