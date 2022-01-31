package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: zh  reason: default package */
/* compiled from: ViewModel */
public abstract class zh {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f4172a = new HashMap();
    public volatile boolean b = false;

    public <T> T a(String str) {
        T t;
        Map<String, Object> map = this.f4172a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.f4172a.get(str);
        }
        return t;
    }

    public void b() {
    }

    public <T> T c(String str, T t) {
        Object obj;
        synchronized (this.f4172a) {
            obj = this.f4172a.get(str);
            if (obj == null) {
                this.f4172a.put(str, t);
            }
        }
        if (obj != null) {
            t = obj;
        }
        if (this.b && (t instanceof Closeable)) {
            try {
                t.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return t;
    }
}
