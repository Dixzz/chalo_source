package defpackage;

import java.lang.reflect.Method;

/* renamed from: qz5  reason: default package */
/* compiled from: SubscriberMethod */
public final class qz5 {

    /* renamed from: a  reason: collision with root package name */
    public final Method f3016a;
    public final tz5 b;
    public final Class<?> c;
    public String d;

    public qz5(Method method, tz5 tz5, Class<?> cls) {
        this.f3016a = method;
        this.b = tz5;
        this.c = cls;
    }

    public final synchronized void a() {
        if (this.d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f3016a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f3016a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qz5)) {
            return false;
        }
        a();
        qz5 qz5 = (qz5) obj;
        qz5.a();
        return this.d.equals(qz5.d);
    }

    public int hashCode() {
        return this.f3016a.hashCode();
    }
}
