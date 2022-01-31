package defpackage;

/* renamed from: s04  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class s04 implements p04 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f3159a;
    public static final is3<Boolean> b;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f3159a = ns3.c("measurement.sdk.screen.manual_screen_view_logging", true);
        b = ns3.c("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    @Override // defpackage.p04
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.p04
    public final boolean zzb() {
        return f3159a.d().booleanValue();
    }

    @Override // defpackage.p04
    public final boolean zzc() {
        return b.d().booleanValue();
    }
}
