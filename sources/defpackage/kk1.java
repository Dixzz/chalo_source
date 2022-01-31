package defpackage;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: kk1  reason: default package */
/* compiled from: HurlStack */
public class kk1 extends fk1 {

    /* renamed from: a  reason: collision with root package name */
    public final b f2073a = null;
    public final SSLSocketFactory b = null;

    /* renamed from: kk1$a */
    /* compiled from: HurlStack */
    public static class a extends FilterInputStream {
        public final HttpURLConnection f;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.net.HttpURLConnection r2) {
            /*
                r1 = this;
                java.io.InputStream r0 = r2.getInputStream()     // Catch:{ IOException -> 0x0005 }
                goto L_0x0009
            L_0x0005:
                java.io.InputStream r0 = r2.getErrorStream()
            L_0x0009:
                r1.<init>(r0)
                r1.f = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.kk1.a.<init>(java.net.HttpURLConnection):void");
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            super.close();
            this.f.disconnect();
        }
    }

    /* renamed from: kk1$b */
    /* compiled from: HurlStack */
    public interface b {
        String a(String str);
    }

    public kk1() {
    }

    public static void b(HttpURLConnection httpURLConnection, wj1<?> wj1, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", wj1.k());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public static List<pj1> c(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new pj1(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    public static void e(HttpURLConnection httpURLConnection, wj1<?> wj1) throws IOException, ij1 {
        switch (wj1.g) {
            case -1:
                byte[] p = wj1.p();
                if (p != null) {
                    httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
                    b(httpURLConnection, wj1, p);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.GET);
                return;
            case 1:
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
                byte[] j = wj1.j();
                if (j != null) {
                    b(httpURLConnection, wj1, j);
                    return;
                }
                return;
            case 2:
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.PUT);
                byte[] j2 = wj1.j();
                if (j2 != null) {
                    b(httpURLConnection, wj1, j2);
                    return;
                }
                return;
            case 3:
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.DELETE);
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.OPTIONS);
                return;
            case 6:
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.TRACE);
                return;
            case 7:
                httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.PATCH);
                byte[] j3 = wj1.j();
                if (j3 != null) {
                    b(httpURLConnection, wj1, j3);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2  */
    @Override // defpackage.fk1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.jk1 a(defpackage.wj1<?> r6, java.util.Map<java.lang.String, java.lang.String> r7) throws java.io.IOException, defpackage.ij1 {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kk1.a(wj1, java.util.Map):jk1");
    }

    public HttpURLConnection d(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public kk1(b bVar) {
    }
}
