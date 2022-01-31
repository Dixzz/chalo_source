package defpackage;

import java.util.Collections;
import java.util.HashMap;

/* renamed from: lh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class lh3 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile lh3 f2220a;
    public static final lh3 b = new lh3(true);

    public lh3() {
        new HashMap();
    }

    public static lh3 a() {
        lh3 lh3 = f2220a;
        if (lh3 == null) {
            synchronized (lh3.class) {
                lh3 = f2220a;
                if (lh3 == null) {
                    lh3 = b;
                    f2220a = lh3;
                }
            }
        }
        return lh3;
    }

    public lh3(boolean z) {
        Collections.emptyMap();
    }
}
