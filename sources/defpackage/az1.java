package defpackage;

import java.util.HashMap;
import java.util.Map;

/* renamed from: az1  reason: default package */
public class az1 {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f354a = new HashMap();

    public final Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.f354a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return iz1.b(this.f354a, 1);
    }
}
