package server.zophop.queue;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.TaskType;
import server.zophop.models.SimpleLogger;

public class RabbitMqTaskConvertor {
    public static final String DATA = "data";
    public static final String EVENT = "event";
    public static final String USERID = "userId";

    public static BasicTask getTask(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("userId");
        TaskType valueOf = TaskType.valueOf(jSONObject.getString("event"));
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        new TypeToken<HashMap<String, Object>>() {
            /* class server.zophop.queue.RabbitMqTaskConvertor.AnonymousClass1 */
        }.getType();
        return new BasicTask(string, valueOf, jsonToMap(jSONObject2));
    }

    public static String getTaskJson(BasicTask basicTask) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", basicTask.getUserId());
        jSONObject.put("event", basicTask.getType().name());
        jSONObject.put("data", new JSONObject((HashMap) basicTask.getData()));
        return jSONObject.toString();
    }

    public static String getTaskJson1(BasicTask basicTask) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", basicTask.getUserId());
        jsonObject.addProperty("event", basicTask.getType().name());
        jsonObject.addProperty("data", new Gson().toJson((HashMap) basicTask.getData()));
        SimpleLogger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

    public static Map<String, Object> jsonToMap(JSONObject jSONObject) throws JSONException {
        return jSONObject != JSONObject.NULL ? toMap(jSONObject) : new HashMap();
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }
}
