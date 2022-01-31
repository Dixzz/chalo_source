package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import defpackage.p1;
import defpackage.v1;
import defpackage.x;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: q0  reason: default package */
/* compiled from: ToolbarActionBar */
public class q0 extends x {

    /* renamed from: a  reason: collision with root package name */
    public DecorToolbar f2877a;
    public boolean b;
    public Window.Callback c;
    public boolean d;
    public boolean e;
    public ArrayList<x.b> f = new ArrayList<>();
    public final Runnable g = new a();
    public final Toolbar.OnMenuItemClickListener h;

    /* renamed from: q0$a */
    /* compiled from: ToolbarActionBar */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            q0 q0Var = q0.this;
            Menu D = q0Var.D();
            p1 p1Var = D instanceof p1 ? (p1) D : null;
            if (p1Var != null) {
                p1Var.A();
            }
            try {
                D.clear();
                if (!q0Var.c.onCreatePanelMenu(0, D) || !q0Var.c.onPreparePanel(0, null, D)) {
                    D.clear();
                }
            } finally {
                if (p1Var != null) {
                    p1Var.z();
                }
            }
        }
    }

    /* renamed from: q0$b */
    /* compiled from: ToolbarActionBar */
    public class b implements Toolbar.OnMenuItemClickListener {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return q0.this.c.onMenuItemSelected(0, menuItem);
        }
    }

    /* renamed from: q0$c */
    /* compiled from: ToolbarActionBar */
    public final class c implements v1.a {
        public boolean f;

        public c() {
        }

        @Override // defpackage.v1.a
        public void onCloseMenu(p1 p1Var, boolean z) {
            if (!this.f) {
                this.f = true;
                q0.this.f2877a.dismissPopupMenus();
                Window.Callback callback = q0.this.c;
                if (callback != null) {
                    callback.onPanelClosed(108, p1Var);
                }
                this.f = false;
            }
        }

        @Override // defpackage.v1.a
        public boolean onOpenSubMenu(p1 p1Var) {
            Window.Callback callback = q0.this.c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, p1Var);
            return true;
        }
    }

    /* renamed from: q0$d */
    /* compiled from: ToolbarActionBar */
    public final class d implements p1.a {
        public d() {
        }

        @Override // defpackage.p1.a
        public boolean onMenuItemSelected(p1 p1Var, MenuItem menuItem) {
            return false;
        }

        @Override // defpackage.p1.a
        public void onMenuModeChange(p1 p1Var) {
            q0 q0Var = q0.this;
            if (q0Var.c == null) {
                return;
            }
            if (q0Var.f2877a.isOverflowMenuShowing()) {
                q0.this.c.onPanelClosed(108, p1Var);
            } else if (q0.this.c.onPreparePanel(0, null, p1Var)) {
                q0.this.c.onMenuOpened(108, p1Var);
            }
        }
    }

    /* renamed from: q0$e */
    /* compiled from: ToolbarActionBar */
    public class e extends i1 {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // defpackage.i1
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(q0.this.f2877a.getContext());
            }
            return this.f.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = this.f.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                q0 q0Var = q0.this;
                if (!q0Var.b) {
                    q0Var.f2877a.setMenuPrepared();
                    q0.this.b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public q0(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.h = bVar;
        this.f2877a = new ToolbarWidgetWrapper(toolbar, false);
        e eVar = new e(callback);
        this.c = eVar;
        this.f2877a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f2877a.setWindowTitle(charSequence);
    }

    @Override // defpackage.x
    public void A(CharSequence charSequence) {
        this.f2877a.setWindowTitle(charSequence);
    }

    @Override // defpackage.x
    public void B() {
        this.f2877a.setVisibility(0);
    }

    public final Menu D() {
        if (!this.d) {
            this.f2877a.setMenuCallbacks(new c(), new d());
            this.d = true;
        }
        return this.f2877a.getMenu();
    }

    public void E(int i, int i2) {
        this.f2877a.setDisplayOptions((i & i2) | ((~i2) & this.f2877a.getDisplayOptions()));
    }

    @Override // defpackage.x
    public boolean a() {
        return this.f2877a.hideOverflowMenu();
    }

    @Override // defpackage.x
    public boolean b() {
        if (!this.f2877a.hasExpandedActionView()) {
            return false;
        }
        this.f2877a.collapseActionView();
        return true;
    }

    @Override // defpackage.x
    public void c(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(z);
            }
        }
    }

    @Override // defpackage.x
    public int d() {
        return this.f2877a.getDisplayOptions();
    }

    @Override // defpackage.x
    public Context e() {
        return this.f2877a.getContext();
    }

    @Override // defpackage.x
    public void f() {
        this.f2877a.setVisibility(8);
    }

    @Override // defpackage.x
    public boolean g() {
        this.f2877a.getViewGroup().removeCallbacks(this.g);
        ViewGroup viewGroup = this.f2877a.getViewGroup();
        Runnable runnable = this.g;
        AtomicInteger atomicInteger = r8.f3055a;
        viewGroup.postOnAnimation(runnable);
        return true;
    }

    @Override // defpackage.x
    public void h(Configuration configuration) {
    }

    @Override // defpackage.x
    public void i() {
        this.f2877a.getViewGroup().removeCallbacks(this.g);
    }

    @Override // defpackage.x
    public boolean j(int i, KeyEvent keyEvent) {
        Menu D = D();
        if (D == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        D.setQwertyMode(z);
        return D.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.x
    public boolean k(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            this.f2877a.showOverflowMenu();
        }
        return true;
    }

    @Override // defpackage.x
    public boolean l() {
        return this.f2877a.showOverflowMenu();
    }

    @Override // defpackage.x
    public void m(View view) {
        x.a aVar = new x.a(-2, -2);
        if (view != null) {
            view.setLayoutParams(aVar);
        }
        this.f2877a.setCustomView(view);
    }

    @Override // defpackage.x
    public void n(boolean z) {
    }

    @Override // defpackage.x
    public void o(boolean z) {
        E(z ? 4 : 0, 4);
    }

    @Override // defpackage.x
    public void p(boolean z) {
        E(z ? 16 : 0, 16);
    }

    @Override // defpackage.x
    public void q(boolean z) {
        E(z ? 2 : 0, 2);
    }

    @Override // defpackage.x
    public void r(boolean z) {
        E(z ? 1 : 0, 1);
    }

    @Override // defpackage.x
    public void s(int i) {
        this.f2877a.setNavigationContentDescription(i);
    }

    @Override // defpackage.x
    public void t(int i) {
        this.f2877a.setNavigationIcon(i);
    }

    @Override // defpackage.x
    public void u(Drawable drawable) {
        this.f2877a.setNavigationIcon(drawable);
    }

    @Override // defpackage.x
    public void v(boolean z) {
    }

    @Override // defpackage.x
    public void w(boolean z) {
    }

    @Override // defpackage.x
    public void x(CharSequence charSequence) {
        this.f2877a.setSubtitle(charSequence);
    }

    @Override // defpackage.x
    public void y(int i) {
        DecorToolbar decorToolbar = this.f2877a;
        decorToolbar.setTitle(i != 0 ? decorToolbar.getContext().getText(i) : null);
    }

    @Override // defpackage.x
    public void z(CharSequence charSequence) {
        this.f2877a.setTitle(charSequence);
    }
}
