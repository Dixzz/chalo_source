package defpackage;

import android.graphics.Rect;

/* renamed from: ra5  reason: default package */
/* compiled from: FitCenterStrategy */
public class ra5 extends va5 {
    @Override // defpackage.va5
    public float a(fa5 fa5, fa5 fa52) {
        if (fa5.f <= 0 || fa5.g <= 0) {
            return 0.0f;
        }
        fa5 c = fa5.c(fa52);
        float f = (((float) c.f) * 1.0f) / ((float) fa5.f);
        if (f > 1.0f) {
            f = (float) Math.pow((double) (1.0f / f), 1.1d);
        }
        float f2 = ((((float) fa52.g) * 1.0f) / ((float) c.g)) * ((((float) fa52.f) * 1.0f) / ((float) c.f));
        return (((1.0f / f2) / f2) / f2) * f;
    }

    @Override // defpackage.va5
    public Rect b(fa5 fa5, fa5 fa52) {
        fa5 c = fa5.c(fa52);
        String str = "Preview: " + fa5 + "; Scaled: " + c + "; Want: " + fa52;
        int i = (c.f - fa52.f) / 2;
        int i2 = (c.g - fa52.g) / 2;
        return new Rect(-i, -i2, c.f - i, c.g - i2);
    }
}
