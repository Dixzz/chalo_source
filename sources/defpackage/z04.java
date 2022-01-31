package defpackage;

/* renamed from: z04  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class z04 implements a14 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f4106a;
    public static final is3<Double> b;
    public static final is3<Long> c;
    public static final is3<Long> d;
    public static final is3<String> e;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f4106a = ns3.c("measurement.test.boolean_flag", false);
        Object obj = is3.g;
        b = new ls3(ns3, "measurement.test.double_flag", Double.valueOf(-3.0d));
        c = ns3.a("measurement.test.int_flag", -2);
        d = ns3.a("measurement.test.long_flag", -1);
        e = ns3.b("measurement.test.string_flag", "---");
    }

    @Override // defpackage.a14
    public final boolean zza() {
        return f4106a.d().booleanValue();
    }

    @Override // defpackage.a14
    public final double zzb() {
        return b.d().doubleValue();
    }

    @Override // defpackage.a14
    public final long zzc() {
        return c.d().longValue();
    }

    @Override // defpackage.a14
    public final long zzd() {
        return d.d().longValue();
    }

    @Override // defpackage.a14
    public final String zze() {
        return e.d();
    }
}
