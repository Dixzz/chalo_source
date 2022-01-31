package defpackage;

import java.security.InvalidKeyException;

/* renamed from: qw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class qw2 extends rw2 {
    public qw2(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // defpackage.rw2
    public final int[] b(int[] iArr, int i) {
        int length = iArr.length;
        if (length == 3) {
            int[] iArr2 = new int[16];
            rw2.f(iArr2, this.f3140a);
            iArr2[12] = i;
            System.arraycopy(iArr, 0, iArr2, 13, 3);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
    }

    @Override // defpackage.rw2
    public final int c() {
        return 12;
    }
}
