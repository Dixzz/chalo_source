package defpackage;

import com.crashlytics.android.core.CrashlyticsPinningInfoProvider;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: s16  reason: default package */
/* compiled from: PinningTrustManager */
public class s16 implements X509TrustManager {
    public static final X509Certificate[] f = new X509Certificate[0];

    /* renamed from: a  reason: collision with root package name */
    public final TrustManager[] f3169a;
    public final t16 b;
    public final long c;
    public final List<byte[]> d = new LinkedList();
    public final Set<X509Certificate> e = Collections.synchronizedSet(new HashSet());

    public s16(t16 t16, CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(t16.f3296a);
            this.f3169a = instance.getTrustManagers();
            this.b = t16;
            this.c = crashlyticsPinningInfoProvider.getPinCreationTimeInMillis();
            String[] pins = crashlyticsPinningInfoProvider.getPins();
            for (String str : pins) {
                List<byte[]> list = this.d;
                int length = str.length();
                byte[] bArr = new byte[(length / 2)];
                for (int i = 0; i < length; i += 2) {
                    bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
                }
                list.add(bArr);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a A[LOOP:1: B:12:0x004d->B:25:0x007a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0082 A[EDGE_INSN: B:61:0x0082->B:26:0x0082 ?: BREAK  , SYNTHETIC] */
    @Override // javax.net.ssl.X509TrustManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkServerTrusted(java.security.cert.X509Certificate[] r10, java.lang.String r11) throws java.security.cert.CertificateException {
        /*
        // Method dump skipped, instructions count: 280
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s16.checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String):void");
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f;
    }
}
