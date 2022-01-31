package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: jx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class jx2 implements lo2 {

    /* renamed from: a  reason: collision with root package name */
    public final lr2 f1992a;
    public final int b;

    public jx2(lr2 lr2, int i) throws GeneralSecurityException {
        this.f1992a = lr2;
        this.b = i;
        if (i >= 10) {
            lr2.a(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // defpackage.lo2
    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!gj1.h1(this.f1992a.a(bArr2, this.b), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
