package defpackage;

/* renamed from: pf2  reason: default package */
public final class pf2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f2798a;
    public static final boolean b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f2798a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        b = cls2 != null;
    }

    public static boolean a() {
        return f2798a != null && !b;
    }
}
