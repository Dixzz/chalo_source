package defpackage;

import java.util.Objects;

/* renamed from: z86  reason: default package */
/* compiled from: Reflection */
public class z86 {

    /* renamed from: a  reason: collision with root package name */
    public static final a96 f4146a;
    public static final n96[] b = new n96[0];

    static {
        a96 a96 = null;
        try {
            a96 = (a96) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (a96 == null) {
            a96 = new a96();
        }
        f4146a = a96;
    }

    public static n96 a(Class cls) {
        Objects.requireNonNull(f4146a);
        return new h86(cls);
    }
}
