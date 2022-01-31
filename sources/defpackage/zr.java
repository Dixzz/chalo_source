package defpackage;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: zr  reason: default package */
/* compiled from: SystemForegroundDispatcher */
public class zr implements gr, fq {
    public static final String p = tp.e("SystemFgDispatcher");
    public Context f;
    public pq g;
    public final pt h;
    public final Object i = new Object();
    public String j;
    public final Map<String, pp> k;
    public final Map<String, rs> l;
    public final Set<rs> m;
    public final hr n;
    public a o;

    /* renamed from: zr$a */
    /* compiled from: SystemForegroundDispatcher */
    public interface a {
    }

    public zr(Context context) {
        this.f = context;
        pq a2 = pq.a(this.f);
        this.g = a2;
        pt ptVar = a2.d;
        this.h = ptVar;
        this.j = null;
        this.k = new LinkedHashMap();
        this.m = new HashSet();
        this.l = new HashMap();
        this.n = new hr(this.f, ptVar, this);
        this.g.f.a(this);
    }

    public final void a(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        tp.c().a(p, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.o == null)) {
            this.k.put(stringExtra, new pp(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.j)) {
                this.j = stringExtra;
                ((SystemForegroundService) this.o).b(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.o;
            systemForegroundService.g.post(new as(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, pp> entry : this.k.entrySet()) {
                    i2 |= entry.getValue().b;
                }
                pp ppVar = this.k.get(this.j);
                if (ppVar != null) {
                    ((SystemForegroundService) this.o).b(ppVar.f2835a, i2, ppVar.c);
                }
            }
        }
    }

    @Override // defpackage.gr
    public void b(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                tp.c().a(p, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                pq pqVar = this.g;
                pt ptVar = pqVar.d;
                ((qt) ptVar).f2987a.execute(new ht(pqVar, str, true));
            }
        }
    }

    public void c() {
        this.o = null;
        synchronized (this.i) {
            this.n.c();
        }
        this.g.f.e(this);
    }

    @Override // defpackage.fq
    public void d(String str, boolean z) {
        Map.Entry<String, pp> entry;
        synchronized (this.i) {
            rs remove = this.l.remove(str);
            if (remove != null ? this.m.remove(remove) : false) {
                this.n.b(this.m);
            }
        }
        pp remove2 = this.k.remove(str);
        if (str.equals(this.j) && this.k.size() > 0) {
            Iterator<Map.Entry<String, pp>> it = this.k.entrySet().iterator();
            Map.Entry<String, pp> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.j = entry.getKey();
            if (this.o != null) {
                pp value = entry.getValue();
                ((SystemForegroundService) this.o).b(value.f2835a, value.b, value.c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.o;
                systemForegroundService.g.post(new bs(systemForegroundService, value.f2835a));
            }
        }
        a aVar = this.o;
        if (remove2 != null && aVar != null) {
            tp.c().a(p, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.f2835a), str, Integer.valueOf(remove2.b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) aVar;
            systemForegroundService2.g.post(new bs(systemForegroundService2, remove2.f2835a));
        }
    }

    @Override // defpackage.gr
    public void f(List<String> list) {
    }
}
