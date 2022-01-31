package defpackage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: mh6  reason: default package */
/* compiled from: Challenge.kt */
public final class mh6 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f2378a;
    public final String b;

    public mh6(String str, Map<String, String> map) {
        String str2;
        n86.f(str, "scheme");
        n86.f(map, "authParams");
        this.b = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                n86.b(locale, "US");
                str2 = key.toLowerCase(locale);
                n86.b(str2, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            linkedHashMap.put(str2, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        n86.b(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f2378a = unmodifiableMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof mh6) {
            mh6 mh6 = (mh6) obj;
            return n86.a(mh6.b, this.b) && n86.a(mh6.f2378a, this.f2378a);
        }
    }

    public int hashCode() {
        return this.f2378a.hashCode() + hj1.r0(this.b, 899, 31);
    }

    public String toString() {
        return this.b + " authParams=" + this.f2378a;
    }
}
