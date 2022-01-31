package defpackage;

import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.LiveData;
import com.razorpay.AnalyticsConstants;
import defpackage.m66;

/* renamed from: wg  reason: default package */
/* compiled from: FlowLiveData.kt */
public final class wg {
    public static LiveData a(qe6 qe6, m66 m66, long j, int i) {
        o66 o66 = (i & 1) != 0 ? o66.f : null;
        if ((i & 2) != 0) {
            j = 5000;
        }
        n86.e(qe6, "$this$asLiveData");
        n86.e(o66, AnalyticsConstants.CONTEXT);
        vg vgVar = new vg(qe6, null);
        n86.e(o66, AnalyticsConstants.CONTEXT);
        n86.e(vgVar, "block");
        return new rg(o66, j, vgVar);
    }

    public static final ah b(fh fhVar) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        n86.e(fhVar, "$this$lifecycleScope");
        zg lifecycle = fhVar.getLifecycle();
        n86.d(lifecycle, "lifecycle");
        n86.e(lifecycle, "$this$coroutineScope");
        while (true) {
            lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) lifecycle.f4167a.get();
            if (lifecycleCoroutineScopeImpl == null) {
                cb6 b = ec6.b(null, 1);
                xb6 xb6 = xb6.f3911a;
                ad6 ad6 = xf6.c;
                lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, m66.a.C0044a.d((wc6) b, ad6.A()));
                if (lifecycle.f4167a.compareAndSet(null, lifecycleCoroutineScopeImpl)) {
                    hd3.Y1(lifecycleCoroutineScopeImpl, ad6.A(), null, new bh(lifecycleCoroutineScopeImpl, null), 2, null);
                    break;
                }
            } else {
                break;
            }
        }
        return lifecycleCoroutineScopeImpl;
    }
}
