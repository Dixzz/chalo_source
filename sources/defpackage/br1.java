package defpackage;

import android.graphics.Bitmap;
import defpackage.dr1;

/* renamed from: br1  reason: default package */
/* compiled from: GifDrawableResource */
public class br1 extends uq1<zq1> implements on1 {
    public br1(zq1 zq1) {
        super(zq1);
    }

    @Override // defpackage.rn1
    public void a() {
        ((zq1) this.f).stop();
        zq1 zq1 = (zq1) this.f;
        zq1.i = true;
        dr1 dr1 = zq1.f.b;
        dr1.c.clear();
        Bitmap bitmap = dr1.l;
        if (bitmap != null) {
            dr1.e.d(bitmap);
            dr1.l = null;
        }
        dr1.f = false;
        dr1.a aVar = dr1.i;
        if (aVar != null) {
            dr1.d.o(aVar);
            dr1.i = null;
        }
        dr1.a aVar2 = dr1.k;
        if (aVar2 != null) {
            dr1.d.o(aVar2);
            dr1.k = null;
        }
        dr1.f881a.clear();
        dr1.j = true;
    }

    @Override // defpackage.rn1
    public int b() {
        dr1 dr1 = ((zq1) this.f).f.b;
        return rt1.c(dr1.a().getWidth(), dr1.a().getHeight(), dr1.a().getConfig()) + dr1.f881a.g();
    }

    @Override // defpackage.rn1
    public Class<zq1> c() {
        return zq1.class;
    }

    @Override // defpackage.on1
    public void initialize() {
        ((zq1) this.f).f.b.l.prepareToDraw();
    }
}
