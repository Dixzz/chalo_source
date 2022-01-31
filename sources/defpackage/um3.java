package defpackage;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* renamed from: um3  reason: default package */
public final class um3 extends im3 {
    public m32<Status> f;

    public um3(m32<Status> m32) {
        this.f = m32;
    }

    @Override // defpackage.hm3
    public final void L3(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }

    @Override // defpackage.hm3
    public final void S2(int i, String[] strArr) {
        if (this.f == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        }
        if ((i < 0 || i > 1) && (1000 > i || i > 1002)) {
            i = 1;
        }
        if (i == 1) {
            i = 13;
        }
        this.f.setResult(new Status(i, null));
        this.f = null;
    }

    @Override // defpackage.hm3
    public final void v1(int i, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }
}
