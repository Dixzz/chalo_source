package defpackage;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* renamed from: i82  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class i82 {
    public static i82 b;
    public static final RootTelemetryConfiguration c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public RootTelemetryConfiguration f1489a;

    @RecentlyNonNull
    public static synchronized i82 a() {
        i82 i82;
        synchronized (i82.class) {
            if (b == null) {
                b = new i82();
            }
            i82 = b;
        }
        return i82;
    }
}
