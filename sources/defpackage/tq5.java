package defpackage;

import java.util.List;
import java.util.Map;

/* renamed from: tq5  reason: default package */
/* compiled from: Response */
public class tq5<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f3395a;
    public final Map<String, List<String>> b;
    public final int c;
    public final long d;
    public final T e;

    /* renamed from: tq5$b */
    /* compiled from: Response */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f3396a;
        public Map<String, List<String>> b;
        public final int c;
        public long d = 0;
        public T e;

        public b(int i) {
            this.c = i;
        }
    }

    public tq5(b bVar, a aVar) {
        this.c = bVar.c;
        this.f3395a = bVar.f3396a;
        this.b = bVar.b;
        this.d = bVar.d;
        this.e = bVar.e;
    }

    public String a(String str) {
        List<String> list;
        Map<String, List<String>> map = this.b;
        if (map == null || (list = map.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean b() {
        return this.c / 100 == 5;
    }

    public boolean c() {
        return hd3.A1(this.c);
    }

    public boolean d() {
        return this.c == 429;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Response{responseBody='");
        hj1.U0(i0, this.f3395a, '\'', ", responseHeaders=");
        i0.append(this.b);
        i0.append(", status=");
        i0.append(this.c);
        i0.append(", lastModified=");
        i0.append(this.d);
        i0.append('}');
        return i0.toString();
    }
}
