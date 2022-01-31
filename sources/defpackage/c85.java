package defpackage;

/* renamed from: c85  reason: default package */
/* compiled from: BoundingBox */
public final class c85 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f534a;
    public final g35 b;
    public final g35 c;
    public final g35 d;
    public final g35 e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public c85(f45 f45, g35 g35, g35 g352, g35 g353, g35 g354) throws a35 {
        boolean z = false;
        boolean z2 = g35 == null || g352 == null;
        z = (g353 == null || g354 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                g35 = new g35(0.0f, g353.b);
                g352 = new g35(0.0f, g354.b);
            } else if (z) {
                int i2 = f45.f;
                g353 = new g35((float) (i2 - 1), g35.b);
                g354 = new g35((float) (i2 - 1), g352.b);
            }
            this.f534a = f45;
            this.b = g35;
            this.c = g352;
            this.d = g353;
            this.e = g354;
            this.f = (int) Math.min(g35.f1210a, g352.f1210a);
            this.g = (int) Math.max(g353.f1210a, g354.f1210a);
            this.h = (int) Math.min(g35.b, g353.b);
            this.i = (int) Math.max(g352.b, g354.b);
            return;
        }
        throw a35.h;
    }

    public c85(c85 c85) {
        this.f534a = c85.f534a;
        this.b = c85.b;
        this.c = c85.c;
        this.d = c85.d;
        this.e = c85.e;
        this.f = c85.f;
        this.g = c85.g;
        this.h = c85.h;
        this.i = c85.i;
    }
}
