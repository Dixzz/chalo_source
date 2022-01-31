package defpackage;

/* renamed from: aa3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class aa3 implements am2 {

    /* renamed from: a  reason: collision with root package name */
    public static final aa3 f139a = new aa3();

    @Override // defpackage.am2
    public final boolean a(Class<?> cls) {
        return ea3.class.isAssignableFrom(cls);
    }

    @Override // defpackage.am2
    public final zl2 b(Class<?> cls) {
        String str;
        if (!ea3.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            if (name.length() != 0) {
                str = "Unsupported message type: ".concat(name);
            } else {
                str = new String("Unsupported message type: ");
            }
            throw new IllegalArgumentException(str);
        }
        try {
            return (zl2) ea3.q(cls.asSubclass(ea3.class)).i(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
