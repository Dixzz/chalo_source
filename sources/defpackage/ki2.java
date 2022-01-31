package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* renamed from: ki2  reason: default package */
public final class ki2 {
    public static final ki2 c = new ki2();

    /* renamed from: a  reason: collision with root package name */
    public final qi2 f2063a;
    public final ConcurrentMap<Class<?>, pi2<?>> b = new ConcurrentHashMap();

    public ki2() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        qi2 qi2 = null;
        for (int i = 0; i <= 0; i++) {
            try {
                qi2 = (qi2) Class.forName(strArr[0]).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                qi2 = null;
            }
            if (qi2 != null) {
                break;
            }
        }
        this.f2063a = qi2 == null ? new ph2() : qi2;
    }

    public final <T> pi2<T> a(Class<T> cls) {
        Charset charset = wg2.f3775a;
        Objects.requireNonNull(cls, "messageType");
        pi2<T> pi2 = (pi2<T>) this.b.get(cls);
        if (pi2 != null) {
            return pi2;
        }
        pi2<T> a2 = this.f2063a.a(cls);
        Objects.requireNonNull(a2, "schema");
        pi2<T> pi22 = (pi2<T>) this.b.putIfAbsent(cls, a2);
        return pi22 != null ? pi22 : a2;
    }

    public final <T> pi2<T> b(T t) {
        return a(t.getClass());
    }
}
