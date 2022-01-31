package defpackage;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* renamed from: bf2  reason: default package */
public final /* synthetic */ class bf2 implements if2 {

    /* renamed from: a  reason: collision with root package name */
    public final af2 f422a;
    public final xe2 b;

    public bf2(af2 af2, xe2 xe2) {
        this.f422a = af2;
        this.b = xe2;
    }

    @Override // defpackage.if2
    public final Object f() {
        af2 af2 = this.f422a;
        xe2 xe2 = this.b;
        Objects.requireNonNull(xe2);
        Map<String, String> a2 = af2.d("gms:phenotype:phenotype_flag:debug_disable_caching") ? xe2.a() : xe2.e;
        if (a2 == null) {
            synchronized (xe2.d) {
                a2 = xe2.e;
                if (a2 == null) {
                    a2 = xe2.a();
                    xe2.e = a2;
                }
            }
        }
        if (a2 == null) {
            a2 = Collections.emptyMap();
        }
        return a2.get(af2.b);
    }
}
