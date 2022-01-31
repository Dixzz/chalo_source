package defpackage;

/* renamed from: m04  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class m04 implements j04 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f2303a;
    public static final is3<Boolean> b;
    public static final is3<Boolean> c;
    public static final is3<Boolean> d;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f2303a = ns3.c("measurement.sdk.collection.enable_extend_user_property_size", true);
        b = ns3.c("measurement.sdk.collection.last_deep_link_referrer2", true);
        c = ns3.c("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        d = ns3.c("measurement.sdk.collection.last_gclid_from_referrer2", false);
        ns3.a("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    @Override // defpackage.j04
    public final boolean zza() {
        return f2303a.d().booleanValue();
    }

    @Override // defpackage.j04
    public final boolean zzb() {
        return b.d().booleanValue();
    }

    @Override // defpackage.j04
    public final boolean zzc() {
        return c.d().booleanValue();
    }

    @Override // defpackage.j04
    public final boolean zzd() {
        return d.d().booleanValue();
    }
}
