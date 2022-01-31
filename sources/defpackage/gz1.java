package defpackage;

import android.annotation.TargetApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: gz1  reason: default package */
public final class gz1 {

    /* renamed from: a  reason: collision with root package name */
    public final cz1 f1319a;
    public final cb2 b;
    public boolean c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public final Map<Class<? extends iz1>, iz1> j;
    public final List<nz1> k;

    public gz1(cz1 cz1, cb2 cb2) {
        Objects.requireNonNull(cb2, "null reference");
        this.f1319a = cz1;
        this.b = cb2;
        this.g = 1800000;
        this.h = 3024000000L;
        this.j = new HashMap();
        this.k = new ArrayList();
    }

    @TargetApi(19)
    public static <T extends iz1> T c(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            if (e2 instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e2);
            } else if (e2 instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
            } else if (e2 instanceof ReflectiveOperationException) {
                throw new IllegalArgumentException("Linkage exception", e2);
            } else {
                throw new RuntimeException(e2);
            }
        }
    }

    public final void a(iz1 iz1) {
        Objects.requireNonNull(iz1, "null reference");
        Class<?> cls = iz1.getClass();
        if (cls.getSuperclass() == iz1.class) {
            iz1.c(b(cls));
            return;
        }
        throw new IllegalArgumentException();
    }

    public final <T extends iz1> T b(Class<T> cls) {
        T t = (T) this.j.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) c(cls);
        this.j.put(cls, t2);
        return t2;
    }

    public gz1(gz1 gz1) {
        this.f1319a = gz1.f1319a;
        this.b = gz1.b;
        this.d = gz1.d;
        this.e = gz1.e;
        this.f = gz1.f;
        this.g = gz1.g;
        this.h = gz1.h;
        this.k = new ArrayList(gz1.k);
        this.j = new HashMap(gz1.j.size());
        for (Map.Entry<Class<? extends iz1>, iz1> entry : gz1.j.entrySet()) {
            iz1 c2 = c(entry.getKey());
            entry.getValue().c(c2);
            this.j.put(entry.getKey(), c2);
        }
    }
}
