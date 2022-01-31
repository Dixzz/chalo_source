package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: gx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class gx2 implements lr2 {

    /* renamed from: a  reason: collision with root package name */
    public final SecretKey f1312a;
    public final byte[] b;
    public final byte[] c;

    public gx2(byte[] bArr) throws GeneralSecurityException {
        mx2.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f1312a = secretKeySpec;
        Cipher a2 = yw2.e.a("AES/ECB/NoPadding");
        a2.init(1, secretKeySpec);
        byte[] i1 = gj1.i1(a2.doFinal(new byte[16]));
        this.b = i1;
        this.c = gj1.i1(i1);
    }

    @Override // defpackage.lr2
    public final byte[] a(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher a2 = yw2.e.a("AES/ECB/NoPadding");
            a2.init(1, this.f1312a);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
            if (max * 16 == length) {
                bArr2 = gj1.J1(bArr, (max - 1) * 16, this.b, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) * 16, length);
                int length2 = copyOfRange.length;
                if (length2 < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[length2] = Byte.MIN_VALUE;
                    bArr2 = gj1.X1(copyOf, this.c);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = a2.doFinal(gj1.J1(bArr3, 0, bArr, i2 * 16, 16));
            }
            return Arrays.copyOf(a2.doFinal(gj1.X1(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
