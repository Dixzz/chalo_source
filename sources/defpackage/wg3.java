package defpackage;

/* renamed from: wg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class wg3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3776a;
    public static final boolean b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f3776a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        b = cls2 != null;
    }

    public static boolean a() {
        return f3776a != null && !b;
    }
}
