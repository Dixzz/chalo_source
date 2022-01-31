package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* renamed from: ix2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ix2 implements lr2 {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadLocal<Mac> f1581a;
    public final String b;
    public final Key c;
    public final int d;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public ix2(String str, Key key) throws GeneralSecurityException {
        char c2;
        int i;
        String str2;
        hx2 hx2 = new hx2(this);
        this.f1581a = hx2;
        this.b = str;
        this.c = key;
        if (key.getEncoded().length >= 16) {
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                i = 20;
            } else if (c2 == 1) {
                i = 32;
            } else if (c2 == 2) {
                i = 48;
            } else if (c2 != 3) {
                if (str.length() != 0) {
                    str2 = "unknown Hmac algorithm: ".concat(str);
                } else {
                    str2 = new String("unknown Hmac algorithm: ");
                }
                throw new NoSuchAlgorithmException(str2);
            } else {
                this.d = 64;
                hx2.get();
                return;
            }
            this.d = i;
            hx2.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    @Override // defpackage.lr2
    public final byte[] a(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= this.d) {
            this.f1581a.get().update(bArr);
            return Arrays.copyOf(this.f1581a.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
