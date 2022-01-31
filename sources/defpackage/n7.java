package defpackage;

import android.os.Handler;
import java.util.concurrent.Callable;

/* renamed from: n7  reason: default package */
/* compiled from: RequestExecutor */
public class n7<T> implements Runnable {
    public Callable<T> f;
    public t7<T> g;
    public Handler h;

    /* renamed from: n7$a */
    /* compiled from: RequestExecutor */
    public class a implements Runnable {
        public final /* synthetic */ t7 f;
        public final /* synthetic */ Object g;

        public a(n7 n7Var, t7 t7Var, Object obj) {
            this.f = t7Var;
            this.g = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: t7 */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            this.f.a(this.g);
        }
    }

    public n7(Handler handler, Callable<T> callable, t7<T> t7Var) {
        this.f = callable;
        this.g = t7Var;
        this.h = handler;
    }

    public void run() {
        T t;
        try {
            t = this.f.call();
        } catch (Exception unused) {
            t = null;
        }
        this.h.post(new a(this, this.g, t));
    }
}
