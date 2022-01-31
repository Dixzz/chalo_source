package defpackage;

import androidx.work.impl.WorkDatabase;

/* renamed from: bt  reason: default package */
/* compiled from: IdGenerator */
public class bt {

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f472a;

    public bt(WorkDatabase workDatabase) {
        this.f472a = workDatabase;
    }

    public final int a(String str) {
        this.f472a.beginTransaction();
        try {
            Long a2 = ((hs) this.f472a.b()).a(str);
            int i = 0;
            int intValue = a2 != null ? a2.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i = intValue + 1;
            }
            ((hs) this.f472a.b()).b(new fs(str, (long) i));
            this.f472a.setTransactionSuccessful();
            return intValue;
        } finally {
            this.f472a.endTransaction();
        }
    }

    public int b(int i, int i2) {
        synchronized (bt.class) {
            int a2 = a("next_job_scheduler_id");
            if (a2 >= i) {
                if (a2 <= i2) {
                    i = a2;
                }
            }
            ((hs) this.f472a.b()).b(new fs("next_job_scheduler_id", (long) (i + 1)));
        }
        return i;
    }
}
