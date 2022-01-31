package androidx.work;

import defpackage.np;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends qp {
    @Override // defpackage.qp
    public np a(List<np> list) {
        np.a aVar = new np.a();
        HashMap hashMap = new HashMap();
        for (np npVar : list) {
            hashMap.putAll(Collections.unmodifiableMap(npVar.f2585a));
        }
        aVar.b(hashMap);
        return aVar.a();
    }
}
