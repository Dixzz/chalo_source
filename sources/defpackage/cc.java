package defpackage;

import defpackage.kc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: cc  reason: default package */
/* compiled from: ExtensionRegistryLite */
public class cc {
    public static volatile cc b;
    public static final cc c = new cc(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, kc.e<?, ?>> f545a;

    /* renamed from: cc$a */
    /* compiled from: ExtensionRegistryLite */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f546a;
        public final int b;

        public a(Object obj, int i) {
            this.f546a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f546a == aVar.f546a && this.b == aVar.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f546a) * 65535) + this.b;
        }
    }

    static {
        try {
            Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
    }

    public cc() {
        this.f545a = new HashMap();
    }

    public static cc a() {
        cc ccVar = b;
        if (ccVar == null) {
            synchronized (cc.class) {
                ccVar = b;
                if (ccVar == null) {
                    Class<?> cls = bc.f407a;
                    if (cls != null) {
                        try {
                            ccVar = (cc) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                        b = ccVar;
                    }
                    ccVar = c;
                    b = ccVar;
                }
            }
        }
        return ccVar;
    }

    public cc(boolean z) {
        this.f545a = Collections.emptyMap();
    }
}
