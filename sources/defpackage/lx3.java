package defpackage;

/* renamed from: lx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class lx3 {

    /* renamed from: a  reason: collision with root package name */
    public static final nx3 f2290a;

    static {
        nx3 nx3;
        if (!(kx3.g && kx3.f) || nt3.a()) {
            nx3 = new mx3();
        } else {
            nx3 = new ox3();
        }
        f2290a = nx3;
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new px3(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    public static boolean b(byte[] bArr, int i, int i2) {
        if (f2290a.a(0, bArr, i, i2) == 0) {
            return true;
        }
        return false;
    }

    public static int c(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static int d(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        int i4 = -1;
        if (i3 == 0) {
            if (b > -12) {
                b = -1;
            }
            return b;
        } else if (i3 == 1) {
            byte b2 = bArr[i];
            if (b <= -12 && b2 <= -65) {
                i4 = b ^ (b2 << 8);
            }
            return i4;
        } else if (i3 == 2) {
            return c(b, bArr[i], bArr[i + 1]);
        } else {
            throw new AssertionError();
        }
    }
}
