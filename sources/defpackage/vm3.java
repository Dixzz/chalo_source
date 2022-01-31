package defpackage;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* renamed from: vm3  reason: default package */
public final class vm3 extends im3 {
    public m32<Status> f;

    public vm3(m32<Status> m32) {
        this.f = m32;
    }

    public final void F(int i) {
        if (this.f == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
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
    public final void L3(int i, String[] strArr) {
        F(i);
    }

    @Override // defpackage.hm3
    public final void S2(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }

    @Override // defpackage.hm3
    public final void v1(int i, PendingIntent pendingIntent) {
        F(i);
    }
}
