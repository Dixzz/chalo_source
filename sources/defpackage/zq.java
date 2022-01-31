package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import defpackage.ar;
import defpackage.lt;
import java.util.Collections;
import java.util.List;

/* renamed from: zq  reason: default package */
/* compiled from: DelayMetCommandHandler */
public class zq implements gr, fq, lt.b {
    public static final String o = tp.e("DelayMetCommandHandler");
    public final Context f;
    public final int g;
    public final String h;
    public final ar i;
    public final hr j;
    public final Object k = new Object();
    public int l = 0;
    public PowerManager.WakeLock m;
    public boolean n = false;

    public zq(Context context, int i2, String str, ar arVar) {
        this.f = context;
        this.g = i2;
        this.i = arVar;
        this.h = str;
        this.j = new hr(context, arVar.g, this);
    }

    @Override // defpackage.lt.b
    public void a(String str) {
        tp.c().a(o, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // defpackage.gr
    public void b(List<String> list) {
        g();
    }

    public final void c() {
        synchronized (this.k) {
            this.j.c();
            this.i.h.b(this.h);
            PowerManager.WakeLock wakeLock = this.m;
            if (wakeLock != null && wakeLock.isHeld()) {
                tp.c().a(o, String.format("Releasing wakelock %s for WorkSpec %s", this.m, this.h), new Throwable[0]);
                this.m.release();
            }
        }
    }

    @Override // defpackage.fq
    public void d(String str, boolean z) {
        tp.c().a(o, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        c();
        if (z) {
            Intent c = xq.c(this.f, this.h);
            ar arVar = this.i;
            arVar.l.post(new ar.b(arVar, c, this.g));
        }
        if (this.n) {
            Intent a2 = xq.a(this.f);
            ar arVar2 = this.i;
            arVar2.l.post(new ar.b(arVar2, a2, this.g));
        }
    }

    public void e() {
        this.m = it.a(this.f, String.format("%s (%s)", this.h, Integer.valueOf(this.g)));
        tp c = tp.c();
        String str = o;
        c.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.m, this.h), new Throwable[0]);
        this.m.acquire();
        rs i2 = ((ts) this.i.j.c.f()).i(this.h);
        if (i2 == null) {
            g();
            return;
        }
        boolean b = i2.b();
        this.n = b;
        if (!b) {
            tp.c().a(str, String.format("No constraints for %s", this.h), new Throwable[0]);
            f(Collections.singletonList(this.h));
            return;
        }
        this.j.b(Collections.singletonList(i2));
    }

    @Override // defpackage.gr
    public void f(List<String> list) {
        if (list.contains(this.h)) {
            synchronized (this.k) {
                if (this.l == 0) {
                    this.l = 1;
                    tp.c().a(o, String.format("onAllConstraintsMet for %s", this.h), new Throwable[0]);
                    if (this.i.i.f(this.h, null)) {
                        this.i.h.a(this.h, 600000, this);
                    } else {
                        c();
                    }
                } else {
                    tp.c().a(o, String.format("Already started work for %s", this.h), new Throwable[0]);
                }
            }
        }
    }

    public final void g() {
        synchronized (this.k) {
            if (this.l < 2) {
                this.l = 2;
                tp c = tp.c();
                String str = o;
                c.a(str, String.format("Stopping work for WorkSpec %s", this.h), new Throwable[0]);
                Context context = this.f;
                String str2 = this.h;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str2);
                ar arVar = this.i;
                arVar.l.post(new ar.b(arVar, intent, this.g));
                if (this.i.i.c(this.h)) {
                    tp.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.h), new Throwable[0]);
                    Intent c2 = xq.c(this.f, this.h);
                    ar arVar2 = this.i;
                    arVar2.l.post(new ar.b(arVar2, c2, this.g));
                } else {
                    tp.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.h), new Throwable[0]);
                }
            } else {
                tp.c().a(o, String.format("Already stopped work for %s", this.h), new Throwable[0]);
            }
        }
    }
}
