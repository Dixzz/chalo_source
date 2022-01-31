package defpackage;

/* renamed from: ow3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class ow3 implements aw3 {

    /* renamed from: a  reason: collision with root package name */
    public final cw3 f2737a;
    public final String b;
    public final Object[] c;
    public final int d;

    public ow3(cw3 cw3, String str, Object[] objArr) {
        this.f2737a = cw3;
        this.b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.d = i | (charAt2 << i2);
                return;
            }
        }
    }

    @Override // defpackage.aw3
    public final int zza() {
        return (this.d & 1) == 1 ? 1 : 2;
    }

    @Override // defpackage.aw3
    public final boolean zzb() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.aw3
    public final cw3 zzc() {
        return this.f2737a;
    }
}
