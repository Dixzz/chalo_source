package defpackage;

/* renamed from: ry3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ry3 implements sy3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f3151a;
    public static final is3<Boolean> b;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f3151a = ns3.c("measurement.service.configurable_service_limits", true);
        b = ns3.c("measurement.client.configurable_service_limits", true);
        ns3.a("measurement.id.service.configurable_service_limits", 0);
    }

    @Override // defpackage.sy3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.sy3
    public final boolean zzb() {
        return f3151a.d().booleanValue();
    }

    @Override // defpackage.sy3
    public final boolean zzc() {
        return b.d().booleanValue();
    }
}
