package defpackage;

import com.google.firebase.appindexing.Indexable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import defpackage.ju1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: hu1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hu1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ju1 f1428a;

    public /* synthetic */ hu1(ju1 ju1) {
        this.f1428a = ju1;
    }

    public final Object a(Object obj) {
        ju1 ju1 = this.f1428a;
        ju1.a aVar = (ju1.a) obj;
        Objects.requireNonNull(ju1);
        gj1.C("CctTransportBackend", "Making request to: %s", aVar.f1981a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(aVar.f1981a.openConnection()));
        httpURLConnection.setConnectTimeout(Indexable.MAX_BYTE_SIZE);
        httpURLConnection.setReadTimeout(ju1.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.0.0"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                ju1.f1980a.encode(aVar.b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (ConnectException | UnknownHostException unused) {
                        gj1.L("CctTransportBackend");
                        return new ju1.b(500, null, 0);
                    } catch (EncodingException | IOException unused2) {
                        gj1.L("CctTransportBackend");
                        return new ju1.b(400, null, 0);
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                gj1.L("CctTransportBackend");
                httpURLConnection.getHeaderField("Content-Type");
                gj1.L("CctTransportBackend");
                httpURLConnection.getHeaderField("Content-Encoding");
                gj1.L("CctTransportBackend");
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new ju1.b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
                }
                if (responseCode != 200) {
                    return new ju1.b(responseCode, null, 0);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                    try {
                        ju1.b bVar = new ju1.b(responseCode, null, ((ru1) xu1.a(new BufferedReader(new InputStreamReader(gZIPInputStream)))).f3133a);
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return bVar;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
            throw th;
            throw th;
            throw th;
            throw th;
        } catch (Throwable th4) {
            th.addSuppressed(th4);
        }
    }
}
