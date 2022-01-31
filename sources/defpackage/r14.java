package defpackage;

/* renamed from: r14  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class r14 implements s14 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f3026a = new ns3(fs3.a("com.google.android.gms.measurement")).c("measurement.integration.disable_firebase_instance_id", false);

    @Override // defpackage.s14
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.s14
    public final boolean zzb() {
        return f3026a.d().booleanValue();
    }
}
