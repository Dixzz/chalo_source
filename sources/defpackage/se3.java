package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: se3  reason: default package */
public final class se3 extends iz1<se3> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f3207a = new HashMap();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final void c(se3 se3) {
        se3 se32 = se3;
        Objects.requireNonNull(se32, "null reference");
        se32.f3207a.putAll(this.f3207a);
    }

    public final String toString() {
        return iz1.a(this.f3207a);
    }
}
