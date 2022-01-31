package com.freshchat.consumer.sdk.e;

import android.content.Context;
import android.os.Build;
import com.freshchat.consumer.sdk.BuildConfig;
import com.freshchat.consumer.sdk.b.b;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cw;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class c {
    private int eA = 10000;
    private int eB = 45000;
    private final Context ez;
    private final String iq;

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.ez = applicationContext;
        this.iq = cw.bu(applicationContext);
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static String a(d dVar) {
        try {
            return ad.a(dVar.getInputStream(), b.da);
        } catch (Exception e) {
            q.a(e);
            return "";
        }
    }

    public static Map<String, String> ah(String str) throws IOException {
        HashMap hashMap = new HashMap();
        if (as.a(str)) {
            hashMap.put("Content-Type", str);
        }
        return hashMap;
    }

    private d b(HttpURLConnection httpURLConnection) throws IOException {
        InputStream a2 = a(httpURLConnection);
        d dVar = new d();
        dVar.setInputStream(a2);
        dVar.setStatusCode(httpURLConnection.getResponseCode());
        dVar.a(httpURLConnection.getHeaderFields());
        return dVar;
    }

    public d a(String str, Map<String, String> map) {
        try {
            HttpURLConnection a2 = a(str, FirebasePerformance.HttpMethod.GET, map);
            a2.setInstanceFollowRedirects(true);
            return b(a2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HttpURLConnection a(String str, String str2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        if (!FirebasePerformance.HttpMethod.GET.equals(str2)) {
            httpURLConnection.setDoOutput(true);
            if (!map.containsKey("Content-Type")) {
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
            }
            httpURLConnection.setUseCaches(false);
        }
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("X-FC-Platform", AnalyticsConstants.ANDROID);
        httpURLConnection.setRequestProperty("X-SDK-Version-Code", String.valueOf((int) BuildConfig.VERSION_CODE));
        StringBuilder sb = new StringBuilder();
        sb.append("FC-Android(");
        hj1.V0(sb, Build.VERSION.RELEASE, ")(", BuildConfig.VERSION_NAME, ")(");
        sb.append(Build.MODEL);
        sb.append(")(");
        sb.append(this.ez.getPackageName());
        sb.append(")(");
        sb.append(this.iq);
        sb.append(")");
        httpURLConnection.setRequestProperty("User-Agent", sb.toString());
        httpURLConnection.setRequestProperty("X-App-Package-Name", this.ez.getPackageName());
        if (k.d(map)) {
            for (String str3 : map.keySet()) {
                String str4 = map.get(str3);
                if (as.a(str4)) {
                    httpURLConnection.setRequestProperty(str3, str4);
                }
            }
        }
        httpURLConnection.setConnectTimeout(da());
        httpURLConnection.setReadTimeout(getReadTimeout());
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public d ae(String str) {
        return a(str, new HashMap());
    }

    public d af(String str) {
        try {
            return b(e(str, FirebasePerformance.HttpMethod.PUT));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public d ag(String str) {
        return c(str, null);
    }

    public d c(String str, String str2) {
        try {
            HttpURLConnection e = e(str, FirebasePerformance.HttpMethod.POST);
            OutputStream outputStream = e.getOutputStream();
            if (as.a(str2)) {
                outputStream.write(str2.getBytes(b.da));
            }
            outputStream.flush();
            outputStream.close();
            return b(e);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public d d(String str, String str2) {
        try {
            HttpURLConnection e = e(str, FirebasePerformance.HttpMethod.PUT);
            OutputStream outputStream = e.getOutputStream();
            outputStream.write(str2.getBytes(b.da));
            outputStream.flush();
            outputStream.close();
            return b(e);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public int da() {
        return this.eA;
    }

    public HttpURLConnection e(String str, String str2) throws IOException {
        return a(str, str2, new HashMap());
    }

    public int getReadTimeout() {
        return this.eB;
    }
}
