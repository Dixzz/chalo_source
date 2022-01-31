package defpackage;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: zq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zq2 implements jo2 {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    public KeyStore f4202a = new yq2().f4081a;

    public final synchronized boolean a(String str) throws GeneralSecurityException {
        String str2;
        try {
        } catch (NullPointerException unused) {
            try {
                Thread.sleep(20);
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                this.f4202a = instance;
                instance.load(null);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            } catch (InterruptedException unused2) {
            }
            return this.f4202a.containsAlias(str2);
        }
        return this.f4202a.containsAlias(mx2.c("android-keystore://", str));
    }

    @Override // defpackage.jo2
    public final synchronized boolean zza(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    @Override // defpackage.jo2
    public final synchronized vn2 zzb(String str) throws GeneralSecurityException {
        xq2 xq2;
        xq2 = new xq2(mx2.c("android-keystore://", str), this.f4202a);
        byte[] a2 = lx2.a(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(a2, xq2.b(xq2.a(a2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return xq2;
    }
}
