package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.ProviderException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* renamed from: xq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class xq2 implements vn2 {

    /* renamed from: a  reason: collision with root package name */
    public final SecretKey f3955a;

    public xq2(String str, KeyStore keyStore) throws GeneralSecurityException {
        SecretKey secretKey = (SecretKey) keyStore.getKey(str, null);
        this.f3955a = secretKey;
        if (secretKey == null) {
            String valueOf = String.valueOf(str);
            throw new InvalidKeyException(valueOf.length() != 0 ? "Keystore cannot load the key with ID: ".concat(valueOf) : new String("Keystore cannot load the key with ID: "));
        }
    }

    @Override // defpackage.vn2
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return c(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException unused) {
            try {
                Thread.sleep((long) ((int) (Math.random() * 100.0d)));
            } catch (InterruptedException unused2) {
            }
            return c(bArr, bArr2);
        }
    }

    @Override // defpackage.vn2
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return d(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException unused) {
            try {
                Thread.sleep((long) ((int) (Math.random() * 100.0d)));
            } catch (InterruptedException unused2) {
            }
            return d(bArr, bArr2);
        }
    }

    public final byte[] c(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length <= 2147483619) {
            byte[] bArr3 = new byte[(length + 28)];
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(1, this.f3955a);
            instance.updateAAD(bArr2);
            instance.doFinal(bArr, 0, length, bArr3, 12);
            System.arraycopy(instance.getIV(), 0, bArr3, 0, 12);
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public final byte[] d(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 28) {
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(2, this.f3955a, gCMParameterSpec);
            instance.updateAAD(bArr2);
            return instance.doFinal(bArr, 12, length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
