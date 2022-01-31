package defpackage;

import defpackage.ru3;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: eu3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class eu3 {
    public static volatile eu3 b;
    public static volatile eu3 c;
    public static final eu3 d = new eu3(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, ru3.f<?, ?>> f1030a;

    /* renamed from: eu3$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1031a;
        public final int b;

        public a(Object obj, int i) {
            this.f1031a = obj;
            this.b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1031a == aVar.f1031a && this.b == aVar.b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f1031a) * 65535) + this.b;
        }
    }

    public eu3() {
        this.f1030a = new HashMap();
    }

    public static eu3 a() {
        eu3 eu3 = b;
        if (eu3 == null) {
            synchronized (eu3.class) {
                eu3 = b;
                if (eu3 == null) {
                    eu3 = d;
                    b = eu3;
                }
            }
        }
        return eu3;
    }

    public eu3(boolean z) {
        this.f1030a = Collections.emptyMap();
    }
}
