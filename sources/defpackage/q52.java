package defpackage;

import com.google.android.gms.common.Feature;
import com.razorpay.AnalyticsConstants;
import java.util.Arrays;

/* renamed from: q52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class q52 {

    /* renamed from: a  reason: collision with root package name */
    public final j32<?> f2899a;
    public final Feature b;

    public /* synthetic */ q52(j32 j32, Feature feature) {
        this.f2899a = j32;
        this.b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof q52)) {
            q52 q52 = (q52) obj;
            if (!gj1.G(this.f2899a, q52.f2899a) || !gj1.G(this.b, q52.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2899a, this.b});
    }

    public final String toString() {
        g82 g82 = new g82(this);
        g82.a(AnalyticsConstants.KEY, this.f2899a);
        g82.a("feature", this.b);
        return g82.toString();
    }
}
