package defpackage;

/* renamed from: rv4  reason: default package */
public final class rv4 extends ov4 {
    public final /* synthetic */ xv4 g;

    public rv4(xv4 xv4) {
        this.g = xv4;
    }

    @Override // defpackage.ov4
    public final void a() {
        xv4 xv4 = this.g;
        if (xv4.k != null) {
            xv4.b.b(4, "Unbind from service.", new Object[0]);
            xv4 xv42 = this.g;
            xv42.f3969a.unbindService(xv42.j);
            xv4 xv43 = this.g;
            xv43.e = false;
            xv43.k = null;
            xv43.j = null;
        }
    }
}
