package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: uq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class uq2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3542a;
    public final int b;
    public ts2 c;
    public vr2 d;
    public int e;

    public uq2(cv2 cv2) throws GeneralSecurityException {
        String str;
        String s = cv2.s();
        this.f3542a = s;
        if (s.equals(zo2.b)) {
            try {
                ws2 t = ws2.t(cv2.t(), s93.a());
                this.c = (ts2) xo2.d(cv2);
                this.b = t.s();
            } catch (ma3 e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        } else if (s.equals(zo2.f4194a)) {
            try {
                yr2 u = yr2.u(cv2.t(), s93.a());
                this.d = (vr2) xo2.d(cv2);
                this.e = u.s().t();
                this.b = this.e + u.t().t();
            } catch (ma3 e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            String valueOf = String.valueOf(s);
            if (valueOf.length() != 0) {
                str = "unsupported AEAD DEM key type: ".concat(valueOf);
            } else {
                str = new String("unsupported AEAD DEM key type: ");
            }
            throw new GeneralSecurityException(str);
        }
    }
}
