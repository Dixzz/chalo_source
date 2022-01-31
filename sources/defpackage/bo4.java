package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: bo4  reason: default package */
/* compiled from: AbsoluteCornerSize */
public final class bo4 implements do4 {

    /* renamed from: a  reason: collision with root package name */
    public final float f457a;

    public bo4(float f) {
        this.f457a = f;
    }

    @Override // defpackage.do4
    public float a(RectF rectF) {
        return this.f457a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof bo4) && this.f457a == ((bo4) obj).f457a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f457a)});
    }
}
