package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: id5  reason: default package */
/* compiled from: Tweaks */
public class id5 {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap<String, b> f1507a = new ConcurrentHashMap();
    public final ConcurrentMap<String, b> b = new ConcurrentHashMap();
    public final ConcurrentMap<String, b> c = new ConcurrentHashMap();
    public final List<a> d = new ArrayList();

    /* renamed from: id5$a */
    /* compiled from: Tweaks */
    public interface a {
        void a();
    }

    /* renamed from: id5$b */
    /* compiled from: Tweaks */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f1508a;
        public final Object b;
        public final Object c;
        public final Number d;
        public final Number e;
        public final String f;

        public b(int i, Object obj, Number number, Number number2, Object obj2, String str) {
            this.f1508a = i;
            this.f = str;
            this.d = number;
            this.e = number2;
            if (!(number == null || number2 == null)) {
                if (!d(obj)) {
                    obj = Long.valueOf(Math.min(Math.max(((Number) obj).longValue(), number.longValue()), number2.longValue()));
                    String str2 = "Attempt to define a tweak \"" + str + "\" with default value " + obj + " out of its bounds [" + number + ", " + number2 + "]Tweak \"" + str + "\" new default value: " + obj + ".";
                }
                if (!d(obj2)) {
                    obj2 = Long.valueOf(Math.min(Math.max(((Number) obj2).longValue(), number.longValue()), number2.longValue()));
                    String str3 = "Attempt to define a tweak \"" + str + "\" with value " + obj + " out of its bounds [" + number + ", " + number2 + "]Tweak \"" + str + "\" new value: " + obj2 + ".";
                }
            }
            this.c = obj;
            this.b = obj2;
        }

        public static b a(JSONObject jSONObject) {
            Object obj;
            Number number;
            Number number2;
            Object obj2;
            int i;
            Number number3;
            Number number4;
            Object obj3;
            Object obj4;
            int i2;
            try {
                String string = jSONObject.getString("name");
                String string2 = jSONObject.getString("type");
                if ("number".equals(string2)) {
                    String string3 = jSONObject.getString("encoding");
                    if ("d".equals(string3)) {
                        i2 = 2;
                        obj4 = Double.valueOf(jSONObject.getDouble(FirebaseAnalytics.Param.VALUE));
                        obj3 = Double.valueOf(jSONObject.getDouble(ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT));
                        number4 = !jSONObject.isNull("minimum") ? Double.valueOf(jSONObject.getDouble("minimum")) : null;
                        if (!jSONObject.isNull("maximum")) {
                            number3 = Double.valueOf(jSONObject.getDouble("maximum"));
                            number = number3;
                            obj = obj4;
                            number2 = number4;
                            obj2 = obj3;
                            i = i2;
                        }
                    } else if (!"l".equals(string3)) {
                        return null;
                    } else {
                        obj4 = Long.valueOf(jSONObject.getLong(FirebaseAnalytics.Param.VALUE));
                        i2 = 3;
                        obj3 = Long.valueOf(jSONObject.getLong(ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT));
                        number4 = !jSONObject.isNull("minimum") ? Long.valueOf(jSONObject.getLong("minimum")) : null;
                        if (!jSONObject.isNull("maximum")) {
                            number3 = Long.valueOf(jSONObject.getLong("maximum"));
                            number = number3;
                            obj = obj4;
                            number2 = number4;
                            obj2 = obj3;
                            i = i2;
                        }
                    }
                    number3 = null;
                    number = number3;
                    obj = obj4;
                    number2 = number4;
                    obj2 = obj3;
                    i = i2;
                } else if ("boolean".equals(string2)) {
                    Object valueOf = Boolean.valueOf(jSONObject.getBoolean(FirebaseAnalytics.Param.VALUE));
                    obj2 = Boolean.valueOf(jSONObject.getBoolean(ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT));
                    number2 = null;
                    number = null;
                    obj = valueOf;
                    i = 1;
                } else {
                    if ("string".equals(string2)) {
                        Object string4 = jSONObject.getString(FirebaseAnalytics.Param.VALUE);
                        obj2 = jSONObject.getString(ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT);
                        number2 = null;
                        number = null;
                        obj = string4;
                        i = 4;
                    }
                    return null;
                }
                return new b(i, obj2, number2, number, obj, string);
            } catch (JSONException unused) {
            }
        }

        public Boolean b() {
            Boolean bool = Boolean.FALSE;
            Object obj = this.c;
            if (obj != null) {
                try {
                    bool = (Boolean) obj;
                } catch (ClassCastException unused) {
                }
            }
            Object obj2 = this.b;
            if (obj2 == null) {
                return bool;
            }
            try {
                return (Boolean) obj2;
            } catch (ClassCastException unused2) {
                return bool;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Number] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Number c() {
            /*
                r2 = this;
                r0 = 0
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.Object r1 = r2.c
                if (r1 == 0) goto L_0x000e
                java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ ClassCastException -> 0x000d }
                r0 = r1
                goto L_0x000e
            L_0x000d:
            L_0x000e:
                java.lang.Object r1 = r2.b
                if (r1 == 0) goto L_0x0015
                java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ ClassCastException -> 0x0015 }
                r0 = r1
            L_0x0015:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.id5.b.c():java.lang.Number");
        }

        public final boolean d(Object obj) {
            try {
                Number number = (Number) obj;
                return (Math.min(Math.max(number.longValue(), this.d.longValue()), this.e.longValue()) == this.d.longValue() || Math.min(Math.max(number.longValue(), this.d.longValue()), this.e.longValue()) == this.e.longValue()) ? false : true;
            } catch (ClassCastException unused) {
                return true;
            }
        }
    }

    public void a(String str, Object obj, Number number, Number number2, int i) {
        b bVar;
        if (str != null && !this.f1507a.containsKey(str)) {
            if (this.c.containsKey(str)) {
                bVar = this.c.get(str);
                this.c.remove(str);
            } else {
                bVar = new b(i, obj, null, null, obj, str);
            }
            this.f1507a.put(str, bVar);
            this.b.put(str, bVar);
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.d.get(i2).a();
            }
        }
    }

    public synchronized boolean b(String str, Object obj) {
        if (!this.f1507a.containsKey(str)) {
            return false;
        }
        return !this.f1507a.get(str).b.equals(obj);
    }

    public synchronized void c(String str, Object obj) {
        if (this.f1507a.containsKey(str)) {
            b bVar = this.f1507a.get(str);
            this.f1507a.put(str, new b(bVar.f1508a, bVar.c, bVar.d, bVar.e, obj, bVar.f));
        }
    }
}
