package defpackage;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: bz5  reason: default package */
/* compiled from: RetryingExecutor */
public class bz5 implements Executor {
    public final Handler f;
    public final Executor g;
    public boolean h = false;
    public final List<Runnable> i = new ArrayList();

    /* renamed from: bz5$a */
    /* compiled from: RetryingExecutor */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f497a;

        public a(bz5 bz5, Runnable runnable) {
            this.f497a = runnable;
        }

        @Override // defpackage.bz5.c
        public int run() {
            this.f497a.run();
            return 0;
        }
    }

    /* renamed from: bz5$b */
    /* compiled from: RetryingExecutor */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final List<? extends c> f498a;

        public b(List<? extends c> list) {
            this.f498a = new ArrayList(list);
        }

        @Override // defpackage.bz5.c
        public int run() {
            if (this.f498a.isEmpty()) {
                return 0;
            }
            int run = ((c) this.f498a.get(0)).run();
            int i = 1;
            if (run != 1) {
                i = 2;
                if (run != 2) {
                    this.f498a.remove(0);
                    bz5 bz5 = bz5.this;
                    bz5.g.execute(new cz5(bz5, this, 30000));
                    return 0;
                }
            }
            return i;
        }
    }

    /* renamed from: bz5$c */
    /* compiled from: RetryingExecutor */
    public interface c {
        int run();
    }

    public bz5(Handler handler, Executor executor) {
        this.f = handler;
        this.g = executor;
    }

    public void a(boolean z) {
        if (z != this.h) {
            synchronized (this.i) {
                this.h = z;
                if (!z && !this.i.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.i);
                    this.i.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.g.execute((Runnable) it.next());
                    }
                }
            }
        }
    }

    public void execute(Runnable runnable) {
        this.g.execute(new cz5(this, new a(this, runnable), 30000));
    }
}
