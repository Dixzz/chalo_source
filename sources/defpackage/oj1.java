package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: oj1  reason: default package */
/* compiled from: ExecutorDelivery */
public class oj1 implements zj1 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2697a;

    /* renamed from: oj1$a */
    /* compiled from: ExecutorDelivery */
    public class a implements Executor {
        public final /* synthetic */ Handler f;

        public a(oj1 oj1, Handler handler) {
            this.f = handler;
        }

        public void execute(Runnable runnable) {
            this.f.post(runnable);
        }
    }

    /* renamed from: oj1$b */
    /* compiled from: ExecutorDelivery */
    public static class b implements Runnable {
        public final wj1 f;
        public final yj1 g;
        public final Runnable h;

        public b(wj1 wj1, yj1 yj1, Runnable runnable) {
            this.f = wj1;
            this.g = yj1;
            this.h = runnable;
        }

        public void run() {
            if (this.f.t()) {
                this.f.i("canceled-at-delivery");
                return;
            }
            yj1 yj1 = this.g;
            dk1 dk1 = yj1.c;
            if (dk1 == null) {
                this.f.g(yj1.f4056a);
            } else {
                this.f.f(dk1);
            }
            if (this.g.d) {
                this.f.a("intermediate-response");
            } else {
                this.f.i("done");
            }
            Runnable runnable = this.h;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public oj1(Handler handler) {
        this.f2697a = new a(this, handler);
    }

    public void a(wj1<?> wj1, yj1<?> yj1, Runnable runnable) {
        synchronized (wj1.j) {
            wj1.p = true;
        }
        wj1.a("post-response");
        this.f2697a.execute(new b(wj1, yj1, runnable));
    }
}
