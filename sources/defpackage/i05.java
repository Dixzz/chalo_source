package defpackage;

import defpackage.q05;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: i05  reason: default package */
/* compiled from: ExtensionRegistryLite */
public class i05 {
    public static volatile i05 b;
    public static final i05 c = new i05(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, q05.e<?, ?>> f1458a;

    /* renamed from: i05$a */
    /* compiled from: ExtensionRegistryLite */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1459a;
        public final int b;

        public a(Object obj, int i) {
            this.f1459a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1459a == aVar.f1459a && this.b == aVar.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f1459a) * 65535) + this.b;
        }
    }

    public i05() {
        this.f1458a = new HashMap();
    }

    public static i05 a() {
        i05 i05 = b;
        if (i05 == null) {
            synchronized (i05.class) {
                i05 = b;
                if (i05 == null) {
                    Class<?> cls = h05.f1326a;
                    i05 i052 = null;
                    if (cls != null) {
                        try {
                            i052 = (i05) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    if (i052 == null) {
                        i052 = c;
                    }
                    b = i052;
                    i05 = i052;
                }
            }
        }
        return i05;
    }

    public i05(boolean z) {
        this.f1458a = Collections.emptyMap();
    }
}
