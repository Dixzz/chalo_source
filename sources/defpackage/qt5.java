package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: qt5  reason: default package */
/* compiled from: JobDispatcher */
public class qt5 {
    @SuppressLint({"StaticFieldLeak"})
    public static qt5 e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2990a;
    public final tt5 b;
    public final List<rt5> c = new ArrayList();
    public final Runnable d = new a();

    /* renamed from: qt5$a */
    /* compiled from: JobDispatcher */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                qt5.this.b();
            } catch (ut5 unused) {
                qt5 qt5 = qt5.this;
                Objects.requireNonNull(qt5);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.removeCallbacks(qt5.d);
                handler.postDelayed(qt5.d, 1000);
            }
        }
    }

    public qt5(Context context) {
        vt5 vt5 = new vt5();
        this.f2990a = context.getApplicationContext();
        this.b = vt5;
    }

    public static qt5 c(Context context) {
        if (e == null) {
            synchronized (qt5.class) {
                if (e == null) {
                    e = new qt5(context);
                }
            }
        }
        return e;
    }

    public void a(rt5 rt5) {
        try {
            b();
            ((vt5) this.b).b(this.f2990a, rt5);
        } catch (ut5 e2) {
            yj5.e(e2, "Scheduler failed to schedule jobInfo", new Object[0]);
            synchronized (this.c) {
                this.c.add(rt5);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.removeCallbacks(this.d);
                handler.postDelayed(this.d, 1000);
            }
        }
    }

    public final void b() throws ut5 {
        synchronized (this.c) {
            Iterator it = new ArrayList(this.c).iterator();
            while (it.hasNext()) {
                rt5 rt5 = (rt5) it.next();
                ((vt5) this.b).b(this.f2990a, rt5);
                this.c.remove(rt5);
            }
        }
    }
}
