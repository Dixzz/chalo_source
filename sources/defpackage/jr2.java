package defpackage;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: jr2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class jr2 implements lo2 {

    /* renamed from: a  reason: collision with root package name */
    public final po2<lo2> f1973a;
    public final byte[] b = {0};

    public /* synthetic */ jr2(po2 po2) {
        this.f1973a = po2;
    }

    @Override // defpackage.lo2
    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (no2<lo2> no2 : this.f1973a.a(copyOf)) {
                try {
                    if (no2.d.equals(bw2.LEGACY)) {
                        no2.f2580a.a(copyOfRange, gj1.y1(bArr2, this.b));
                        return;
                    }
                    no2.f2580a.a(copyOfRange, bArr2);
                    return;
                } catch (GeneralSecurityException e) {
                    Logger logger = kr2.f2110a;
                    Level level = Level.INFO;
                    String valueOf = String.valueOf(e);
                    logger.logp(level, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", hj1.a0(new StringBuilder(valueOf.length() + 45), "tag prefix matches a key, but cannot verify: ", valueOf));
                }
            }
            for (no2<lo2> no22 : this.f1973a.a(xn2.f3943a)) {
                try {
                    no22.f2580a.a(bArr, bArr2);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
