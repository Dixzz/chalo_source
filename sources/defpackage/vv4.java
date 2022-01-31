package defpackage;

/* renamed from: vv4  reason: default package */
public final class vv4 extends ov4 {
    public final /* synthetic */ wv4 g;

    public vv4(wv4 wv4) {
        this.g = wv4;
    }

    @Override // defpackage.ov4
    public final void a() {
        xv4 xv4 = this.g.f3843a;
        xv4.b.b(4, "unlinkToDeath", new Object[0]);
        xv4.k.asBinder().unlinkToDeath(xv4.i, 0);
        xv4 xv42 = this.g.f3843a;
        xv42.k = null;
        xv42.e = false;
    }
}
