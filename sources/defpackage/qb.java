package defpackage;

/* renamed from: qb  reason: default package */
/* compiled from: Android */
public final class qb {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f2920a;
    public static final boolean b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f2920a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        b = cls2 != null;
    }

    public static boolean a() {
        return f2920a != null && !b;
    }
}
