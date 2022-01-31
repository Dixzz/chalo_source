package server.zophop.utils;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import server.zophop.models.SimpleLogger;

public class UrlFetchUtils {
    public static String addRequestParam(String str, String str2, String str3, boolean z) {
        return hj1.c0(hj1.i0(str), z ? "" : "&", str2, "=", str3);
    }

    public static String sendGet(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.GET);
        int responseCode = httpURLConnection.getResponseCode();
        SimpleLogger.info("\nSending 'GET' request to URL : " + str);
        SimpleLogger.info("Response Code : " + responseCode);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine);
            } else {
                bufferedReader.close();
                return stringBuffer.toString();
            }
        }
    }

    public static String sendGetWithParameter(String str, Map map) throws Exception {
        String str2 = "";
        for (String str3 : map.keySet()) {
            StringBuilder i0 = hj1.i0(str2);
            i0.append(addRequestParam(str2, str3, (String) map.get(str3), false));
            str2 = i0.toString();
        }
        System.out.println(str2);
        System.out.println(str);
        return sendGet(str2);
    }

    public static String sendPost(String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
        httpURLConnection.setRequestProperty("content-Type", "text/plain; charset=utf-8");
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.writeBytes(str2);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpURLConnection.getResponseCode();
        SimpleLogger.info("response code :" + responseCode);
        if (responseCode < 200 || responseCode > 299) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine);
            } else {
                bufferedReader.close();
                SimpleLogger.info(stringBuffer.toString());
                return stringBuffer.toString();
            }
        }
    }
}
