package defpackage;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: fp1  reason: default package */
/* compiled from: LazyHeaders */
public final class fp1 implements dp1 {
    public final Map<String, List<ep1>> b;
    public volatile Map<String, String> c;

    /* renamed from: fp1$a */
    /* compiled from: LazyHeaders */
    public static final class a {
        public static final String b;
        public static final Map<String, List<ep1>> c;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, List<ep1>> f1155a = c;

        static {
            String property = System.getProperty("http.agent");
            b = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(property)));
            }
            c = Collections.unmodifiableMap(hashMap);
        }
    }

    /* renamed from: fp1$b */
    /* compiled from: LazyHeaders */
    public static final class b implements ep1 {

        /* renamed from: a  reason: collision with root package name */
        public final String f1156a;

        public b(String str) {
            this.f1156a = str;
        }

        @Override // defpackage.ep1
        public String a() {
            return this.f1156a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f1156a.equals(((b) obj).f1156a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1156a.hashCode();
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("StringHeaderFactory{value='");
            i0.append(this.f1156a);
            i0.append('\'');
            i0.append('}');
            return i0.toString();
        }
    }

    public fp1(Map<String, List<ep1>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<ep1>> entry : this.b.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<ep1> value = entry.getValue();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                String a2 = value.get(i).a();
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                    if (i != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                hashMap.put(entry.getKey(), sb.toString());
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof fp1) {
            return this.b.equals(((fp1) obj).b);
        }
        return false;
    }

    @Override // defpackage.dp1
    public Map<String, String> getHeaders() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = Collections.unmodifiableMap(a());
                }
            }
        }
        return this.c;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("LazyHeaders{headers=");
        i0.append(this.b);
        i0.append('}');
        return i0.toString();
    }
}
