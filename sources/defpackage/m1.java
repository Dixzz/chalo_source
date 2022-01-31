package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import defpackage.v1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: m1  reason: default package */
/* compiled from: CascadingMenuPopup */
public final class m1 extends t1 implements v1, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int G = R.layout.abc_cascading_menu_item_layout;
    public boolean A;
    public boolean B;
    public v1.a C;
    public ViewTreeObserver D;
    public PopupWindow.OnDismissListener E;
    public boolean F;
    public final Context g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;
    public final Handler l;
    public final List<p1> m = new ArrayList();
    public final List<d> n = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener o = new a();
    public final View.OnAttachStateChangeListener p = new b();
    public final MenuItemHoverListener q = new c();
    public int r;
    public int s;
    public View t;
    public View u;
    public int v;
    public boolean w;
    public boolean x;
    public int y;
    public int z;

    /* renamed from: m1$a */
    /* compiled from: CascadingMenuPopup */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (m1.this.isShowing() && m1.this.n.size() > 0 && !m1.this.n.get(0).f2306a.isModal()) {
                View view = m1.this.u;
                if (view == null || !view.isShown()) {
                    m1.this.dismiss();
                    return;
                }
                for (d dVar : m1.this.n) {
                    dVar.f2306a.show();
                }
            }
        }
    }

    /* renamed from: m1$b */
    /* compiled from: CascadingMenuPopup */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = m1.this.D;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    m1.this.D = view.getViewTreeObserver();
                }
                m1 m1Var = m1.this;
                m1Var.D.removeGlobalOnLayoutListener(m1Var.o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: m1$c */
    /* compiled from: CascadingMenuPopup */
    public class c implements MenuItemHoverListener {

        /* renamed from: m1$c$a */
        /* compiled from: CascadingMenuPopup */
        public class a implements Runnable {
            public final /* synthetic */ d f;
            public final /* synthetic */ MenuItem g;
            public final /* synthetic */ p1 h;

            public a(d dVar, MenuItem menuItem, p1 p1Var) {
                this.f = dVar;
                this.g = menuItem;
                this.h = p1Var;
            }

            public void run() {
                d dVar = this.f;
                if (dVar != null) {
                    m1.this.F = true;
                    dVar.b.c(false);
                    m1.this.F = false;
                }
                if (this.g.isEnabled() && this.g.hasSubMenu()) {
                    this.h.r(this.g, 4);
                }
            }
        }

        public c() {
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(p1 p1Var, MenuItem menuItem) {
            d dVar = null;
            m1.this.l.removeCallbacksAndMessages(null);
            int size = m1.this.n.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (p1Var == m1.this.n.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < m1.this.n.size()) {
                    dVar = m1.this.n.get(i2);
                }
                m1.this.l.postAtTime(new a(dVar, menuItem, p1Var), p1Var, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(p1 p1Var, MenuItem menuItem) {
            m1.this.l.removeCallbacksAndMessages(p1Var);
        }
    }

    /* renamed from: m1$d */
    /* compiled from: CascadingMenuPopup */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f2306a;
        public final p1 b;
        public final int c;

        public d(MenuPopupWindow menuPopupWindow, p1 p1Var, int i) {
            this.f2306a = menuPopupWindow;
            this.b = p1Var;
            this.c = i;
        }

        public ListView a() {
            return this.f2306a.getListView();
        }
    }

    public m1(Context context, View view, int i2, int i3, boolean z2) {
        int i4 = 0;
        this.r = 0;
        this.s = 0;
        this.g = context;
        this.t = view;
        this.i = i2;
        this.j = i3;
        this.k = z2;
        this.A = false;
        AtomicInteger atomicInteger = r8.f3055a;
        this.v = view.getLayoutDirection() != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.l = new Handler();
    }

    @Override // defpackage.t1
    public void a(p1 p1Var) {
        p1Var.b(this, this.g);
        if (isShowing()) {
            l(p1Var);
        } else {
            this.m.add(p1Var);
        }
    }

    @Override // defpackage.t1
    public boolean b() {
        return false;
    }

    @Override // defpackage.t1
    public void d(View view) {
        if (this.t != view) {
            this.t = view;
            int i2 = this.r;
            AtomicInteger atomicInteger = r8.f3055a;
            this.s = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    @Override // defpackage.y1
    public void dismiss() {
        int size = this.n.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.n.toArray(new d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d dVar = dVarArr[i2];
                if (dVar.f2306a.isShowing()) {
                    dVar.f2306a.dismiss();
                }
            }
        }
    }

    @Override // defpackage.t1
    public void e(boolean z2) {
        this.A = z2;
    }

    @Override // defpackage.t1
    public void f(int i2) {
        if (this.r != i2) {
            this.r = i2;
            View view = this.t;
            AtomicInteger atomicInteger = r8.f3055a;
            this.s = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    @Override // defpackage.v1
    public boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.t1
    public void g(int i2) {
        this.w = true;
        this.y = i2;
    }

    @Override // defpackage.y1
    public ListView getListView() {
        if (this.n.isEmpty()) {
            return null;
        }
        return ((d) hj1.t(this.n, -1)).a();
    }

    @Override // defpackage.t1
    public void h(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    @Override // defpackage.t1
    public void i(boolean z2) {
        this.B = z2;
    }

    @Override // defpackage.y1
    public boolean isShowing() {
        return this.n.size() > 0 && this.n.get(0).f2306a.isShowing();
    }

    @Override // defpackage.t1
    public void j(int i2) {
        this.x = true;
        this.z = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0113, code lost:
        if (((r7.getWidth() + r9[0]) + r2) > r10.right) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0119, code lost:
        if ((r9[0] - r2) < 0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011d, code lost:
        r7 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(defpackage.p1 r15) {
        /*
        // Method dump skipped, instructions count: 478
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m1.l(p1):void");
    }

    @Override // defpackage.v1
    public void onCloseMenu(p1 p1Var, boolean z2) {
        int size = this.n.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (p1Var == this.n.get(i2).b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int i3 = i2 + 1;
            if (i3 < this.n.size()) {
                this.n.get(i3).b.c(false);
            }
            d remove = this.n.remove(i2);
            remove.b.u(this);
            if (this.F) {
                remove.f2306a.setExitTransition(null);
                remove.f2306a.setAnimationStyle(0);
            }
            remove.f2306a.dismiss();
            int size2 = this.n.size();
            if (size2 > 0) {
                this.v = this.n.get(size2 - 1).c;
            } else {
                View view = this.t;
                AtomicInteger atomicInteger = r8.f3055a;
                this.v = view.getLayoutDirection() == 1 ? 0 : 1;
            }
            if (size2 == 0) {
                dismiss();
                v1.a aVar = this.C;
                if (aVar != null) {
                    aVar.onCloseMenu(p1Var, true);
                }
                ViewTreeObserver viewTreeObserver = this.D;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.D.removeGlobalOnLayoutListener(this.o);
                    }
                    this.D = null;
                }
                this.u.removeOnAttachStateChangeListener(this.p);
                this.E.onDismiss();
            } else if (z2) {
                this.n.get(0).b.c(false);
            }
        }
    }

    public void onDismiss() {
        d dVar;
        int size = this.n.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.n.get(i2);
            if (!dVar.f2306a.isShowing()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.b.c(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // defpackage.v1
    public boolean onSubMenuSelected(a2 a2Var) {
        for (d dVar : this.n) {
            if (a2Var == dVar.b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!a2Var.hasVisibleItems()) {
            return false;
        }
        a2Var.b(this, this.g);
        if (isShowing()) {
            l(a2Var);
        } else {
            this.m.add(a2Var);
        }
        v1.a aVar = this.C;
        if (aVar != null) {
            aVar.onOpenSubMenu(a2Var);
        }
        return true;
    }

    @Override // defpackage.v1
    public void setCallback(v1.a aVar) {
        this.C = aVar;
    }

    @Override // defpackage.y1
    public void show() {
        if (!isShowing()) {
            for (p1 p1Var : this.m) {
                l(p1Var);
            }
            this.m.clear();
            View view = this.t;
            this.u = view;
            if (view != null) {
                boolean z2 = this.D == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.D = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.o);
                }
                this.u.addOnAttachStateChangeListener(this.p);
            }
        }
    }

    @Override // defpackage.v1
    public void updateMenuView(boolean z2) {
        for (d dVar : this.n) {
            ListAdapter adapter = dVar.a().getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((o1) adapter).notifyDataSetChanged();
        }
    }
}
