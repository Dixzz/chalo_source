package defpackage;

/* renamed from: iz3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class iz3 implements fz3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f1587a;
    public static final is3<Boolean> b;
    public static final is3<Boolean> c;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        ns3.c("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f1587a = ns3.c("measurement.audience.refresh_event_count_filters_timestamp", false);
        b = ns3.c("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        c = ns3.c("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // defpackage.fz3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.fz3
    public final boolean zzb() {
        return f1587a.d().booleanValue();
    }

    @Override // defpackage.fz3
    public final boolean zzc() {
        return b.d().booleanValue();
    }

    @Override // defpackage.fz3
    public final boolean zzd() {
        return c.d().booleanValue();
    }
}
