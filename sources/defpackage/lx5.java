package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: lx5  reason: default package */
/* compiled from: Subject */
public class lx5<T> extends sw5<T> implements hx5<T> {
    public final ArrayList<hx5<T>> b = new ArrayList<>();
    public boolean c = false;

    /* renamed from: lx5$a */
    /* compiled from: Subject */
    public class a implements Runnable {
        public final /* synthetic */ hx5 f;

        public a(hx5 hx5) {
            this.f = hx5;
        }

        public void run() {
            boolean z;
            lx5 lx5 = lx5.this;
            synchronized (lx5) {
                z = lx5.b.size() > 0;
            }
            if (z) {
                lx5.this.b.remove(this.f);
            }
        }
    }

    @Override // defpackage.hx5
    public synchronized void a() {
        this.c = true;
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            ((hx5) it.next()).a();
        }
    }

    @Override // defpackage.hx5
    public synchronized void b(T t) {
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            ((hx5) it.next()).b(t);
        }
    }

    @Override // defpackage.sw5
    public synchronized nx5 g(hx5<T> hx5) {
        synchronized (this) {
        }
        return new nx5(new a(hx5));
        if (!this.c) {
            synchronized (this) {
                this.b.add(hx5);
            }
        }
        return new nx5(new a(hx5));
    }
}
