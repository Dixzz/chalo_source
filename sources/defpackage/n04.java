package defpackage;

/* renamed from: n04  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class n04 implements o04 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f2504a;
    public static final is3<Boolean> b;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        ns3.a("measurement.id.lifecycle.app_in_background_parameter", 0);
        f2504a = ns3.c("measurement.lifecycle.app_backgrounded_engagement", false);
        ns3.c("measurement.lifecycle.app_backgrounded_tracking", true);
        b = ns3.c("measurement.lifecycle.app_in_background_parameter", false);
        ns3.a("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    @Override // defpackage.o04
    public final boolean zza() {
        return f2504a.d().booleanValue();
    }

    @Override // defpackage.o04
    public final boolean zzb() {
        return b.d().booleanValue();
    }
}
