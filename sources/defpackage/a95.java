package defpackage;

import java.io.UnsupportedEncodingException;

/* renamed from: a95  reason: default package */
/* compiled from: DecodedBitStreamParser */
public final class a95 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f136a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static void a(g45 g45, StringBuilder sb, int i, boolean z) throws v25 {
        while (i > 1) {
            if (g45.a() >= 11) {
                int b = g45.b(11);
                sb.append(f(b / 45));
                sb.append(f(b % 45));
                i -= 2;
            } else {
                throw v25.a();
            }
        }
        if (i == 1) {
            if (g45.a() >= 6) {
                sb.append(f(g45.b(6)));
            } else {
                throw v25.a();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0143, code lost:
        if (r1 == 2) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0147, code lost:
        if ((r17 * 10) >= r23) goto L_0x0151;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(defpackage.g45 r21, java.lang.StringBuilder r22, int r23, defpackage.h45 r24, java.util.Collection<byte[]> r25, java.util.Map<defpackage.s25, ?> r26) throws defpackage.v25 {
        /*
        // Method dump skipped, instructions count: 382
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a95.b(g45, java.lang.StringBuilder, int, h45, java.util.Collection, java.util.Map):void");
    }

    public static void c(g45 g45, StringBuilder sb, int i) throws v25 {
        if (i * 13 <= g45.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int b = g45.b(13);
                int i3 = (b % 96) | ((b / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw v25.a();
            }
        } else {
            throw v25.a();
        }
    }

    public static void d(g45 g45, StringBuilder sb, int i) throws v25 {
        if (i * 13 <= g45.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int b = g45.b(13);
                int i3 = (b % 192) | ((b / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw v25.a();
            }
        } else {
            throw v25.a();
        }
    }

    public static void e(g45 g45, StringBuilder sb, int i) throws v25 {
        while (i >= 3) {
            if (g45.a() >= 10) {
                int b = g45.b(10);
                if (b < 1000) {
                    sb.append(f(b / 100));
                    sb.append(f((b / 10) % 10));
                    sb.append(f(b % 10));
                    i -= 3;
                } else {
                    throw v25.a();
                }
            } else {
                throw v25.a();
            }
        }
        if (i == 2) {
            if (g45.a() >= 7) {
                int b2 = g45.b(7);
                if (b2 < 100) {
                    sb.append(f(b2 / 10));
                    sb.append(f(b2 % 10));
                    return;
                }
                throw v25.a();
            }
            throw v25.a();
        } else if (i != 1) {
        } else {
            if (g45.a() >= 4) {
                int b3 = g45.b(4);
                if (b3 < 10) {
                    sb.append(f(b3));
                    return;
                }
                throw v25.a();
            }
            throw v25.a();
        }
    }

    public static char f(int i) throws v25 {
        char[] cArr = f136a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw v25.a();
    }
}
