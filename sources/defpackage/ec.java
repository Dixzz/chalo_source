package defpackage;

import defpackage.cc;
import defpackage.kc;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/* renamed from: ec  reason: default package */
/* compiled from: ExtensionSchemaLite */
public final class ec extends dc<kc.d> {
    @Override // defpackage.dc
    public int a(Map.Entry<?, ?> entry) {
        Objects.requireNonNull((kc.d) entry.getKey());
        return 0;
    }

    @Override // defpackage.dc
    public Object b(cc ccVar, dd ddVar, int i) {
        return ccVar.f545a.get(new cc.a(ddVar, i));
    }

    @Override // defpackage.dc
    public gc<kc.d> c(Object obj) {
        return ((kc.c) obj).extensions;
    }

    @Override // defpackage.dc
    public gc<kc.d> d(Object obj) {
        kc.c cVar = (kc.c) obj;
        gc<kc.d> gcVar = cVar.extensions;
        if (gcVar.b) {
            cVar.extensions = gcVar.clone();
        }
        return cVar.extensions;
    }

    @Override // defpackage.dc
    public boolean e(dd ddVar) {
        return ddVar instanceof kc.c;
    }

    @Override // defpackage.dc
    public void f(Object obj) {
        ((kc.c) obj).extensions.l();
    }

    @Override // defpackage.dc
    public <UT, UB> UB g(qd qdVar, Object obj, cc ccVar, gc<kc.d> gcVar, UB ub, yd<UT, UB> ydVar) throws IOException {
        Objects.requireNonNull((kc.e) obj);
        throw null;
    }

    @Override // defpackage.dc
    public void h(qd qdVar, Object obj, cc ccVar, gc<kc.d> gcVar) throws IOException {
        Objects.requireNonNull((kc.e) obj);
        throw null;
    }

    @Override // defpackage.dc
    public void i(ub ubVar, Object obj, cc ccVar, gc<kc.d> gcVar) throws IOException {
        Objects.requireNonNull((kc.e) obj);
        throw null;
    }

    @Override // defpackage.dc
    public void j(he heVar, Map.Entry<?, ?> entry) throws IOException {
        Objects.requireNonNull((kc.d) entry.getKey());
        throw null;
    }
}
