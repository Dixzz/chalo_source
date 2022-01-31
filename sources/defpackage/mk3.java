package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: mk3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class mk3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f2389a = Logger.getLogger(mk3.class.getName());
    public static final Unsafe b;
    public static final Class<?> c = wg3.f3776a;
    public static final boolean d;
    public static final boolean e;
    public static final d f;
    public static final boolean g;
    public static final boolean h;
    public static final long i = ((long) j(byte[].class));
    public static final boolean j = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: mk3$a */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.mk3.d
        public final void a(Object obj, long j, double d) {
            d(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.mk3.d
        public final void b(Object obj, long j, float f) {
            c(obj, j, Float.floatToIntBits(f));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.mk3.d
        public final void e(Object obj, long j, boolean z) {
            if (mk3.j) {
                mk3.b(obj, j, z ? (byte) 1 : 0);
            } else {
                mk3.f(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.mk3.d
        public final void f(Object obj, long j, byte b) {
            if (mk3.j) {
                mk3.b(obj, j, b);
            } else {
                mk3.f(obj, j, b);
            }
        }

        @Override // defpackage.mk3.d
        public final boolean i(Object obj, long j) {
            if (mk3.j) {
                if (mk3.s(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (mk3.t(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.mk3.d
        public final float j(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // defpackage.mk3.d
        public final double k(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // defpackage.mk3.d
        public final byte l(Object obj, long j) {
            if (mk3.j) {
                return mk3.s(obj, j);
            }
            return mk3.t(obj, j);
        }
    }

    /* renamed from: mk3$b */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.mk3.d
        public final void a(Object obj, long j, double d) {
            this.f2390a.putDouble(obj, j, d);
        }

        @Override // defpackage.mk3.d
        public final void b(Object obj, long j, float f) {
            this.f2390a.putFloat(obj, j, f);
        }

        @Override // defpackage.mk3.d
        public final void e(Object obj, long j, boolean z) {
            this.f2390a.putBoolean(obj, j, z);
        }

        @Override // defpackage.mk3.d
        public final void f(Object obj, long j, byte b) {
            this.f2390a.putByte(obj, j, b);
        }

        @Override // defpackage.mk3.d
        public final boolean i(Object obj, long j) {
            return this.f2390a.getBoolean(obj, j);
        }

        @Override // defpackage.mk3.d
        public final float j(Object obj, long j) {
            return this.f2390a.getFloat(obj, j);
        }

        @Override // defpackage.mk3.d
        public final double k(Object obj, long j) {
            return this.f2390a.getDouble(obj, j);
        }

        @Override // defpackage.mk3.d
        public final byte l(Object obj, long j) {
            return this.f2390a.getByte(obj, j);
        }
    }

    /* renamed from: mk3$c */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.mk3.d
        public final void a(Object obj, long j, double d) {
            d(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.mk3.d
        public final void b(Object obj, long j, float f) {
            c(obj, j, Float.floatToIntBits(f));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.mk3.d
        public final void e(Object obj, long j, boolean z) {
            if (mk3.j) {
                mk3.b(obj, j, z ? (byte) 1 : 0);
            } else {
                mk3.f(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.mk3.d
        public final void f(Object obj, long j, byte b) {
            if (mk3.j) {
                mk3.b(obj, j, b);
            } else {
                mk3.f(obj, j, b);
            }
        }

        @Override // defpackage.mk3.d
        public final boolean i(Object obj, long j) {
            if (mk3.j) {
                if (mk3.s(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (mk3.t(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.mk3.d
        public final float j(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // defpackage.mk3.d
        public final double k(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // defpackage.mk3.d
        public final byte l(Object obj, long j) {
            if (mk3.j) {
                return mk3.s(obj, j);
            }
            return mk3.t(obj, j);
        }
    }

    /* renamed from: mk3$d */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f2390a;

        public d(Unsafe unsafe) {
            this.f2390a = unsafe;
        }

        public abstract void a(Object obj, long j, double d);

        public abstract void b(Object obj, long j, float f);

        public final void c(Object obj, long j, int i) {
            this.f2390a.putInt(obj, j, i);
        }

        public final void d(Object obj, long j, long j2) {
            this.f2390a.putLong(obj, j, j2);
        }

        public abstract void e(Object obj, long j, boolean z);

        public abstract void f(Object obj, long j, byte b);

        public final int g(Object obj, long j) {
            return this.f2390a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.f2390a.getLong(obj, j);
        }

        public abstract boolean i(Object obj, long j);

        public abstract float j(Object obj, long j);

        public abstract double k(Object obj, long j);

        public abstract byte l(Object obj, long j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0128 A[SYNTHETIC, Splitter:B:30:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0275  */
    static {
        /*
        // Method dump skipped, instructions count: 633
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mk3.<clinit>():void");
    }

    public static byte a(byte[] bArr, long j2) {
        return f.l(bArr, i + j2);
    }

    public static void b(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int l = l(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        d dVar = f;
        dVar.c(obj, j3, ((255 & b2) << i2) | (l & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static void c(Object obj, long j2, long j3) {
        f.d(obj, j2, j3);
    }

    public static void d(Object obj, long j2, Object obj2) {
        f.f2390a.putObject(obj, j2, obj2);
    }

    public static void e(byte[] bArr, long j2, byte b2) {
        f.f(bArr, i + j2, b2);
    }

    public static void f(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        d dVar = f;
        dVar.c(obj, j3, ((255 & b2) << i2) | (l(obj, j3) & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static Unsafe g() {
        try {
            return (Unsafe) AccessController.doPrivileged(new ok3());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field h() {
        Field field;
        Field field2;
        if (wg3.a()) {
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

    public static <T> T i(Class<T> cls) {
        try {
            return (T) b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int j(Class<?> cls) {
        if (h) {
            return f.f2390a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int k(Class<?> cls) {
        if (h) {
            return f.f2390a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static int l(Object obj, long j2) {
        return f.g(obj, j2);
    }

    public static boolean m(Class<?> cls) {
        if (!wg3.a()) {
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

    public static long n(Object obj, long j2) {
        return f.h(obj, j2);
    }

    public static boolean o(Object obj, long j2) {
        return f.i(obj, j2);
    }

    public static float p(Object obj, long j2) {
        return f.j(obj, j2);
    }

    public static double q(Object obj, long j2) {
        return f.k(obj, j2);
    }

    public static Object r(Object obj, long j2) {
        return f.f2390a.getObject(obj, j2);
    }

    public static byte s(Object obj, long j2) {
        return (byte) (l(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    public static byte t(Object obj, long j2) {
        return (byte) (l(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }
}
