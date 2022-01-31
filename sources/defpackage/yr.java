package defpackage;

import androidx.work.impl.WorkDatabase;

/* renamed from: yr  reason: default package */
/* compiled from: SystemForegroundDispatcher */
public class yr implements Runnable {
    public final /* synthetic */ WorkDatabase f;
    public final /* synthetic */ String g;
    public final /* synthetic */ zr h;

    public yr(zr zrVar, WorkDatabase workDatabase, String str) {
        this.h = zrVar;
        this.f = workDatabase;
        this.g = str;
    }

    public void run() {
        rs i = ((ts) this.f.f()).i(this.g);
        if (i != null && i.b()) {
            synchronized (this.h.i) {
                this.h.l.put(this.g, i);
                this.h.m.add(i);
                zr zrVar = this.h;
                zrVar.n.b(zrVar.m);
            }
        }
    }
}
