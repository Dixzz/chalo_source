package defpackage;

import android.graphics.Rect;

/* renamed from: pa5  reason: default package */
/* compiled from: CenterCropStrategy */
public class pa5 extends va5 {
    @Override // defpackage.va5
    public float a(fa5 fa5, fa5 fa52) {
        if (fa5.f <= 0 || fa5.g <= 0) {
            return 0.0f;
        }
        fa5 a2 = fa5.a(fa52);
        float f = (((float) a2.f) * 1.0f) / ((float) fa5.f);
        if (f > 1.0f) {
            f = (float) Math.pow((double) (1.0f / f), 1.1d);
        }
        float f2 = ((((float) a2.g) * 1.0f) / ((float) fa52.g)) + ((((float) a2.f) * 1.0f) / ((float) fa52.f));
        return ((1.0f / f2) / f2) * f;
    }

    @Override // defpackage.va5
    public Rect b(fa5 fa5, fa5 fa52) {
        fa5 a2 = fa5.a(fa52);
        String str = "Preview: " + fa5 + "; Scaled: " + a2 + "; Want: " + fa52;
        int i = (a2.f - fa52.f) / 2;
        int i2 = (a2.g - fa52.g) / 2;
        return new Rect(-i, -i2, a2.f - i, a2.g - i2);
    }
}
