package defpackage;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: zo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zo2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4194a = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String b = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    public static final dw2 c = dw2.s();

    static {
        new fp2();
        new pp2();
        new sp2();
        new lp2();
        new yp2();
        new cq2();
        new vp2();
        new fq2();
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() throws GeneralSecurityException {
        boolean z;
        ir2.a();
        xo2.a(new fp2(), true);
        xo2.a(new lp2(), true);
        xo2.a(new pp2(), true);
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            z = true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            z = false;
        }
        if (z) {
            xo2.a(new sp2(), true);
        }
        xo2.a(new vp2(), true);
        xo2.a(new yp2(), true);
        xo2.a(new cq2(), true);
        xo2.a(new fq2(), true);
        xo2.b(new cp2());
    }
}
