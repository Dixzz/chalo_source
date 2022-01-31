package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: gi  reason: default package */
/* compiled from: ViewModelStore */
public class gi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, zh> f1264a = new HashMap<>();

    public final void a() {
        for (zh zhVar : this.f1264a.values()) {
            zhVar.b = true;
            Map<String, Object> map = zhVar.f4172a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : zhVar.f4172a.values()) {
                        if (obj instanceof Closeable) {
                            try {
                                ((Closeable) obj).close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
            zhVar.b();
        }
        this.f1264a.clear();
    }
}
