package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: s93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class s93 {
    public static volatile s93 b;
    public static final s93 c = new s93(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<r93, da3<?, ?>> f3198a;

    public s93() {
        this.f3198a = new HashMap();
    }

    public static s93 a() {
        s93 s93 = b;
        if (s93 == null) {
            synchronized (s93.class) {
                s93 = b;
                if (s93 == null) {
                    s93 = c;
                    b = s93;
                }
            }
        }
        return s93;
    }

    public s93(boolean z) {
        this.f3198a = Collections.emptyMap();
    }
}
