package defpackage;

/* renamed from: h04  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class h04 implements i04 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f1325a;
    public static final is3<Boolean> b;
    public static final is3<Boolean> c;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f1325a = ns3.c("measurement.client.global_params", true);
        b = ns3.c("measurement.service.global_params_in_payload", true);
        c = ns3.c("measurement.service.global_params", true);
        ns3.a("measurement.id.service.global_params", 0);
    }

    @Override // defpackage.i04
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.i04
    public final boolean zzb() {
        return f1325a.d().booleanValue();
    }

    @Override // defpackage.i04
    public final boolean zzc() {
        return b.d().booleanValue();
    }

    @Override // defpackage.i04
    public final boolean zzd() {
        return c.d().booleanValue();
    }
}
