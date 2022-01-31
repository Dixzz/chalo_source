package defpackage;

import defpackage.bm2;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: fo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class fo2<KeyProtoT extends bm2> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<KeyProtoT> f1152a;
    public final Map<Class<?>, eo2<?, KeyProtoT>> b;
    public final Class<?> c;

    /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: java.lang.Class<PrimitiveT>, java.lang.Class<?> */
    @SafeVarargs
    public fo2(Class<KeyProtoT> cls, eo2<?, KeyProtoT>... eo2Arr) {
        String str;
        this.f1152a = cls;
        HashMap hashMap = new HashMap();
        for (int i = 0; i <= 0; i++) {
            eo2<?, KeyProtoT> eo2 = eo2Arr[i];
            if (hashMap.containsKey(eo2.f1014a)) {
                String valueOf = String.valueOf(eo2.f1014a.getCanonicalName());
                if (valueOf.length() != 0) {
                    str = "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf);
                } else {
                    str = new String("KeyTypeManager constructed with duplicate factories for primitive ");
                }
                throw new IllegalArgumentException(str);
            }
            hashMap.put(eo2.f1014a, eo2);
        }
        this.c = (Class<PrimitiveT>) eo2Arr[0].f1014a;
        this.b = Collections.unmodifiableMap(hashMap);
    }

    public abstract String a();

    public abstract wu2 b();

    public abstract KeyProtoT c(g93 g93) throws ma3;

    public abstract void d(KeyProtoT keyprotot) throws GeneralSecurityException;

    public final <P> P e(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        eo2<?, KeyProtoT> eo2 = this.b.get(cls);
        if (eo2 != null) {
            return (P) eo2.a(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException(hj1.b0(new StringBuilder(String.valueOf(canonicalName).length() + 41), "Requested primitive class ", canonicalName, " not supported."));
    }

    public final Set<Class<?>> f() {
        return this.b.keySet();
    }

    public do2<?, KeyProtoT> g() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
