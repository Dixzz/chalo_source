package defpackage;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: bp2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class bp2 implements vn2 {

    /* renamed from: a  reason: collision with root package name */
    public final po2<vn2> f463a;

    public /* synthetic */ bp2(po2 po2) {
        this.f463a = po2;
    }

    @Override // defpackage.vn2
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // defpackage.vn2
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        String str;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (no2<vn2> no2 : this.f463a.a(copyOfRange)) {
                try {
                    return no2.f2580a.b(copyOfRange2, bArr2);
                } catch (GeneralSecurityException e) {
                    Logger logger = cp2.f741a;
                    Level level = Level.INFO;
                    String valueOf = String.valueOf(e.toString());
                    if (valueOf.length() != 0) {
                        str = "ciphertext prefix matches a key, but cannot decrypt: ".concat(valueOf);
                    } else {
                        str = new String("ciphertext prefix matches a key, but cannot decrypt: ");
                    }
                    logger.logp(level, "com.google.crypto.tink.aead.AeadWrapper$WrappedAead", "decrypt", str);
                }
            }
        }
        for (no2<vn2> no22 : this.f463a.a(xn2.f3943a)) {
            try {
                return no22.f2580a.b(bArr, bArr2);
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
