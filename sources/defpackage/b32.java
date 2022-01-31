package defpackage;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import defpackage.f32;

/* renamed from: b32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class b32<R extends f32> {

    /* renamed from: b32$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public interface a {
        void a(@RecentlyNonNull Status status);
    }

    public abstract void a();

    public abstract void b(@RecentlyNonNull g32<? super R> g32);
}
