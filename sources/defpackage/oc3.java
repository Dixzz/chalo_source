package defpackage;

import android.database.sqlite.SQLiteException;
import java.util.Objects;

/* renamed from: oc3  reason: default package */
public final class oc3 extends cd3 {
    public final /* synthetic */ mc3 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public oc3(mc3 mc3, ac3 ac3) {
        super(ac3);
        this.e = mc3;
    }

    @Override // defpackage.cd3
    public final void c() {
        mc3 mc3 = this.e;
        Objects.requireNonNull(mc3);
        try {
            mc3.i.z0();
            mc3.q0();
        } catch (SQLiteException e2) {
            mc3.J("Failed to delete stale hits", e2);
        }
        mc3.o.e(86400000);
    }
}
