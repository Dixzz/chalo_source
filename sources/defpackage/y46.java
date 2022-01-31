package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: y46  reason: default package */
/* compiled from: Binary */
public class y46 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3998a = Logger.getLogger(y46.class.getName());

    public static Object a(Object obj, List<byte[]> list) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_placeholder", true);
                jSONObject.put("num", list.size());
                list.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e) {
                f3998a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e);
                return null;
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, a(jSONArray2.get(i), list));
                } catch (JSONException e2) {
                    f3998a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e2);
                    return null;
                }
            }
            return jSONArray;
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = (JSONObject) obj;
            Iterator<String> keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject2.put(next, a(jSONObject3.get(next), list));
                } catch (JSONException e3) {
                    f3998a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e3);
                    return null;
                }
            }
            return jSONObject2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x006c */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.json.JSONObject] */
    public static Object b(Object obj, byte[][] bArr) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, b(jSONArray.get(i), bArr));
                } catch (JSONException e) {
                    f3998a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e);
                    return null;
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            obj = (JSONObject) obj;
            if (obj.optBoolean("_placeholder")) {
                int optInt = obj.optInt("num", -1);
                if (optInt < 0 || optInt >= bArr.length) {
                    return null;
                }
                return bArr[optInt];
            }
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    obj.put(next, b(obj.get(next), bArr));
                } catch (JSONException e2) {
                    f3998a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e2);
                    return null;
                }
            }
        }
        return obj;
    }
}
