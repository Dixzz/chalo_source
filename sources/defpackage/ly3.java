package defpackage;

/* renamed from: ly3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ly3 implements my3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f2294a;
    public static final is3<Long> b;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f2294a = ns3.c("measurement.sdk.attribution.cache", true);
        b = ns3.a("measurement.sdk.attribution.cache.ttl", 604800000);
    }

    @Override // defpackage.my3
    public final boolean zza() {
        return f2294a.d().booleanValue();
    }

    @Override // defpackage.my3
    public final long zzb() {
        return b.d().longValue();
    }
}
