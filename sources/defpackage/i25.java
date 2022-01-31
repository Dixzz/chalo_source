package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: i25  reason: default package */
/* compiled from: UnsafeUtil */
public final class i25 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f1464a = Logger.getLogger(i25.class.getName());
    public static final Unsafe b;
    public static final Class<?> c = uz4.f3575a;
    public static final boolean d;
    public static final boolean e;
    public static final e f;
    public static final boolean g;
    public static final boolean h;
    public static final long i = ((long) c(byte[].class));
    public static final long j;
    public static final boolean k = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: i25$a */
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

    /* renamed from: i25$b */
    /* compiled from: UnsafeUtil */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.i25.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // defpackage.i25.e
        public boolean d(Object obj, long j) {
            if (i25.k) {
                if (i25.j(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (i25.k(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.i25.e
        public byte e(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // defpackage.i25.e
        public byte f(Object obj, long j) {
            if (i25.k) {
                return i25.j(obj, j);
            }
            return i25.k(obj, j);
        }

        @Override // defpackage.i25.e
        public double g(Object obj, long j) {
            return Double.longBitsToDouble(j(obj, j));
        }

        @Override // defpackage.i25.e
        public float h(Object obj, long j) {
            return Float.intBitsToFloat(i(obj, j));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.i25.e
        public void m(Object obj, long j, boolean z) {
            if (i25.k) {
                i25.t(obj, j, z ? (byte) 1 : 0);
            } else {
                i25.u(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.i25.e
        public void n(Object obj, long j, byte b) {
            if (i25.k) {
                i25.t(obj, j, b);
            } else {
                i25.u(obj, j, b);
            }
        }

        @Override // defpackage.i25.e
        public void o(Object obj, long j, double d) {
            r(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.i25.e
        public void p(Object obj, long j, float f) {
            q(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: i25$c */
    /* compiled from: UnsafeUtil */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.i25.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // defpackage.i25.e
        public boolean d(Object obj, long j) {
            if (i25.k) {
                if (i25.j(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (i25.k(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.i25.e
        public byte e(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // defpackage.i25.e
        public byte f(Object obj, long j) {
            if (i25.k) {
                return i25.j(obj, j);
            }
            return i25.k(obj, j);
        }

        @Override // defpackage.i25.e
        public double g(Object obj, long j) {
            return Double.longBitsToDouble(j(obj, j));
        }

        @Override // defpackage.i25.e
        public float h(Object obj, long j) {
            return Float.intBitsToFloat(i(obj, j));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.i25.e
        public void m(Object obj, long j, boolean z) {
            if (i25.k) {
                i25.t(obj, j, z ? (byte) 1 : 0);
            } else {
                i25.u(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.i25.e
        public void n(Object obj, long j, byte b) {
            if (i25.k) {
                i25.t(obj, j, b);
            } else {
                i25.u(obj, j, b);
            }
        }

        @Override // defpackage.i25.e
        public void o(Object obj, long j, double d) {
            r(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.i25.e
        public void p(Object obj, long j, float f) {
            q(obj, j, Float.floatToIntBits(f));
        }
    }

    /* renamed from: i25$d */
    /* compiled from: UnsafeUtil */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.i25.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            this.f1465a.copyMemory((Object) null, j, bArr, i25.i + j2, j3);
        }

        @Override // defpackage.i25.e
        public boolean d(Object obj, long j) {
            return this.f1465a.getBoolean(obj, j);
        }

        @Override // defpackage.i25.e
        public byte e(long j) {
            return this.f1465a.getByte(j);
        }

        @Override // defpackage.i25.e
        public byte f(Object obj, long j) {
            return this.f1465a.getByte(obj, j);
        }

        @Override // defpackage.i25.e
        public double g(Object obj, long j) {
            return this.f1465a.getDouble(obj, j);
        }

        @Override // defpackage.i25.e
        public float h(Object obj, long j) {
            return this.f1465a.getFloat(obj, j);
        }

        @Override // defpackage.i25.e
        public void m(Object obj, long j, boolean z) {
            this.f1465a.putBoolean(obj, j, z);
        }

        @Override // defpackage.i25.e
        public void n(Object obj, long j, byte b) {
            this.f1465a.putByte(obj, j, b);
        }

        @Override // defpackage.i25.e
        public void o(Object obj, long j, double d) {
            this.f1465a.putDouble(obj, j, d);
        }

        @Override // defpackage.i25.e
        public void p(Object obj, long j, float f) {
            this.f1465a.putFloat(obj, j, f);
        }
    }

    /* renamed from: i25$e */
    /* compiled from: UnsafeUtil */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f1465a;

        public e(Unsafe unsafe) {
            this.f1465a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f1465a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f1465a.arrayIndexScale(cls);
        }

        public abstract void c(long j, byte[] bArr, long j2, long j3);

        public abstract boolean d(Object obj, long j);

        public abstract byte e(long j);

        public abstract byte f(Object obj, long j);

        public abstract double g(Object obj, long j);

        public abstract float h(Object obj, long j);

        public final int i(Object obj, long j) {
            return this.f1465a.getInt(obj, j);
        }

        public final long j(Object obj, long j) {
            return this.f1465a.getLong(obj, j);
        }

        public final Object k(Object obj, long j) {
            return this.f1465a.getObject(obj, j);
        }

        public final long l(Field field) {
            return this.f1465a.objectFieldOffset(field);
        }

        public abstract void m(Object obj, long j, boolean z);

        public abstract void n(Object obj, long j, byte b);

        public abstract void o(Object obj, long j, double d);

        public abstract void p(Object obj, long j, float f);

        public final void q(Object obj, long j, int i) {
            this.f1465a.putInt(obj, j, i);
        }

        public final void r(Object obj, long j, long j2) {
            this.f1465a.putLong(obj, j, j2);
        }

        public final void s(Object obj, long j, Object obj2) {
            this.f1465a.putObject(obj, j, obj2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0130 A[SYNTHETIC, Splitter:B:39:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0287  */
    static {
        /*
        // Method dump skipped, instructions count: 651
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i25.<clinit>():void");
    }

    public static long a(ByteBuffer byteBuffer) {
        return f.j(byteBuffer, j);
    }

    public static <T> T b(Class<T> cls) {
        try {
            return (T) b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int c(Class<?> cls) {
        if (h) {
            return f.a(cls);
        }
        return -1;
    }

    public static int d(Class<?> cls) {
        if (h) {
            return f.b(cls);
        }
        return -1;
    }

    public static Field e() {
        Field field;
        Field field2;
        if (uz4.a()) {
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

    public static boolean f(Class<?> cls) {
        if (!uz4.a()) {
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

    public static boolean g(Object obj, long j2) {
        return f.d(obj, j2);
    }

    public static byte h(long j2) {
        return f.e(j2);
    }

    public static byte i(byte[] bArr, long j2) {
        return f.f(bArr, i + j2);
    }

    public static byte j(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static byte k(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static double l(Object obj, long j2) {
        return f.g(obj, j2);
    }

    public static float m(Object obj, long j2) {
        return f.h(obj, j2);
    }

    public static int n(Object obj, long j2) {
        return f.i(obj, j2);
    }

    public static long o(Object obj, long j2) {
        return f.j(obj, j2);
    }

    public static Object p(Object obj, long j2) {
        return f.k(obj, j2);
    }

    public static Unsafe q() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void r(Object obj, long j2, boolean z) {
        f.m(obj, j2, z);
    }

    public static void s(byte[] bArr, long j2, byte b2) {
        f.n(bArr, i + j2, b2);
    }

    public static void t(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int n = n(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        e eVar = f;
        eVar.q(obj, j3, ((255 & b2) << i2) | (n & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static void u(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        e eVar = f;
        eVar.q(obj, j3, ((255 & b2) << i2) | (n(obj, j3) & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static void v(Object obj, long j2, double d2) {
        f.o(obj, j2, d2);
    }

    public static void w(Object obj, long j2, float f2) {
        f.p(obj, j2, f2);
    }

    public static void x(Object obj, long j2, int i2) {
        f.q(obj, j2, i2);
    }

    public static void y(Object obj, long j2, long j3) {
        f.r(obj, j2, j3);
    }

    public static void z(Object obj, long j2, Object obj2) {
        f.s(obj, j2, obj2);
    }
}
