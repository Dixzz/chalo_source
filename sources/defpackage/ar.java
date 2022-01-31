package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: ar  reason: default package */
/* compiled from: SystemAlarmDispatcher */
public class ar implements fq {
    public static final String p = tp.e("SystemAlarmDispatcher");
    public final Context f;
    public final pt g;
    public final lt h = new lt();
    public final hq i;
    public final pq j;
    public final xq k;
    public final Handler l;
    public final List<Intent> m;
    public Intent n;
    public c o;

    /* renamed from: ar$a */
    /* compiled from: SystemAlarmDispatcher */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ar arVar;
            d dVar;
            synchronized (ar.this.m) {
                ar arVar2 = ar.this;
                arVar2.n = arVar2.m.get(0);
            }
            Intent intent = ar.this.n;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = ar.this.n.getIntExtra("KEY_START_ID", 0);
                tp c = tp.c();
                String str = ar.p;
                c.a(str, String.format("Processing command %s, %s", ar.this.n, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock a2 = it.a(ar.this.f, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    tp.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, a2), new Throwable[0]);
                    a2.acquire();
                    ar arVar3 = ar.this;
                    arVar3.k.e(arVar3.n, intExtra, arVar3);
                    tp.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, a2), new Throwable[0]);
                    a2.release();
                    arVar = ar.this;
                    dVar = new d(arVar);
                } catch (Throwable th) {
                    tp.c().a(ar.p, String.format("Releasing operation wake lock (%s) %s", action, a2), new Throwable[0]);
                    a2.release();
                    ar arVar4 = ar.this;
                    arVar4.l.post(new d(arVar4));
                    throw th;
                }
                arVar.l.post(dVar);
            }
        }
    }

    /* renamed from: ar$b */
    /* compiled from: SystemAlarmDispatcher */
    public static class b implements Runnable {
        public final ar f;
        public final Intent g;
        public final int h;

        public b(ar arVar, Intent intent, int i) {
            this.f = arVar;
            this.g = intent;
            this.h = i;
        }

        public void run() {
            this.f.a(this.g, this.h);
        }
    }

    /* renamed from: ar$c */
    /* compiled from: SystemAlarmDispatcher */
    public interface c {
    }

    /* renamed from: ar$d */
    /* compiled from: SystemAlarmDispatcher */
    public static class d implements Runnable {
        public final ar f;

        public d(ar arVar) {
            this.f = arVar;
        }

        public void run() {
            boolean z;
            ar arVar = this.f;
            Objects.requireNonNull(arVar);
            tp c = tp.c();
            String str = ar.p;
            c.a(str, "Checking if commands are complete.", new Throwable[0]);
            arVar.b();
            synchronized (arVar.m) {
                boolean z2 = true;
                if (arVar.n != null) {
                    tp.c().a(str, String.format("Removing command %s", arVar.n), new Throwable[0]);
                    if (arVar.m.remove(0).equals(arVar.n)) {
                        arVar.n = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                ft ftVar = ((qt) arVar.g).f2987a;
                xq xqVar = arVar.k;
                synchronized (xqVar.h) {
                    z = !xqVar.g.isEmpty();
                }
                if (!z && arVar.m.isEmpty()) {
                    synchronized (ftVar.h) {
                        if (ftVar.f.isEmpty()) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        tp.c().a(str, "No more commands & intents.", new Throwable[0]);
                        c cVar = arVar.o;
                        if (cVar != null) {
                            ((SystemAlarmService) cVar).b();
                        }
                    }
                }
                if (!arVar.m.isEmpty()) {
                    arVar.e();
                }
            }
        }
    }

    public ar(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        this.k = new xq(applicationContext);
        pq a2 = pq.a(context);
        this.j = a2;
        hq hqVar = a2.f;
        this.i = hqVar;
        this.g = a2.d;
        hqVar.a(this);
        this.m = new ArrayList();
        this.n = null;
        this.l = new Handler(Looper.getMainLooper());
    }

    public boolean a(Intent intent, int i2) {
        boolean z;
        tp c2 = tp.c();
        String str = p;
        boolean z2 = false;
        c2.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i2)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            tp.c().f(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            b();
            synchronized (this.m) {
                Iterator<Intent> it = this.m.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(it.next().getAction())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                return false;
            }
        }
        intent.putExtra("KEY_START_ID", i2);
        synchronized (this.m) {
            if (!this.m.isEmpty()) {
                z2 = true;
            }
            this.m.add(intent);
            if (!z2) {
                e();
            }
        }
        return true;
    }

    public final void b() {
        if (this.l.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void c() {
        tp.c().a(p, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.i.e(this);
        lt ltVar = this.h;
        if (!ltVar.b.isShutdown()) {
            ltVar.b.shutdownNow();
        }
        this.o = null;
    }

    @Override // defpackage.fq
    public void d(String str, boolean z) {
        Context context = this.f;
        String str2 = xq.i;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        this.l.post(new b(this, intent, 0));
    }

    public final void e() {
        b();
        PowerManager.WakeLock a2 = it.a(this.f, "ProcessCommand");
        try {
            a2.acquire();
            pt ptVar = this.j.d;
            ((qt) ptVar).f2987a.execute(new a());
        } finally {
            a2.release();
        }
    }
}
