package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.rabbitmq.client.ConnectionFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: ya4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class ya4 extends jg4 {
    public ya4(lg4 lg4) {
        super(lg4);
    }

    public static byte[] s(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream2 = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream2.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream2.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream.close();
            }
            throw th;
        }
    }

    @Override // defpackage.jg4
    public final boolean n() {
        return false;
    }

    public final HttpURLConnection q(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(ConnectionFactory.DEFAULT_CONNECTION_TIMEOUT);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    public final boolean t() {
        k();
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ((ConnectivityManager) this.f3331a.f3627a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        return networkInfo != null && networkInfo.isConnected();
    }
}
