package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* renamed from: po2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class po2<P> {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap<oo2, List<no2<P>>> f2833a = new ConcurrentHashMap();
    public final Class<P> b;

    public po2(Class<P> cls) {
        this.b = cls;
    }

    public final List<no2<P>> a(byte[] bArr) {
        List<no2<P>> list = this.f2833a.get(new oo2(bArr));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }
}
