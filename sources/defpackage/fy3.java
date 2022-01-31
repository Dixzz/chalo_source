package defpackage;

/* renamed from: fy3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class fy3 implements gy3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f1186a;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f1186a = ns3.c("measurement.androidId.delete_feature", true);
        ns3.c("measurement.log_androidId_enabled", false);
    }

    @Override // defpackage.gy3
    public final boolean zza() {
        return f1186a.d().booleanValue();
    }
}
