package defpackage;

import java.security.GeneralSecurityException;

/* renamed from: eo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class eo2<PrimitiveT, KeyT> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<PrimitiveT> f1014a;

    public eo2(Class<PrimitiveT> cls) {
        this.f1014a = cls;
    }

    public abstract PrimitiveT a(KeyT keyt) throws GeneralSecurityException;
}
