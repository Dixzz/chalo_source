package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.logging.LoggingConstants;

/* renamed from: ad5  reason: default package */
/* compiled from: SelectorEvaluator */
public class ad5 {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f153a;

    /* renamed from: ad5$a */
    /* compiled from: SelectorEvaluator */
    public enum a {
        Array,
        Boolean,
        Datetime,
        Null,
        Number,
        Object,
        String,
        Unknown
    }

    public ad5(JSONObject jSONObject) throws IllegalArgumentException {
        if (!jSONObject.has(LoggingConstants.OPERATOR) || !jSONObject.has("children")) {
            throw new IllegalArgumentException("Missing required keys: operator children");
        }
        this.f153a = jSONObject;
    }

    public static boolean a(Object obj, Object obj2) {
        if (d(obj) != d(obj2)) {
            return false;
        }
        int ordinal = d(obj).ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return e(obj).equals(e(obj2));
            }
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return true;
                }
                if (ordinal == 4) {
                    return f(obj).equals(f(obj2));
                }
                if (ordinal != 6) {
                    return false;
                }
            }
        }
        return obj.equals(obj2);
    }

    public static Object b(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (!jSONObject.has("property")) {
            return c(jSONObject, jSONObject2);
        }
        if (!jSONObject.has("property") || !jSONObject.has(FirebaseAnalytics.Param.VALUE)) {
            throw new IllegalArgumentException("Missing required keys: property/value");
        }
        String string = jSONObject.getString("property");
        string.hashCode();
        if (string.equals("event")) {
            return jSONObject2.opt(jSONObject.getString(FirebaseAnalytics.Param.VALUE));
        }
        if (!string.equals("literal")) {
            StringBuilder i0 = hj1.i0("Invalid operand: Invalid property type: ");
            i0.append(jSONObject.getString("property"));
            throw new IllegalArgumentException(i0.toString());
        } else if (d(jSONObject.get(FirebaseAnalytics.Param.VALUE)) == a.String && jSONObject.getString(FirebaseAnalytics.Param.VALUE).equalsIgnoreCase("now")) {
            return new Date();
        } else {
            Object obj = jSONObject.get(FirebaseAnalytics.Param.VALUE);
            if (d(obj).ordinal() != 5) {
                return obj;
            }
            JSONObject jSONObject3 = (JSONObject) obj;
            JSONObject optJSONObject = jSONObject3.optJSONObject("window");
            if (optJSONObject == null || !optJSONObject.has(FirebaseAnalytics.Param.VALUE) || !optJSONObject.has("unit")) {
                StringBuilder i02 = hj1.i0("Invalid window specification for value key ");
                i02.append(jSONObject3.toString());
                throw new IllegalArgumentException(i02.toString());
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            char c = 65535;
            Integer valueOf = Integer.valueOf(optJSONObject.getInt(FirebaseAnalytics.Param.VALUE) * -1);
            String string2 = optJSONObject.getString("unit");
            string2.hashCode();
            switch (string2.hashCode()) {
                case 99228:
                    if (string2.equals("day")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3208676:
                    if (string2.equals("hour")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3645428:
                    if (string2.equals("week")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104080000:
                    if (string2.equals("month")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                instance.add(6, valueOf.intValue());
            } else if (c == 1) {
                instance.add(10, valueOf.intValue());
            } else if (c == 2) {
                instance.add(6, valueOf.intValue() * 7);
            } else if (c == 3) {
                instance.add(6, valueOf.intValue() * 30);
            } else {
                StringBuilder i03 = hj1.i0("Invalid unit specification for window ");
                i03.append(optJSONObject.getString("unit"));
                throw new IllegalArgumentException(i03.toString());
            }
            return instance.getTime();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x05b7  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0750  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0770  */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x08bf  */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x08c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object c(org.json.JSONObject r17, org.json.JSONObject r18) throws org.json.JSONException {
        /*
        // Method dump skipped, instructions count: 2418
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ad5.c(org.json.JSONObject, org.json.JSONObject):java.lang.Object");
    }

    public static a d(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return a.Null;
        }
        if (obj instanceof String) {
            return a.String;
        }
        if (obj instanceof JSONArray) {
            return a.Array;
        }
        if (obj instanceof JSONObject) {
            return a.Object;
        }
        if ((obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Number)) {
            return a.Number;
        }
        if (obj instanceof Boolean) {
            return a.Boolean;
        }
        if (obj instanceof Date) {
            return a.Datetime;
        }
        return a.Unknown;
    }

    public static Boolean e(Object obj) {
        Boolean bool = Boolean.FALSE;
        boolean z = true;
        switch (d(obj).ordinal()) {
            case 0:
                if (((JSONArray) obj).length() <= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                return (Boolean) obj;
            case 2:
                if (((Date) obj).getTime() <= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                return bool;
            case 4:
                if (f(obj).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 5:
                if (((JSONObject) obj).length() <= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 6:
                if (((String) obj).length() <= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return bool;
        }
    }

    public static Double f(Object obj) {
        int ordinal = d(obj).ordinal();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (ordinal == 1) {
            if (((Boolean) obj).booleanValue()) {
                d = 1.0d;
            }
            return Double.valueOf(d);
        } else if (ordinal != 2) {
            if (ordinal != 4) {
                if (ordinal != 6) {
                    return null;
                }
            } else if (obj instanceof Double) {
                return (Double) obj;
            } else {
                if (obj instanceof Integer) {
                    return Double.valueOf(((Integer) obj).doubleValue());
                }
                if (obj instanceof Number) {
                    return Double.valueOf(((Number) obj).doubleValue());
                }
            }
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
                return Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
        } else {
            Date date = (Date) obj;
            if (date.getTime() > 0) {
                return new Double((double) date.getTime());
            }
            return null;
        }
    }
}
