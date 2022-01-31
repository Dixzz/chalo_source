package defpackage;

/* renamed from: ok6  reason: default package */
/* compiled from: Http2.kt */
public final class ok6 {

    /* renamed from: a  reason: collision with root package name */
    public static final zm6 f2707a = zm6.j.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] c = new String[64];
    public static final String[] d;
    public static final ok6 e = new ok6();

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            n86.b(binaryString, "Integer.toBinaryString(it)");
            String i2 = vi6.i("%8s", binaryString);
            n86.e(i2, "$this$replace");
            String replace = i2.replace(' ', '0');
            n86.d(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            strArr[i] = replace;
        }
        d = strArr;
        String[] strArr2 = c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = c;
            strArr3[i4 | 8] = n86.j(strArr3[i4], "|PADDED");
        }
        String[] strArr4 = c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = c;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + "|" + strArr5[i6];
                StringBuilder sb = new StringBuilder();
                sb.append(strArr5[i8]);
                sb.append("|");
                strArr5[i9 | 8] = hj1.a0(sb, strArr5[i6], "|PADDED");
            }
        }
        int length = c.length;
        for (int i10 = 0; i10 < length; i10++) {
            String[] strArr6 = c;
            if (strArr6[i10] == null) {
                strArr6[i10] = d[i10];
            }
        }
    }

    public final String a(int i) {
        String[] strArr = b;
        if (i < strArr.length) {
            return strArr[i];
        }
        return vi6.i("0x%02x", Integer.valueOf(i));
    }

    public final String b(boolean z, int i, int i2, int i3, int i4) {
        String str;
        String str2;
        String a2 = a(i3);
        if (i4 == 0) {
            str = "";
        } else {
            if (!(i3 == 2 || i3 == 3)) {
                if (i3 == 4 || i3 == 6) {
                    str = i4 == 1 ? "ACK" : d[i4];
                } else if (!(i3 == 7 || i3 == 8)) {
                    String[] strArr = c;
                    if (i4 < strArr.length) {
                        str2 = strArr[i4];
                        if (str2 == null) {
                            n86.k();
                            throw null;
                        }
                    } else {
                        str2 = d[i4];
                    }
                    str = (i3 != 5 || (i4 & 4) == 0) ? (i3 != 0 || (i4 & 32) == 0) ? str2 : ea6.x(str2, "PRIORITY", "COMPRESSED", false, 4) : ea6.x(str2, "HEADERS", "PUSH_PROMISE", false, 4);
                }
            }
            str = d[i4];
        }
        return vi6.i("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), a2, str);
    }
}
