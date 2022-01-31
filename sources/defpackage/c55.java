package defpackage;

/* renamed from: c55  reason: default package */
/* compiled from: ASCIIEncoder */
public final class c55 implements i55 {
    @Override // defpackage.i55
    public void a(j55 j55) {
        int i;
        String str = j55.f1880a;
        int i2 = j55.f;
        int length = str.length();
        if (i2 < length) {
            char charAt = str.charAt(i2);
            i = 0;
            while (hd3.F1(charAt) && i2 < length) {
                i++;
                i2++;
                if (i2 < length) {
                    charAt = str.charAt(i2);
                }
            }
        } else {
            i = 0;
        }
        if (i >= 2) {
            char charAt2 = j55.f1880a.charAt(j55.f);
            char charAt3 = j55.f1880a.charAt(j55.f + 1);
            if (!hd3.F1(charAt2) || !hd3.F1(charAt3)) {
                throw new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            }
            j55.e.append((char) ((charAt3 - '0') + ((charAt2 - '0') * 10) + 130));
            j55.f += 2;
            return;
        }
        char b = j55.b();
        int e2 = hd3.e2(j55.f1880a, j55.f, 0);
        if (e2 != 0) {
            if (e2 == 1) {
                j55.e.append((char) 230);
                j55.g = 1;
            } else if (e2 == 2) {
                j55.e.append((char) 239);
                j55.g = 2;
            } else if (e2 == 3) {
                j55.e.append((char) 238);
                j55.g = 3;
            } else if (e2 == 4) {
                j55.e.append((char) 240);
                j55.g = 4;
            } else if (e2 == 5) {
                j55.e.append((char) 231);
                j55.g = 5;
            } else {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(e2)));
            }
        } else if (hd3.I1(b)) {
            j55.e.append((char) 235);
            j55.e.append((char) ((b - 128) + 1));
            j55.f++;
        } else {
            j55.e.append((char) (b + 1));
            j55.f++;
        }
    }
}
