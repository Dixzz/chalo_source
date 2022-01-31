package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import defpackage.km1;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* renamed from: qm1  reason: default package */
/* compiled from: HttpUrlFetcher */
public class qm1 implements km1<InputStream> {
    public static final b k = new a();
    public final cp1 f;
    public final int g;
    public HttpURLConnection h;
    public InputStream i;
    public volatile boolean j;

    /* renamed from: qm1$a */
    /* compiled from: HttpUrlFetcher */
    public static class a implements b {
    }

    /* renamed from: qm1$b */
    /* compiled from: HttpUrlFetcher */
    public interface b {
    }

    public qm1(cp1 cp1, int i2) {
        this.f = cp1;
        this.g = i2;
    }

    @Override // defpackage.km1
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // defpackage.km1
    public void b() {
        InputStream inputStream = this.i;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.h;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final InputStream c(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new bm1("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.h = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.h.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.h.setConnectTimeout(this.g);
            this.h.setReadTimeout(this.g);
            this.h.setUseCaches(false);
            this.h.setDoInput(true);
            this.h.setInstanceFollowRedirects(false);
            this.h.connect();
            if (this.j) {
                return null;
            }
            int responseCode = this.h.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                HttpURLConnection httpURLConnection = this.h;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.i = new lt1(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        httpURLConnection.getContentEncoding();
                    }
                    this.i = httpURLConnection.getInputStream();
                }
                return this.i;
            } else if (i3 == 3) {
                String headerField = this.h.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    return c(new URL(url, headerField), i2 + 1, url, map);
                }
                throw new bm1("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new bm1(responseCode);
            } else {
                throw new bm1(this.h.getResponseMessage(), responseCode);
            }
        } else {
            throw new bm1("Too many (> 5) redirects!");
        }
    }

    @Override // defpackage.km1
    public void cancel() {
        this.j = true;
    }

    @Override // defpackage.km1
    public xl1 d() {
        return xl1.REMOTE;
    }

    @Override // defpackage.km1
    public void e(kl1 kl1, km1.a<? super InputStream> aVar) {
        int i2 = nt1.b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            InputStream c = c(this.f.d(), 0, null, this.f.b.getHeaders());
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                StringBuilder i0 = hj1.i0("Finished http url fetcher fetch in ");
                i0.append(nt1.a(elapsedRealtimeNanos));
                i0.append(" ms and loaded ");
                i0.append(c);
                i0.toString();
            }
            aVar.g(c);
        } catch (IOException e) {
            aVar.c(e);
        }
    }
}
