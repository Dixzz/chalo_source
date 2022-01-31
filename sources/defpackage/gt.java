package defpackage;

import androidx.work.WorkerParameters;

/* renamed from: gt  reason: default package */
/* compiled from: StartWorkRunnable */
public class gt implements Runnable {
    public pq f;
    public String g;
    public WorkerParameters.a h;

    public gt(pq pqVar, String str, WorkerParameters.a aVar) {
        this.f = pqVar;
        this.g = str;
        this.h = aVar;
    }

    public void run() {
        this.f.f.f(this.g, this.h);
    }
}
