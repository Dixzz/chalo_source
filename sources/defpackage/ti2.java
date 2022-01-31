package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: ti2  reason: default package */
public final class ti2 extends si2<FieldDescriptorType, Object> {
    public ti2(int i) {
        super(i, null);
    }

    @Override // defpackage.si2
    public final void i() {
        if (!this.i) {
            for (int i = 0; i < e(); i++) {
                Map.Entry c = c(i);
                if (((og2) c.getKey()).G()) {
                    c.setValue(Collections.unmodifiableList((List) c.getValue()));
                }
            }
            for (Map.Entry entry : f()) {
                if (((og2) entry.getKey()).G()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.i();
    }
}
