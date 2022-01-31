package defpackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* renamed from: t16  reason: default package */
/* compiled from: SystemKeyStore */
public class t16 {

    /* renamed from: a  reason: collision with root package name */
    public final KeyStore f3296a;
    public final HashMap<Principal, X509Certificate> b;

    public t16(InputStream inputStream, String str) {
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                instance.load(bufferedInputStream, str.toCharArray());
                try {
                    HashMap<Principal, X509Certificate> hashMap = new HashMap<>();
                    Enumeration<String> aliases = instance.aliases();
                    while (aliases.hasMoreElements()) {
                        X509Certificate x509Certificate = (X509Certificate) instance.getCertificate(aliases.nextElement());
                        if (x509Certificate != null) {
                            hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                        }
                    }
                    this.b = hashMap;
                    this.f3296a = instance;
                } catch (KeyStoreException e) {
                    throw new AssertionError(e);
                }
            } finally {
                bufferedInputStream.close();
            }
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        } catch (CertificateException e4) {
            throw new AssertionError(e4);
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }

    public boolean a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = this.b.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }
}
