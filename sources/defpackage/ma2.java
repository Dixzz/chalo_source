package defpackage;

import android.net.Uri;
import java.util.Arrays;

/* renamed from: ma2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ma2 {
    public static final Uri e = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    public final String f2345a;
    public final String b;
    public final int c;
    public final boolean d;

    public ma2(String str, String str2, int i, boolean z) {
        gj1.j(str);
        this.f2345a = str;
        gj1.j(str2);
        this.b = str2;
        this.c = i;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ma2)) {
            return false;
        }
        ma2 ma2 = (ma2) obj;
        return gj1.G(this.f2345a, ma2.f2345a) && gj1.G(this.b, ma2.b) && gj1.G(null, null) && this.c == ma2.c && this.d == ma2.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2345a, this.b, null, Integer.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final String toString() {
        String str = this.f2345a;
        if (str != null) {
            return str;
        }
        throw null;
    }
}
