package defpackage;

import java.util.Map;

/* renamed from: e65  reason: default package */
/* compiled from: EAN8Writer */
public final class e65 extends s65 {
    @Override // defpackage.l65, defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        if (o25 == o25.EAN_8) {
            return super.a(str, o25, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(o25)));
    }

    @Override // defpackage.l65
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = hj1.I(str, r65.r(str));
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
        boolean[] zArr = new boolean[67];
        int b = l65.b(zArr, 0, r65.d, true) + 0;
        for (int i = 0; i <= 3; i++) {
            b += l65.b(zArr, b, r65.g[Character.digit(str.charAt(i), 10)], false);
        }
        int b2 = l65.b(zArr, b, r65.e, false) + b;
        for (int i2 = 4; i2 <= 7; i2++) {
            b2 += l65.b(zArr, b2, r65.g[Character.digit(str.charAt(i2), 10)], true);
        }
        l65.b(zArr, b2, r65.d, true);
        return zArr;
    }
}
