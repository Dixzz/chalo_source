package defpackage;

import androidx.work.impl.WorkDatabase;
import defpackage.wl;

/* renamed from: mq  reason: default package */
/* compiled from: WorkDatabase */
public class mq extends wl.b {
    @Override // defpackage.wl.b
    public void onOpen(om omVar) {
        super.onOpen(omVar);
        omVar.beginTransaction();
        try {
            int i = WorkDatabase.b;
            omVar.y("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + (System.currentTimeMillis() - WorkDatabase.f263a) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            omVar.setTransactionSuccessful();
        } finally {
            omVar.endTransaction();
        }
    }
}
