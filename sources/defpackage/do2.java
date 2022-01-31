package defpackage;

import defpackage.bm2;
import java.security.GeneralSecurityException;

/* renamed from: do2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class do2<KeyFormatProtoT extends bm2, KeyT> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<KeyFormatProtoT> f868a;

    public do2(Class<KeyFormatProtoT> cls) {
        this.f868a = cls;
    }

    public abstract void a(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT b(g93 g93) throws ma3;

    public abstract KeyT c(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
}
