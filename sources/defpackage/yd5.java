package defpackage;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: yd5  reason: default package */
/* compiled from: EditState */
public class yd5 extends ee5<Activity> {
    public final Handler b = new Handler(Looper.getMainLooper());
    public final Map<String, List<je5>> c = new HashMap();
    public final Set<b> d = new HashSet();

    /* renamed from: yd5$a */
    /* compiled from: EditState */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            yd5.this.d();
        }
    }

    /* renamed from: yd5$b */
    /* compiled from: EditState */
    public static class b implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        public volatile boolean f = false;
        public boolean g = true;
        public final WeakReference<View> h;
        public final je5 i;
        public final Handler j;

        public b(View view, je5 je5, Handler handler) {
            this.i = je5;
            this.h = new WeakReference<>(view);
            this.j = handler;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        public void onGlobalLayout() {
            run();
        }

        public void run() {
            if (this.g) {
                View view = this.h.get();
                if (view == null || this.f) {
                    if (this.g) {
                        View view2 = this.h.get();
                        if (view2 != null) {
                            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.removeGlobalOnLayoutListener(this);
                            }
                        }
                        this.i.b();
                    }
                    this.g = false;
                    return;
                }
                this.i.c(view);
                this.j.removeCallbacks(this);
                this.j.postDelayed(this, 1000);
            }
        }
    }

    public final void b(View view, List<je5> list) {
        synchronized (this.d) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.d.add(new b(view, list.get(i), this.b));
            }
        }
    }

    public final void c() {
        if (Thread.currentThread() == this.b.getLooper().getThread()) {
            d();
        } else {
            this.b.post(new a());
        }
    }

    public final void d() {
        List<je5> list;
        List<je5> list2;
        for (Activity activity : a()) {
            String canonicalName = activity.getClass().getCanonicalName();
            View rootView = activity.getWindow().getDecorView().getRootView();
            synchronized (this.c) {
                list = this.c.get(canonicalName);
                list2 = this.c.get(null);
            }
            if (list != null) {
                b(rootView, list);
            }
            if (list2 != null) {
                b(rootView, list2);
            }
        }
    }
}
