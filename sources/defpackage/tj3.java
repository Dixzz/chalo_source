package defpackage;

/* renamed from: tj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class tj3 implements ej3 {

    /* renamed from: a  reason: collision with root package name */
    public final gj3 f3366a;
    public final String b;
    public final Object[] c;
    public final int d;

    public tj3(gj3 gj3, String str, Object[] objArr) {
        this.f3366a = gj3;
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

    @Override // defpackage.ej3
    public final int a() {
        return (this.d & 1) == 1 ? 1 : 2;
    }

    @Override // defpackage.ej3
    public final boolean b() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.ej3
    public final gj3 c() {
        return this.f3366a;
    }
}
