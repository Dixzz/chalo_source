package defpackage;

/* renamed from: oi2  reason: default package */
public final class oi2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2693a;
    public int b = 0;

    public oi2(String str) {
        this.f2693a = str;
    }

    public final int a() {
        String str = this.f2693a;
        int i = this.b;
        this.b = i + 1;
        char charAt = str.charAt(i);
        if (charAt < 55296) {
            return charAt;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        while (true) {
            String str2 = this.f2693a;
            int i4 = this.b;
            this.b = i4 + 1;
            char charAt2 = str2.charAt(i4);
            if (charAt2 < 55296) {
                return i2 | (charAt2 << i3);
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
        }
    }
}
