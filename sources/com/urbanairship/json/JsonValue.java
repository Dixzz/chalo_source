package com.urbanairship.json;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.razorpay.AnalyticsConstants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class JsonValue implements Parcelable, cu5 {
    public static final Parcelable.Creator<JsonValue> CREATOR = new a();
    public static final JsonValue g = new JsonValue(null);
    public final Object f;

    public static class a implements Parcelable.Creator<JsonValue> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public JsonValue createFromParcel(Parcel parcel) {
            try {
                return JsonValue.p(parcel.readString());
            } catch (xt5 e) {
                yj5.e(e, "JsonValue - Unable to create JsonValue from parcel.", new Object[0]);
                return JsonValue.g;
            }
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public JsonValue[] newArray(int i) {
            return new JsonValue[i];
        }
    }

    public JsonValue(Object obj) {
        this.f = obj;
    }

    public static JsonValue p(String str) throws xt5 {
        if (hd3.G1(str)) {
            return g;
        }
        try {
            return r(new JSONTokener(str).nextValue());
        } catch (JSONException e) {
            throw new xt5("Unable to parse string", e);
        }
    }

    public static JsonValue q(double d) {
        Double valueOf = Double.valueOf(d);
        if (valueOf.isInfinite() || valueOf.isNaN()) {
            return g;
        }
        return x(Double.valueOf(d));
    }

    public static JsonValue r(Object obj) throws xt5 {
        if (obj == null || obj == JSONObject.NULL) {
            return g;
        }
        if (obj instanceof JsonValue) {
            return (JsonValue) obj;
        }
        if ((obj instanceof zt5) || (obj instanceof yt5) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String)) {
            return new JsonValue(obj);
        }
        if (obj instanceof cu5) {
            return ((cu5) obj).b();
        }
        if ((obj instanceof Byte) || (obj instanceof Short)) {
            return new JsonValue(Integer.valueOf(((Number) obj).intValue()));
        }
        if (obj instanceof Character) {
            return new JsonValue(((Character) obj).toString());
        }
        if (obj instanceof Float) {
            return new JsonValue(Double.valueOf(((Number) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (!d.isInfinite() && !d.isNaN()) {
                return new JsonValue(obj);
            }
            throw new xt5("Invalid Double value: " + d);
        }
        try {
            if (obj instanceof JSONArray) {
                return u((JSONArray) obj);
            }
            if (obj instanceof JSONObject) {
                return v((JSONObject) obj);
            }
            if (obj instanceof Collection) {
                return t((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return s(obj);
            }
            if (obj instanceof Map) {
                return w((Map) obj);
            }
            throw new xt5("Illegal object: " + obj);
        } catch (xt5 e) {
            throw e;
        } catch (Exception e2) {
            throw new xt5("Failed to wrap value.", e2);
        }
    }

    public static JsonValue s(Object obj) throws xt5 {
        int length = Array.getLength(obj);
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                arrayList.add(r(obj2));
            }
        }
        return new JsonValue(new yt5(arrayList));
    }

    public static JsonValue t(Collection collection) throws xt5 {
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(r(obj));
            }
        }
        return new JsonValue(new yt5(arrayList));
    }

    public static JsonValue u(JSONArray jSONArray) throws xt5 {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!jSONArray.isNull(i)) {
                arrayList.add(r(jSONArray.opt(i)));
            }
        }
        return new JsonValue(new yt5(arrayList));
    }

    public static JsonValue v(JSONObject jSONObject) throws xt5 {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.isNull(next)) {
                hashMap.put(next, r(jSONObject.opt(next)));
            }
        }
        return new JsonValue(new zt5(hashMap));
    }

    public static JsonValue w(Map<?, ?> map) throws xt5 {
        HashMap hashMap = new HashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw new xt5("Only string map keys are accepted.");
            } else if (entry.getValue() != null) {
                hashMap.put((String) entry.getKey(), r(entry.getValue()));
            }
        }
        return new JsonValue(new zt5(hashMap));
    }

    public static JsonValue x(Object obj) {
        JsonValue jsonValue = g;
        try {
            return r(obj);
        } catch (xt5 unused) {
            return jsonValue;
        }
    }

    public boolean a(boolean z) {
        Object obj = this.f;
        return (obj != null && (obj instanceof Boolean)) ? ((Boolean) obj).booleanValue() : z;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return this;
    }

    public double c(double d) {
        Object obj = this.f;
        if (obj == null) {
            return d;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    public float d(float f2) {
        Object obj = this.f;
        if (obj == null) {
            return f2;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return obj instanceof Number ? ((Number) obj).floatValue() : f2;
    }

    public int describeContents() {
        return 0;
    }

    public int e(int i) {
        Object obj = this.f;
        if (obj == null) {
            return i;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsonValue)) {
            return false;
        }
        JsonValue jsonValue = (JsonValue) obj;
        Object obj2 = this.f;
        if (obj2 == null) {
            return jsonValue.l();
        }
        if (obj2 instanceof Number) {
            Object obj3 = jsonValue.f;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof Double) || (obj3 instanceof Double)) {
                    if (Double.compare(c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), jsonValue.c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) == 0) {
                        return true;
                    }
                    return false;
                } else if ((obj2 instanceof Float) || (obj3 instanceof Float)) {
                    if (Float.compare(d(0.0f), jsonValue.d(0.0f)) == 0) {
                        return true;
                    }
                    return false;
                } else if (g(0) == jsonValue.g(0)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return obj2.equals(jsonValue.f);
    }

    public yt5 f() {
        Object obj = this.f;
        if (obj != null && (obj instanceof yt5)) {
            return (yt5) obj;
        }
        return null;
    }

    public long g(long j) {
        Object obj = this.f;
        if (obj == null) {
            return j;
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return obj instanceof Number ? ((Number) obj).longValue() : j;
    }

    public zt5 h() {
        Object obj = this.f;
        if (obj != null && (obj instanceof zt5)) {
            return (zt5) obj;
        }
        return null;
    }

    public int hashCode() {
        Object obj = this.f;
        if (obj != null) {
            return obj.hashCode() + 527;
        }
        return 17;
    }

    public String i() {
        Object obj = this.f;
        if (obj != null && (obj instanceof String)) {
            return (String) obj;
        }
        return null;
    }

    public String j(String str) {
        String i = i();
        return i == null ? str : i;
    }

    public boolean l() {
        return this.f == null;
    }

    public yt5 m() {
        yt5 f2 = f();
        return f2 == null ? yt5.g : f2;
    }

    public zt5 n() {
        zt5 h = h();
        return h == null ? zt5.g : h;
    }

    public String o() {
        String i = i();
        return i == null ? "" : i;
    }

    public String toString() {
        if (l()) {
            return AnalyticsConstants.NULL;
        }
        try {
            Object obj = this.f;
            if (obj instanceof String) {
                return JSONObject.quote((String) obj);
            }
            if (obj instanceof Number) {
                return JSONObject.numberToString((Number) obj);
            }
            if (!(obj instanceof zt5)) {
                if (!(obj instanceof yt5)) {
                    return String.valueOf(obj);
                }
            }
            return obj.toString();
        } catch (JSONException e) {
            yj5.e(e, "JsonValue - Failed to create JSON String.", new Object[0]);
            return "";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(toString());
    }

    public void y(JSONStringer jSONStringer) throws JSONException {
        if (l()) {
            jSONStringer.value((Object) null);
            return;
        }
        Object obj = this.f;
        if (obj instanceof yt5) {
            ((yt5) obj).k(jSONStringer);
        } else if (obj instanceof zt5) {
            ((zt5) obj).v(jSONStringer);
        } else {
            jSONStringer.value(obj);
        }
    }
}
