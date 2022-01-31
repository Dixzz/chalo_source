package defpackage;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: pq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class pq2 implements yn2 {

    /* renamed from: a  reason: collision with root package name */
    public final po2<yn2> f2841a;

    public pq2(po2<yn2> po2) {
        this.f2841a = po2;
    }

    @Override // defpackage.yn2
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        String str;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (no2<yn2> no2 : this.f2841a.a(copyOfRange)) {
                try {
                    return no2.f2580a.a(copyOfRange2, null);
                } catch (GeneralSecurityException e) {
                    Logger logger = qq2.f2979a;
                    Level level = Level.INFO;
                    String valueOf = String.valueOf(e.toString());
                    if (valueOf.length() != 0) {
                        str = "ciphertext prefix matches a key, but cannot decrypt: ".concat(valueOf);
                    } else {
                        str = new String("ciphertext prefix matches a key, but cannot decrypt: ");
                    }
                    logger.logp(level, "com.google.crypto.tink.hybrid.HybridDecryptWrapper$WrappedHybridDecrypt", "decrypt", str);
                }
            }
        }
        for (no2<yn2> no22 : this.f2841a.a(xn2.f3943a)) {
            try {
                return no22.f2580a.a(bArr, null);
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
