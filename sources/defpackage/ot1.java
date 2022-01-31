package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ot1  reason: default package */
/* compiled from: LruCache */
public class ot1<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<T, Y> f2727a = new LinkedHashMap<>(100, 0.75f, true);
    public int b;
    public int c = 0;

    public ot1(int i) {
        this.b = i;
    }

    public synchronized Y a(T t) {
        return this.f2727a.get(t);
    }

    public int b(Y y) {
        return 1;
    }

    public void c(T t, Y y) {
    }

    public synchronized Y d(T t, Y y) {
        if (b(y) >= this.b) {
            c(t, y);
            return null;
        }
        Y put = this.f2727a.put(t, y);
        if (y != null) {
            this.c += b(y);
        }
        if (put != null) {
            this.c -= b(put);
        }
        e(this.b);
        return put;
    }

    public synchronized void e(int i) {
        while (this.c > i) {
            Map.Entry<T, Y> next = this.f2727a.entrySet().iterator().next();
            Y value = next.getValue();
            this.c -= b(value);
            T key = next.getKey();
            this.f2727a.remove(key);
            c(key, value);
        }
    }
}
