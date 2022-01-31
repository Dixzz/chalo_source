package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: wj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class wj3 extends xj3<FieldDescriptorType, Object> {
    public wj3(int i) {
        super(i, null);
    }

    @Override // defpackage.xj3
    public final void c() {
        if (!this.i) {
            for (int i = 0; i < f(); i++) {
                Map.Entry d = d(i);
                if (((rh3) d.getKey()).H()) {
                    d.setValue(Collections.unmodifiableList((List) d.getValue()));
                }
            }
            for (Map.Entry entry : g()) {
                if (((rh3) entry.getKey()).H()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.c();
    }
}
