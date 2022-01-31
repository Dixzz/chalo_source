package defpackage;

import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: bl5  reason: default package */
/* compiled from: BaseTagsAction */
public abstract class bl5 extends nk5 {
    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        if (ok5.b.f.l()) {
            return false;
        }
        if (ok5.b.d() == null && ok5.b.a() == null && ok5.b.c() == null) {
            return false;
        }
        return true;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        if (ok5.b.d() != null) {
            HashSet hashSet = new HashSet();
            hashSet.add(String.valueOf(ok5.b.d()));
            h(hashSet);
        }
        if (ok5.b.a() != null) {
            HashSet hashSet2 = new HashSet();
            Iterator<JsonValue> it = ok5.b.a().iterator();
            while (it.hasNext()) {
                JsonValue next = it.next();
                if (next.i() != null) {
                    hashSet2.add(next.i());
                }
            }
            h(hashSet2);
        }
        if (ok5.b.c() != null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : ((HashMap) ok5.b.c().u("channel").n().n()).entrySet()) {
                String str = (String) entry.getKey();
                HashSet hashSet3 = new HashSet();
                Iterator it2 = ((ArrayList) ((JsonValue) entry.getValue()).m().e()).iterator();
                while (it2.hasNext()) {
                    hashSet3.add(((JsonValue) it2.next()).i());
                }
                if (!hd3.G1(str) && !hashSet3.isEmpty()) {
                    hashMap.put(str, hashSet3);
                }
            }
            if (!hashMap.isEmpty()) {
                g(hashMap);
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((HashMap) ok5.b.c().u("named_user").n().n()).entrySet()) {
                String str2 = (String) entry2.getKey();
                HashSet hashSet4 = new HashSet();
                Iterator it3 = ((ArrayList) ((JsonValue) entry2.getValue()).m().e()).iterator();
                while (it3.hasNext()) {
                    hashSet4.add(((JsonValue) it3.next()).i());
                }
                if (!hd3.G1(str2) && !hashSet4.isEmpty()) {
                    hashMap2.put(str2, hashSet4);
                }
            }
            if (!hashMap2.isEmpty()) {
                i(hashMap2);
            }
            HashSet hashSet5 = new HashSet();
            Iterator<JsonValue> it4 = ok5.b.c().u(AnalyticsConstants.DEVICE).m().iterator();
            while (it4.hasNext()) {
                JsonValue next2 = it4.next();
                if (next2.i() != null) {
                    hashSet5.add(next2.i());
                }
            }
            if (!hashSet5.isEmpty()) {
                h(hashSet5);
            }
        }
        return rk5.a();
    }

    public abstract void g(Map<String, Set<String>> map);

    public abstract void h(Set<String> set);

    public abstract void i(Map<String, Set<String>> map);

    public kp5 j() {
        return UAirship.l().j;
    }
}
