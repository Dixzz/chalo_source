package defpackage;

import java.util.Set;

/* renamed from: kv1  reason: default package */
/* compiled from: TransportFactoryImpl */
public final class kv1 implements eu1 {

    /* renamed from: a  reason: collision with root package name */
    public final Set<zt1> f2124a;
    public final jv1 b;
    public final mv1 c;

    public kv1(Set<zt1> set, jv1 jv1, mv1 mv1) {
        this.f2124a = set;
        this.b = jv1;
        this.c = mv1;
    }

    @Override // defpackage.eu1
    public <T> du1<T> a(String str, Class<T> cls, zt1 zt1, cu1<T, byte[]> cu1) {
        if (this.f2124a.contains(zt1)) {
            return new lv1(this.b, str, zt1, cu1, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", zt1, this.f2124a));
    }
}
