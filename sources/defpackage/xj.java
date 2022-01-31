package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: xj  reason: default package */
/* compiled from: ChildHelper */
public class xj {

    /* renamed from: a  reason: collision with root package name */
    public final b f3930a;
    public final a b = new a();
    public final List<View> c = new ArrayList();

    /* renamed from: xj$a */
    /* compiled from: ChildHelper */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f3931a = 0;
        public a b;

        public void a(int i) {
            if (i >= 64) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.f3931a &= ~(1 << i);
        }

        public int b(int i) {
            a aVar = this.b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f3931a);
                }
                return Long.bitCount(this.f3931a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f3931a & ((1 << i) - 1));
            } else {
                return Long.bitCount(this.f3931a) + aVar.b(i - 64);
            }
        }

        public final void c() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return (this.f3931a & (1 << i)) != 0;
            }
            c();
            return this.b.d(i - 64);
        }

        public void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.b.e(i - 64, z);
                return;
            }
            long j = this.f3931a;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.f3931a = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.b != null) {
                c();
                this.b.e(0, z2);
            }
        }

        public boolean f(int i) {
            if (i >= 64) {
                c();
                return this.b.f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.f3931a;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.f3931a = j3;
            long j4 = j - 1;
            this.f3931a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            a aVar = this.b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.b.f(0);
            }
            return z;
        }

        public void g() {
            this.f3931a = 0;
            a aVar = this.b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i) {
            if (i >= 64) {
                c();
                this.b.h(i - 64);
                return;
            }
            this.f3931a |= 1 << i;
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.f3931a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.f3931a);
        }
    }

    /* renamed from: xj$b */
    /* compiled from: ChildHelper */
    public interface b {
    }

    public xj(b bVar) {
        this.f3930a = bVar;
    }

    public void a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = ((xk) this.f3930a).b();
        } else {
            i2 = f(i);
        }
        this.b.e(i2, z);
        if (z) {
            i(view);
        }
        xk xkVar = (xk) this.f3930a;
        xkVar.f3935a.addView(view, i2);
        RecyclerView recyclerView = xkVar.f3935a;
        Objects.requireNonNull(recyclerView);
        RecyclerView.a0 K = RecyclerView.K(view);
        recyclerView.S();
        RecyclerView.e eVar = recyclerView.q;
        if (!(eVar == null || K == null)) {
            eVar.onViewAttachedToWindow(K);
        }
        List<RecyclerView.o> list = recyclerView.I;
        if (list != null) {
            int size = list.size();
            while (true) {
                size--;
                if (size >= 0) {
                    recyclerView.I.get(size).b(view);
                } else {
                    return;
                }
            }
        }
    }

    public void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = ((xk) this.f3930a).b();
        } else {
            i2 = f(i);
        }
        this.b.e(i2, z);
        if (z) {
            i(view);
        }
        xk xkVar = (xk) this.f3930a;
        Objects.requireNonNull(xkVar);
        RecyclerView.a0 K = RecyclerView.K(view);
        if (K != null) {
            if (K.isTmpDetached() || K.shouldIgnore()) {
                K.clearTmpDetachFlag();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(K);
                throw new IllegalArgumentException(hj1.A(xkVar.f3935a, sb));
            }
        }
        xkVar.f3935a.attachViewToParent(view, i2, layoutParams);
    }

    public void c(int i) {
        RecyclerView.a0 K;
        int f = f(i);
        this.b.f(f);
        xk xkVar = (xk) this.f3930a;
        View childAt = xkVar.f3935a.getChildAt(f);
        if (!(childAt == null || (K = RecyclerView.K(childAt)) == null)) {
            if (!K.isTmpDetached() || K.shouldIgnore()) {
                K.addFlags(256);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(K);
                throw new IllegalArgumentException(hj1.A(xkVar.f3935a, sb));
            }
        }
        xkVar.f3935a.detachViewFromParent((RecyclerView) f);
    }

    public View d(int i) {
        return ((xk) this.f3930a).a(f(i));
    }

    public int e() {
        return ((xk) this.f3930a).b() - this.c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int b2 = ((xk) this.f3930a).b();
        int i2 = i;
        while (i2 < b2) {
            int b3 = i - (i2 - this.b.b(i2));
            if (b3 == 0) {
                while (this.b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b3;
        }
        return -1;
    }

    public View g(int i) {
        return ((xk) this.f3930a).f3935a.getChildAt(i);
    }

    public int h() {
        return ((xk) this.f3930a).b();
    }

    public final void i(View view) {
        this.c.add(view);
        xk xkVar = (xk) this.f3930a;
        Objects.requireNonNull(xkVar);
        RecyclerView.a0 K = RecyclerView.K(view);
        if (K != null) {
            K.onEnteredHiddenState(xkVar.f3935a);
        }
    }

    public int j(View view) {
        int indexOfChild = ((xk) this.f3930a).f3935a.indexOfChild(view);
        if (indexOfChild != -1 && !this.b.d(indexOfChild)) {
            return indexOfChild - this.b.b(indexOfChild);
        }
        return -1;
    }

    public boolean k(View view) {
        return this.c.contains(view);
    }

    public void l(int i) {
        int f = f(i);
        View a2 = ((xk) this.f3930a).a(f);
        if (a2 != null) {
            if (this.b.f(f)) {
                m(a2);
            }
            ((xk) this.f3930a).c(f);
        }
    }

    public final boolean m(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        xk xkVar = (xk) this.f3930a;
        Objects.requireNonNull(xkVar);
        RecyclerView.a0 K = RecyclerView.K(view);
        if (K == null) {
            return true;
        }
        K.onLeftHiddenState(xkVar.f3935a);
        return true;
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
