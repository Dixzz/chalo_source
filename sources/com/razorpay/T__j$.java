package com.razorpay;

import android.os.AsyncTask;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.rabbitmq.client.StringRpcServer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: Owl */
public final class T__j$ extends AsyncTask<String, Void, ResponseObject> {

    /* renamed from: a  reason: collision with root package name */
    private Callback f688a;
    private String b = null;
    private Map<String, String> c = new HashMap();
    private String d = null;

    private T__j$(Callback callback) {
        this.f688a = callback;
    }

    public static AsyncTask a(String str, Callback callback) {
        T__j$ t__j$ = new T__j$(callback);
        t__j$.b = FirebasePerformance.HttpMethod.GET;
        return t__j$.execute(str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(ResponseObject responseObject) {
        ResponseObject responseObject2 = responseObject;
        Callback callback = this.f688a;
        if (callback != null) {
            callback.run(responseObject2);
        }
    }

    public static AsyncTask a(String str, Map<String, String> map, Callback callback) {
        T__j$ t__j$ = new T__j$(callback);
        t__j$.b = FirebasePerformance.HttpMethod.GET;
        t__j$.c = map;
        return t__j$.execute(str);
    }

    public static AsyncTask a(String str, String str2, Map<String, String> map, Callback callback) {
        T__j$ t__j$ = new T__j$(callback);
        t__j$.b = FirebasePerformance.HttpMethod.POST;
        t__j$.d = str2;
        t__j$.c = map;
        return t__j$.execute(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ResponseObject doInBackground(String... strArr) {
        InputStream inputStream;
        ResponseObject responseObject = new ResponseObject();
        InputStream inputStream2 = null;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(strArr[0]).openConnection()));
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpsURLConnection.setRequestMethod(this.b);
            if (this.d != null) {
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.getOutputStream().write(this.d.getBytes(StandardCharsets.UTF_8));
            }
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setReadTimeout(Indexable.MAX_STRING_LENGTH);
            httpsURLConnection.connect();
            int responseCode = httpsURLConnection.getResponseCode();
            responseObject.setResponseCode(responseCode);
            if (responseCode >= 400) {
                inputStream = httpsURLConnection.getErrorStream();
            } else {
                inputStream = httpsURLConnection.getInputStream();
            }
            responseObject.setHeaders(httpsURLConnection.getHeaderFields());
            responseObject.setResponseResult(a(inputStream));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    AnalyticsUtil.reportError(e, "error", e.getMessage());
                }
            }
        } catch (Exception e2) {
            e2.getLocalizedMessage();
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
            if (0 != 0) {
                inputStream2.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream2.close();
                } catch (Exception e3) {
                    AnalyticsUtil.reportError(e3, "error", e3.getMessage());
                }
            }
            throw th;
        }
        return responseObject;
    }

    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringRpcServer.STRING_ENCODING));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }
}
