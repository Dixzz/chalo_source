package defpackage;

import java.util.Map;

/* renamed from: w55  reason: default package */
/* compiled from: Code128Writer */
public final class w55 extends l65 {

    /* renamed from: w55$a */
    /* compiled from: Code128Writer */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static a e(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return a.ONE_DIGIT;
        }
        return a.TWO_DIGITS;
    }

    @Override // defpackage.l65, defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        if (o25 == o25.CODE_128) {
            return super.a(str, o25, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(o25)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        if (e(r17, r6 + 3) == defpackage.w55.a.TWO_DIGITS) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0095, code lost:
        if (r11 == defpackage.w55.a.ONE_DIGIT) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a4, code lost:
        if (r11 == defpackage.w55.a.TWO_DIGITS) goto L_0x00a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0038 A[SYNTHETIC] */
    @Override // defpackage.l65
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] c(java.lang.String r17) {
        /*
        // Method dump skipped, instructions count: 376
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w55.c(java.lang.String):boolean[]");
    }
}
