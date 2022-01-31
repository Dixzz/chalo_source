package defpackage;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* renamed from: u85  reason: default package */
/* compiled from: PDF417HighLevelEncoder */
public final class u85 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3470a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    public static final byte[] b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    public static final byte[] c;
    public static final byte[] d = new byte[128];
    public static final Charset e = StandardCharsets.ISO_8859_1;

    static {
        byte[] bArr = new byte[128];
        c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f3470a;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i2];
            if (b2 > 0) {
                c[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(d, (byte) -1);
        while (true) {
            byte[] bArr3 = b;
            if (i < bArr3.length) {
                byte b3 = bArr3[i];
                if (b3 > 0) {
                    d[b3] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void a(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    public static void b(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder("1");
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            int length = sb2.length();
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f6 A[EDGE_INSN: B:75:0x00f6->B:60:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0012 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
        // Method dump skipped, instructions count: 293
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u85.c(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    public static boolean d(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    public static boolean e(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    public static boolean f(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean g(char c2) {
        return c[c2] != -1;
    }
}
