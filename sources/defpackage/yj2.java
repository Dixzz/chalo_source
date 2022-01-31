package defpackage;

import defpackage.bg2;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.util.logging.Logger;

/* renamed from: yj2  reason: default package */
public final class yj2 {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f4057a;
    public bg2 b;
    public int c;

    public yj2(byte[] bArr, int i, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        this.f4057a = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
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
                                throw new IllegalArgumentException(hj1.v(39, "Unpaired surrogate at index ", i2));
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

    public static int g(int i, ek2 ek2) {
        int r = r(i);
        int c2 = ek2.c();
        return t(c2) + c2 + r;
    }

    public static int h(int i, String str) {
        int r = r(i);
        int a2 = a(str);
        return r + t(a2) + a2;
    }

    public static int i(int i, byte[] bArr) {
        return r(i) + t(bArr.length) + bArr.length;
    }

    public static int l(int i, long j) {
        return q(j) + r(i);
    }

    public static void m(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i4 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i5 = remaining + arrayOffset;
                    while (i4 < length) {
                        int i6 = i4 + arrayOffset;
                        if (i6 >= i5 || (charAt = charSequence.charAt(i4)) >= 128) {
                            break;
                        }
                        array[i6] = (byte) charAt;
                        i4++;
                    }
                    if (i4 == length) {
                        i2 = arrayOffset + length;
                    } else {
                        i2 = arrayOffset + i4;
                        while (i4 < length) {
                            char charAt2 = charSequence.charAt(i4);
                            if (charAt2 < 128 && i2 < i5) {
                                i3 = i2 + 1;
                                array[i2] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i2 <= i5 - 2) {
                                int i7 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 6) | 960);
                                i2 = i7 + 1;
                                array[i7] = (byte) ((charAt2 & '?') | 128);
                                i4++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i2 <= i5 - 3) {
                                int i8 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> '\f') | 480);
                                int i9 = i8 + 1;
                                array[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i3 = i9 + 1;
                                array[i9] = (byte) ((charAt2 & '?') | 128);
                            } else if (i2 <= i5 - 4) {
                                int i10 = i4 + 1;
                                if (i10 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i10);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i11 = i2 + 1;
                                        array[i2] = (byte) ((codePoint >>> 18) | 240);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i13 = i12 + 1;
                                        array[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i2 = i13 + 1;
                                        array[i13] = (byte) ((codePoint & 63) | 128);
                                        i4 = i10;
                                        i4++;
                                    } else {
                                        i4 = i10;
                                    }
                                }
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i4 - 1);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i2);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i2 = i3;
                            i4++;
                        }
                    }
                    byteBuffer.position(i2 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt4 = charSequence.charAt(i4);
                    char c2 = charAt4;
                    if (charAt4 >= 128) {
                        if (charAt4 < 2048) {
                            i = (charAt4 >>> 6) | 960;
                        } else if (charAt4 < 55296 || 57343 < charAt4) {
                            byteBuffer.put((byte) ((charAt4 >>> '\f') | 480));
                            i = ((charAt4 >>> 6) & 63) | 128;
                        } else {
                            int i14 = i4 + 1;
                            if (i14 != charSequence.length()) {
                                char charAt5 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                    i4 = i14;
                                    i4++;
                                } else {
                                    i4 = i14;
                                }
                            }
                            throw new IllegalArgumentException(hj1.v(39, "Unpaired surrogate at index ", i4 - 1));
                        }
                        byteBuffer.put((byte) i);
                        c2 = (charAt4 & '?') | 128;
                    }
                    byteBuffer.put(c2 == 1 ? (byte) 1 : 0);
                    i4++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public static int q(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int r(int i) {
        return t(i << 3);
    }

    public static int s(int i) {
        if (i >= 0) {
            return t(i);
        }
        return 10;
    }

    public static int t(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public final void b(int i, ek2 ek2) throws IOException {
        f((i << 3) | 2);
        if (ek2.f < 0) {
            ek2.c();
        }
        f(ek2.f);
        ek2.a(this);
    }

    public final void c(int i, String str) throws IOException {
        f((i << 3) | 2);
        try {
            int t = t(str.length());
            if (t == t(str.length() * 3)) {
                int position = this.f4057a.position();
                if (this.f4057a.remaining() >= t) {
                    this.f4057a.position(position + t);
                    m(str, this.f4057a);
                    int position2 = this.f4057a.position();
                    this.f4057a.position(position);
                    f((position2 - position) - t);
                    this.f4057a.position(position2);
                    return;
                }
                throw new zj2(position + t, this.f4057a.limit());
            }
            f(a(str));
            m(str, this.f4057a);
        } catch (BufferOverflowException e) {
            zj2 zj2 = new zj2(this.f4057a.position(), this.f4057a.limit());
            zj2.initCause(e);
            throw zj2;
        }
    }

    public final void d(int i, byte[] bArr) throws IOException {
        f((i << 3) | 2);
        f(bArr.length);
        int length = bArr.length;
        if (this.f4057a.remaining() >= length) {
            this.f4057a.put(bArr, 0, length);
            return;
        }
        throw new zj2(this.f4057a.position(), this.f4057a.limit());
    }

    public final void e(int i) throws IOException {
        byte b2 = (byte) i;
        if (this.f4057a.hasRemaining()) {
            this.f4057a.put(b2);
            return;
        }
        throw new zj2(this.f4057a.position(), this.f4057a.limit());
    }

    public final void f(int i) throws IOException {
        while ((i & -128) != 0) {
            e((i & 127) | 128);
            i >>>= 7;
        }
        e(i);
    }

    public final void j(int i, int i2) throws IOException {
        f((i << 3) | i2);
    }

    public final void k(int i, int i2) throws IOException {
        f((i << 3) | 0);
        if (i2 >= 0) {
            f(i2);
        } else {
            p((long) i2);
        }
    }

    public final void n(int i, zh2 zh2) throws IOException {
        bg2 bg2;
        if (this.b == null) {
            ByteBuffer byteBuffer = this.f4057a;
            Logger logger = bg2.b;
            if (byteBuffer.hasArray()) {
                bg2 = new bg2.b(byteBuffer);
            } else if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
                throw new IllegalArgumentException("ByteBuffer is read-only");
            } else {
                bg2 = jj2.g ? new bg2.e(byteBuffer) : new bg2.d(byteBuffer);
            }
            this.b = bg2;
        } else {
            if (this.c != this.f4057a.position()) {
                this.b.c(this.f4057a.array(), this.c, this.f4057a.position() - this.c);
            }
            bg2 bg22 = this.b;
            bg22.g(i, zh2);
            bg22.b();
            this.c = this.f4057a.position();
        }
        this.c = this.f4057a.position();
        bg2 bg222 = this.b;
        bg222.g(i, zh2);
        bg222.b();
        this.c = this.f4057a.position();
    }

    public final void o(int i, long j) throws IOException {
        f((i << 3) | 0);
        p(j);
    }

    public final void p(long j) throws IOException {
        while ((-128 & j) != 0) {
            e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        e((int) j);
    }
}
