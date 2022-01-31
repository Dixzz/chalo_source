package defpackage;

import defpackage.bm2;
import java.security.GeneralSecurityException;

/* renamed from: bo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class bo2<PrimitiveT, KeyProtoT extends bm2> implements ao2<PrimitiveT> {

    /* renamed from: a  reason: collision with root package name */
    public final fo2<KeyProtoT> f456a;
    public final Class<PrimitiveT> b;

    public bo2(fo2<KeyProtoT> fo2, Class<PrimitiveT> cls) {
        if (fo2.f().contains(cls) || Void.class.equals(cls)) {
            this.f456a = fo2;
            this.b = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", fo2.toString(), cls.getName()));
    }

    public final PrimitiveT a(g93 g93) throws GeneralSecurityException {
        try {
            return d(this.f456a.c(g93));
        } catch (ma3 e) {
            String name = this.f456a.f1152a.getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e);
        }
    }

    public final bm2 b(g93 g93) throws GeneralSecurityException {
        try {
            do2<?, KeyProtoT> g = this.f456a.g();
            bm2 b2 = g.b(g93);
            g.a(b2);
            return g.c(b2);
        } catch (ma3 e) {
            String name = this.f456a.g().f868a.getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e);
        }
    }

    public final xu2 c(g93 g93) throws GeneralSecurityException {
        try {
            do2<?, KeyProtoT> g = this.f456a.g();
            bm2 b2 = g.b(g93);
            g.a(b2);
            KeyProtoT c = g.c(b2);
            uu2 v = xu2.v();
            String a2 = this.f456a.a();
            if (v.h) {
                v.a();
                v.h = false;
            }
            xu2.y((xu2) v.g, a2);
            g93 j = c.j();
            if (v.h) {
                v.a();
                v.h = false;
            }
            xu2.z((xu2) v.g, j);
            wu2 b3 = this.f456a.b();
            if (v.h) {
                v.a();
                v.h = false;
            }
            ((xu2) v.g).zzf = b3.zza();
            return (xu2) v.c();
        } catch (ma3 e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: java.lang.Class<PrimitiveT>, java.lang.Class<P> */
    public final PrimitiveT d(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.b)) {
            this.f456a.d(keyprotot);
            return (PrimitiveT) this.f456a.e(keyprotot, (Class<PrimitiveT>) this.b);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }
}
