package defpackage;

/* renamed from: jz3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class jz3 implements kz3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f2001a;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f2001a = ns3.c("measurement.sdk.referrer.delayed_install_referrer_api", false);
        ns3.a("measurement.id.sdk.referrer.delayed_install_referrer_api", 0);
    }

    @Override // defpackage.kz3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.kz3
    public final boolean zzb() {
        return f2001a.d().booleanValue();
    }
}
