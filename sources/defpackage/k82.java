package defpackage;

import androidx.annotation.RecentlyNonNull;
import defpackage.x22;
import java.util.Arrays;

/* renamed from: k82  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class k82 implements x22.d {
    @RecentlyNonNull
    public static final k82 g = new k82(null);
    public final String f = null;

    public /* synthetic */ k82(String str) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k82)) {
            return false;
        }
        return gj1.G(this.f, ((k82) obj).f);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f});
    }
}
