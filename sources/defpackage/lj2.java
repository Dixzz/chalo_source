package defpackage;

import java.nio.ByteBuffer;

/* renamed from: lj2  reason: default package */
public final class lj2 {

    /* renamed from: a  reason: collision with root package name */
    public static final mj2 f2227a = (jj2.h && jj2.g ? new pj2() : new nj2());

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
                                throw new oj2(i2, length2);
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

    public static int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f2227a.b(charSequence, bArr, i, i2);
    }

    public static void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        mj2 mj2 = f2227a;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(b(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            mj2.c(charSequence, byteBuffer);
        } else {
            mj2.d(charSequence, byteBuffer);
        }
    }

    public static int d(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean e(byte[] bArr, int i, int i2) {
        return f2227a.a(0, bArr, i, i2) == 0;
    }

    public static int f(byte[] bArr, int i, int i2) {
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
            return d(b, bArr[i], bArr[i + 1]);
        } else {
            throw new AssertionError();
        }
    }
}
