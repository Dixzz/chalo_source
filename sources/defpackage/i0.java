package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.b1;
import defpackage.f1;
import defpackage.p1;
import defpackage.v1;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: i0  reason: default package */
/* compiled from: AppCompatDelegateImpl */
public class i0 extends h0 implements p1.a, LayoutInflater.Factory2 {
    public static final u2<String, Integer> d0 = new u2<>();
    public static final int[] e0 = {16842836};
    public static final boolean f0 = (!"robolectric".equals(Build.FINGERPRINT));
    public static final boolean g0 = true;
    public View A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public j[] J;
    public j K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q = -100;
    public int R;
    public boolean S;
    public boolean T;
    public g U;
    public g V;
    public boolean W;
    public int X;
    public final Runnable Y = new a();
    public boolean Z;
    public Rect a0;
    public Rect b0;
    public p0 c0;
    public final Object h;
    public final Context i;
    public Window j;
    public e k;
    public final g0 l;
    public x m;
    public MenuInflater n;
    public CharSequence o;
    public DecorContentParent p;
    public c q;
    public k r;
    public b1 s;
    public ActionBarContextView t;
    public PopupWindow u;
    public Runnable v;
    public y8 w = null;
    public boolean x;
    public ViewGroup y;
    public TextView z;

    /* renamed from: i0$a */
    /* compiled from: AppCompatDelegateImpl */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            i0 i0Var = i0.this;
            if ((i0Var.X & 1) != 0) {
                i0Var.I(0);
            }
            i0 i0Var2 = i0.this;
            if ((i0Var2.X & 4096) != 0) {
                i0Var2.I(108);
            }
            i0 i0Var3 = i0.this;
            i0Var3.W = false;
            i0Var3.X = 0;
        }
    }

    /* renamed from: i0$b */
    /* compiled from: AppCompatDelegateImpl */
    public class b implements y {
        public b() {
        }
    }

    /* renamed from: i0$c */
    /* compiled from: AppCompatDelegateImpl */
    public final class c implements v1.a {
        public c() {
        }

        @Override // defpackage.v1.a
        public void onCloseMenu(p1 p1Var, boolean z) {
            i0.this.E(p1Var);
        }

        @Override // defpackage.v1.a
        public boolean onOpenSubMenu(p1 p1Var) {
            Window.Callback Q = i0.this.Q();
            if (Q == null) {
                return true;
            }
            Q.onMenuOpened(108, p1Var);
            return true;
        }
    }

    /* renamed from: i0$d */
    /* compiled from: AppCompatDelegateImpl */
    public class d implements b1.a {

        /* renamed from: a  reason: collision with root package name */
        public b1.a f1449a;

        /* renamed from: i0$d$a */
        /* compiled from: AppCompatDelegateImpl */
        public class a extends a9 {
            public a() {
            }

            @Override // defpackage.a9, defpackage.z8
            public void onAnimationEnd(View view) {
                i0.this.t.setVisibility(8);
                i0 i0Var = i0.this;
                PopupWindow popupWindow = i0Var.u;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (i0Var.t.getParent() instanceof View) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    ((View) i0.this.t.getParent()).requestApplyInsets();
                }
                i0.this.t.killMode();
                i0.this.w.d(null);
                i0 i0Var2 = i0.this;
                i0Var2.w = null;
                ViewGroup viewGroup = i0Var2.y;
                AtomicInteger atomicInteger2 = r8.f3055a;
                viewGroup.requestApplyInsets();
            }
        }

        public d(b1.a aVar) {
            this.f1449a = aVar;
        }

        @Override // defpackage.b1.a
        public void a(b1 b1Var) {
            this.f1449a.a(b1Var);
            i0 i0Var = i0.this;
            if (i0Var.u != null) {
                i0Var.j.getDecorView().removeCallbacks(i0.this.v);
            }
            i0 i0Var2 = i0.this;
            if (i0Var2.t != null) {
                i0Var2.J();
                i0 i0Var3 = i0.this;
                y8 b2 = r8.b(i0Var3.t);
                b2.a(0.0f);
                i0Var3.w = b2;
                y8 y8Var = i0.this.w;
                a aVar = new a();
                View view = y8Var.f4016a.get();
                if (view != null) {
                    y8Var.e(view, aVar);
                }
            }
            i0 i0Var4 = i0.this;
            g0 g0Var = i0Var4.l;
            if (g0Var != null) {
                g0Var.onSupportActionModeFinished(i0Var4.s);
            }
            i0 i0Var5 = i0.this;
            i0Var5.s = null;
            ViewGroup viewGroup = i0Var5.y;
            AtomicInteger atomicInteger = r8.f3055a;
            viewGroup.requestApplyInsets();
        }

        @Override // defpackage.b1.a
        public boolean b(b1 b1Var, Menu menu) {
            return this.f1449a.b(b1Var, menu);
        }

        @Override // defpackage.b1.a
        public boolean c(b1 b1Var, Menu menu) {
            ViewGroup viewGroup = i0.this.y;
            AtomicInteger atomicInteger = r8.f3055a;
            viewGroup.requestApplyInsets();
            return this.f1449a.c(b1Var, menu);
        }

        @Override // defpackage.b1.a
        public boolean d(b1 b1Var, MenuItem menuItem) {
            return this.f1449a.d(b1Var, menuItem);
        }
    }

    /* renamed from: i0$f */
    /* compiled from: AppCompatDelegateImpl */
    public class f extends g {
        public final PowerManager c;

        public f(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // defpackage.i0.g
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // defpackage.i0.g
        public int c() {
            return this.c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // defpackage.i0.g
        public void d() {
            i0.this.A();
        }
    }

    /* renamed from: i0$g */
    /* compiled from: AppCompatDelegateImpl */
    public abstract class g {

        /* renamed from: a  reason: collision with root package name */
        public BroadcastReceiver f1451a;

        /* renamed from: i0$g$a */
        /* compiled from: AppCompatDelegateImpl */
        public class a extends BroadcastReceiver {
            public a() {
            }

            public void onReceive(Context context, Intent intent) {
                g.this.d();
            }
        }

        public g() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f1451a;
            if (broadcastReceiver != null) {
                try {
                    i0.this.i.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1451a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f1451a == null) {
                    this.f1451a = new a();
                }
                i0.this.i.registerReceiver(this.f1451a, b2);
            }
        }
    }

    /* renamed from: i0$h */
    /* compiled from: AppCompatDelegateImpl */
    public class h extends g {
        public final s0 c;

        public h(s0 s0Var) {
            super();
            this.c = s0Var;
        }

        @Override // defpackage.i0.g
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7  */
        @Override // defpackage.i0.g
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int c() {
            /*
            // Method dump skipped, instructions count: 254
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.h.c():int");
        }

        @Override // defpackage.i0.g
        public void d() {
            i0.this.A();
        }
    }

    /* renamed from: i0$i */
    /* compiled from: AppCompatDelegateImpl */
    public class i extends ContentFrameLayout {
        public i(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i0.this.H(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    i0 i0Var = i0.this;
                    i0Var.F(i0Var.P(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(u0.b(getContext(), i));
        }
    }

    /* renamed from: i0$j */
    /* compiled from: AppCompatDelegateImpl */
    public static final class j {

        /* renamed from: a  reason: collision with root package name */
        public int f1453a;
        public int b;
        public int c;
        public int d;
        public ViewGroup e;
        public View f;
        public View g;
        public p1 h;
        public n1 i;
        public Context j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o = false;
        public boolean p;
        public Bundle q;

        public j(int i2) {
            this.f1453a = i2;
        }

        public void a(p1 p1Var) {
            n1 n1Var;
            p1 p1Var2 = this.h;
            if (p1Var != p1Var2) {
                if (p1Var2 != null) {
                    p1Var2.u(this.i);
                }
                this.h = p1Var;
                if (p1Var != null && (n1Var = this.i) != null) {
                    p1Var.b(n1Var, p1Var.f2757a);
                }
            }
        }
    }

    /* renamed from: i0$k */
    /* compiled from: AppCompatDelegateImpl */
    public final class k implements v1.a {
        public k() {
        }

        @Override // defpackage.v1.a
        public void onCloseMenu(p1 p1Var, boolean z) {
            p1 k = p1Var.k();
            boolean z2 = k != p1Var;
            i0 i0Var = i0.this;
            if (z2) {
                p1Var = k;
            }
            j M = i0Var.M(p1Var);
            if (M == null) {
                return;
            }
            if (z2) {
                i0.this.D(M.f1453a, M, k);
                i0.this.F(M, true);
                return;
            }
            i0.this.F(M, z);
        }

        @Override // defpackage.v1.a
        public boolean onOpenSubMenu(p1 p1Var) {
            Window.Callback Q;
            if (p1Var != p1Var.k()) {
                return true;
            }
            i0 i0Var = i0.this;
            if (!i0Var.D || (Q = i0Var.Q()) == null || i0.this.P) {
                return true;
            }
            Q.onMenuOpened(108, p1Var);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r4 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i0(android.content.Context r4, android.view.Window r5, defpackage.g0 r6, java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.<init>(android.content.Context, android.view.Window, g0, java.lang.Object):void");
    }

    public boolean A() {
        return B(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean B(boolean r14) {
        /*
        // Method dump skipped, instructions count: 515
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.B(boolean):boolean");
    }

    public final void C(Window window) {
        if (this.j == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof e)) {
                e eVar = new e(callback);
                this.k = eVar;
                window.setCallback(eVar);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.i, (AttributeSet) null, e0);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.recycle();
                this.j = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public void D(int i2, j jVar, Menu menu) {
        if (menu == null && jVar != null) {
            menu = jVar.h;
        }
        if ((jVar == null || jVar.m) && !this.P) {
            this.k.f.onPanelClosed(i2, menu);
        }
    }

    public void E(p1 p1Var) {
        if (!this.I) {
            this.I = true;
            this.p.dismissPopups();
            Window.Callback Q2 = Q();
            if (Q2 != null && !this.P) {
                Q2.onPanelClosed(108, p1Var);
            }
            this.I = false;
        }
    }

    public void F(j jVar, boolean z2) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z2 || jVar.f1453a != 0 || (decorContentParent = this.p) == null || !decorContentParent.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.i.getSystemService("window");
            if (!(windowManager == null || !jVar.m || (viewGroup = jVar.e) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    D(jVar.f1453a, jVar, null);
                }
            }
            jVar.k = false;
            jVar.l = false;
            jVar.m = false;
            jVar.f = null;
            jVar.o = true;
            if (this.K == jVar) {
                this.K = null;
                return;
            }
            return;
        }
        E(jVar.h);
    }

    public final Configuration G(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean H(android.view.KeyEvent r7) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.H(android.view.KeyEvent):boolean");
    }

    public void I(int i2) {
        j P2 = P(i2);
        if (P2.h != null) {
            Bundle bundle = new Bundle();
            P2.h.w(bundle);
            if (bundle.size() > 0) {
                P2.q = bundle;
            }
            P2.h.A();
            P2.h.clear();
        }
        P2.p = true;
        P2.o = true;
        if ((i2 == 108 || i2 == 0) && this.p != null) {
            j P3 = P(0);
            P3.k = false;
            W(P3, null);
        }
    }

    public void J() {
        y8 y8Var = this.w;
        if (y8Var != null) {
            y8Var.b();
        }
    }

    public final void K() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.x) {
            TypedArray obtainStyledAttributes = this.i.obtainStyledAttributes(R.styleable.AppCompatTheme);
            int i2 = R.styleable.AppCompatTheme_windowActionBar;
            if (obtainStyledAttributes.hasValue(i2)) {
                if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                    s(1);
                } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                    s(108);
                }
                if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                    s(109);
                }
                if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                    s(10);
                }
                this.G = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                L();
                this.j.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.i);
                if (this.H) {
                    viewGroup = this.F ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
                } else if (this.G) {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                    this.E = false;
                    this.D = false;
                } else if (this.D) {
                    TypedValue typedValue = new TypedValue();
                    this.i.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new d1(this.i, typedValue.resourceId);
                    } else {
                        context = this.i;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                    DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.decor_content_parent);
                    this.p = decorContentParent;
                    decorContentParent.setWindowCallback(Q());
                    if (this.E) {
                        this.p.initFeature(109);
                    }
                    if (this.B) {
                        this.p.initFeature(2);
                    }
                    if (this.C) {
                        this.p.initFeature(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    r8.w(viewGroup, new j0(this));
                    if (this.p == null) {
                        this.z = (TextView) viewGroup.findViewById(R.id.title);
                    }
                    ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.j.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.j.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new k0(this));
                    this.y = viewGroup;
                    Object obj = this.h;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.o;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        DecorContentParent decorContentParent2 = this.p;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setWindowTitle(charSequence);
                        } else {
                            x xVar = this.m;
                            if (xVar != null) {
                                xVar.A(charSequence);
                            } else {
                                TextView textView = this.z;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.y.findViewById(16908290);
                    View decorView = this.j.getDecorView();
                    contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    TypedArray obtainStyledAttributes2 = this.i.obtainStyledAttributes(R.styleable.AppCompatTheme);
                    obtainStyledAttributes2.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    int i3 = R.styleable.AppCompatTheme_windowFixedWidthMajor;
                    if (obtainStyledAttributes2.hasValue(i3)) {
                        obtainStyledAttributes2.getValue(i3, contentFrameLayout2.getFixedWidthMajor());
                    }
                    int i4 = R.styleable.AppCompatTheme_windowFixedWidthMinor;
                    if (obtainStyledAttributes2.hasValue(i4)) {
                        obtainStyledAttributes2.getValue(i4, contentFrameLayout2.getFixedWidthMinor());
                    }
                    int i5 = R.styleable.AppCompatTheme_windowFixedHeightMajor;
                    if (obtainStyledAttributes2.hasValue(i5)) {
                        obtainStyledAttributes2.getValue(i5, contentFrameLayout2.getFixedHeightMajor());
                    }
                    int i6 = R.styleable.AppCompatTheme_windowFixedHeightMinor;
                    if (obtainStyledAttributes2.hasValue(i6)) {
                        obtainStyledAttributes2.getValue(i6, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.x = true;
                    j P2 = P(0);
                    if (!this.P && P2.h == null) {
                        S(108);
                        return;
                    }
                    return;
                }
                StringBuilder i0 = hj1.i0("AppCompat does not support the current theme features: { windowActionBar: ");
                i0.append(this.D);
                i0.append(", windowActionBarOverlay: ");
                i0.append(this.E);
                i0.append(", android:windowIsFloating: ");
                i0.append(this.G);
                i0.append(", windowActionModeOverlay: ");
                i0.append(this.F);
                i0.append(", windowNoTitle: ");
                i0.append(this.H);
                i0.append(" }");
                throw new IllegalArgumentException(i0.toString());
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void L() {
        if (this.j == null) {
            Object obj = this.h;
            if (obj instanceof Activity) {
                C(((Activity) obj).getWindow());
            }
        }
        if (this.j == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public j M(Menu menu) {
        j[] jVarArr = this.J;
        int length = jVarArr != null ? jVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            j jVar = jVarArr[i2];
            if (jVar != null && jVar.h == menu) {
                return jVar;
            }
        }
        return null;
    }

    public final Context N() {
        R();
        x xVar = this.m;
        Context e2 = xVar != null ? xVar.e() : null;
        return e2 == null ? this.i : e2;
    }

    public final g O(Context context) {
        if (this.U == null) {
            if (s0.d == null) {
                Context applicationContext = context.getApplicationContext();
                s0.d = new s0(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
            }
            this.U = new h(s0.d);
        }
        return this.U;
    }

    public j P(int i2) {
        j[] jVarArr = this.J;
        if (jVarArr == null || jVarArr.length <= i2) {
            j[] jVarArr2 = new j[(i2 + 1)];
            if (jVarArr != null) {
                System.arraycopy(jVarArr, 0, jVarArr2, 0, jVarArr.length);
            }
            this.J = jVarArr2;
            jVarArr = jVarArr2;
        }
        j jVar = jVarArr[i2];
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(i2);
        jVarArr[i2] = jVar2;
        return jVar2;
    }

    public final Window.Callback Q() {
        return this.j.getCallback();
    }

    public final void R() {
        K();
        if (this.D && this.m == null) {
            Object obj = this.h;
            if (obj instanceof Activity) {
                this.m = new t0((Activity) this.h, this.E);
            } else if (obj instanceof Dialog) {
                this.m = new t0((Dialog) this.h);
            }
            x xVar = this.m;
            if (xVar != null) {
                xVar.n(this.Z);
            }
        }
    }

    public final void S(int i2) {
        this.X = (1 << i2) | this.X;
        if (!this.W) {
            View decorView = this.j.getDecorView();
            Runnable runnable = this.Y;
            AtomicInteger atomicInteger = r8.f3055a;
            decorView.postOnAnimation(runnable);
            this.W = true;
        }
    }

    public int T(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        if (this.V == null) {
                            this.V = new f(context);
                        }
                        return this.V.c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                return O(context).c();
            } else {
                return -1;
            }
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0147, code lost:
        if (r14 != null) goto L_0x0149;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void U(defpackage.i0.j r13, android.view.KeyEvent r14) {
        /*
        // Method dump skipped, instructions count: 457
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.U(i0$j, android.view.KeyEvent):void");
    }

    public final boolean V(j jVar, int i2, KeyEvent keyEvent, int i3) {
        p1 p1Var;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((jVar.k || W(jVar, keyEvent)) && (p1Var = jVar.h) != null) {
            z2 = p1Var.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.p == null) {
            F(jVar, true);
        }
        return z2;
    }

    public final boolean W(j jVar, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        Resources.Theme theme;
        DecorContentParent decorContentParent4;
        if (this.P) {
            return false;
        }
        if (jVar.k) {
            return true;
        }
        j jVar2 = this.K;
        if (!(jVar2 == null || jVar2 == jVar)) {
            F(jVar2, false);
        }
        Window.Callback Q2 = Q();
        if (Q2 != null) {
            jVar.g = Q2.onCreatePanelView(jVar.f1453a);
        }
        int i2 = jVar.f1453a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (decorContentParent4 = this.p) != null) {
            decorContentParent4.setMenuPrepared();
        }
        if (jVar.g == null && (!z2 || !(this.m instanceof q0))) {
            p1 p1Var = jVar.h;
            if (p1Var == null || jVar.p) {
                if (p1Var == null) {
                    Context context = this.i;
                    int i3 = jVar.f1453a;
                    if ((i3 == 0 || i3 == 108) && this.p != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            d1 d1Var = new d1(context, 0);
                            d1Var.getTheme().setTo(theme);
                            context = d1Var;
                        }
                    }
                    p1 p1Var2 = new p1(context);
                    p1Var2.e = this;
                    jVar.a(p1Var2);
                    if (jVar.h == null) {
                        return false;
                    }
                }
                if (z2 && (decorContentParent3 = this.p) != null) {
                    if (this.q == null) {
                        this.q = new c();
                    }
                    decorContentParent3.setMenu(jVar.h, this.q);
                }
                jVar.h.A();
                if (!Q2.onCreatePanelMenu(jVar.f1453a, jVar.h)) {
                    jVar.a(null);
                    if (z2 && (decorContentParent2 = this.p) != null) {
                        decorContentParent2.setMenu(null, this.q);
                    }
                    return false;
                }
                jVar.p = false;
            }
            jVar.h.A();
            Bundle bundle = jVar.q;
            if (bundle != null) {
                jVar.h.v(bundle);
                jVar.q = null;
            }
            if (!Q2.onPreparePanel(0, jVar.g, jVar.h)) {
                if (z2 && (decorContentParent = this.p) != null) {
                    decorContentParent.setMenu(null, this.q);
                }
                jVar.h.z();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            jVar.n = z3;
            jVar.h.setQwertyMode(z3);
            jVar.h.z();
        }
        jVar.k = true;
        jVar.l = false;
        this.K = jVar;
        return true;
    }

    public final boolean X() {
        ViewGroup viewGroup;
        if (this.x && (viewGroup = this.y) != null) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (viewGroup.isLaidOut()) {
                return true;
            }
        }
        return false;
    }

    public final void Y() {
        if (this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int Z(c9 c9Var, Rect rect) {
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i5;
        int e2 = c9Var.e();
        ActionBarContextView actionBarContextView = this.t;
        int i6 = 8;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
            boolean z4 = true;
            if (this.t.isShown()) {
                if (this.a0 == null) {
                    this.a0 = new Rect();
                    this.b0 = new Rect();
                }
                Rect rect2 = this.a0;
                Rect rect3 = this.b0;
                rect2.set(c9Var.c(), c9Var.e(), c9Var.d(), c9Var.b());
                ViewUtils.computeFitSystemWindows(this.y, rect2, rect3);
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                c9 l2 = r8.l(this.y);
                if (l2 == null) {
                    i2 = 0;
                } else {
                    i2 = l2.c();
                }
                if (l2 == null) {
                    i3 = 0;
                } else {
                    i3 = l2.d();
                }
                if (marginLayoutParams2.topMargin == i7 && marginLayoutParams2.leftMargin == i8 && marginLayoutParams2.rightMargin == i9) {
                    z3 = false;
                } else {
                    marginLayoutParams2.topMargin = i7;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i9;
                    z3 = true;
                }
                if (i7 <= 0 || this.A != null) {
                    View view = this.A;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i5 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3))) {
                        marginLayoutParams.height = i5;
                        marginLayoutParams.leftMargin = i2;
                        marginLayoutParams.rightMargin = i3;
                        this.A.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.i);
                    this.A = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i2;
                    layoutParams.rightMargin = i3;
                    this.y.addView(this.A, -1, layoutParams);
                }
                View view3 = this.A;
                z2 = view3 != null;
                if (z2 && view3.getVisibility() != 0) {
                    View view4 = this.A;
                    AtomicInteger atomicInteger = r8.f3055a;
                    if ((view4.getWindowSystemUiVisibility() & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        i4 = q5.b(this.i, R.color.abc_decor_view_status_guard_light);
                    } else {
                        i4 = q5.b(this.i, R.color.abc_decor_view_status_guard);
                    }
                    view4.setBackgroundColor(i4);
                }
                if (!this.F && z2) {
                    e2 = 0;
                }
                z4 = z3;
            } else {
                if (marginLayoutParams2.topMargin != 0) {
                    marginLayoutParams2.topMargin = 0;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z4) {
                this.t.setLayoutParams(marginLayoutParams2);
            }
        }
        View view5 = this.A;
        if (view5 != null) {
            if (z2) {
                i6 = 0;
            }
            view5.setVisibility(i6);
        }
        return e2;
    }

    @Override // defpackage.h0
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        K();
        ((ViewGroup) this.y.findViewById(16908290)).addView(view, layoutParams);
        this.k.f.onContentChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x019e  */
    @Override // defpackage.h0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.Context b(android.content.Context r10) {
        /*
        // Method dump skipped, instructions count: 472
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.b(android.content.Context):android.content.Context");
    }

    @Override // defpackage.h0
    public <T extends View> T c(int i2) {
        K();
        return (T) this.j.findViewById(i2);
    }

    @Override // defpackage.h0
    public final y d() {
        return new b();
    }

    @Override // defpackage.h0
    public int e() {
        return this.Q;
    }

    @Override // defpackage.h0
    public MenuInflater f() {
        if (this.n == null) {
            R();
            x xVar = this.m;
            this.n = new g1(xVar != null ? xVar.e() : this.i);
        }
        return this.n;
    }

    @Override // defpackage.h0
    public x g() {
        R();
        return this.m;
    }

    @Override // defpackage.h0
    public void h() {
        LayoutInflater from = LayoutInflater.from(this.i);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            boolean z2 = from.getFactory2() instanceof i0;
        }
    }

    @Override // defpackage.h0
    public void i() {
        R();
        x xVar = this.m;
        if (xVar == null || !xVar.g()) {
            S(0);
        }
    }

    @Override // defpackage.h0
    public void j(Configuration configuration) {
        if (this.D && this.x) {
            R();
            x xVar = this.m;
            if (xVar != null) {
                xVar.h(configuration);
            }
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.i);
        B(false);
    }

    @Override // defpackage.h0
    public void k(Bundle bundle) {
        this.M = true;
        B(false);
        L();
        Object obj = this.h;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = h.T((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                x xVar = this.m;
                if (xVar == null) {
                    this.Z = true;
                } else {
                    xVar.n(true);
                }
            }
            synchronized (h0.g) {
                h0.r(this);
                h0.f.add(new WeakReference<>(this));
            }
        }
        this.N = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.h0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l() {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.l():void");
    }

    @Override // defpackage.h0
    public void m(Bundle bundle) {
        K();
    }

    @Override // defpackage.h0
    public void n() {
        R();
        x xVar = this.m;
        if (xVar != null) {
            xVar.w(true);
        }
    }

    @Override // defpackage.h0
    public void o(Bundle bundle) {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x01a9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r7v2, types: [p0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r1v83 */
    /* JADX WARN: Type inference failed for: r1v84 */
    /* JADX WARN: Type inference failed for: r1v85 */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r7, java.lang.String r8, android.content.Context r9, android.util.AttributeSet r10) {
        /*
        // Method dump skipped, instructions count: 650
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // defpackage.p1.a
    public boolean onMenuItemSelected(p1 p1Var, MenuItem menuItem) {
        j M2;
        Window.Callback Q2 = Q();
        if (Q2 == null || this.P || (M2 = M(p1Var.k())) == null) {
            return false;
        }
        return Q2.onMenuItemSelected(M2.f1453a, menuItem);
    }

    @Override // defpackage.p1.a
    public void onMenuModeChange(p1 p1Var) {
        DecorContentParent decorContentParent = this.p;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.i).hasPermanentMenuKey() && !this.p.isOverflowMenuShowPending())) {
            j P2 = P(0);
            P2.o = true;
            F(P2, false);
            U(P2, null);
            return;
        }
        Window.Callback Q2 = Q();
        if (this.p.isOverflowMenuShowing()) {
            this.p.hideOverflowMenu();
            if (!this.P) {
                Q2.onPanelClosed(108, P(0).h);
            }
        } else if (Q2 != null && !this.P) {
            if (this.W && (1 & this.X) != 0) {
                this.j.getDecorView().removeCallbacks(this.Y);
                this.Y.run();
            }
            j P3 = P(0);
            p1 p1Var2 = P3.h;
            if (p1Var2 != null && !P3.p && Q2.onPreparePanel(0, P3.g, p1Var2)) {
                Q2.onMenuOpened(108, P3.h);
                this.p.showOverflowMenu();
            }
        }
    }

    @Override // defpackage.h0
    public void p() {
        this.O = true;
        A();
    }

    @Override // defpackage.h0
    public void q() {
        this.O = false;
        R();
        x xVar = this.m;
        if (xVar != null) {
            xVar.w(false);
        }
    }

    @Override // defpackage.h0
    public boolean s(int i2) {
        if (i2 == 8) {
            i2 = 108;
        } else if (i2 == 9) {
            i2 = 109;
        }
        if (this.H && i2 == 108) {
            return false;
        }
        if (this.D && i2 == 1) {
            this.D = false;
        }
        if (i2 == 1) {
            Y();
            this.H = true;
            return true;
        } else if (i2 == 2) {
            Y();
            this.B = true;
            return true;
        } else if (i2 == 5) {
            Y();
            this.C = true;
            return true;
        } else if (i2 == 10) {
            Y();
            this.F = true;
            return true;
        } else if (i2 == 108) {
            Y();
            this.D = true;
            return true;
        } else if (i2 != 109) {
            return this.j.requestFeature(i2);
        } else {
            Y();
            this.E = true;
            return true;
        }
    }

    @Override // defpackage.h0
    public void t(int i2) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.i).inflate(i2, viewGroup);
        this.k.f.onContentChanged();
    }

    @Override // defpackage.h0
    public void u(View view) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.k.f.onContentChanged();
    }

    @Override // defpackage.h0
    public void v(View view, ViewGroup.LayoutParams layoutParams) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.k.f.onContentChanged();
    }

    @Override // defpackage.h0
    public void w(Toolbar toolbar) {
        CharSequence charSequence;
        if (this.h instanceof Activity) {
            R();
            x xVar = this.m;
            if (!(xVar instanceof t0)) {
                this.n = null;
                if (xVar != null) {
                    xVar.i();
                }
                if (toolbar != null) {
                    Object obj = this.h;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.o;
                    }
                    q0 q0Var = new q0(toolbar, charSequence, this.k);
                    this.m = q0Var;
                    this.j.setCallback(q0Var.c);
                } else {
                    this.m = null;
                    this.j.setCallback(this.k);
                }
                i();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // defpackage.h0
    public void x(int i2) {
        this.R = i2;
    }

    @Override // defpackage.h0
    public final void y(CharSequence charSequence) {
        this.o = charSequence;
        DecorContentParent decorContentParent = this.p;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        x xVar = this.m;
        if (xVar != null) {
            xVar.A(charSequence);
            return;
        }
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    @Override // defpackage.h0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.b1 z(defpackage.b1.a r8) {
        /*
        // Method dump skipped, instructions count: 421
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.z(b1$a):b1");
    }

    /* renamed from: i0$e */
    /* compiled from: AppCompatDelegateImpl */
    public class e extends i1 {
        public e(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode a(ActionMode.Callback callback) {
            f1.a aVar = new f1.a(i0.this.i, callback);
            b1 z = i0.this.z(aVar);
            if (z != null) {
                return aVar.e(z);
            }
            return null;
        }

        @Override // defpackage.i1
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return i0.this.H(keyEvent) || this.f.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // defpackage.i1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                android.view.Window$Callback r0 = r5.f
                boolean r0 = r0.dispatchKeyShortcutEvent(r6)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x004f
                i0 r0 = defpackage.i0.this
                int r3 = r6.getKeyCode()
                r0.R()
                x r4 = r0.m
                if (r4 == 0) goto L_0x001f
                boolean r3 = r4.j(r3, r6)
                if (r3 == 0) goto L_0x001f
            L_0x001d:
                r6 = 1
                goto L_0x004d
            L_0x001f:
                i0$j r3 = r0.K
                if (r3 == 0) goto L_0x0034
                int r4 = r6.getKeyCode()
                boolean r3 = r0.V(r3, r4, r6, r2)
                if (r3 == 0) goto L_0x0034
                i0$j r6 = r0.K
                if (r6 == 0) goto L_0x001d
                r6.l = r2
                goto L_0x001d
            L_0x0034:
                i0$j r3 = r0.K
                if (r3 != 0) goto L_0x004c
                i0$j r3 = r0.P(r1)
                r0.W(r3, r6)
                int r4 = r6.getKeyCode()
                boolean r6 = r0.V(r3, r4, r6, r2)
                r3.k = r1
                if (r6 == 0) goto L_0x004c
                goto L_0x001d
            L_0x004c:
                r6 = 0
            L_0x004d:
                if (r6 == 0) goto L_0x0050
            L_0x004f:
                r1 = 1
            L_0x0050:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.i0.e.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // defpackage.i1
        public void onContentChanged() {
        }

        @Override // defpackage.i1
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof p1)) {
                return this.f.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // defpackage.i1
        public boolean onMenuOpened(int i, Menu menu) {
            this.f.onMenuOpened(i, menu);
            i0 i0Var = i0.this;
            Objects.requireNonNull(i0Var);
            if (i == 108) {
                i0Var.R();
                x xVar = i0Var.m;
                if (xVar != null) {
                    xVar.c(true);
                }
            }
            return true;
        }

        @Override // defpackage.i1
        public void onPanelClosed(int i, Menu menu) {
            this.f.onPanelClosed(i, menu);
            i0 i0Var = i0.this;
            Objects.requireNonNull(i0Var);
            if (i == 108) {
                i0Var.R();
                x xVar = i0Var.m;
                if (xVar != null) {
                    xVar.c(false);
                }
            } else if (i == 0) {
                j P = i0Var.P(i);
                if (P.m) {
                    i0Var.F(P, false);
                }
            }
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            p1 p1Var = menu instanceof p1 ? (p1) menu : null;
            if (i == 0 && p1Var == null) {
                return false;
            }
            if (p1Var != null) {
                p1Var.x = true;
            }
            boolean onPreparePanel = this.f.onPreparePanel(i, view, menu);
            if (p1Var != null) {
                p1Var.x = false;
            }
            return onPreparePanel;
        }

        @Override // defpackage.i1, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            p1 p1Var = i0.this.P(0).h;
            if (p1Var != null) {
                this.f.onProvideKeyboardShortcuts(list, p1Var, i);
            } else {
                this.f.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // defpackage.i1
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            Objects.requireNonNull(i0.this);
            return a(callback);
        }

        @Override // defpackage.i1
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            Objects.requireNonNull(i0.this);
            if (i != 0) {
                return this.f.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
