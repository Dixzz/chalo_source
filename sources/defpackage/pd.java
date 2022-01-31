package defpackage;

/* renamed from: pd  reason: default package */
/* compiled from: RawMessageInfo */
public final class pd implements bd {

    /* renamed from: a  reason: collision with root package name */
    public final dd f2792a;
    public final String b;
    public final Object[] c;
    public final int d;

    public pd(dd ddVar, String str, Object[] objArr) {
        this.f2792a = ddVar;
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

    @Override // defpackage.bd
    public boolean a() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.bd
    public dd b() {
        return this.f2792a;
    }

    @Override // defpackage.bd
    public md c() {
        return (this.d & 1) == 1 ? md.PROTO2 : md.PROTO3;
    }
}
