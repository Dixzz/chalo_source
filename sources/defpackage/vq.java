package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: vq  reason: default package */
/* compiled from: GreedyScheduler */
public class vq implements iq, gr, fq {
    public static final String n = tp.e("GreedyScheduler");
    public final Context f;
    public final pq g;
    public final hr h;
    public final Set<rs> i = new HashSet();
    public uq j;
    public boolean k;
    public final Object l;
    public Boolean m;

    public vq(Context context, kp kpVar, pt ptVar, pq pqVar) {
        this.f = context;
        this.g = pqVar;
        this.h = new hr(context, ptVar, this);
        this.j = new uq(this, kpVar.e);
        this.l = new Object();
    }

    @Override // defpackage.iq
    public void a(rs... rsVarArr) {
        if (this.m == null) {
            this.m = Boolean.valueOf(et.a(this.f, this.g.b));
        }
        if (!this.m.booleanValue()) {
            tp.c().d(n, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.k) {
            this.g.f.a(this);
            this.k = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (rs rsVar : rsVarArr) {
            long a2 = rsVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (rsVar.b == zp.ENQUEUED) {
                if (currentTimeMillis < a2) {
                    uq uqVar = this.j;
                    if (uqVar != null) {
                        Runnable remove = uqVar.c.remove(rsVar.f3122a);
                        if (remove != null) {
                            uqVar.b.f1017a.removeCallbacks(remove);
                        }
                        tq tqVar = new tq(uqVar, rsVar);
                        uqVar.c.put(rsVar.f3122a, tqVar);
                        uqVar.b.f1017a.postDelayed(tqVar, rsVar.a() - System.currentTimeMillis());
                    }
                } else if (rsVar.b()) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 < 23 || !rsVar.j.c) {
                        if (i2 >= 24) {
                            if (rsVar.j.h.a() > 0) {
                                tp.c().a(n, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", rsVar), new Throwable[0]);
                            }
                        }
                        hashSet.add(rsVar);
                        hashSet2.add(rsVar.f3122a);
                    } else {
                        tp.c().a(n, String.format("Ignoring WorkSpec %s, Requires device idle.", rsVar), new Throwable[0]);
                    }
                } else {
                    tp.c().a(n, String.format("Starting work for %s", rsVar.f3122a), new Throwable[0]);
                    pq pqVar = this.g;
                    ((qt) pqVar.d).f2987a.execute(new gt(pqVar, rsVar.f3122a, null));
                }
            }
        }
        synchronized (this.l) {
            if (!hashSet.isEmpty()) {
                tp.c().a(n, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.i.addAll(hashSet);
                this.h.b(this.i);
            }
        }
    }

    @Override // defpackage.gr
    public void b(List<String> list) {
        for (String str : list) {
            tp.c().a(n, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.g.d(str);
        }
    }

    @Override // defpackage.iq
    public boolean c() {
        return false;
    }

    @Override // defpackage.fq
    public void d(String str, boolean z) {
        synchronized (this.l) {
            Iterator<rs> it = this.i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                rs next = it.next();
                if (next.f3122a.equals(str)) {
                    tp.c().a(n, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.i.remove(next);
                    this.h.b(this.i);
                    break;
                }
            }
        }
    }

    @Override // defpackage.iq
    public void e(String str) {
        Runnable remove;
        if (this.m == null) {
            this.m = Boolean.valueOf(et.a(this.f, this.g.b));
        }
        if (!this.m.booleanValue()) {
            tp.c().d(n, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.k) {
            this.g.f.a(this);
            this.k = true;
        }
        tp.c().a(n, String.format("Cancelling work ID %s", str), new Throwable[0]);
        uq uqVar = this.j;
        if (!(uqVar == null || (remove = uqVar.c.remove(str)) == null)) {
            uqVar.b.f1017a.removeCallbacks(remove);
        }
        this.g.d(str);
    }

    @Override // defpackage.gr
    public void f(List<String> list) {
        for (String str : list) {
            tp.c().a(n, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            pq pqVar = this.g;
            pt ptVar = pqVar.d;
            ((qt) ptVar).f2987a.execute(new gt(pqVar, str, null));
        }
    }
}
