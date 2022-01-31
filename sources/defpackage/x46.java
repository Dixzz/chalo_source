package defpackage;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: x46  reason: default package */
/* compiled from: HasBinary */
public class x46 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3884a = Logger.getLogger(x46.class.getName());

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    if (a(jSONArray.isNull(i) ? null : jSONArray.get(i))) {
                        return true;
                    }
                } catch (JSONException e) {
                    f3884a.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e);
                    return false;
                }
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    if (a(jSONObject.get(keys.next()))) {
                        return true;
                    }
                } catch (JSONException e2) {
                    f3884a.log(Level.WARNING, "An error occured while retrieving data from JSONObject", (Throwable) e2);
                }
            }
        }
        return false;
    }
}
