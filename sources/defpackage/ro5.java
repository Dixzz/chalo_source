package defpackage;

import com.urbanairship.automation.Trigger;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ro5  reason: default package */
/* compiled from: Converters */
public final class ro5 {
    public static String b(List<String> list) {
        return JsonValue.x(list).toString();
    }

    public static List<String> g(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = JsonValue.p(str).m().iterator();
            while (it.hasNext()) {
                JsonValue next = it.next();
                if (next.i() != null) {
                    arrayList.add(next.o());
                }
            }
            return arrayList;
        } catch (xt5 e) {
            yj5.e(e, hj1.S("Unable to parse string array from string: ", str), new Object[0]);
            return null;
        }
    }

    public fm5 a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return fm5.a(JsonValue.p(str));
        } catch (xt5 e) {
            yj5.e(e, hj1.S("Unable to parse audience: ", str), new Object[0]);
            return null;
        }
    }

    public zt5 c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonValue.p(str).n();
        } catch (xt5 e) {
            yj5.e(e, hj1.S("Unable to parse json value: ", str), new Object[0]);
            return null;
        }
    }

    public bu5 d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return bu5.d(JsonValue.p(str));
        } catch (xt5 e) {
            yj5.e(e, hj1.S("Unable to parse trigger context: ", str), new Object[0]);
            return null;
        }
    }

    public JsonValue e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonValue.p(str);
        } catch (xt5 e) {
            yj5.e(e, hj1.S("Unable to parse json value: ", str), new Object[0]);
            return null;
        }
    }

    public String f(JsonValue jsonValue) {
        if (jsonValue == null) {
            return null;
        }
        return jsonValue.toString();
    }

    public pn5 h(String str) {
        if (str == null) {
            return null;
        }
        try {
            JsonValue p = JsonValue.p(str);
            return new pn5(Trigger.c(p.n().u("trigger")), p.n().u("event"));
        } catch (xt5 e) {
            yj5.e(e, hj1.S("Unable to parse trigger context: ", str), new Object[0]);
            return null;
        }
    }
}
