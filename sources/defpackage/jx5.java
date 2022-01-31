package defpackage;

import android.os.Handler;
import android.os.Looper;

/* renamed from: jx5  reason: default package */
/* compiled from: Schedulers */
public class jx5 implements ix5 {

    /* renamed from: a  reason: collision with root package name */
    public final Looper f1993a;

    /* renamed from: jx5$a */
    /* compiled from: Schedulers */
    public class a implements Runnable {
        public final /* synthetic */ nx5 f;
        public final /* synthetic */ Runnable g;

        public a(jx5 jx5, nx5 nx5, Runnable runnable) {
            this.f = nx5;
            this.g = runnable;
        }

        public void run() {
            if (!this.f.b()) {
                this.g.run();
            }
        }
    }

    public jx5(Looper looper) {
        this.f1993a = looper;
    }

    public nx5 a(Runnable runnable) {
        nx5 nx5 = new nx5();
        new Handler(this.f1993a).post(new a(this, nx5, runnable));
        return nx5;
    }
}
