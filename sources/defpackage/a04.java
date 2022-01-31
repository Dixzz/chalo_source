package defpackage;

/* renamed from: a04  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class a04 implements xz3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f100a;
    public static final is3<Boolean> b;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f100a = ns3.c("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        b = ns3.c("measurement.collection.redundant_engagement_removal_enabled", false);
        ns3.a("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    @Override // defpackage.xz3
    public final boolean zza() {
        return f100a.d().booleanValue();
    }

    @Override // defpackage.xz3
    public final boolean zzb() {
        return b.d().booleanValue();
    }
}
