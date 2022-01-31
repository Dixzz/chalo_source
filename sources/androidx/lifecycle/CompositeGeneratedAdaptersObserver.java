package androidx.lifecycle;

import defpackage.zg;

public class CompositeGeneratedAdaptersObserver implements dh {
    public final yg[] f;

    public CompositeGeneratedAdaptersObserver(yg[] ygVarArr) {
        this.f = ygVarArr;
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        nh nhVar = new nh();
        for (yg ygVar : this.f) {
            ygVar.a(fhVar, aVar, false, nhVar);
        }
        for (yg ygVar2 : this.f) {
            ygVar2.a(fhVar, aVar, true, nhVar);
        }
    }
}
