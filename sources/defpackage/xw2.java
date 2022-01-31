package defpackage;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: xw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class xw2 implements vn2 {

    /* renamed from: a  reason: collision with root package name */
    public final fx2 f3973a;
    public final lo2 b;
    public final int c;

    public xw2(fx2 fx2, lo2 lo2, int i) {
        this.f3973a = fx2;
        this.b = lo2;
        this.c = i;
    }

    @Override // defpackage.vn2
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // defpackage.vn2
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.c;
        if (length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length - i);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length - this.c, length);
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.b.a(copyOfRange2, gj1.y1(bArr2, copyOfRange, copyOf));
            return this.f3973a.a(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
