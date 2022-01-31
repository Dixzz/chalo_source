package defpackage;

import java.util.Map;

/* renamed from: c65  reason: default package */
/* compiled from: EAN13Writer */
public final class c65 extends s65 {
    @Override // defpackage.l65, defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        if (o25 == o25.EAN_13) {
            return super.a(str, o25, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(o25)));
    }

    @Override // defpackage.l65
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = hj1.I(str, r65.r(str));
            } catch (v25 e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 13) {
            try {
                if (!r65.j(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (v25 unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i = b65.j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int b = l65.b(zArr, 0, r65.d, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int digit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                digit += 10;
            }
            b += l65.b(zArr, b, r65.h[digit], false);
        }
        int b2 = l65.b(zArr, b, r65.e, false) + b;
        for (int i3 = 7; i3 <= 12; i3++) {
            b2 += l65.b(zArr, b2, r65.g[Character.digit(str.charAt(i3), 10)], true);
        }
        l65.b(zArr, b2, r65.d, true);
        return zArr;
    }
}
