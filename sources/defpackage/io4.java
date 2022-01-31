package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: io4  reason: default package */
/* compiled from: RelativeCornerSize */
public final class io4 implements do4 {

    /* renamed from: a  reason: collision with root package name */
    public final float f1547a;

    public io4(float f) {
        this.f1547a = f;
    }

    @Override // defpackage.do4
    public float a(RectF rectF) {
        return rectF.height() * this.f1547a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof io4) && this.f1547a == ((io4) obj).f1547a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f1547a)});
    }
}
