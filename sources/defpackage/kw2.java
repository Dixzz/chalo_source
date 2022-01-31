package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: kw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class kw2 implements fx2 {
    public static final ThreadLocal<Cipher> d = new jw2();

    /* renamed from: a  reason: collision with root package name */
    public final SecretKeySpec f2127a;
    public final int b;
    public final int c;

    public kw2(byte[] bArr, int i) throws GeneralSecurityException {
        mx2.a(bArr.length);
        this.f2127a = new SecretKeySpec(bArr, "AES");
        int blockSize = d.get().getBlockSize();
        this.c = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.b = i;
    }

    @Override // defpackage.fx2
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.b;
        if (length >= i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            int i2 = this.b;
            int i3 = length - i2;
            byte[] bArr3 = new byte[i3];
            Cipher cipher = d.get();
            byte[] bArr4 = new byte[this.c];
            System.arraycopy(bArr2, 0, bArr4, 0, this.b);
            cipher.init(2, this.f2127a, new IvParameterSpec(bArr4));
            if (cipher.doFinal(bArr, i2, i3, bArr3, 0) == i3) {
                return bArr3;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
