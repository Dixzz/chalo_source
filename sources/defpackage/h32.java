package defpackage;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;

/* renamed from: h32  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class h32 extends UnsupportedOperationException {
    public final Feature f;

    public h32(@RecentlyNonNull Feature feature) {
        this.f = feature;
    }

    @RecentlyNonNull
    public String getMessage() {
        String valueOf = String.valueOf(this.f);
        return hj1.a0(new StringBuilder(valueOf.length() + 8), "Missing ", valueOf);
    }
}
