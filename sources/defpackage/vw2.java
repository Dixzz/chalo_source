package defpackage;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* renamed from: vw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class vw2 implements zn2 {
    public vw2(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, uq2 uq2) throws GeneralSecurityException {
        gj1.d1(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
    }
}
