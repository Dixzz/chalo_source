package defpackage;

import com.rabbitmq.client.AMQP;

/* renamed from: z55  reason: default package */
/* compiled from: Code93Reader */
public final class z55 extends k65 {
    public static final char[] c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    public static final int[] d;
    public static final int e;

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f4132a = new StringBuilder(20);
    public final int[] b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, AMQP.NOT_FOUND, AMQP.INVALID_PATH, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, AMQP.PRECONDITION_FAILED, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        d = iArr;
        e = iArr[47];
    }

    public static void i(CharSequence charSequence, int i, int i2) throws r25 {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != c[i3 % 47]) {
            throw r25.a();
        }
    }

    public static int j(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((((float) iArr[i4]) * 9.0f) / ((float) i));
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < round; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r8 = defpackage.z55.c[r9];
        r7.append(r8);
        r9 = r6.length;
        r12 = r4;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r10 >= r9) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9 = r18.f(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        if (r8 != '*') goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        r7.deleteCharAt(r7.length() - 1);
        r8 = r6.length;
        r10 = 0;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        if (r10 >= r8) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        if (r9 == r5) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        if (r18.e(r9) == false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
        if (r7.length() < 2) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r7.length();
        i(r7, r1 - 2, 20);
        i(r7, r1 - 1, 15);
        r7.setLength(r7.length() - 2);
        r1 = r7.length();
        r5 = new java.lang.StringBuilder(r1);
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bf, code lost:
        if (r6 >= r1) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        r8 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        if (r8 < 'a') goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cb, code lost:
        if (r8 > 'd') goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
        if (r6 >= (r1 - 1)) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d1, code lost:
        r6 = r6 + 1;
        r9 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dd, code lost:
        switch(r8) {
            case 97: goto L_0x0136;
            case 98: goto L_0x0100;
            case 99: goto L_0x00ef;
            case 100: goto L_0x00e3;
            default: goto L_0x00e0;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e0, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e3, code lost:
        if (r9 < 'A') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e5, code lost:
        if (r9 > 'Z') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e7, code lost:
        r9 = r9 + ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ee, code lost:
        throw defpackage.v25.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ef, code lost:
        if (r9 < 'A') goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f1, code lost:
        if (r9 > 'O') goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f3, code lost:
        r9 = r9 - ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f6, code lost:
        if (r9 != 'Z') goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f8, code lost:
        r8 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ff, code lost:
        throw defpackage.v25.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0100, code lost:
        if (r9 < 'A') goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0104, code lost:
        if (r9 > 'E') goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0106, code lost:
        r9 = r9 - '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010b, code lost:
        if (r9 < 'F') goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010f, code lost:
        if (r9 > 'J') goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0111, code lost:
        r9 = r9 - 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0116, code lost:
        if (r9 < 'K') goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0118, code lost:
        if (r9 > 'O') goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011a, code lost:
        r9 = r9 + 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011f, code lost:
        if (r9 < 'P') goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0123, code lost:
        if (r9 > 'S') goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0125, code lost:
        r9 = r9 + '+';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012a, code lost:
        if (r9 < 'T') goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012c, code lost:
        if (r9 > 'Z') goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012e, code lost:
        r8 = 127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0135, code lost:
        throw defpackage.v25.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0136, code lost:
        if (r9 < 'A') goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0138, code lost:
        if (r9 > 'Z') goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013a, code lost:
        r9 = r9 - '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x013c, code lost:
        r8 = (char) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0142, code lost:
        throw defpackage.v25.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0143, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x014b, code lost:
        throw defpackage.v25.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x014c, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x014f, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0152, code lost:
        r9 = (float) r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017e, code lost:
        return new defpackage.e35(r5.toString(), null, new defpackage.g35[]{new defpackage.g35(((float) (r2[1] + r2[0])) / 2.0f, r9), new defpackage.g35((((float) r12) / 2.0f) + ((float) r4), r9)}, defpackage.o25.CODE_93);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0181, code lost:
        throw defpackage.a35.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0184, code lost:
        throw defpackage.a35.h;
     */
    @Override // defpackage.k65
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.e35 d(int r17, defpackage.e45 r18, java.util.Map<defpackage.s25, ?> r19) throws defpackage.a35, defpackage.r25, defpackage.v25 {
        /*
        // Method dump skipped, instructions count: 452
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z55.d(int, e45, java.util.Map):e35");
    }
}
