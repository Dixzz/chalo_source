package defpackage;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: zp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zp2 implements vn2 {
    public static final byte[] c = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final cv2 f4200a;
    public final vn2 b;

    public zp2(cv2 cv2, vn2 vn2) {
        this.f4200a = cv2;
        this.b = vn2;
    }

    @Override // defpackage.vn2
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // defpackage.vn2
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((vn2) xo2.f(this.f4200a.s(), this.b.b(bArr3, c), vn2.class)).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
