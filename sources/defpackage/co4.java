package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: co4  reason: default package */
/* compiled from: AdjustedCornerSize */
public final class co4 implements do4 {

    /* renamed from: a  reason: collision with root package name */
    public final do4 f590a;
    public final float b;

    public co4(float f, do4 do4) {
        while (do4 instanceof co4) {
            do4 = ((co4) do4).f590a;
            f += ((co4) do4).b;
        }
        this.f590a = do4;
        this.b = f;
    }

    @Override // defpackage.do4
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f590a.a(rectF) + this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof co4)) {
            return false;
        }
        co4 co4 = (co4) obj;
        if (!this.f590a.equals(co4.f590a) || this.b != co4.b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f590a, Float.valueOf(this.b)});
    }
}
