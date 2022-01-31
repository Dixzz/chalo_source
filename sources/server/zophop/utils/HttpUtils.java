package server.zophop.utils;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import defpackage.di6;
import defpackage.fi6;
import defpackage.ji6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.json.JSONObject;
import server.zophop.models.HTTPResponse;

public class HttpUtils {
    private static final fi6 JSON = fi6.a.b("application/json; charset=utf-8");
    private static hi6 _client = new hi6();

    static {
        fi6.a aVar = fi6.f;
    }

    private static void addHeaders(ji6.a aVar, Map<String, String> map) throws Exception {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.a(entry.getKey().toString(), entry.getValue().toString());
            }
        }
    }

    private static void closeConnection(ni6 ni6) {
        ni6.m.close();
    }

    public static String generateUrl(String str, Map<String, String> map) {
        di6.a f = di6.h(str).f();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            f.b(entry.getKey().toString(), entry.getValue().toString());
        }
        return f.c().j;
    }

    public static JSONObject getDataByPost(String str, Map<String, String> map, String str2) throws Exception {
        mi6 create = mi6.create(JSON, str2);
        ji6.a aVar = new ji6.a();
        aVar.i(str);
        n86.f(create, ProductPromotionsObject.KEY_BODY);
        aVar.f(FirebasePerformance.HttpMethod.POST, create);
        addHeaders(aVar, map);
        ni6 execute = FirebasePerfOkHttpClient.execute(_client.a(aVar.b()));
        StringBuilder inputStreamToString = inputStreamToString(execute.m.byteStream());
        closeConnection(execute);
        return new JSONObject(inputStreamToString.toString());
    }

    private static HTTPResponse getResponse(ni6 ni6) {
        return new HTTPResponse(ni6.j, ni6.m.toString());
    }

    public static String getStreamableWithoutHeaders(String str, Map<String, String> map) throws Exception {
        String generateUrl = generateUrl(str, map);
        System.out.println(generateUrl);
        ji6.a aVar = new ji6.a();
        aVar.i(generateUrl);
        aVar.f(FirebasePerformance.HttpMethod.GET, null);
        ni6 execute = FirebasePerfOkHttpClient.execute(_client.a(aVar.b()));
        StringBuilder inputStreamToString = inputStreamToString(execute.m.byteStream());
        closeConnection(execute);
        return inputStreamToString.toString();
    }

    public static HTTPResponse getWithoutHeaders(String str, Map<String, String> map) throws IOException {
        String generateUrl = generateUrl(str, map);
        System.out.println(generateUrl);
        ji6.a aVar = new ji6.a();
        aVar.i(generateUrl);
        aVar.f(FirebasePerformance.HttpMethod.GET, null);
        ni6 execute = FirebasePerfOkHttpClient.execute(_client.a(aVar.b()));
        HTTPResponse response = getResponse(execute);
        closeConnection(execute);
        return response;
    }

    public static StringBuilder inputStreamToString(InputStream inputStream) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb;
            }
            sb.append(readLine);
        }
    }

    public static HTTPResponse postWithHeaders(String str, Map<String, String> map, String str2) throws Exception {
        mi6 create = mi6.create(JSON, str2);
        ji6.a aVar = new ji6.a();
        aVar.i(str);
        n86.f(create, ProductPromotionsObject.KEY_BODY);
        aVar.f(FirebasePerformance.HttpMethod.POST, create);
        addHeaders(aVar, map);
        ni6 execute = FirebasePerfOkHttpClient.execute(_client.a(aVar.b()));
        HTTPResponse response = getResponse(execute);
        closeConnection(execute);
        return response;
    }
}
