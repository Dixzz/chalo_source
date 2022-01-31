package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: tw3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class tw3 extends rw3<FieldDescriptorType, Object> {
    public tw3(int i) {
        super(i, null);
    }

    @Override // defpackage.rw3
    public final void c() {
        if (!this.i) {
            for (int i = 0; i < e(); i++) {
                Map.Entry d = d(i);
                if (((mu3) d.getKey()).zzd()) {
                    d.setValue(Collections.unmodifiableList((List) d.getValue()));
                }
            }
            for (Map.Entry entry : g()) {
                if (((mu3) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.c();
    }
}
