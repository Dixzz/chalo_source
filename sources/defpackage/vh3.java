package defpackage;

/* renamed from: vh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class vh3 implements dj3 {

    /* renamed from: a  reason: collision with root package name */
    public static final vh3 f3650a = new vh3();

    @Override // defpackage.dj3
    public final boolean a(Class<?> cls) {
        return uh3.class.isAssignableFrom(cls);
    }

    @Override // defpackage.dj3
    public final ej3 b(Class<?> cls) {
        if (!uh3.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (ej3) uh3.e(cls.asSubclass(uh3.class)).f(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
