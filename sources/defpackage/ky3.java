package defpackage;

/* renamed from: ky3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ky3 implements hy3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f2137a;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f2137a = ns3.c("measurement.service.directly_maybe_log_error_events", false);
        ns3.a("measurement.id.service.directly_maybe_log_error_events", 0);
    }

    @Override // defpackage.hy3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.hy3
    public final boolean zzb() {
        return f2137a.d().booleanValue();
    }
}
