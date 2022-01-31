package defpackage;

import androidx.work.impl.WorkDatabase;
import defpackage.wp;
import java.util.LinkedList;

/* renamed from: zs  reason: default package */
/* compiled from: CancelWorkRunnable */
public abstract class zs implements Runnable {
    public final gq f = new gq();

    public void a(pq pqVar, String str) {
        boolean z;
        WorkDatabase workDatabase = pqVar.c;
        ss f2 = workDatabase.f();
        ds a2 = workDatabase.a();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (true) {
            z = true;
            if (linkedList.isEmpty()) {
                break;
            }
            String str2 = (String) linkedList.remove();
            ts tsVar = (ts) f2;
            zp g = tsVar.g(str2);
            if (!(g == zp.SUCCEEDED || g == zp.FAILED)) {
                tsVar.p(zp.CANCELLED, str2);
            }
            linkedList.addAll(((es) a2).a(str2));
        }
        hq hqVar = pqVar.f;
        synchronized (hqVar.o) {
            tp.c().a(hq.p, String.format("Processor cancelling %s", str), new Throwable[0]);
            hqVar.m.add(str);
            sq remove = hqVar.j.remove(str);
            if (remove == null) {
                z = false;
            }
            if (remove == null) {
                remove = hqVar.k.remove(str);
            }
            hq.b(str, remove);
            if (z) {
                hqVar.g();
            }
        }
        for (iq iqVar : pqVar.e) {
            iqVar.e(str);
        }
    }

    public abstract void b();

    public void run() {
        try {
            b();
            this.f.a(wp.f3818a);
        } catch (Throwable th) {
            this.f.a(new wp.b.a(th));
        }
    }
}
