package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.zza;

/* renamed from: v24  reason: default package */
public final class v24 implements ph4 {
    public final Status f;
    public final zza g;

    public v24(Status status, zza zza) {
        this.f = status;
        this.g = zza;
    }

    @Override // defpackage.f32
    public final Status M0() {
        return this.f;
    }

    @Override // defpackage.ph4
    public final String U0() {
        zza zza = this.g;
        if (zza == null) {
            return null;
        }
        return zza.f;
    }
}
