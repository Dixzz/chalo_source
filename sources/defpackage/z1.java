package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuPopupWindow;
import defpackage.v1;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: z1  reason: default package */
/* compiled from: StandardMenuPopup */
public final class z1 extends t1 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, v1, View.OnKeyListener {
    public static final int A = R.layout.abc_popup_menu_item_layout;
    public final Context g;
    public final p1 h;
    public final o1 i;
    public final boolean j;
    public final int k;
    public final int l;
    public final int m;
    public final MenuPopupWindow n;
    public final ViewTreeObserver.OnGlobalLayoutListener o = new a();
    public final View.OnAttachStateChangeListener p = new b();
    public PopupWindow.OnDismissListener q;
    public View r;
    public View s;
    public v1.a t;
    public ViewTreeObserver u;
    public boolean v;
    public boolean w;
    public int x;
    public int y = 0;
    public boolean z;

    /* renamed from: z1$a */
    /* compiled from: StandardMenuPopup */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (z1.this.isShowing() && !z1.this.n.isModal()) {
                View view = z1.this.s;
                if (view == null || !view.isShown()) {
                    z1.this.dismiss();
                } else {
                    z1.this.n.show();
                }
            }
        }
    }

    /* renamed from: z1$b */
    /* compiled from: StandardMenuPopup */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = z1.this.u;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    z1.this.u = view.getViewTreeObserver();
                }
                z1 z1Var = z1.this;
                z1Var.u.removeGlobalOnLayoutListener(z1Var.o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public z1(Context context, p1 p1Var, View view, int i2, int i3, boolean z2) {
        this.g = context;
        this.h = p1Var;
        this.j = z2;
        this.i = new o1(p1Var, LayoutInflater.from(context), z2, A);
        this.l = i2;
        this.m = i3;
        Resources resources = context.getResources();
        this.k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.r = view;
        this.n = new MenuPopupWindow(context, null, i2, i3);
        p1Var.b(this, context);
    }

    @Override // defpackage.t1
    public void a(p1 p1Var) {
    }

    @Override // defpackage.t1
    public void d(View view) {
        this.r = view;
    }

    @Override // defpackage.y1
    public void dismiss() {
        if (isShowing()) {
            this.n.dismiss();
        }
    }

    @Override // defpackage.t1
    public void e(boolean z2) {
        this.i.h = z2;
    }

    @Override // defpackage.t1
    public void f(int i2) {
        this.y = i2;
    }

    @Override // defpackage.v1
    public boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.t1
    public void g(int i2) {
        this.n.setHorizontalOffset(i2);
    }

    @Override // defpackage.y1
    public ListView getListView() {
        return this.n.getListView();
    }

    @Override // defpackage.t1
    public void h(PopupWindow.OnDismissListener onDismissListener) {
        this.q = onDismissListener;
    }

    @Override // defpackage.t1
    public void i(boolean z2) {
        this.z = z2;
    }

    @Override // defpackage.y1
    public boolean isShowing() {
        return !this.v && this.n.isShowing();
    }

    @Override // defpackage.t1
    public void j(int i2) {
        this.n.setVerticalOffset(i2);
    }

    @Override // defpackage.v1
    public void onCloseMenu(p1 p1Var, boolean z2) {
        if (p1Var == this.h) {
            dismiss();
            v1.a aVar = this.t;
            if (aVar != null) {
                aVar.onCloseMenu(p1Var, z2);
            }
        }
    }

    public void onDismiss() {
        this.v = true;
        this.h.c(true);
        ViewTreeObserver viewTreeObserver = this.u;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.u = this.s.getViewTreeObserver();
            }
            this.u.removeGlobalOnLayoutListener(this.o);
            this.u = null;
        }
        this.s.removeOnAttachStateChangeListener(this.p);
        PopupWindow.OnDismissListener onDismissListener = this.q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        if (a2Var.hasVisibleItems()) {
            u1 u1Var = new u1(this.g, a2Var, this.s, this.j, this.l, this.m);
            u1Var.setPresenterCallback(this.t);
            u1Var.setForceShowIcon(t1.k(a2Var));
            u1Var.setOnDismissListener(this.q);
            this.q = null;
            this.h.c(false);
            int horizontalOffset = this.n.getHorizontalOffset();
            int verticalOffset = this.n.getVerticalOffset();
            int i2 = this.y;
            View view = this.r;
            AtomicInteger atomicInteger = r8.f3055a;
            if ((Gravity.getAbsoluteGravity(i2, view.getLayoutDirection()) & 7) == 5) {
                horizontalOffset += this.r.getWidth();
            }
            if (u1Var.tryShow(horizontalOffset, verticalOffset)) {
                v1.a aVar = this.t;
                if (aVar == null) {
                    return true;
                }
                aVar.onOpenSubMenu(a2Var);
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.v1
    public void setCallback(v1.a aVar) {
        this.t = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c3  */
    @Override // defpackage.y1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show() {
        /*
        // Method dump skipped, instructions count: 203
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z1.show():void");
    }

    @Override // defpackage.v1
    public void updateMenuView(boolean z2) {
        this.w = false;
        o1 o1Var = this.i;
        if (o1Var != null) {
            o1Var.notifyDataSetChanged();
        }
    }
}
