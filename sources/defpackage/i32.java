package defpackage;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

/* renamed from: i32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class i32 implements b42 {
    @Override // defpackage.b42
    @RecentlyNonNull
    public final Exception getException(@RecentlyNonNull Status status) {
        if (status.l1()) {
            return new d32(status);
        }
        return new y22(status);
    }
}
