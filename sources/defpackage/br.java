package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;

/* renamed from: br  reason: default package */
/* compiled from: SystemAlarmScheduler */
public class br implements iq {
    public static final String g = tp.e("SystemAlarmScheduler");
    public final Context f;

    public br(Context context) {
        this.f = context.getApplicationContext();
    }

    @Override // defpackage.iq
    public void a(rs... rsVarArr) {
        for (rs rsVar : rsVarArr) {
            tp.c().a(g, String.format("Scheduling work with workSpecId %s", rsVar.f3122a), new Throwable[0]);
            this.f.startService(xq.c(this.f, rsVar.f3122a));
        }
    }

    @Override // defpackage.iq
    public boolean c() {
        return true;
    }

    @Override // defpackage.iq
    public void e(String str) {
        Context context = this.f;
        String str2 = xq.i;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        this.f.startService(intent);
    }
}
