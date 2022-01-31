package defpackage;

/* renamed from: ws4  reason: default package */
public final /* synthetic */ class ws4 implements ct4 {

    /* renamed from: a  reason: collision with root package name */
    public final dt4 f3833a;
    public final int b;
    public final /* synthetic */ int c = 0;

    public ws4(dt4 dt4, int i) {
        this.f3833a = dt4;
        this.b = i;
    }

    public ws4(dt4 dt4, int i, byte[] bArr) {
        this.f3833a = dt4;
        this.b = i;
    }

    @Override // defpackage.ct4
    public final Object a() {
        if (this.c != 0) {
            this.f3833a.c(this.b).c.c = 5;
            return null;
        }
        dt4 dt4 = this.f3833a;
        int i = this.b;
        at4 c2 = dt4.c(i);
        if (mt4.e(c2.c.c)) {
            bs4 bs4 = dt4.f888a;
            zs4 zs4 = c2.c;
            String str = zs4.f4206a;
            int i2 = c2.b;
            long j = zs4.b;
            if (bs4.e(str, i2, j).exists()) {
                bs4.h(bs4.e(str, i2, j));
            }
            zs4 zs42 = c2.c;
            int i3 = zs42.c;
            if (i3 == 5 || i3 == 6) {
                bs4 bs42 = dt4.f888a;
                String str2 = zs42.f4206a;
                int i4 = c2.b;
                long j2 = zs42.b;
                if (bs42.j(str2, i4, j2).exists()) {
                    bs4.h(bs42.j(str2, i4, j2));
                }
            }
            return null;
        }
        throw new os4(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i)), i);
    }
}
