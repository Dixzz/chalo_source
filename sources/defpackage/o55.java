package defpackage;

/* renamed from: o55  reason: default package */
/* compiled from: X12Encoder */
public final class o55 extends e55 {
    @Override // defpackage.e55, defpackage.i55
    public void a(j55 j55) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!j55.d()) {
                break;
            }
            char b = j55.b();
            j55.f++;
            c(b, sb);
            if (sb.length() % 3 == 0) {
                e55.f(j55, sb);
                if (hd3.e2(j55.f1880a, j55.f, 3) != 3) {
                    j55.g = 0;
                    break;
                }
            }
        }
        e(j55, sb);
    }

    @Override // defpackage.e55
    public int c(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            hd3.z1(c);
            throw null;
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    @Override // defpackage.e55
    public int d() {
        return 3;
    }

    @Override // defpackage.e55
    public void e(j55 j55, StringBuilder sb) {
        j55.e();
        int a2 = j55.h.b - j55.a();
        j55.f -= sb.length();
        if (j55.c() > 1 || a2 > 1 || j55.c() != a2) {
            j55.e.append((char) 254);
        }
        if (j55.g < 0) {
            j55.g = 0;
        }
    }
}
