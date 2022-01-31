package defpackage;

/* renamed from: wy3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class wy3 implements ty3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f3860a;
    public static final is3<Boolean> b;
    public static final is3<Boolean> c;
    public static final is3<Long> d;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f3860a = ns3.c("measurement.client.consent_state_v1", false);
        b = ns3.c("measurement.client.3p_consent_state_v1", false);
        c = ns3.c("measurement.service.consent_state_v1_W36", false);
        ns3.a("measurement.id.service.consent_state_v1_W36", 0);
        d = ns3.a("measurement.service.storage_consent_support_version", 203590);
    }

    @Override // defpackage.ty3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.ty3
    public final boolean zzb() {
        return f3860a.d().booleanValue();
    }

    @Override // defpackage.ty3
    public final boolean zzc() {
        return b.d().booleanValue();
    }

    @Override // defpackage.ty3
    public final boolean zzd() {
        return c.d().booleanValue();
    }

    @Override // defpackage.ty3
    public final long zze() {
        return d.d().longValue();
    }
}
