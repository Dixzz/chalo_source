package defpackage;

import java.util.Collections;
import java.util.HashMap;

/* renamed from: gg2  reason: default package */
public final class gg2 {

    /* renamed from: a  reason: collision with root package name */
    public static final gg2 f1255a = new gg2(true);

    static {
        try {
            Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
    }

    public gg2() {
        new HashMap();
    }

    public gg2(boolean z) {
        Collections.emptyMap();
    }

    public static gg2 a() {
        Class<?> cls = fg2.f1119a;
        if (cls != null) {
            try {
                return (gg2) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return f1255a;
    }
}
