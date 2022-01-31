package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: xo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class xo2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3947a = Logger.getLogger(xo2.class.getName());
    public static final ConcurrentMap<String, wo2> b = new ConcurrentHashMap();
    public static final ConcurrentMap<String, vo2> c = new ConcurrentHashMap();
    public static final ConcurrentMap<String, Boolean> d = new ConcurrentHashMap();
    public static final ConcurrentMap<Class<?>, qo2<?, ?>> e = new ConcurrentHashMap();

    static {
        new ConcurrentHashMap();
    }

    public static synchronized <KeyProtoT extends bm2> void a(fo2<KeyProtoT> fo2, boolean z) throws GeneralSecurityException {
        synchronized (xo2.class) {
            String a2 = fo2.a();
            h(a2, fo2.getClass(), true);
            ConcurrentMap<String, wo2> concurrentMap = b;
            if (!concurrentMap.containsKey(a2)) {
                concurrentMap.put(a2, new to2(fo2));
                c.put(a2, new vo2(fo2));
            }
            d.put(a2, Boolean.TRUE);
        }
    }

    public static synchronized <B, P> void b(qo2<B, P> qo2) throws GeneralSecurityException {
        synchronized (xo2.class) {
            Class<P> zzb = qo2.zzb();
            ConcurrentMap<Class<?>, qo2<?, ?>> concurrentMap = e;
            if (concurrentMap.containsKey(zzb)) {
                qo2<?, ?> qo22 = concurrentMap.get(zzb);
                if (!qo2.getClass().equals(qo22.getClass())) {
                    Logger logger = f3947a;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(zzb);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 56);
                    sb.append("Attempted overwrite of a registered SetWrapper for type ");
                    sb.append(valueOf);
                    logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", zzb.getName(), qo22.getClass().getName(), qo2.getClass().getName()));
                }
            }
            concurrentMap.put(zzb, qo2);
        }
    }

    public static synchronized xu2 c(cv2 cv2) throws GeneralSecurityException {
        xu2 c2;
        synchronized (xo2.class) {
            ao2<?> zzb = g(cv2.s()).zzb();
            if (d.get(cv2.s()).booleanValue()) {
                c2 = ((bo2) zzb).c(cv2.t());
            } else {
                String valueOf = String.valueOf(cv2.s());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return c2;
    }

    public static synchronized bm2 d(cv2 cv2) throws GeneralSecurityException {
        bm2 b2;
        synchronized (xo2.class) {
            ao2<?> zzb = g(cv2.s()).zzb();
            if (d.get(cv2.s()).booleanValue()) {
                b2 = ((bo2) zzb).b(cv2.t());
            } else {
                String valueOf = String.valueOf(cv2.s());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return b2;
    }

    public static <P> P e(String str, bm2 bm2, Class<P> cls) throws GeneralSecurityException {
        String str2;
        bo2 bo2 = (bo2) i(str, cls);
        String name = bo2.f456a.f1152a.getName();
        if (name.length() != 0) {
            str2 = "Expected proto of type ".concat(name);
        } else {
            str2 = new String("Expected proto of type ");
        }
        if (bo2.f456a.f1152a.isInstance(bm2)) {
            return (P) bo2.d(bm2);
        }
        throw new GeneralSecurityException(str2);
    }

    public static <P> P f(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        g93 g93 = g93.g;
        return (P) j(str, g93.A(bArr, 0, bArr.length), cls);
    }

    public static synchronized wo2 g(String str) throws GeneralSecurityException {
        wo2 wo2;
        String str2;
        synchronized (xo2.class) {
            ConcurrentMap<String, wo2> concurrentMap = b;
            if (!concurrentMap.containsKey(str)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "No key manager found for key type ".concat(valueOf);
                } else {
                    str2 = new String("No key manager found for key type ");
                }
                throw new GeneralSecurityException(str2);
            }
            wo2 = concurrentMap.get(str);
        }
        return wo2;
    }

    public static synchronized void h(String str, Class<?> cls, boolean z) throws GeneralSecurityException {
        String str2;
        String str3;
        synchronized (xo2.class) {
            ConcurrentMap<String, wo2> concurrentMap = b;
            if (concurrentMap.containsKey(str)) {
                wo2 wo2 = concurrentMap.get(str);
                if (!wo2.zzc().equals(cls)) {
                    Logger logger = f3947a;
                    Level level = Level.WARNING;
                    if (str.length() != 0) {
                        str3 = "Attempted overwrite of a registered key manager for key type ".concat(str);
                    } else {
                        str3 = new String("Attempted overwrite of a registered key manager for key type ");
                    }
                    logger.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", str3);
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, wo2.zzc().getName(), cls.getName()));
                } else if (z && !d.get(str).booleanValue()) {
                    if (str.length() != 0) {
                        str2 = "New keys are already disallowed for key type ".concat(str);
                    } else {
                        str2 = new String("New keys are already disallowed for key type ");
                    }
                    throw new GeneralSecurityException(str2);
                }
            }
        }
    }

    public static <P> ao2<P> i(String str, Class<P> cls) throws GeneralSecurityException {
        wo2 g = g(str);
        if (cls == null) {
            return (ao2<P>) g.zzb();
        }
        if (g.zzd().contains(cls)) {
            return g.b(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(g.zzc());
        Set<Class<?>> zzd = g.zzd();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : zzd) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        int length = name.length();
        StringBuilder sb3 = new StringBuilder(length + 77 + valueOf.length() + String.valueOf(sb2).length());
        hj1.V0(sb3, "Primitive type ", name, " not supported by key manager of type ", valueOf);
        throw new GeneralSecurityException(hj1.a0(sb3, ", supported primitives: ", sb2));
    }

    public static <P> P j(String str, g93 g93, Class<P> cls) throws GeneralSecurityException {
        return (P) ((bo2) i(str, cls)).a(g93);
    }
}
