package defpackage;

/* renamed from: xy3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class xy3 implements yy3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f3980a;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f3980a = ns3.c("measurement.sdk.dynamite.allow_remote_dynamite3", true);
        ns3.c("measurement.collection.init_params_control_enabled", true);
        ns3.c("measurement.sdk.dynamite.use_dynamite3", true);
        ns3.a("measurement.id.sdk.dynamite.use_dynamite", 0);
    }

    @Override // defpackage.yy3
    public final boolean zza() {
        return f3980a.d().booleanValue();
    }
}
