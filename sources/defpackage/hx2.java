package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* renamed from: hx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class hx2 extends ThreadLocal<Mac> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ix2 f1441a;

    public hx2(ix2 ix2) {
        this.f1441a = ix2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public final Mac initialValue() {
        try {
            Mac a2 = yw2.f.a(this.f1441a.b);
            a2.init(this.f1441a.c);
            return a2;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
