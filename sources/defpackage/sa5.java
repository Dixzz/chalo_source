package defpackage;

import android.graphics.Rect;

/* renamed from: sa5  reason: default package */
/* compiled from: FitXYStrategy */
public class sa5 extends va5 {
    public static float c(float f) {
        return f < 1.0f ? 1.0f / f : f;
    }

    @Override // defpackage.va5
    public float a(fa5 fa5, fa5 fa52) {
        int i = fa5.f;
        if (i <= 0 || fa5.g <= 0) {
            return 0.0f;
        }
        float c = (1.0f / c((((float) i) * 1.0f) / ((float) fa52.f))) / c((((float) fa5.g) * 1.0f) / ((float) fa52.g));
        float c2 = c(((((float) fa5.f) * 1.0f) / ((float) fa5.g)) / ((((float) fa52.f) * 1.0f) / ((float) fa52.g)));
        return (((1.0f / c2) / c2) / c2) * c;
    }

    @Override // defpackage.va5
    public Rect b(fa5 fa5, fa5 fa52) {
        return new Rect(0, 0, fa52.f, fa52.g);
    }
}
