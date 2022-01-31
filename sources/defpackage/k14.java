package defpackage;

/* renamed from: k14  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class k14 implements h14 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f2011a;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f2011a = ns3.c("measurement.service.ssaid_removal", true);
        ns3.a("measurement.id.ssaid_removal", 0);
    }

    @Override // defpackage.h14
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.h14
    public final boolean zzb() {
        return f2011a.d().booleanValue();
    }
}
