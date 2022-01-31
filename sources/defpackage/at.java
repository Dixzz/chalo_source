package defpackage;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import defpackage.np;
import defpackage.wp;
import java.util.HashSet;
import java.util.Objects;

/* renamed from: at  reason: default package */
/* compiled from: EnqueueRunnable */
public class at implements Runnable {
    public static final String h = tp.e("EnqueueRunnable");
    public final kq f;
    public final gq g = new gq();

    public at(kq kqVar) {
        this.f = kqVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v20, types: [java.util.List] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x020d  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(defpackage.kq r22) {
        /*
        // Method dump skipped, instructions count: 872
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.at.a(kq):boolean");
    }

    public static void b(rs rsVar) {
        lp lpVar = rsVar.j;
        if (lpVar.d || lpVar.e) {
            String str = rsVar.c;
            np.a aVar = new np.a();
            aVar.b(rsVar.e.f2585a);
            aVar.f2586a.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            rsVar.c = ConstraintTrackingWorker.class.getName();
            rsVar.e = aVar.a();
        }
    }

    public void run() {
        try {
            kq kqVar = this.f;
            Objects.requireNonNull(kqVar);
            if (!kq.b(kqVar, new HashSet())) {
                WorkDatabase workDatabase = this.f.f2103a.c;
                workDatabase.beginTransaction();
                try {
                    boolean a2 = a(this.f);
                    workDatabase.setTransactionSuccessful();
                    if (a2) {
                        ct.a(this.f.f2103a.f2838a, RescheduleReceiver.class, true);
                        pq pqVar = this.f.f2103a;
                        jq.a(pqVar.b, pqVar.c, pqVar.e);
                    }
                    this.g.a(wp.f3818a);
                } finally {
                    workDatabase.endTransaction();
                }
            } else {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f));
            }
        } catch (Throwable th) {
            this.g.a(new wp.b.a(th));
        }
    }
}
