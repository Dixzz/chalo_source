package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: rw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class rw2 implements fx2 {
    public static final int[] c = i(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: a  reason: collision with root package name */
    public int[] f3140a;
    public final int b;

    public rw2(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.f3140a = i(bArr);
            this.b = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public static void f(int[] iArr, int[] iArr2) {
        int[] iArr3 = c;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static void g(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            h(iArr, 0, 4, 8, 12);
            h(iArr, 1, 5, 9, 13);
            h(iArr, 2, 6, 10, 14);
            h(iArr, 3, 7, 11, 15);
            h(iArr, 0, 5, 10, 15);
            h(iArr, 1, 6, 11, 12);
            h(iArr, 2, 7, 8, 13);
            h(iArr, 3, 4, 9, 14);
        }
    }

    public static void h(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int i6 = i5 ^ iArr[i4];
        int i7 = (i6 >>> -16) | (i6 << 16);
        iArr[i4] = i7;
        int i8 = iArr[i3] + i7;
        iArr[i3] = i8;
        int i9 = iArr[i2] ^ i8;
        int i10 = (i9 >>> -12) | (i9 << 12);
        iArr[i2] = i10;
        int i11 = iArr[i] + i10;
        iArr[i] = i11;
        int i12 = iArr[i4] ^ i11;
        int i13 = (i12 >>> -8) | (i12 << 8);
        iArr[i4] = i13;
        int i14 = iArr[i3] + i13;
        iArr[i3] = i14;
        int i15 = iArr[i2] ^ i14;
        iArr[i2] = (i15 >>> -7) | (i15 << 7);
    }

    public static int[] i(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    @Override // defpackage.fx2
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        return d(ByteBuffer.wrap(bArr));
    }

    public abstract int[] b(int[] iArr, int i);

    public abstract int c();

    public final byte[] d(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= c()) {
            byte[] bArr = new byte[c()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            int remaining = byteBuffer.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer e = e(bArr, this.b + i2);
                if (i2 == i - 1) {
                    gj1.R1(allocate, byteBuffer, e, remaining % 64);
                } else {
                    gj1.R1(allocate, byteBuffer, e, 64);
                }
            }
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final ByteBuffer e(byte[] bArr, int i) {
        int[] b2 = b(i(bArr), i);
        int[] iArr = (int[]) b2.clone();
        g(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            b2[i2] = b2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(b2, 0, 16);
        return order;
    }
}
