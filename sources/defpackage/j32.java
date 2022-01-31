package defpackage;

import defpackage.x22;
import defpackage.x22.d;
import java.util.Arrays;

/* renamed from: j32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class j32<O extends x22.d> {

    /* renamed from: a  reason: collision with root package name */
    public final int f1868a;
    public final x22<O> b;
    public final O c;
    public final String d;

    public j32(x22<O> x22, O o, String str) {
        this.b = x22;
        this.c = o;
        this.d = str;
        this.f1868a = Arrays.hashCode(new Object[]{x22, o, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j32)) {
            return false;
        }
        j32 j32 = (j32) obj;
        return gj1.G(this.b, j32.b) && gj1.G(this.c, j32.c) && gj1.G(this.d, j32.d);
    }

    public final int hashCode() {
        return this.f1868a;
    }
}
