package defpackage;

import defpackage.gc;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: ud  reason: default package */
/* compiled from: SmallSortedMap */
public final class ud extends vd<FieldDescriptorType, Object> {
    public ud(int i) {
        super(i, null);
    }

    @Override // defpackage.vd
    public void g() {
        if (!this.i) {
            for (int i = 0; i < d(); i++) {
                Map.Entry c = c(i);
                if (((gc.a) c.getKey()).b()) {
                    c.setValue(Collections.unmodifiableList((List) c.getValue()));
                }
            }
            for (Map.Entry entry : e()) {
                if (((gc.a) entry.getKey()).b()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.g();
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map, defpackage.vd
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((gc.a) obj, obj2);
    }
}
