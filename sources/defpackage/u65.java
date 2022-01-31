package defpackage;

import java.util.Map;

/* renamed from: u65  reason: default package */
/* compiled from: UPCEWriter */
public final class u65 extends s65 {
    @Override // defpackage.l65, defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        if (o25 == o25.UPC_E) {
            return super.a(str, o25, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(o25)));
    }

    @Override // defpackage.l65
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = hj1.I(str, r65.r(t65.s(str)));
            } catch (v25 e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 8) {
            try {
                if (!r65.j(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (v25 unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i = t65.k[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int b = l65.b(zArr, 0, r65.d, true) + 0;
            for (int i2 = 1; i2 <= 6; i2++) {
                int digit2 = Character.digit(str.charAt(i2), 10);
                if (((i >> (6 - i2)) & 1) == 1) {
                    digit2 += 10;
                }
                b += l65.b(zArr, b, r65.h[digit2], false);
            }
            l65.b(zArr, b, r65.f, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}
