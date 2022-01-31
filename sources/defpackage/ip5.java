package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ip5  reason: default package */
/* compiled from: TagSelector */
public class ip5 implements cu5 {
    public static final Map<String, Set<String>> j = Collections.unmodifiableMap(new HashMap());
    public final String f;
    public String g;
    public String h;
    public List<ip5> i;

    public ip5(String str, String str2) {
        this.f = "tag";
        this.g = str;
        this.h = str2;
    }

    public static ip5 d(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        if (n.f.containsKey("tag")) {
            String i2 = n.u("tag").i();
            if (i2 != null) {
                return new ip5(i2, n.u("group").i());
            }
            throw new xt5(hj1.F(n, "tag", hj1.i0("Tag selector expected a tag: ")));
        } else if (n.f.containsKey("or")) {
            yt5 f2 = n.u("or").f();
            if (f2 != null) {
                return new ip5("or", f(f2));
            }
            throw new xt5(hj1.F(n, "or", hj1.i0("OR selector expected array of tag selectors: ")));
        } else if (n.f.containsKey("and")) {
            yt5 f3 = n.u("and").f();
            if (f3 != null) {
                return new ip5("and", f(f3));
            }
            throw new xt5(hj1.F(n, "and", hj1.i0("AND selector expected array of tag selectors: ")));
        } else if (n.f.containsKey("not")) {
            return new ip5("not", Collections.singletonList(d(n.u("not"))));
        } else {
            throw new xt5(hj1.R("Json value did not contain a valid selector: ", jsonValue));
        }
    }

    public static List<ip5> f(yt5 yt5) throws xt5 {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = yt5.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next()));
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new xt5("Expected 1 or more selectors");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.util.Collection<java.lang.String> r7, java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r8) {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ip5.a(java.util.Collection, java.util.Map):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    @Override // defpackage.cu5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.urbanairship.json.JsonValue b() {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ip5.b():com.urbanairship.json.JsonValue");
    }

    public boolean c() {
        if (!(this.h == null || this.g == null)) {
            return true;
        }
        List<ip5> list = this.i;
        if (list == null) {
            return false;
        }
        for (ip5 ip5 : list) {
            if (ip5.c()) {
                return true;
            }
        }
        return false;
    }

    public Map<String, Set<String>> e() {
        HashMap hashMap = new HashMap();
        if (this.h == null || this.g == null) {
            List<ip5> list = this.i;
            if (list != null) {
                for (ip5 ip5 : list) {
                    hd3.i(hashMap, ip5.e());
                }
            }
            return hashMap;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(this.g);
        hashMap.put(this.h, hashSet);
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ip5.class != obj.getClass()) {
            return false;
        }
        ip5 ip5 = (ip5) obj;
        if (!this.f.equals(ip5.f)) {
            return false;
        }
        String str = this.g;
        if (str == null ? ip5.g != null : !str.equals(ip5.g)) {
            return false;
        }
        String str2 = this.h;
        if (str2 == null ? ip5.h != null : !str2.equals(ip5.h)) {
            return false;
        }
        List<ip5> list = this.i;
        List<ip5> list2 = ip5.i;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f.hashCode() * 31;
        String str = this.g;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.h;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ip5> list = this.i;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return b().toString();
    }

    public ip5(String str, List<ip5> list) {
        this.f = str;
        this.i = new ArrayList(list);
    }
}
