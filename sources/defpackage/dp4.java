package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: dp4  reason: default package */
/* compiled from: SnackbarManager */
public class dp4 {
    public static dp4 e;

    /* renamed from: a  reason: collision with root package name */
    public final Object f875a = new Object();
    public final Handler b = new Handler(Looper.getMainLooper(), new a());
    public c c;
    public c d;

    /* renamed from: dp4$a */
    /* compiled from: SnackbarManager */
    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            dp4 dp4 = dp4.this;
            c cVar = (c) message.obj;
            synchronized (dp4.f875a) {
                if (dp4.c == cVar || dp4.d == cVar) {
                    dp4.a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* renamed from: dp4$b */
    /* compiled from: SnackbarManager */
    public interface b {
        void a(int i);

        void show();
    }

    /* renamed from: dp4$c */
    /* compiled from: SnackbarManager */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f877a;
        public int b;
        public boolean c;

        public c(int i, b bVar) {
            this.f877a = new WeakReference<>(bVar);
            this.b = i;
        }
    }

    public static dp4 b() {
        if (e == null) {
            e = new dp4();
        }
        return e;
    }

    public final boolean a(c cVar, int i) {
        b bVar = cVar.f877a.get();
        if (bVar == null) {
            return false;
        }
        this.b.removeCallbacksAndMessages(cVar);
        bVar.a(i);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.c;
        if (cVar == null) {
            return false;
        }
        if (bVar != null && cVar.f877a.get() == bVar) {
            return true;
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.d;
        if (cVar == null) {
            return false;
        }
        if (bVar != null && cVar.f877a.get() == bVar) {
            return true;
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.f875a) {
            if (c(bVar)) {
                c cVar = this.c;
                if (!cVar.c) {
                    cVar.c = true;
                    this.b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f875a) {
            if (c(bVar)) {
                c cVar = this.c;
                if (cVar.c) {
                    cVar.c = false;
                    g(cVar);
                }
            }
        }
    }

    public final void g(c cVar) {
        int i = cVar.b;
        if (i != -2) {
            if (i <= 0) {
                i = i == -1 ? 1500 : 2750;
            }
            this.b.removeCallbacksAndMessages(cVar);
            Handler handler = this.b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i);
        }
    }

    public final void h() {
        c cVar = this.d;
        if (cVar != null) {
            this.c = cVar;
            this.d = null;
            b bVar = cVar.f877a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.c = null;
            }
        }
    }
}
