package defpackage;

/* renamed from: lm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class lm2 implements zl2 {

    /* renamed from: a  reason: collision with root package name */
    public final bm2 f2238a;
    public final String b;
    public final Object[] c;
    public final int d;

    public lm2(bm2 bm2, String str, Object[] objArr) {
        this.f2238a = bm2;
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

    @Override // defpackage.zl2
    public final boolean zza() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.zl2
    public final bm2 zzb() {
        return this.f2238a;
    }

    @Override // defpackage.zl2
    public final int zzc() {
        return (this.d & 1) == 1 ? 1 : 2;
    }
}
