package defpackage;

import defpackage.x22;
import java.util.Arrays;

/* renamed from: l53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class l53 extends a13 implements x22.d {
    public final String g;

    public /* synthetic */ l53(String str) {
        gj1.i(str, "A valid API key must be provided");
        this.g = str;
    }

    @Override // java.lang.Object
    public final Object clone() throws CloneNotSupportedException {
        String str = this.g;
        gj1.j(str);
        return new l53(str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l53)) {
            return false;
        }
        l53 l53 = (l53) obj;
        return gj1.G(this.g, l53.g) && this.f == l53.f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.g}) + (1 ^ (this.f ? 1 : 0));
    }
}
