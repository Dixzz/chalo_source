package defpackage;

import defpackage.m05;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: a25  reason: default package */
/* compiled from: SmallSortedMap */
public final class a25 extends b25<FieldDescriptorType, Object> {
    public a25(int i) {
        super(i, null);
    }

    @Override // defpackage.b25
    public void g() {
        if (!this.i) {
            for (int i = 0; i < d(); i++) {
                Map.Entry c = c(i);
                if (((m05.a) c.getKey()).b()) {
                    c.setValue(Collections.unmodifiableList((List) c.getValue()));
                }
            }
            for (Map.Entry entry : e()) {
                if (((m05.a) entry.getKey()).b()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.g();
    }

    @Override // java.util.AbstractMap, defpackage.b25, java.util.Map, j$.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((m05.a) obj, obj2);
    }
}
