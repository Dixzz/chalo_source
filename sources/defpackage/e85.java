package defpackage;

import java.math.BigInteger;

/* renamed from: e85  reason: default package */
/* compiled from: DecodedBitStreamParser */
public final class e85 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f941a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    public static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    public static final BigInteger[] c;

    /* renamed from: e85$a */
    /* compiled from: DecodedBitStreamParser */
    public enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        bigIntegerArr[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    public static String a(int[] iArr, int i) throws v25 {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(c[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw v25.a();
    }

    public static int b(int[] iArr, int i, StringBuilder sb) throws v25 {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else {
                if (!(i4 == 900 || i4 == 901 || i4 == 928)) {
                    switch (i4) {
                    }
                }
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(a(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x013f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(int[] r16, int r17, java.lang.StringBuilder r18) {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e85.c(int[], int, java.lang.StringBuilder):int");
    }
}
