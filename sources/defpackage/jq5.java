package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: jq5  reason: default package */
/* compiled from: TagGroupsMutation */
public class jq5 implements cu5 {
    public final Map<String, Set<String>> f;
    public final Map<String, Set<String>> g;
    public final Map<String, Set<String>> h;

    public jq5(Map<String, Set<String>> map, Map<String, Set<String>> map2, Map<String, Set<String>> map3) {
        this.f = map == null ? Collections.emptyMap() : map;
        this.g = map2 == null ? Collections.emptyMap() : map2;
        this.h = map3 == null ? Collections.emptyMap() : map3;
    }

    public static List<jq5> a(List<jq5> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (jq5 jq5 : list) {
            Map<String, Set<String>> map = jq5.f;
            if (map != null) {
                for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                    Set<String> value = entry.getValue();
                    String trim = entry.getKey().trim();
                    if (!trim.isEmpty() && value != null && !value.isEmpty()) {
                        Set set = (Set) hashMap3.get(trim);
                        if (set != null) {
                            set.addAll(value);
                        } else {
                            Set set2 = (Set) hashMap2.get(trim);
                            if (set2 != null) {
                                set2.removeAll(value);
                                if (set2.isEmpty()) {
                                    hashMap2.remove(trim);
                                }
                            }
                            Set set3 = (Set) hashMap.get(trim);
                            if (set3 == null) {
                                set3 = new HashSet();
                                hashMap.put(trim, set3);
                            }
                            set3.addAll(value);
                        }
                    }
                }
            }
            Map<String, Set<String>> map2 = jq5.g;
            if (map2 != null) {
                for (Map.Entry<String, Set<String>> entry2 : map2.entrySet()) {
                    Set<String> value2 = entry2.getValue();
                    String trim2 = entry2.getKey().trim();
                    if (!trim2.isEmpty() && value2 != null && !value2.isEmpty()) {
                        Set set4 = (Set) hashMap3.get(trim2);
                        if (set4 != null) {
                            set4.removeAll(value2);
                        } else {
                            Set set5 = (Set) hashMap.get(trim2);
                            if (set5 != null) {
                                set5.removeAll(value2);
                                if (set5.isEmpty()) {
                                    hashMap.remove(trim2);
                                }
                            }
                            Set set6 = (Set) hashMap2.get(trim2);
                            if (set6 == null) {
                                set6 = new HashSet();
                                hashMap2.put(trim2, set6);
                            }
                            set6.addAll(value2);
                        }
                    }
                }
            }
            Map<String, Set<String>> map3 = jq5.h;
            if (map3 != null) {
                for (Map.Entry<String, Set<String>> entry3 : map3.entrySet()) {
                    Set<String> value3 = entry3.getValue();
                    String trim3 = entry3.getKey().trim();
                    if (!trim3.isEmpty()) {
                        hashMap3.put(trim3, value3 == null ? new HashSet() : new HashSet(value3));
                        hashMap2.remove(trim3);
                        hashMap.remove(trim3);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!hashMap3.isEmpty()) {
            arrayList.add(new jq5(null, null, hashMap3));
        }
        if (!hashMap.isEmpty() || !hashMap2.isEmpty()) {
            arrayList.add(new jq5(hashMap, hashMap2, null));
        }
        return arrayList;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        Map<String, Set<String>> map = this.f;
        if (map != null && !map.isEmpty()) {
            s.e("add", JsonValue.x(this.f));
        }
        Map<String, Set<String>> map2 = this.g;
        if (map2 != null && !map2.isEmpty()) {
            s.e("remove", JsonValue.x(this.g));
        }
        Map<String, Set<String>> map3 = this.h;
        if (map3 != null && !map3.isEmpty()) {
            s.e("set", JsonValue.x(this.h));
        }
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jq5.class != obj.getClass()) {
            return false;
        }
        jq5 jq5 = (jq5) obj;
        Map<String, Set<String>> map = this.f;
        if (map == null ? jq5.f != null : !map.equals(jq5.f)) {
            return false;
        }
        Map<String, Set<String>> map2 = this.g;
        if (map2 == null ? jq5.g != null : !map2.equals(jq5.g)) {
            return false;
        }
        Map<String, Set<String>> map3 = this.h;
        Map<String, Set<String>> map4 = jq5.h;
        if (map3 != null) {
            return map3.equals(map4);
        }
        if (map4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Map<String, Set<String>> map = this.f;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, Set<String>> map2 = this.g;
        int hashCode2 = (hashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Set<String>> map3 = this.h;
        if (map3 != null) {
            i = map3.hashCode();
        }
        return hashCode2 + i;
    }
}
