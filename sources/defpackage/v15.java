package defpackage;

/* renamed from: v15  reason: default package */
/* compiled from: RawMessageInfo */
public final class v15 implements h15 {

    /* renamed from: a  reason: collision with root package name */
    public final j15 f3583a;
    public final String b;
    public final Object[] c;
    public final int d;

    public v15(j15 j15, String str, Object[] objArr) {
        this.f3583a = j15;
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

    @Override // defpackage.h15
    public boolean a() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.h15
    public j15 b() {
        return this.f3583a;
    }

    @Override // defpackage.h15
    public s15 c() {
        return (this.d & 1) == 1 ? s15.PROTO2 : s15.PROTO3;
    }
}
