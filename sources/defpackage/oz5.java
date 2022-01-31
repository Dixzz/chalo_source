package defpackage;

/* renamed from: oz5  reason: default package */
/* compiled from: PendingPostQueue */
public final class oz5 {

    /* renamed from: a  reason: collision with root package name */
    public nz5 f2751a;
    public nz5 b;

    public synchronized void a(nz5 nz5) {
        nz5 nz52 = this.b;
        if (nz52 != null) {
            nz52.c = nz5;
            this.b = nz5;
        } else if (this.f2751a == null) {
            this.b = nz5;
            this.f2751a = nz5;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }

    public synchronized nz5 b() {
        nz5 nz5;
        nz5 = this.f2751a;
        if (nz5 != null) {
            nz5 nz52 = nz5.c;
            this.f2751a = nz52;
            if (nz52 == null) {
                this.b = null;
            }
        }
        return nz5;
    }
}
