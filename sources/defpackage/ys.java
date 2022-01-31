package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ys  reason: default package */
/* compiled from: CancelWorkRunnable */
public class ys extends zs {
    public final /* synthetic */ pq g;
    public final /* synthetic */ String h;
    public final /* synthetic */ boolean i;

    public ys(pq pqVar, String str, boolean z) {
        this.g = pqVar;
        this.h = str;
        this.i = z;
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.zs
    public void b() {
        WorkDatabase workDatabase = this.g.c;
        workDatabase.beginTransaction();
        try {
            Iterator it = ((ArrayList) ((ts) workDatabase.f()).h(this.h)).iterator();
            while (it.hasNext()) {
                a(this.g, (String) it.next());
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (this.i) {
                pq pqVar = this.g;
                jq.a(pqVar.b, pqVar.c, pqVar.e);
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
