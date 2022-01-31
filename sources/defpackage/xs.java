package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* renamed from: xs  reason: default package */
/* compiled from: CancelWorkRunnable */
public class xs extends zs {
    public final /* synthetic */ pq g;
    public final /* synthetic */ UUID h;

    public xs(pq pqVar, UUID uuid) {
        this.g = pqVar;
        this.h = uuid;
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.zs
    public void b() {
        WorkDatabase workDatabase = this.g.c;
        workDatabase.beginTransaction();
        try {
            a(this.g, this.h.toString());
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            pq pqVar = this.g;
            jq.a(pqVar.b, pqVar.c, pqVar.e);
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
