package defpackage;

/* renamed from: su3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class su3 implements zv3 {

    /* renamed from: a  reason: collision with root package name */
    public static final su3 f3259a = new su3();

    @Override // defpackage.zv3
    public final aw3 a(Class<?> cls) {
        if (!ru3.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (aw3) ru3.k(cls.asSubclass(ru3.class)).n(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }

    @Override // defpackage.zv3
    public final boolean b(Class<?> cls) {
        return ru3.class.isAssignableFrom(cls);
    }
}
