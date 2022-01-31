package defpackage;

/* renamed from: uz3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class uz3 implements rz3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f3574a;

    static {
        ns3 ns3 = new ns3(fs3.a("com.google.android.gms.measurement"));
        f3574a = ns3.c("measurement.client.sessions.check_on_reset_and_enable2", true);
        ns3.c("measurement.client.sessions.check_on_startup", true);
        ns3.c("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // defpackage.rz3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.rz3
    public final boolean zzb() {
        return f3574a.d().booleanValue();
    }
}
