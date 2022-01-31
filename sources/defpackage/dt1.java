package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.RtlSpacingHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: dt1  reason: default package */
/* compiled from: ViewTarget */
public abstract class dt1<T extends View, Z> extends vs1<Z> {
    public final T g;
    public final a h;

    /* renamed from: dt1$a */
    /* compiled from: ViewTarget */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final View f886a;
        public final List<bt1> b = new ArrayList();
        public ViewTreeObserver$OnPreDrawListenerC0019a c;

        /* renamed from: dt1$a$a  reason: collision with other inner class name */
        /* compiled from: ViewTarget */
        public static class ViewTreeObserver$OnPreDrawListenerC0019a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<a> f;

            public ViewTreeObserver$OnPreDrawListenerC0019a(a aVar) {
                this.f = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    String str = "OnGlobalLayoutListener called listener=" + this;
                }
                a aVar = this.f.get();
                if (aVar == null || aVar.b.isEmpty()) {
                    return true;
                }
                int d = aVar.d();
                int c = aVar.c();
                if (!aVar.f(d, c)) {
                    return true;
                }
                Iterator it = new ArrayList(aVar.b).iterator();
                while (it.hasNext()) {
                    ((bt1) it.next()).d(d, c);
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.f886a = view;
        }

        public void a() {
            ViewTreeObserver viewTreeObserver = this.f886a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.c);
            }
            this.c = null;
            this.b.clear();
        }

        public final int b(int i, int i2, int i3) {
            int i4 = i - i3;
            if (e(i4)) {
                return i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i2 == -2) {
                return RtlSpacingHelper.UNDEFINED;
            }
            if (i2 > 0) {
                return i2 - i3;
            }
            return 0;
        }

        public final int c() {
            int paddingBottom = this.f886a.getPaddingBottom() + this.f886a.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.f886a.getLayoutParams();
            return b(this.f886a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int d() {
            int paddingRight = this.f886a.getPaddingRight() + this.f886a.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.f886a.getLayoutParams();
            return b(this.f886a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        public final boolean e(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        public final boolean f(int i, int i2) {
            boolean z;
            if (this.f886a.getLayoutParams() == null || this.f886a.getLayoutParams().width <= 0 || this.f886a.getLayoutParams().height <= 0) {
                z = !this.f886a.isLayoutRequested();
            } else {
                z = true;
            }
            if (!z || !e(i) || !e(i2)) {
                return false;
            }
            return true;
        }
    }

    public dt1(T t) {
        Objects.requireNonNull(t, "Argument must not be null");
        this.g = t;
        this.h = new a(t);
    }

    @Override // defpackage.ct1
    public void a(bt1 bt1) {
        this.h.b.remove(bt1);
    }

    @Override // defpackage.ct1, defpackage.vs1
    public void d(os1 os1) {
        this.g.setTag(os1);
    }

    @Override // defpackage.ct1, defpackage.vs1
    public os1 g() {
        Object tag = this.g.getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof os1) {
            return (os1) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // defpackage.ct1
    public void i(bt1 bt1) {
        a aVar = this.h;
        int d = aVar.d();
        int c = aVar.c();
        if (aVar.f(d, c)) {
            ((ts1) bt1).d(d, c);
            return;
        }
        if (!aVar.b.contains(bt1)) {
            aVar.b.add(bt1);
        }
        if (aVar.c == null) {
            ViewTreeObserver viewTreeObserver = aVar.f886a.getViewTreeObserver();
            a.ViewTreeObserver$OnPreDrawListenerC0019a aVar2 = new a.ViewTreeObserver$OnPreDrawListenerC0019a(aVar);
            aVar.c = aVar2;
            viewTreeObserver.addOnPreDrawListener(aVar2);
        }
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Target for: ");
        i0.append(this.g);
        return i0.toString();
    }
}
