package defpackage;

/* renamed from: dz3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class dz3 implements ez3 {

    /* renamed from: a  reason: collision with root package name */
    public static final is3<Boolean> f906a = new ns3(fs3.a("com.google.android.gms.measurement")).c("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // defpackage.ez3
    public final boolean zza() {
        return true;
    }

    @Override // defpackage.ez3
    public final boolean zzb() {
        return f906a.d().booleanValue();
    }
}
