package defpackage;

/* renamed from: zx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zx3 implements ay3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f4225a;
    public static final is3<Boolean> b;
    public static final is3<Boolean> c;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f4225a = ns3.c("measurement.client.ad_impression", true);
        b = ns3.c("measurement.service.separate_public_internal_event_blacklisting", true);
        c = ns3.c("measurement.service.ad_impression", true);
        ns3.a("measurement.id.service.ad_impression", 0);
    }

    @Override // defpackage.ay3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.ay3
    public final boolean zzb() {
        return f4225a.d().booleanValue();
    }

    @Override // defpackage.ay3
    public final boolean zzc() {
        return b.d().booleanValue();
    }

    @Override // defpackage.ay3
    public final boolean zzd() {
        return c.d().booleanValue();
    }
}
