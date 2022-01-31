package server.zophop.logging;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.ConnectionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import server.zophop.Constants;
import server.zophop.models.HTTPResponse;
import server.zophop.utils.HttpUtils;

public class ElasticHandler {
    private Map<String, String> _headers;

    public ElasticHandler() {
        HashMap hashMap = new HashMap();
        this._headers = hashMap;
        addBasicAuthToHeader(hashMap, Constants.ELASTIC_SEARCH_BASIC_AUTH_USERNAME, Constants.ELASTIC_SEARCH_BASIC_AUTH_PASSWORD);
    }

    private static void addBasicAuthToHeader(Map map, String str, String str2) {
        byte[] encodeBase64 = Base64.encodeBase64((str + ProductDiscountsObject.KEY_DELIMITER + str2).getBytes());
        StringBuilder i0 = hj1.i0("Basic ");
        i0.append(new String(encodeBase64));
        map.put("Authorization", i0.toString());
    }

    private String generateUrl(String str, String str2) {
        StringBuilder i0 = hj1.i0(Constants.ELASTIC_SEARCH_FORWARD_URL);
        i0.append(str.toLowerCase());
        i0.append(ConnectionFactory.DEFAULT_VHOST);
        i0.append(str2.toLowerCase());
        return i0.toString();
    }

    private ArrayList<JSONObject> getJsonObjects(JSONObject jSONObject, String str) throws Exception {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        this._headers.put("Content-type", "application/json");
        for (int i = 0; i < 10; i++) {
            JSONArray jSONArray = (JSONArray) ((JSONObject) HttpUtils.getDataByPost(str, this._headers, jSONObject.toString()).get("hits")).get("hits");
            if (jSONArray.length() == 0) {
                break;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add((JSONObject) jSONArray.get(i2));
            }
            jSONObject.put("search_after", new JSONArray(((JSONObject) jSONArray.get(jSONArray.length() - 1)).get("sort").toString()));
        }
        return arrayList;
    }

    private int responseCode(HTTPResponse hTTPResponse) {
        return hTTPResponse.code();
    }

    public int execute(JSONObject jSONObject, String str, String str2) throws Exception {
        return responseCode(execute(jSONObject, generateUrl(str, str2)));
    }

    public ArrayList<JSONObject> getPointAddedData(JSONObject jSONObject) throws Exception {
        return getJsonObjects(jSONObject, "http://13.232.94.4:9200/point_added/_search");
    }

    public ArrayList<JSONObject> getSessionsData(JSONObject jSONObject) throws Exception {
        return getJsonObjects(jSONObject, "http://13.232.94.4:9200/sessions/_search");
    }

    private HTTPResponse execute(JSONObject jSONObject, String str) throws Exception {
        return HttpUtils.postWithHeaders(str, this._headers, jSONObject.toString());
    }
}
