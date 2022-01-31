package defpackage;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* renamed from: nx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class nx2 extends rw2 {
    public nx2(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // defpackage.rw2
    public final int[] b(int[] iArr, int i) {
        int length = iArr.length;
        if (length == 6) {
            int[] iArr2 = new int[16];
            int[] iArr3 = new int[16];
            rw2.f(iArr3, this.f3140a);
            iArr3[12] = iArr[0];
            iArr3[13] = iArr[1];
            iArr3[14] = iArr[2];
            iArr3[15] = iArr[3];
            rw2.g(iArr3);
            iArr3[4] = iArr3[12];
            iArr3[5] = iArr3[13];
            iArr3[6] = iArr3[14];
            iArr3[7] = iArr3[15];
            rw2.f(iArr2, Arrays.copyOf(iArr3, 8));
            iArr2[12] = i;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
    }

    @Override // defpackage.rw2
    public final int c() {
        return 24;
    }
}
