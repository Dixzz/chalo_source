package defpackage;

import android.os.Parcel;
import com.google.android.gms.common.internal.TelemetryData;
import defpackage.x22;

/* renamed from: w82  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final /* synthetic */ class w82 implements z32 {

    /* renamed from: a  reason: collision with root package name */
    public final TelemetryData f3744a;

    public w82(TelemetryData telemetryData) {
        this.f3744a = telemetryData;
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.z32
    public final void accept(Object obj, Object obj2) {
        TelemetryData telemetryData = this.f3744a;
        zi4 zi4 = (zi4) obj2;
        x22.g<z82> gVar = y82.f4019a;
        u82 u82 = (u82) ((z82) obj).getService();
        Parcel C = u82.C();
        int i = re2.f3072a;
        if (telemetryData == null) {
            C.writeInt(0);
        } else {
            C.writeInt(1);
            telemetryData.writeToParcel(C, 0);
        }
        try {
            u82.f.transact(1, C, null, 1);
            C.recycle();
            zi4.f4178a.t(null);
        } catch (Throwable th) {
            C.recycle();
            throw th;
        }
    }
}
