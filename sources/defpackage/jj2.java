package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* renamed from: jj2  reason: default package */
public final class jj2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f1934a = Logger.getLogger(jj2.class.getName());
    public static final Unsafe b;
    public static final Class<?> c = pf2.f2798a;
    public static final boolean d;
    public static final boolean e;
    public static final d f;
    public static final boolean g;
    public static final boolean h;
    public static final long i = ((long) l(byte[].class));
    public static final long j;
    public static final boolean k;

    /* renamed from: jj2$a */
    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.jj2.d
        public final void b(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        @Override // defpackage.jj2.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.jj2.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.jj2.d
        public final void g(Object obj, long j, boolean z) {
            if (jj2.k) {
                jj2.c(obj, j, z ? (byte) 1 : 0);
            } else {
                jj2.i(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.jj2.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }

        @Override // defpackage.jj2.d
        public final void i(Object obj, long j, byte b) {
            if (jj2.k) {
                jj2.c(obj, j, b);
            } else {
                jj2.i(obj, j, b);
            }
        }

        @Override // defpackage.jj2.d
        public final boolean l(Object obj, long j) {
            if (jj2.k) {
                if (jj2.u(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (jj2.v(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.jj2.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // defpackage.jj2.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // defpackage.jj2.d
        public final byte o(Object obj, long j) {
            if (jj2.k) {
                return jj2.u(obj, j);
            }
            return jj2.v(obj, j);
        }
    }

    /* renamed from: jj2$b */
    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.jj2.d
        public final void b(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // defpackage.jj2.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.jj2.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.jj2.d
        public final void g(Object obj, long j, boolean z) {
            if (jj2.k) {
                jj2.c(obj, j, z ? (byte) 1 : 0);
            } else {
                jj2.i(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.jj2.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // defpackage.jj2.d
        public final void i(Object obj, long j, byte b) {
            if (jj2.k) {
                jj2.c(obj, j, b);
            } else {
                jj2.i(obj, j, b);
            }
        }

        @Override // defpackage.jj2.d
        public final boolean l(Object obj, long j) {
            if (jj2.k) {
                if (jj2.u(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (jj2.v(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.jj2.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // defpackage.jj2.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // defpackage.jj2.d
        public final byte o(Object obj, long j) {
            if (jj2.k) {
                return jj2.u(obj, j);
            }
            return jj2.v(obj, j);
        }
    }

    /* renamed from: jj2$c */
    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.jj2.d
        public final void b(long j, byte b) {
            this.f1935a.putByte(j, b);
        }

        @Override // defpackage.jj2.d
        public final void c(Object obj, long j, double d) {
            this.f1935a.putDouble(obj, j, d);
        }

        @Override // defpackage.jj2.d
        public final void d(Object obj, long j, float f) {
            this.f1935a.putFloat(obj, j, f);
        }

        @Override // defpackage.jj2.d
        public final void g(Object obj, long j, boolean z) {
            this.f1935a.putBoolean(obj, j, z);
        }

        @Override // defpackage.jj2.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            this.f1935a.copyMemory(bArr, jj2.i + j, (Object) null, j2, j3);
        }

        @Override // defpackage.jj2.d
        public final void i(Object obj, long j, byte b) {
            this.f1935a.putByte(obj, j, b);
        }

        @Override // defpackage.jj2.d
        public final boolean l(Object obj, long j) {
            return this.f1935a.getBoolean(obj, j);
        }

        @Override // defpackage.jj2.d
        public final float m(Object obj, long j) {
            return this.f1935a.getFloat(obj, j);
        }

        @Override // defpackage.jj2.d
        public final double n(Object obj, long j) {
            return this.f1935a.getDouble(obj, j);
        }

        @Override // defpackage.jj2.d
        public final byte o(Object obj, long j) {
            return this.f1935a.getByte(obj, j);
        }
    }

    /* renamed from: jj2$d */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f1935a;

        public d(Unsafe unsafe) {
            this.f1935a = unsafe;
        }

        public final long a(Field field) {
            return this.f1935a.objectFieldOffset(field);
        }

        public abstract void b(long j, byte b);

        public abstract void c(Object obj, long j, double d);

        public abstract void d(Object obj, long j, float f);

        public final void e(Object obj, long j, int i) {
            this.f1935a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.f1935a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract void h(byte[] bArr, long j, long j2, long j3);

        public abstract void i(Object obj, long j, byte b);

        public final int j(Object obj, long j) {
            return this.f1935a.getInt(obj, j);
        }

        public final long k(Object obj, long j) {
            return this.f1935a.getLong(obj, j);
        }

        public abstract boolean l(Object obj, long j);

        public abstract float m(Object obj, long j);

        public abstract double n(Object obj, long j);

        public abstract byte o(Object obj, long j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x007a A[SYNTHETIC, Splitter:B:12:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0127 A[SYNTHETIC, Splitter:B:31:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0294  */
    static {
        /*
        // Method dump skipped, instructions count: 665
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj2.<clinit>():void");
    }

    public static byte a(byte[] bArr, long j2) {
        return f.o(bArr, i + j2);
    }

    public static long b(Field field) {
        return f.a(field);
    }

    public static void c(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int o = o(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        d dVar = f;
        dVar.e(obj, j3, ((255 & b2) << i2) | (o & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static void d(Object obj, long j2, double d2) {
        f.c(obj, j2, d2);
    }

    public static void e(Object obj, long j2, long j3) {
        f.f(obj, j2, j3);
    }

    public static void f(Object obj, long j2, Object obj2) {
        f.f1935a.putObject(obj, j2, obj2);
    }

    public static void g(byte[] bArr, long j2, byte b2) {
        f.i(bArr, i + j2, b2);
    }

    public static Field h(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void i(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        d dVar = f;
        dVar.e(obj, j3, ((255 & b2) << i2) | (o(obj, j3) & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new kj2());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field k() {
        Field h2;
        if (pf2.a() && (h2 = h(Buffer.class, "effectiveDirectAddress")) != null) {
            return h2;
        }
        Field h3 = h(Buffer.class, "address");
        if (h3 == null || h3.getType() != Long.TYPE) {
            return null;
        }
        return h3;
    }

    public static int l(Class<?> cls) {
        if (h) {
            return f.f1935a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int m(Class<?> cls) {
        if (h) {
            return f.f1935a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static boolean n(Class<?> cls) {
        if (!pf2.a()) {
            return false;
        }
        try {
            Class<?> cls2 = c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int o(Object obj, long j2) {
        return f.j(obj, j2);
    }

    public static long p(Object obj, long j2) {
        return f.k(obj, j2);
    }

    public static boolean q(Object obj, long j2) {
        return f.l(obj, j2);
    }

    public static float r(Object obj, long j2) {
        return f.m(obj, j2);
    }

    public static double s(Object obj, long j2) {
        return f.n(obj, j2);
    }

    public static Object t(Object obj, long j2) {
        return f.f1935a.getObject(obj, j2);
    }

    public static byte u(Object obj, long j2) {
        return (byte) (o(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    public static byte v(Object obj, long j2) {
        return (byte) (o(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }
}
