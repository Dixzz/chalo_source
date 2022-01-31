package defpackage;

import android.content.Context;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.TelemetryData;
import defpackage.d42;
import defpackage.x22;
import defpackage.z22;

/* renamed from: y82  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class y82 extends z22<k82> implements j82 {

    /* renamed from: a  reason: collision with root package name */
    public static final x22.g<z82> f4019a;
    public static final x22.a<z82, k82> b;
    public static final x22<k82> c;

    static {
        x22.g<z82> gVar = new x22.g<>();
        f4019a = gVar;
        x82 x82 = new x82();
        b = x82;
        c = new x22<>("ClientTelemetry.API", x82, gVar);
    }

    public y82(Context context, k82 k82) {
        super(context, c, k82, z22.a.c);
    }

    public final yi4<Void> a(TelemetryData telemetryData) {
        d42.a builder = d42.builder();
        builder.c = new Feature[]{se2.f3206a};
        builder.b = false;
        builder.f784a = new w82(telemetryData);
        return doBestEffortWrite(builder.a());
    }
}
