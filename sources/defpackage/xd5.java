package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.be5;
import defpackage.je5;
import defpackage.qd5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: xd5  reason: default package */
/* compiled from: EditProtocol */
public class xd5 {
    public static final Class<?>[] e = new Class[0];
    public static final List<be5.c> f = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    public final Context f3917a;
    public final yc5 b;
    public final qd5 c;
    public final je5.j d;

    /* renamed from: xd5$b */
    /* compiled from: EditProtocol */
    public static class b extends Exception {
        public b(String str) {
            super(str);
        }

        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: xd5$c */
    /* compiled from: EditProtocol */
    public static class c extends Exception {
        public c(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: xd5$d */
    /* compiled from: EditProtocol */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final je5 f3918a;
        public final List<String> b;

        public d(je5 je5, List list, a aVar) {
            this.f3918a = je5;
            this.b = list;
        }
    }

    /* renamed from: xd5$e */
    /* compiled from: EditProtocol */
    public static class e extends b {
        public e(String str) {
            super(str);
        }
    }

    public xd5(Context context, yc5 yc5, qd5 qd5, je5.j jVar) {
        this.f3917a = context;
        this.b = yc5;
        this.c = qd5;
        this.d = jVar;
    }

    public final Object a(Object obj, String str, List<String> list) throws b, c {
        try {
            if ("java.lang.CharSequence".equals(str) || "boolean".equals(str)) {
                return obj;
            }
            if ("java.lang.Boolean".equals(str)) {
                return obj;
            }
            if (!"int".equals(str)) {
                if (!"java.lang.Integer".equals(str)) {
                    if (!"float".equals(str)) {
                        if (!"java.lang.Float".equals(str)) {
                            if ("android.graphics.drawable.Drawable".equals(str)) {
                                return b((JSONObject) obj, list);
                            }
                            if ("android.graphics.drawable.BitmapDrawable".equals(str)) {
                                return b((JSONObject) obj, list);
                            }
                            if ("android.graphics.drawable.ColorDrawable".equals(str)) {
                                return new ColorDrawable(((Number) obj).intValue());
                            }
                            throw new b("Don't know how to interpret type " + str + " (arg was " + obj + ")");
                        }
                    }
                    return Float.valueOf(((Number) obj).floatValue());
                }
            }
            return Integer.valueOf(((Number) obj).intValue());
        } catch (ClassCastException unused) {
            throw new b("Couldn't interpret <" + obj + "> as " + str);
        }
    }

    public final Drawable b(JSONObject jSONObject, List<String> list) throws b, c {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            if (!jSONObject.isNull("url")) {
                String string = jSONObject.getString("url");
                boolean z = false;
                if (jSONObject.isNull("dimensions")) {
                    i = 0;
                    i4 = 0;
                    i3 = 0;
                    i2 = 0;
                } else {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("dimensions");
                    int i5 = jSONObject2.getInt("left");
                    i4 = jSONObject2.getInt("right");
                    i3 = jSONObject2.getInt("top");
                    i2 = jSONObject2.getInt("bottom");
                    i = i5;
                    z = true;
                }
                try {
                    Bitmap b2 = this.c.b(string);
                    list.add(string);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), b2);
                    if (z) {
                        bitmapDrawable.setBounds(i, i3, i4, i2);
                    }
                    return bitmapDrawable;
                } catch (qd5.a e2) {
                    throw new c(e2.getMessage(), e2.getCause());
                }
            } else {
                throw new b("Can't construct a BitmapDrawable with a null url");
            }
        } catch (JSONException e3) {
            throw new b("Couldn't read drawable description", e3);
        }
    }

    public d c(JSONObject jSONObject) throws b, c {
        je5 je5;
        Integer num;
        ArrayList arrayList = new ArrayList();
        try {
            List<be5.c> e2 = e(jSONObject.getJSONArray("path"), this.b);
            if (e2.size() != 0) {
                if (jSONObject.getString("change_type").equals("property")) {
                    String string = jSONObject.getJSONObject("property").getString("classname");
                    if (string != null) {
                        try {
                            ce5 f2 = f(Class.forName(string), jSONObject.getJSONObject("property"));
                            JSONArray jSONArray = jSONObject.getJSONArray("args");
                            Object[] objArr = new Object[jSONArray.length()];
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                                objArr[i] = a(jSONArray2.get(0), jSONArray2.getString(1), arrayList);
                            }
                            String str = f2.d;
                            vd5 vd5 = str == null ? null : new vd5(f2.b, str, objArr, Void.TYPE);
                            if (vd5 != null) {
                                je5 = new je5.k(e2, vd5, f2.c);
                            } else {
                                throw new b("Can't update a read-only property " + f2.f558a + " (add a mutator to make this work)");
                            }
                        } catch (ClassNotFoundException e3) {
                            throw new b("Can't find class for visit path: " + string, e3);
                        }
                    } else {
                        throw new b("Can't bind an edit property without a target class");
                    }
                } else if (jSONObject.getString("change_type").equals("layout")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("args");
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray3.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = jSONArray3.optJSONObject(i2);
                        String string2 = optJSONObject.getString("view_id_name");
                        String string3 = optJSONObject.getString("anchor_id_name");
                        Integer i3 = i(-1, string2, this.b);
                        if (string3.equals("0")) {
                            num = 0;
                        } else if (string3.equals("-1")) {
                            num = -1;
                        } else {
                            num = i(-1, string3, this.b);
                        }
                        if (!(i3 == null || num == null)) {
                            arrayList2.add(new je5.g(i3.intValue(), optJSONObject.getInt("verb"), num.intValue()));
                        }
                    }
                    je5 = new je5.h(e2, arrayList2, jSONObject.getString("name"), this.d);
                } else {
                    throw new b("Can't figure out the edit type");
                }
                return new d(je5, arrayList, null);
            }
            throw new e("Edit will not be bound to any element in the UI.");
        } catch (NoSuchMethodException e4) {
            throw new b("Can't create property mutator", e4);
        } catch (JSONException e5) {
            throw new b("Can't interpret instructions due to JSONException", e5);
        }
    }

    public je5 d(JSONObject jSONObject, je5.i iVar) throws b {
        try {
            String string = jSONObject.getString("event_name");
            String string2 = jSONObject.getString("event_type");
            List<be5.c> e2 = e(jSONObject.getJSONArray("path"), this.b);
            if (e2.size() == 0) {
                throw new e("event '" + string + "' will not be bound to any element in the UI.");
            } else if ("click".equals(string2)) {
                return new je5.b(e2, 1, string, iVar);
            } else {
                if (AnalyticsConstants.SELECTED.equals(string2)) {
                    return new je5.b(e2, 4, string, iVar);
                }
                if ("text_changed".equals(string2)) {
                    return new je5.c(e2, string, iVar);
                }
                if ("detected".equals(string2)) {
                    return new je5.l(e2, string, iVar);
                }
                throw new b("Mixpanel can't track event type \"" + string2 + "\"");
            }
        } catch (JSONException e3) {
            throw new b("Can't interpret instructions due to JSONException", e3);
        }
    }

    public List<be5.c> e(JSONArray jSONArray, yc5 yc5) throws JSONException {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String n2 = hd3.n2(jSONObject, "prefix");
            String n22 = hd3.n2(jSONObject, "view_class");
            int optInt = jSONObject.optInt(FirebaseAnalytics.Param.INDEX, -1);
            String n23 = hd3.n2(jSONObject, "contentDescription");
            int optInt2 = jSONObject.optInt("id", -1);
            String n24 = hd3.n2(jSONObject, "mp_id_name");
            String n25 = hd3.n2(jSONObject, "tag");
            if ("shortest".equals(n2)) {
                i = 1;
            } else if (n2 != null) {
                return f;
            } else {
                i = 0;
            }
            Integer i3 = i(optInt2, n24, yc5);
            if (i3 == null) {
                return f;
            }
            arrayList.add(new be5.c(i, n22, optInt, i3.intValue(), n23, n25));
        }
        return arrayList;
    }

    public final ce5 f(Class<?> cls, JSONObject jSONObject) throws b {
        vd5 vd5;
        try {
            String string = jSONObject.getString("name");
            String str = null;
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                vd5 = new vd5(cls, jSONObject2.getString("selector"), e, Class.forName(jSONObject2.getJSONObject("result").getString("type")));
            } else {
                vd5 = null;
            }
            if (jSONObject.has("set")) {
                str = jSONObject.getJSONObject("set").getString("selector");
            }
            return new ce5(string, cls, vd5, str);
        } catch (NoSuchMethodException e2) {
            throw new b("Can't create property reader", e2);
        } catch (JSONException e3) {
            throw new b("Can't read property JSON", e3);
        } catch (ClassNotFoundException e4) {
            throw new b("Can't read property JSON, relevant arg/return class not found", e4);
        }
    }

    public ie5 g(JSONObject jSONObject) throws b {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray(AnalyticsConstants.PROPERTIES);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(f(cls, jSONArray2.getJSONObject(i2)));
                }
            }
            return new ie5(this.f3917a, arrayList, this.b);
        } catch (JSONException e2) {
            throw new b("Can't read snapshot configuration", e2);
        } catch (ClassNotFoundException e3) {
            throw new b("Can't resolve types for snapshot configuration", e3);
        }
    }

    public sd5<String, Object> h(JSONObject jSONObject) throws b {
        Object obj;
        try {
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("type");
            if ("number".equals(string2)) {
                String string3 = jSONObject.getString("encoding");
                if ("d".equals(string3)) {
                    obj = Double.valueOf(jSONObject.getDouble(FirebaseAnalytics.Param.VALUE));
                } else if ("l".equals(string3)) {
                    obj = Long.valueOf(jSONObject.getLong(FirebaseAnalytics.Param.VALUE));
                } else {
                    throw new b("number must have encoding of type \"l\" for long or \"d\" for double in: " + jSONObject);
                }
            } else if ("boolean".equals(string2)) {
                obj = Boolean.valueOf(jSONObject.getBoolean(FirebaseAnalytics.Param.VALUE));
            } else if ("string".equals(string2)) {
                obj = jSONObject.getString(FirebaseAnalytics.Param.VALUE);
            } else {
                throw new b("Unrecognized tweak type " + string2 + " in: " + jSONObject);
            }
            return new sd5<>(string, obj);
        } catch (JSONException e2) {
            throw new b("Can't read tweak update", e2);
        }
    }

    public final Integer i(int i, String str, yc5 yc5) {
        int i2;
        if (str == null) {
            i2 = -1;
        } else if (!((zc5) yc5).b.containsKey(str)) {
            return null;
        } else {
            i2 = ((zc5) yc5).b.get(str).intValue();
        }
        if (-1 != i2 && -1 != i && i2 != i) {
            return null;
        }
        if (-1 != i2) {
            return Integer.valueOf(i2);
        }
        return Integer.valueOf(i);
    }
}
