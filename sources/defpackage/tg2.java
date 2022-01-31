package defpackage;

/* renamed from: tg2  reason: default package */
public final class tg2 implements yh2 {

    /* renamed from: a  reason: collision with root package name */
    public static final tg2 f3351a = new tg2();

    @Override // defpackage.yh2
    public final xh2 a(Class<?> cls) {
        if (!ug2.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (xh2) ug2.l(cls.asSubclass(ug2.class)).i(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }

    @Override // defpackage.yh2
    public final boolean b(Class<?> cls) {
        return ug2.class.isAssignableFrom(cls);
    }
}
