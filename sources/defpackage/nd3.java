package defpackage;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.gtm.zzbk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: nd3  reason: default package */
public final class nd3 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f2542a;
    public final List<zzbk> b;
    public final long c;
    public final long d;
    public final int e;
    public final boolean f;
    public final String g;

    public nd3(xb3 xb3, Map<String, String> map, long j, boolean z) {
        this(xb3, map, j, z, 0, 0, null);
    }

    public static String a(xb3 xb3, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            xb3.r("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    public static String b(xb3 xb3, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        xb3.r("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    public final String c(String str, String str2) {
        gj1.j(str);
        gj1.c(!str.startsWith("&"), "Short param name required");
        String str3 = this.f2542a.get(str);
        return str3 != null ? str3 : str2;
    }

    public final String toString() {
        StringBuilder i0 = hj1.i0("ht=");
        i0.append(this.d);
        if (this.c != 0) {
            i0.append(", dbId=");
            i0.append(this.c);
        }
        if (this.e != 0) {
            i0.append(", appUID=");
            i0.append(this.e);
        }
        ArrayList arrayList = new ArrayList(this.f2542a.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            i0.append(", ");
            i0.append(str);
            i0.append("=");
            i0.append(this.f2542a.get(str));
        }
        return i0.toString();
    }

    public nd3(xb3 xb3, Map<String, String> map, long j, boolean z, long j2, int i, List<zzbk> list) {
        List<zzbk> list2;
        String str;
        boolean z2;
        String a2;
        String a3;
        Objects.requireNonNull(xb3, "null reference");
        Objects.requireNonNull(map, "null reference");
        this.d = j;
        this.f = z;
        this.c = j2;
        this.e = i;
        if (list != null) {
            list2 = list;
        } else {
            list2 = Collections.emptyList();
        }
        this.b = list2;
        String str2 = null;
        if (list != null) {
            Iterator<zzbk> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zzbk next = it.next();
                if ("appendVersion".equals(next.f)) {
                    str = next.h;
                    break;
                }
            }
        }
        str = null;
        this.g = !TextUtils.isEmpty(str) ? str : str2;
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        while (true) {
            boolean z3 = false;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry<String, String> next2 = it2.next();
            String key = next2.getKey();
            if ((key != null ? key.toString().startsWith("&") : z3) && (a3 = a(xb3, next2.getKey())) != null) {
                hashMap.put(a3, b(xb3, next2.getValue()));
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key2 = entry.getKey();
            if (key2 == null) {
                z2 = false;
            } else {
                z2 = key2.toString().startsWith("&");
            }
            if (!z2 && (a2 = a(xb3, entry.getKey())) != null) {
                hashMap.put(a2, b(xb3, entry.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            ie3.e(hashMap, "_v", this.g);
            if (this.g.equals("ma4.0.0") || this.g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.f2542a = Collections.unmodifiableMap(hashMap);
    }
}
