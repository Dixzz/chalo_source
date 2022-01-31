package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: pm2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class pm2 extends wm2 {
    public pm2(int i) {
        super(i);
    }

    @Override // defpackage.wm2
    public final void a() {
        Iterable<Map.Entry> iterable;
        if (!this.i) {
            for (int i = 0; i < b(); i++) {
                Map.Entry c = c(i);
                if (((w93) c.getKey()).zzb()) {
                    c.setValue(Collections.unmodifiableList((List) c.getValue()));
                }
            }
            if (this.h.isEmpty()) {
                iterable = sm2.b;
            } else {
                iterable = this.h.entrySet();
            }
            for (Map.Entry entry : iterable) {
                if (((w93) entry.getKey()).zzb()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
