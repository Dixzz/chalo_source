package defpackage;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import sun.misc.Unsafe;

/* renamed from: ln2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ln2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f2242a;
    public static final Class<?> b = u83.f3468a;
    public static final boolean c;
    public static final boolean d;
    public static final kn2 e;
    public static final boolean f;
    public static final boolean g;
    public static final long h = ((long) a(byte[].class));
    public static final boolean i = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* JADX WARNING: Removed duplicated region for block: B:30:0x012a A[SYNTHETIC, Splitter:B:30:0x012a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0289  */
    static {
        /*
        // Method dump skipped, instructions count: 653
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ln2.<clinit>():void");
    }

    public static int a(Class<?> cls) {
        if (g) {
            return e.p(cls);
        }
        return -1;
    }

    public static int b(Class<?> cls) {
        if (g) {
            return e.q(cls);
        }
        return -1;
    }

    public static boolean c(Class<?> cls) {
        if (!u83.a()) {
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

    public static Field d() {
        Field field;
        Field field2;
        if (u83.a()) {
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

    public static byte e(Object obj, long j) {
        return (byte) ((e.j(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static byte f(Object obj, long j) {
        return (byte) ((e.j(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & Constants.MAX_HOST_LENGTH);
    }

    public static void g(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        kn2 kn2 = e;
        int j3 = kn2.j(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        kn2.k(obj, j2, ((255 & b2) << i2) | (j3 & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static void h(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        kn2 kn2 = e;
        int i2 = (((int) j) & 3) << 3;
        kn2.k(obj, j2, ((255 & b2) << i2) | (kn2.j(obj, j2) & (~(Constants.MAX_HOST_LENGTH << i2))));
    }

    public static <T> T i(Class<T> cls) {
        try {
            return (T) f2242a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int j(Object obj, long j) {
        return e.j(obj, j);
    }

    public static void k(Object obj, long j, int i2) {
        e.k(obj, j, i2);
    }

    public static long l(Object obj, long j) {
        return e.l(obj, j);
    }

    public static void m(Object obj, long j, long j2) {
        e.m(obj, j, j2);
    }

    public static boolean n(Object obj, long j) {
        return e.c(obj, j);
    }

    public static void o(Object obj, long j, boolean z) {
        e.d(obj, j, z);
    }

    public static float p(Object obj, long j) {
        return e.e(obj, j);
    }

    public static void q(Object obj, long j, float f2) {
        e.f(obj, j, f2);
    }

    public static double r(Object obj, long j) {
        return e.g(obj, j);
    }

    public static void s(Object obj, long j, double d2) {
        e.h(obj, j, d2);
    }

    public static Object t(Object obj, long j) {
        return e.n(obj, j);
    }

    public static void u(Object obj, long j, Object obj2) {
        e.o(obj, j, obj2);
    }

    public static byte v(byte[] bArr, long j) {
        return e.a(bArr, h + j);
    }

    public static void w(byte[] bArr, long j, byte b2) {
        e.b(bArr, h + j, b2);
    }

    public static Unsafe x() {
        try {
            return (Unsafe) AccessController.doPrivileged(new fn2());
        } catch (Throwable unused) {
            return null;
        }
    }
}
