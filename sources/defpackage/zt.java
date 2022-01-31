package defpackage;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: zt  reason: default package */
/* compiled from: DependencyFactory.kt */
public final class zt extends kk1 {
    public zt() {
        super(null);
    }

    @Override // defpackage.kk1
    public HttpURLConnection d(URL url) throws IOException {
        n86.e(url, "url");
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setIfModifiedSince(0);
        n86.d(httpURLConnection, "lConnection");
        return httpURLConnection;
    }
}
