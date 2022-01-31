package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* renamed from: kx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class kx3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f2132a;
    public static final Class<?> b = nt3.f2603a;
    public static final boolean c;
    public static final boolean d;
    public static final c e;
    public static final boolean f;
    public static final boolean g;
    public static final long h = ((long) h(byte[].class));
    public static final boolean i;

    /* renamed from: kx3$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class a extends c {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.kx3.c
        public final byte a(Object obj, long j) {
            if (kx3.i) {
                return kx3.t(obj, j);
            }
            return kx3.u(obj, j);
        }

        @Override // defpackage.kx3.c
        public final void b(Object obj, long j, byte b) {
            if (kx3.i) {
                kx3.l(obj, j, b);
            } else {
                kx3.o(obj, j, b);
            }
        }

        @Override // defpackage.kx3.c
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.kx3.c
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.kx3.c
        public final void g(Object obj, long j, boolean z) {
            if (kx3.i) {
                kx3.l(obj, j, z ? (byte) 1 : 0);
            } else {
                kx3.o(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.kx3.c
        public final boolean h(Object obj, long j) {
            if (kx3.i) {
                if (kx3.t(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (kx3.u(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.kx3.c
        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        @Override // defpackage.kx3.c
        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    /* renamed from: kx3$b */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class b extends c {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.kx3.c
        public final byte a(Object obj, long j) {
            if (kx3.i) {
                return kx3.t(obj, j);
            }
            return kx3.u(obj, j);
        }

        @Override // defpackage.kx3.c
        public final void b(Object obj, long j, byte b) {
            if (kx3.i) {
                kx3.l(obj, j, b);
            } else {
                kx3.o(obj, j, b);
            }
        }

        @Override // defpackage.kx3.c
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // defpackage.kx3.c
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.kx3.c
        public final void g(Object obj, long j, boolean z) {
            if (kx3.i) {
                kx3.l(obj, j, z ? (byte) 1 : 0);
            } else {
                kx3.o(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // defpackage.kx3.c
        public final boolean h(Object obj, long j) {
            if (kx3.i) {
                if (kx3.t(obj, j) != 0) {
                    return true;
                }
                return false;
            } else if (kx3.u(obj, j) != 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override // defpackage.kx3.c
        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        @Override // defpackage.kx3.c
        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    /* renamed from: kx3$c */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f2133a;

        public c(Unsafe unsafe) {
            this.f2133a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void b(Object obj, long j, byte b);

        public abstract void c(Object obj, long j, double d);

        public abstract void d(Object obj, long j, float f);

        public final void e(Object obj, long j, int i) {
            this.f2133a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.f2133a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract boolean h(Object obj, long j);

        public abstract float i(Object obj, long j);

        public abstract double j(Object obj, long j);

        public final int k(Object obj, long j) {
            return this.f2133a.getInt(obj, j);
        }

        public final long l(Object obj, long j) {
            return this.f2133a.getLong(obj, j);
        }
    }

    /* renamed from: kx3$d */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class d extends c {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // defpackage.kx3.c
        public final byte a(Object obj, long j) {
            return this.f2133a.getByte(obj, j);
        }

        @Override // defpackage.kx3.c
        public final void b(Object obj, long j, byte b) {
            this.f2133a.putByte(obj, j, b);
        }

        @Override // defpackage.kx3.c
        public final void c(Object obj, long j, double d) {
            this.f2133a.putDouble(obj, j, d);
        }

        @Override // defpackage.kx3.c
        public final void d(Object obj, long j, float f) {
            this.f2133a.putFloat(obj, j, f);
        }

        @Override // defpackage.kx3.c
        public final void g(Object obj, long j, boolean z) {
            this.f2133a.putBoolean(obj, j, z);
        }

        @Override // defpackage.kx3.c
        public final boolean h(Object obj, long j) {
            return this.f2133a.getBoolean(obj, j);
        }

        @Override // defpackage.kx3.c
        public final float i(Object obj, long j) {
            return this.f2133a.getFloat(obj, j);
        }

        @Override // defpackage.kx3.c
        public final double j(Object obj, long j) {
            return this.f2133a.getDouble(obj, j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0122 A[SYNTHETIC, Splitter:B:32:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0282  */
    static {
        /*
        // Method dump skipped, instructions count: 646
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kx3.<clinit>():void");
    }

    public static byte a(byte[] bArr, long j) {
        return e.a(bArr, h + j);
    }

    public static int b(Object obj, long j) {
        return e.k(obj, j);
    }

    public static <T> T c(Class<T> cls) {
        try {
            return (T) f2132a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void d(Object obj, long j, double d2) {
        e.c(obj, j, d2);
    }

    public static void e(Object obj, long j, long j2) {
        e.f(obj, j, j2);
    }

    public static void f(Object obj, long j, Object obj2) {
        e.f2133a.putObject(obj, j, obj2);
    }

    public static void g(byte[] bArr, long j, byte b2) {
        e.b(bArr, h + j, b2);
    }

    public static int h(Class<?> cls) {
        if (g) {
            return e.f2133a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static long i(Object obj, long j) {
        return e.l(obj, j);
    }

    public static int j(Class<?> cls) {
        if (g) {
            return e.f2133a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Unsafe k() {
        try {
            return (Unsafe) AccessController.doPrivileged(new jx3());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void l(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int b3 = b(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        c cVar = e;
        cVar.e(obj, j2, ((255 & b2) << i2) | (b3 & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static boolean m(Object obj, long j) {
        return e.h(obj, j);
    }

    public static float n(Object obj, long j) {
        return e.i(obj, j);
    }

    public static void o(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i2 = (((int) j) & 3) << 3;
        c cVar = e;
        cVar.e(obj, j2, ((255 & b2) << i2) | (b(obj, j2) & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static boolean p(Class<?> cls) {
        if (!nt3.a()) {
            return false;
        }
        try {
            Class<?> cls2 = b;
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

    public static double q(Object obj, long j) {
        return e.j(obj, j);
    }

    public static Object r(Object obj, long j) {
        return e.f2133a.getObject(obj, j);
    }

    public static Field s() {
        Field field;
        Field field2;
        if (nt3.a()) {
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

    public static byte t(Object obj, long j) {
        return (byte) (b(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    public static byte u(Object obj, long j) {
        return (byte) (b(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }
}
