package androidx.lifecycle;

import defpackage.zg;

public class FullLifecycleObserverAdapter implements dh {
    public final xg f;
    public final dh g;

    public FullLifecycleObserverAdapter(xg xgVar, dh dhVar) {
        this.f = xgVar;
        this.g = dhVar;
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                this.f.b(fhVar);
                break;
            case 1:
                this.f.g(fhVar);
                break;
            case 2:
                this.f.a(fhVar);
                break;
            case 3:
                this.f.d(fhVar);
                break;
            case 4:
                this.f.e(fhVar);
                break;
            case 5:
                this.f.f(fhVar);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        dh dhVar = this.g;
        if (dhVar != null) {
            dhVar.c(fhVar, aVar);
        }
    }
}
