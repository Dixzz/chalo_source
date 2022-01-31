package defpackage;

/* renamed from: pz3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class pz3 implements qz3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f2874a = new ns3(fs3.a("com.google.android.gms.measurement")).c("measurement.service.use_appinfo_modified", false);

    @Override // defpackage.qz3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.qz3
    public final boolean zzb() {
        return f2874a.d().booleanValue();
    }
}
