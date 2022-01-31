package defpackage;

import androidx.work.impl.WorkDatabase;

/* renamed from: ht  reason: default package */
/* compiled from: StopWorkRunnable */
public class ht implements Runnable {
    public static final String i = tp.e("StopWorkRunnable");
    public final pq f;
    public final String g;
    public final boolean h;

    public ht(pq pqVar, String str, boolean z) {
        this.f = pqVar;
        this.g = str;
        this.h = z;
    }

    public void run() {
        boolean containsKey;
        boolean z;
        pq pqVar = this.f;
        WorkDatabase workDatabase = pqVar.c;
        hq hqVar = pqVar.f;
        ss f2 = workDatabase.f();
        workDatabase.beginTransaction();
        try {
            String str = this.g;
            synchronized (hqVar.o) {
                containsKey = hqVar.j.containsKey(str);
            }
            if (this.h) {
                z = this.f.f.h(this.g);
            } else {
                if (!containsKey) {
                    ts tsVar = (ts) f2;
                    if (tsVar.g(this.g) == zp.RUNNING) {
                        tsVar.p(zp.ENQUEUED, this.g);
                    }
                }
                z = this.f.f.i(this.g);
            }
            tp.c().a(i, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.g, Boolean.valueOf(z)), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
