package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.HashMap;
import java.util.Map;

/* renamed from: xq  reason: default package */
/* compiled from: CommandHandler */
public class xq implements fq {
    public static final String i = tp.e("CommandHandler");
    public final Context f;
    public final Map<String, fq> g = new HashMap();
    public final Object h = new Object();

    public xq(Context context) {
        this.f = context;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @Override // defpackage.fq
    public void d(String str, boolean z) {
        synchronized (this.h) {
            fq remove = this.g.remove(str);
            if (remove != null) {
                remove.d(str, z);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.content.Intent r11, int r12, defpackage.ar r13) {
        /*
        // Method dump skipped, instructions count: 893
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xq.e(android.content.Intent, int, ar):void");
    }
}
