package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: ce  reason: default package */
/* compiled from: UnsafeUtil */
public final class ce {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f553a = Logger.getLogger(ce.class.getName());
    public static final Unsafe b;
    public static final Class<?> c = qb.f2920a;
    public static final boolean d;
    public static final boolean e;
    public static final e f;
    public static final boolean g;
    public static final boolean h;
    public static final long i = ((long) b(byte[].class));
    public static final boolean j = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: ce$a */
    /* compiled from: UnsafeUtil */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields = Unsafe.class.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* renamed from: ce$b */
    /* compiled from: UnsafeUtil */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.ce.e
        public boolean c(Object obj, long j) {
            if (ce.j) {
                if (ce.h(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (ce.i(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.ce.e
        public byte d(Object obj, long j) {
            if (ce.j) {
                return ce.h(obj, j);
            }
            return ce.i(obj, j);
        }

        @Override // defpackage.ce.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // defpackage.ce.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.ce.e
        public void k(Object obj, long j, boolean z) {
            if (ce.j) {
                ce.r(obj, j, z ? (byte) 1 : 0);
            } else {
                ce.s(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.ce.e
        public void l(Object obj, long j, byte b) {
            if (ce.j) {
                ce.r(obj, j, b);
            } else {
                ce.s(obj, j, b);
            }
        }

        @Override // defpackage.ce.e
        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.ce.e
        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: ce$c */
    /* compiled from: UnsafeUtil */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.ce.e
        public boolean c(Object obj, long j) {
            if (ce.j) {
                if (ce.h(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (ce.i(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.ce.e
        public byte d(Object obj, long j) {
            if (ce.j) {
                return ce.h(obj, j);
            }
            return ce.i(obj, j);
        }

        @Override // defpackage.ce.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // defpackage.ce.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.ce.e
        public void k(Object obj, long j, boolean z) {
            if (ce.j) {
                ce.r(obj, j, z ? (byte) 1 : 0);
            } else {
                ce.s(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.ce.e
        public void l(Object obj, long j, byte b) {
            if (ce.j) {
                ce.r(obj, j, b);
            } else {
                ce.s(obj, j, b);
            }
        }

        @Override // defpackage.ce.e
        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.ce.e
        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: ce$d */
    /* compiled from: UnsafeUtil */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.ce.e
        public boolean c(Object obj, long j) {
            return this.f554a.getBoolean(obj, j);
        }

        @Override // defpackage.ce.e
        public byte d(Object obj, long j) {
            return this.f554a.getByte(obj, j);
        }

        @Override // defpackage.ce.e
        public double e(Object obj, long j) {
            return this.f554a.getDouble(obj, j);
        }

        @Override // defpackage.ce.e
        public float f(Object obj, long j) {
            return this.f554a.getFloat(obj, j);
        }

        @Override // defpackage.ce.e
        public void k(Object obj, long j, boolean z) {
            this.f554a.putBoolean(obj, j, z);
        }

        @Override // defpackage.ce.e
        public void l(Object obj, long j, byte b) {
            this.f554a.putByte(obj, j, b);
        }

        @Override // defpackage.ce.e
        public void m(Object obj, long j, double d) {
            this.f554a.putDouble(obj, j, d);
        }

        @Override // defpackage.ce.e
        public void n(Object obj, long j, float f) {
            this.f554a.putFloat(obj, j, f);
        }
    }

    /* renamed from: ce$e */
    /* compiled from: UnsafeUtil */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f554a;

        public e(Unsafe unsafe) {
            this.f554a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f554a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f554a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j);

        public abstract byte d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract float f(Object obj, long j);

        public final int g(Object obj, long j) {
            return this.f554a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.f554a.getLong(obj, j);
        }

        public final Object i(Object obj, long j) {
            return this.f554a.getObject(obj, j);
        }

        public final long j(Field field) {
            return this.f554a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j, boolean z);

        public abstract void l(Object obj, long j, byte b);

        public abstract void m(Object obj, long j, double d);

        public abstract void n(Object obj, long j, float f);

        public final void o(Object obj, long j, int i) {
            this.f554a.putInt(obj, j, i);
        }

        public final void p(Object obj, long j, long j2) {
            this.f554a.putLong(obj, j, j2);
        }

        public final void q(Object obj, long j, Object obj2) {
            this.f554a.putObject(obj, j, obj2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0130 A[SYNTHETIC, Splitter:B:39:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0281  */
    static {
        /*
        // Method dump skipped, instructions count: 645
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ce.<clinit>():void");
    }

    public static <T> T a(Class<T> cls) {
        try {
            return (T) b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int b(Class<?> cls) {
        if (h) {
            return f.a(cls);
        }
        return -1;
    }

    public static int c(Class<?> cls) {
        if (h) {
            return f.b(cls);
        }
        return -1;
    }

    public static Field d() {
        Field field;
        Field field2;
        if (qb.a()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static boolean e(Class<?> cls) {
        if (!qb.a()) {
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

    public static boolean f(Object obj, long j2) {
        return f.c(obj, j2);
    }

    public static byte g(byte[] bArr, long j2) {
        return f.d(bArr, i + j2);
    }

    public static byte h(Object obj, long j2) {
        return (byte) ((l(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static byte i(Object obj, long j2) {
        return (byte) ((l(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static double j(Object obj, long j2) {
        return f.e(obj, j2);
    }

    public static float k(Object obj, long j2) {
        return f.f(obj, j2);
    }

    public static int l(Object obj, long j2) {
        return f.g(obj, j2);
    }

    public static long m(Object obj, long j2) {
        return f.h(obj, j2);
    }

    public static Object n(Object obj, long j2) {
        return f.i(obj, j2);
    }

    public static Unsafe o() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void p(Object obj, long j2, boolean z) {
        f.k(obj, j2, z);
    }

    public static void q(byte[] bArr, long j2, byte b2) {
        f.l(bArr, i + j2, b2);
    }

    public static void r(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int l = l(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        e eVar = f;
        eVar.o(obj, j3, ((255 & b2) << i2) | (l & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static void s(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        e eVar = f;
        eVar.o(obj, j3, ((255 & b2) << i2) | (l(obj, j3) & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static void t(Object obj, long j2, double d2) {
        f.m(obj, j2, d2);
    }

    public static void u(Object obj, long j2, float f2) {
        f.n(obj, j2, f2);
    }

    public static void v(Object obj, long j2, int i2) {
        f.o(obj, j2, i2);
    }

    public static void w(Object obj, long j2, long j3) {
        f.p(obj, j2, j3);
    }

    public static void x(Object obj, long j2, Object obj2) {
        f.q(obj, j2, obj2);
    }
}
