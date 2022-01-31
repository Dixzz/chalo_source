package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: l62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class l62 {
    public static final Status c = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: a  reason: collision with root package name */
    public final Set<BasePendingResult<?>> f2180a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    public final k62 b = new k62(this);

    public final void a() {
        boolean z;
        BasePendingResult[] basePendingResultArr = (BasePendingResult[]) this.f2180a.toArray(new BasePendingResult[0]);
        for (BasePendingResult basePendingResult : basePendingResultArr) {
            basePendingResult.g.set(null);
            synchronized (basePendingResult.f603a) {
                if (basePendingResult.c.get() == null || !basePendingResult.m) {
                    basePendingResult.a();
                }
                synchronized (basePendingResult.f603a) {
                    z = basePendingResult.k;
                }
            }
            if (z) {
                this.f2180a.remove(basePendingResult);
            }
        }
    }
}
