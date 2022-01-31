package defpackage;

/* renamed from: qv4  reason: default package */
public final class qv4 extends ov4 {
    public final /* synthetic */ ov4 g;
    public final /* synthetic */ xv4 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qv4(xv4 xv4, ay4 ay4, ov4 ov4) {
        super(ay4);
        this.h = xv4;
        this.g = ov4;
    }

    @Override // defpackage.ov4
    public final void a() {
        xv4 xv4 = this.h;
        ov4 ov4 = this.g;
        if (xv4.k == null && !xv4.e) {
            xv4.b.b(4, "Initiate binding to the service.", new Object[0]);
            xv4.d.add(ov4);
            wv4 wv4 = new wv4(xv4);
            xv4.j = wv4;
            xv4.e = true;
            if (!xv4.f3969a.bindService(xv4.f, wv4, 1)) {
                xv4.b.b(4, "Failed to bind to the service.", new Object[0]);
                xv4.e = false;
                for (ov4 ov42 : xv4.d) {
                    ay4<?> ay4 = ov42.f;
                    if (ay4 != null) {
                        ay4.a(new yv4());
                    }
                }
                xv4.d.clear();
            }
        } else if (xv4.e) {
            xv4.b.b(4, "Waiting to bind to the service.", new Object[0]);
            xv4.d.add(ov4);
        } else {
            ov4.run();
        }
    }
}
