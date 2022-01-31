package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import com.razorpay.AnalyticsConstants;
import defpackage.b1;
import defpackage.p1;
import defpackage.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: t0  reason: default package */
/* compiled from: WindowDecorActionBar */
public class t0 extends x implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final Interpolator A = new AccelerateInterpolator();
    public static final Interpolator B = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public Context f3285a;
    public Context b;
    public ActionBarOverlayLayout c;
    public ActionBarContainer d;
    public DecorToolbar e;
    public ActionBarContextView f;
    public View g;
    public boolean h;
    public d i;
    public b1 j;
    public b1.a k;
    public boolean l;
    public ArrayList<x.b> m = new ArrayList<>();
    public boolean n;
    public int o = 0;
    public boolean p = true;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t = true;
    public h1 u;
    public boolean v;
    public boolean w;
    public final z8 x = new a();
    public final z8 y = new b();
    public final b9 z = new c();

    /* renamed from: t0$a */
    /* compiled from: WindowDecorActionBar */
    public class a extends a9 {
        public a() {
        }

        @Override // defpackage.a9, defpackage.z8
        public void onAnimationEnd(View view) {
            View view2;
            t0 t0Var = t0.this;
            if (t0Var.p && (view2 = t0Var.g) != null) {
                view2.setTranslationY(0.0f);
                t0.this.d.setTranslationY(0.0f);
            }
            t0.this.d.setVisibility(8);
            t0.this.d.setTransitioning(false);
            t0 t0Var2 = t0.this;
            t0Var2.u = null;
            b1.a aVar = t0Var2.k;
            if (aVar != null) {
                aVar.a(t0Var2.j);
                t0Var2.j = null;
                t0Var2.k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = t0.this.c;
            if (actionBarOverlayLayout != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                actionBarOverlayLayout.requestApplyInsets();
            }
        }
    }

    /* renamed from: t0$b */
    /* compiled from: WindowDecorActionBar */
    public class b extends a9 {
        public b() {
        }

        @Override // defpackage.a9, defpackage.z8
        public void onAnimationEnd(View view) {
            t0 t0Var = t0.this;
            t0Var.u = null;
            t0Var.d.requestLayout();
        }
    }

    /* renamed from: t0$c */
    /* compiled from: WindowDecorActionBar */
    public class c implements b9 {
        public c() {
        }
    }

    /* renamed from: t0$d */
    /* compiled from: WindowDecorActionBar */
    public class d extends b1 implements p1.a {
        public final Context h;
        public final p1 i;
        public b1.a j;
        public WeakReference<View> k;

        public d(Context context, b1.a aVar) {
            this.h = context;
            this.j = aVar;
            p1 p1Var = new p1(context);
            p1Var.l = 1;
            this.i = p1Var;
            p1Var.e = this;
        }

        @Override // defpackage.b1
        public void a() {
            t0 t0Var = t0.this;
            if (t0Var.i == this) {
                boolean z = t0Var.q;
                boolean z2 = t0Var.r;
                boolean z3 = true;
                if (z || z2) {
                    z3 = false;
                }
                if (!z3) {
                    t0Var.j = this;
                    t0Var.k = this.j;
                } else {
                    this.j.a(this);
                }
                this.j = null;
                t0.this.D(false);
                t0.this.f.closeMode();
                t0.this.e.getViewGroup().sendAccessibilityEvent(32);
                t0 t0Var2 = t0.this;
                t0Var2.c.setHideOnContentScrollEnabled(t0Var2.w);
                t0.this.i = null;
            }
        }

        @Override // defpackage.b1
        public View b() {
            WeakReference<View> weakReference = this.k;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // defpackage.b1
        public Menu c() {
            return this.i;
        }

        @Override // defpackage.b1
        public MenuInflater d() {
            return new g1(this.h);
        }

        @Override // defpackage.b1
        public CharSequence e() {
            return t0.this.f.getSubtitle();
        }

        @Override // defpackage.b1
        public CharSequence f() {
            return t0.this.f.getTitle();
        }

        @Override // defpackage.b1
        public void g() {
            if (t0.this.i == this) {
                this.i.A();
                try {
                    this.j.c(this, this.i);
                } finally {
                    this.i.z();
                }
            }
        }

        @Override // defpackage.b1
        public boolean h() {
            return t0.this.f.isTitleOptional();
        }

        @Override // defpackage.b1
        public void i(View view) {
            t0.this.f.setCustomView(view);
            this.k = new WeakReference<>(view);
        }

        @Override // defpackage.b1
        public void j(int i2) {
            t0.this.f.setSubtitle(t0.this.f3285a.getResources().getString(i2));
        }

        @Override // defpackage.b1
        public void k(CharSequence charSequence) {
            t0.this.f.setSubtitle(charSequence);
        }

        @Override // defpackage.b1
        public void l(int i2) {
            t0.this.f.setTitle(t0.this.f3285a.getResources().getString(i2));
        }

        @Override // defpackage.b1
        public void m(CharSequence charSequence) {
            t0.this.f.setTitle(charSequence);
        }

        @Override // defpackage.b1
        public void n(boolean z) {
            this.g = z;
            t0.this.f.setTitleOptional(z);
        }

        @Override // defpackage.p1.a
        public boolean onMenuItemSelected(p1 p1Var, MenuItem menuItem) {
            b1.a aVar = this.j;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // defpackage.p1.a
        public void onMenuModeChange(p1 p1Var) {
            if (this.j != null) {
                g();
                t0.this.f.showOverflowMenu();
            }
        }
    }

    public t0(Activity activity, boolean z2) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        E(decorView);
        if (!z2) {
            this.g = decorView.findViewById(16908290);
        }
    }

    @Override // defpackage.x
    public void A(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // defpackage.x
    public void B() {
        if (this.q) {
            this.q = false;
            H(false);
        }
    }

    @Override // defpackage.x
    public b1 C(b1.a aVar) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.killMode();
        d dVar2 = new d(this.f.getContext(), aVar);
        dVar2.i.A();
        try {
            if (!dVar2.j.b(dVar2, dVar2.i)) {
                return null;
            }
            this.i = dVar2;
            dVar2.g();
            this.f.initForMode(dVar2);
            D(true);
            this.f.sendAccessibilityEvent(32);
            return dVar2;
        } finally {
            dVar2.i.z();
        }
    }

    public void D(boolean z2) {
        y8 y8Var;
        y8 y8Var2;
        if (z2) {
            if (!this.s) {
                this.s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                H(false);
            }
        } else if (this.s) {
            this.s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            H(false);
        }
        ActionBarContainer actionBarContainer = this.d;
        AtomicInteger atomicInteger = r8.f3055a;
        if (actionBarContainer.isLaidOut()) {
            if (z2) {
                y8Var = this.e.setupAnimatorToVisibility(4, 100);
                y8Var2 = this.f.setupAnimatorToVisibility(0, 200);
            } else {
                y8Var2 = this.e.setupAnimatorToVisibility(0, 200);
                y8Var = this.f.setupAnimatorToVisibility(8, 100);
            }
            h1 h1Var = new h1();
            h1Var.f1327a.add(y8Var);
            View view = y8Var.f4016a.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = y8Var2.f4016a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            h1Var.f1327a.add(y8Var2);
            h1Var.b();
        } else if (z2) {
            this.e.setVisibility(4);
            this.f.setVisibility(0);
        } else {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        }
    }

    public final void E(View view) {
        DecorToolbar decorToolbar;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R.id.action_bar);
        if (findViewById instanceof DecorToolbar) {
            decorToolbar = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            decorToolbar = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder i0 = hj1.i0("Can't make a decor toolbar out of ");
            i0.append(findViewById != null ? findViewById.getClass().getSimpleName() : AnalyticsConstants.NULL);
            throw new IllegalStateException(i0.toString());
        }
        this.e = decorToolbar;
        this.f = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.d = actionBarContainer;
        DecorToolbar decorToolbar2 = this.e;
        if (decorToolbar2 == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException(t0.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f3285a = decorToolbar2.getContext();
        boolean z2 = (this.e.getDisplayOptions() & 4) != 0;
        if (z2) {
            this.h = true;
        }
        Context context = this.f3285a;
        this.e.setHomeButtonEnabled((context.getApplicationInfo().targetSdkVersion < 14) || z2);
        G(context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f3285a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            if (this.c.isInOverlayMode()) {
                this.w = true;
                this.c.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.d;
            AtomicInteger atomicInteger = r8.f3055a;
            actionBarContainer2.setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void F(int i2, int i3) {
        int displayOptions = this.e.getDisplayOptions();
        if ((i3 & 4) != 0) {
            this.h = true;
        }
        this.e.setDisplayOptions((i2 & i3) | ((~i3) & displayOptions));
    }

    public final void G(boolean z2) {
        this.n = z2;
        if (!z2) {
            this.e.setEmbeddedTabView(null);
            this.d.setTabContainer(null);
        } else {
            this.d.setTabContainer(null);
            this.e.setEmbeddedTabView(null);
        }
        boolean z3 = true;
        boolean z4 = this.e.getNavigationMode() == 2;
        this.e.setCollapsible(!this.n && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (this.n || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    public final void H(boolean z2) {
        View view;
        View view2;
        View view3;
        if (this.s || (!this.q && !this.r)) {
            if (!this.t) {
                this.t = true;
                h1 h1Var = this.u;
                if (h1Var != null) {
                    h1Var.a();
                }
                this.d.setVisibility(0);
                if (this.o != 0 || (!this.v && !z2)) {
                    this.d.setAlpha(1.0f);
                    this.d.setTranslationY(0.0f);
                    if (this.p && (view2 = this.g) != null) {
                        view2.setTranslationY(0.0f);
                    }
                    this.y.onAnimationEnd(null);
                } else {
                    this.d.setTranslationY(0.0f);
                    float f2 = (float) (-this.d.getHeight());
                    if (z2) {
                        int[] iArr = {0, 0};
                        this.d.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.d.setTranslationY(f2);
                    h1 h1Var2 = new h1();
                    y8 b2 = r8.b(this.d);
                    b2.h(0.0f);
                    b2.f(this.z);
                    if (!h1Var2.e) {
                        h1Var2.f1327a.add(b2);
                    }
                    if (this.p && (view3 = this.g) != null) {
                        view3.setTranslationY(f2);
                        y8 b3 = r8.b(this.g);
                        b3.h(0.0f);
                        if (!h1Var2.e) {
                            h1Var2.f1327a.add(b3);
                        }
                    }
                    Interpolator interpolator = B;
                    boolean z3 = h1Var2.e;
                    if (!z3) {
                        h1Var2.c = interpolator;
                    }
                    if (!z3) {
                        h1Var2.b = 250;
                    }
                    z8 z8Var = this.y;
                    if (!z3) {
                        h1Var2.d = z8Var;
                    }
                    this.u = h1Var2;
                    h1Var2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    actionBarOverlayLayout.requestApplyInsets();
                }
            }
        } else if (this.t) {
            this.t = false;
            h1 h1Var3 = this.u;
            if (h1Var3 != null) {
                h1Var3.a();
            }
            if (this.o != 0 || (!this.v && !z2)) {
                this.x.onAnimationEnd(null);
                return;
            }
            this.d.setAlpha(1.0f);
            this.d.setTransitioning(true);
            h1 h1Var4 = new h1();
            float f3 = (float) (-this.d.getHeight());
            if (z2) {
                int[] iArr2 = {0, 0};
                this.d.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            y8 b4 = r8.b(this.d);
            b4.h(f3);
            b4.f(this.z);
            if (!h1Var4.e) {
                h1Var4.f1327a.add(b4);
            }
            if (this.p && (view = this.g) != null) {
                y8 b5 = r8.b(view);
                b5.h(f3);
                if (!h1Var4.e) {
                    h1Var4.f1327a.add(b5);
                }
            }
            Interpolator interpolator2 = A;
            boolean z4 = h1Var4.e;
            if (!z4) {
                h1Var4.c = interpolator2;
            }
            if (!z4) {
                h1Var4.b = 250;
            }
            z8 z8Var2 = this.x;
            if (!z4) {
                h1Var4.d = z8Var2;
            }
            this.u = h1Var4;
            h1Var4.b();
        }
    }

    @Override // defpackage.x
    public boolean b() {
        DecorToolbar decorToolbar = this.e;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.e.collapseActionView();
        return true;
    }

    @Override // defpackage.x
    public void c(boolean z2) {
        if (z2 != this.l) {
            this.l = z2;
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a(z2);
            }
        }
    }

    @Override // defpackage.x
    public int d() {
        return this.e.getDisplayOptions();
    }

    @Override // defpackage.x
    public Context e() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.f3285a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.b = new ContextThemeWrapper(this.f3285a, i2);
            } else {
                this.b = this.f3285a;
            }
        }
        return this.b;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z2) {
        this.p = z2;
    }

    @Override // defpackage.x
    public void f() {
        if (!this.q) {
            this.q = true;
            H(false);
        }
    }

    @Override // defpackage.x
    public void h(Configuration configuration) {
        G(this.f3285a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (!this.r) {
            this.r = true;
            H(true);
        }
    }

    @Override // defpackage.x
    public boolean j(int i2, KeyEvent keyEvent) {
        p1 p1Var;
        d dVar = this.i;
        if (dVar == null || (p1Var = dVar.i) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        p1Var.setQwertyMode(z2);
        return p1Var.performShortcut(i2, keyEvent, 0);
    }

    @Override // defpackage.x
    public void m(View view) {
        this.e.setCustomView(view);
    }

    @Override // defpackage.x
    public void n(boolean z2) {
        if (!this.h) {
            F(z2 ? 4 : 0, 4);
        }
    }

    @Override // defpackage.x
    public void o(boolean z2) {
        F(z2 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        h1 h1Var = this.u;
        if (h1Var != null) {
            h1Var.a();
            this.u = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i2) {
        this.o = i2;
    }

    @Override // defpackage.x
    public void p(boolean z2) {
        F(z2 ? 16 : 0, 16);
    }

    @Override // defpackage.x
    public void q(boolean z2) {
        F(z2 ? 2 : 0, 2);
    }

    @Override // defpackage.x
    public void r(boolean z2) {
        F(z2 ? 1 : 0, 1);
    }

    @Override // defpackage.x
    public void s(int i2) {
        this.e.setNavigationContentDescription(i2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.r) {
            this.r = false;
            H(true);
        }
    }

    @Override // defpackage.x
    public void t(int i2) {
        this.e.setNavigationIcon(i2);
    }

    @Override // defpackage.x
    public void u(Drawable drawable) {
        this.e.setNavigationIcon(drawable);
    }

    @Override // defpackage.x
    public void v(boolean z2) {
        this.e.setHomeButtonEnabled(z2);
    }

    @Override // defpackage.x
    public void w(boolean z2) {
        h1 h1Var;
        this.v = z2;
        if (!z2 && (h1Var = this.u) != null) {
            h1Var.a();
        }
    }

    @Override // defpackage.x
    public void x(CharSequence charSequence) {
        this.e.setSubtitle(charSequence);
    }

    @Override // defpackage.x
    public void y(int i2) {
        this.e.setTitle(this.f3285a.getString(i2));
    }

    @Override // defpackage.x
    public void z(CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    public t0(Dialog dialog) {
        new ArrayList();
        E(dialog.getWindow().getDecorView());
    }
}
