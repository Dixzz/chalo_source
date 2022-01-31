package com.urbanairship.actions;

import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import defpackage.op5;
import defpackage.qk5;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SetAttributesAction extends nk5 {

    public static class SetAttributesPredicate implements qk5.b {
        @Override // defpackage.qk5.b
        public boolean a(ok5 ok5) {
            return 1 != ok5.f2706a;
        }
    }

    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        if (ok5.b.f.l() || ok5.b.c() == null) {
            return false;
        }
        JsonValue u = ok5.b.c().u("channel");
        JsonValue jsonValue = JsonValue.g;
        if (u != jsonValue && !g(u)) {
            return false;
        }
        JsonValue u2 = ok5.b.c().u("named_user");
        if (u2 != jsonValue && !g(u2)) {
            return false;
        }
        if (u == jsonValue && u2 == jsonValue) {
            return false;
        }
        return true;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        if (ok5.b.c() != null) {
            op5 k = UAirship.l().j.k();
            for (Map.Entry<String, JsonValue> entry : ((HashMap) ok5.b.c().u("channel").n().n()).entrySet()) {
                h(k, entry);
            }
            k.a();
            up5 up5 = UAirship.l().o;
            wp5 wp5 = new wp5(up5, up5.h);
            for (Map.Entry<String, JsonValue> entry2 : ((HashMap) ok5.b.c().u("named_user").n().n()).entrySet()) {
                h(wp5, entry2);
            }
            wp5.a();
        }
        return rk5.a();
    }

    public final boolean g(JsonValue jsonValue) {
        if (jsonValue.h() == null) {
            return false;
        }
        JsonValue u = jsonValue.n().u("set");
        JsonValue jsonValue2 = JsonValue.g;
        if (u != jsonValue2) {
            if (!(u.h() != null)) {
                return false;
            }
        }
        JsonValue u2 = jsonValue.n().u("remove");
        if (u2 != jsonValue2) {
            if (!(u2.f() != null)) {
                return false;
            }
        }
        return true;
    }

    public final void h(op5 op5, Map.Entry<String, JsonValue> entry) {
        String key = entry.getKey();
        key.hashCode();
        if (key.equals("remove")) {
            Iterator it = ((ArrayList) entry.getValue().m().e()).iterator();
            while (it.hasNext()) {
                String i = ((JsonValue) it.next()).i();
                if (!op5.b(i)) {
                    op5.f2721a.add(new op5.a(op5, i, null));
                }
            }
        } else if (key.equals("set")) {
            for (Map.Entry<String, JsonValue> entry2 : entry.getValue().n().e()) {
                String key2 = entry2.getKey();
                Object obj = entry2.getValue().f;
                if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    if (!op5.b(key2)) {
                        op5.f2721a.add(new op5.a(op5, key2, Integer.valueOf(intValue)));
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    if (!op5.b(key2)) {
                        op5.f2721a.add(new op5.a(op5, key2, Long.valueOf(longValue)));
                    }
                } else if (obj instanceof Float) {
                    float floatValue = ((Float) obj).floatValue();
                    if (op5.b(key2)) {
                        continue;
                    } else if (Float.isNaN(floatValue) || Float.isInfinite(floatValue)) {
                        throw new NumberFormatException("Infinity or NaN: " + floatValue);
                    } else {
                        op5.f2721a.add(new op5.a(op5, key2, Float.valueOf(floatValue)));
                    }
                } else if (obj instanceof Double) {
                    double doubleValue = ((Double) obj).doubleValue();
                    if (op5.b(key2)) {
                        continue;
                    } else if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                        throw new NumberFormatException("Infinity or NaN: " + doubleValue);
                    } else {
                        op5.f2721a.add(new op5.a(op5, key2, Double.valueOf(doubleValue)));
                    }
                } else if (obj instanceof String) {
                    op5.d(key2, (String) obj);
                } else if (obj instanceof Date) {
                    Date date = (Date) obj;
                    if (!op5.b(key2)) {
                        op5.f2721a.add(new op5.a(op5, key2, ly5.a(date.getTime())));
                    }
                } else {
                    yj5.i("SetAttributesAction - Invalid value type for the key: %s", key2);
                }
            }
        }
    }
}
