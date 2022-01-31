package defpackage;

/* renamed from: t04  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class t04 implements u04 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Long> f3291a;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        ns3.a("measurement.id.max_bundles_per_iteration", 0);
        f3291a = ns3.a("measurement.max_bundles_per_iteration", 2);
    }

    @Override // defpackage.u04
    public final long zza() {
        return f3291a.d().longValue();
    }
}
