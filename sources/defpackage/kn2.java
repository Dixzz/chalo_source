package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* renamed from: kn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class kn2 {

    /* renamed from: a  reason: collision with root package name */
    public final Unsafe f2085a;

    public kn2(Unsafe unsafe) {
        this.f2085a = unsafe;
    }

    public abstract byte a(Object obj, long j);

    public abstract void b(Object obj, long j, byte b);

    public abstract boolean c(Object obj, long j);

    public abstract void d(Object obj, long j, boolean z);

    public abstract float e(Object obj, long j);

    public abstract void f(Object obj, long j, float f);

    public abstract double g(Object obj, long j);

    public abstract void h(Object obj, long j, double d);

    public final long i(Field field) {
        return this.f2085a.objectFieldOffset(field);
    }

    public final int j(Object obj, long j) {
        return this.f2085a.getInt(obj, j);
    }

    public final void k(Object obj, long j, int i) {
        this.f2085a.putInt(obj, j, i);
    }

    public final long l(Object obj, long j) {
        return this.f2085a.getLong(obj, j);
    }

    public final void m(Object obj, long j, long j2) {
        this.f2085a.putLong(obj, j, j2);
    }

    public final Object n(Object obj, long j) {
        return this.f2085a.getObject(obj, j);
    }

    public final void o(Object obj, long j, Object obj2) {
        this.f2085a.putObject(obj, j, obj2);
    }

    public final int p(Class<?> cls) {
        return this.f2085a.arrayBaseOffset(cls);
    }

    public final int q(Class<?> cls) {
        return this.f2085a.arrayIndexScale(cls);
    }
}
