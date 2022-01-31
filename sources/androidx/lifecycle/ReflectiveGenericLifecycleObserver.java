package androidx.lifecycle;

import defpackage.pg;
import defpackage.zg;

public class ReflectiveGenericLifecycleObserver implements dh {
    public final Object f;
    public final pg.a g;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f = obj;
        this.g = pg.c.b(obj.getClass());
    }

    @Override // defpackage.dh
    public void c(fh fhVar, zg.a aVar) {
        pg.a aVar2 = this.g;
        Object obj = this.f;
        pg.a.a(aVar2.f2800a.get(aVar), fhVar, aVar, obj);
        pg.a.a(aVar2.f2800a.get(zg.a.ON_ANY), fhVar, aVar, obj);
    }
}
