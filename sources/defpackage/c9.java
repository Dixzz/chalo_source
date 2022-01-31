package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* renamed from: c9  reason: default package */
/* compiled from: WindowInsetsCompat */
public class c9 {
    public static final c9 b;

    /* renamed from: a  reason: collision with root package name */
    public final k f535a;

    /* renamed from: c9$a */
    /* compiled from: WindowInsetsCompat */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Field f536a;
        public static Field b;
        public static Field c;
        public static boolean d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f536a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: c9$d */
    /* compiled from: WindowInsetsCompat */
    public static class d extends c {
        public d() {
        }

        public d(c9 c9Var) {
            super(c9Var);
        }
    }

    /* renamed from: c9$h */
    /* compiled from: WindowInsetsCompat */
    public static class h extends g {
        public h(c9 c9Var, WindowInsets windowInsets) {
            super(c9Var, windowInsets);
        }

        @Override // defpackage.c9.k
        public c9 a() {
            return c9.j(this.c.consumeDisplayCutout());
        }

        @Override // defpackage.c9.k, defpackage.c9.f
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!Objects.equals(this.c, hVar.c) || !Objects.equals(this.g, hVar.g)) {
                return false;
            }
            return true;
        }

        @Override // defpackage.c9.k
        public c8 f() {
            DisplayCutout displayCutout = this.c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new c8(displayCutout);
        }

        @Override // defpackage.c9.k
        public int hashCode() {
            return this.c.hashCode();
        }

        public h(c9 c9Var, h hVar) {
            super(c9Var, hVar);
        }
    }

    /* renamed from: c9$j */
    /* compiled from: WindowInsetsCompat */
    public static class j extends i {
        public static final c9 r = c9.j(WindowInsets.CONSUMED);

        public j(c9 c9Var, WindowInsets windowInsets) {
            super(c9Var, windowInsets);
        }

        @Override // defpackage.c9.k, defpackage.c9.f
        public final void d(View view) {
        }

        public j(c9 c9Var, j jVar) {
            super(c9Var, jVar);
        }
    }

    /* renamed from: c9$k */
    /* compiled from: WindowInsetsCompat */
    public static class k {
        public static final c9 b;

        /* renamed from: a  reason: collision with root package name */
        public final c9 f538a;

        static {
            e eVar;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                eVar = new d();
            } else if (i >= 29) {
                eVar = new c();
            } else {
                eVar = new b();
            }
            b = eVar.a().f535a.a().f535a.b().a();
        }

        public k(c9 c9Var) {
            this.f538a = c9Var;
        }

        public c9 a() {
            return this.f538a;
        }

        public c9 b() {
            return this.f538a;
        }

        public c9 c() {
            return this.f538a;
        }

        public void d(View view) {
        }

        public void e(c9 c9Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            if (m() != kVar.m() || l() != kVar.l() || !Objects.equals(j(), kVar.j()) || !Objects.equals(h(), kVar.h()) || !Objects.equals(f(), kVar.f())) {
                return false;
            }
            return true;
        }

        public c8 f() {
            return null;
        }

        public b6 g() {
            return j();
        }

        public b6 h() {
            return b6.e;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(m()), Boolean.valueOf(l()), j(), h(), f());
        }

        public b6 i() {
            return j();
        }

        public b6 j() {
            return b6.e;
        }

        public c9 k(int i, int i2, int i3, int i4) {
            return b;
        }

        public boolean l() {
            return false;
        }

        public boolean m() {
            return false;
        }

        public void n(b6[] b6VarArr) {
        }

        public void o(b6 b6Var) {
        }

        public void p(c9 c9Var) {
        }

        public void q(b6 b6Var) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            b = j.r;
        } else {
            b = k.b;
        }
    }

    public c9(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f535a = new j(this, windowInsets);
        } else if (i2 >= 29) {
            this.f535a = new i(this, windowInsets);
        } else if (i2 >= 28) {
            this.f535a = new h(this, windowInsets);
        } else {
            this.f535a = new g(this, windowInsets);
        }
    }

    public static b6 f(b6 b6Var, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, b6Var.f386a - i2);
        int max2 = Math.max(0, b6Var.b - i3);
        int max3 = Math.max(0, b6Var.c - i4);
        int max4 = Math.max(0, b6Var.d - i5);
        if (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) {
            return b6Var;
        }
        return b6.a(max, max2, max3, max4);
    }

    public static c9 j(WindowInsets windowInsets) {
        return k(windowInsets, null);
    }

    public static c9 k(WindowInsets windowInsets, View view) {
        Objects.requireNonNull(windowInsets);
        c9 c9Var = new c9(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            c9Var.f535a.p(r8.l(view));
            c9Var.f535a.d(view.getRootView());
        }
        return c9Var;
    }

    @Deprecated
    public c9 a() {
        return this.f535a.c();
    }

    @Deprecated
    public int b() {
        return this.f535a.j().d;
    }

    @Deprecated
    public int c() {
        return this.f535a.j().f386a;
    }

    @Deprecated
    public int d() {
        return this.f535a.j().c;
    }

    @Deprecated
    public int e() {
        return this.f535a.j().b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c9)) {
            return false;
        }
        return Objects.equals(this.f535a, ((c9) obj).f535a);
    }

    public boolean g() {
        return this.f535a.l();
    }

    @Deprecated
    public c9 h(int i2, int i3, int i4, int i5) {
        e eVar;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            eVar = new d(this);
        } else if (i6 >= 29) {
            eVar = new c(this);
        } else {
            eVar = new b(this);
        }
        eVar.c(b6.a(i2, i3, i4, i5));
        return eVar.a();
    }

    public int hashCode() {
        k kVar = this.f535a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    public WindowInsets i() {
        k kVar = this.f535a;
        if (kVar instanceof f) {
            return ((f) kVar).c;
        }
        return null;
    }

    /* renamed from: c9$c */
    /* compiled from: WindowInsetsCompat */
    public static class c extends e {
        public final WindowInsets.Builder b;

        public c() {
            this.b = new WindowInsets.Builder();
        }

        @Override // defpackage.c9.e
        public c9 a() {
            c9 j = c9.j(this.b.build());
            j.f535a.n(null);
            return j;
        }

        @Override // defpackage.c9.e
        public void b(b6 b6Var) {
            this.b.setStableInsets(b6Var.c());
        }

        @Override // defpackage.c9.e
        public void c(b6 b6Var) {
            this.b.setSystemWindowInsets(b6Var.c());
        }

        public c(c9 c9Var) {
            super(c9Var);
            WindowInsets.Builder builder;
            WindowInsets i = c9Var.i();
            if (i != null) {
                builder = new WindowInsets.Builder(i);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.b = builder;
        }
    }

    /* renamed from: c9$g */
    /* compiled from: WindowInsetsCompat */
    public static class g extends f {
        public b6 n = null;

        public g(c9 c9Var, WindowInsets windowInsets) {
            super(c9Var, windowInsets);
        }

        @Override // defpackage.c9.k
        public c9 b() {
            return c9.j(this.c.consumeStableInsets());
        }

        @Override // defpackage.c9.k
        public c9 c() {
            return c9.j(this.c.consumeSystemWindowInsets());
        }

        @Override // defpackage.c9.k
        public final b6 h() {
            if (this.n == null) {
                this.n = b6.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // defpackage.c9.k
        public boolean l() {
            return this.c.isConsumed();
        }

        @Override // defpackage.c9.k
        public void q(b6 b6Var) {
            this.n = b6Var;
        }

        public g(c9 c9Var, g gVar) {
            super(c9Var, gVar);
            this.n = gVar.n;
        }
    }

    /* renamed from: c9$e */
    /* compiled from: WindowInsetsCompat */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final c9 f537a;

        public e() {
            this.f537a = new c9((c9) null);
        }

        public c9 a() {
            throw null;
        }

        public void b(b6 b6Var) {
            throw null;
        }

        public void c(b6 b6Var) {
            throw null;
        }

        public e(c9 c9Var) {
            this.f537a = c9Var;
        }
    }

    /* renamed from: c9$f */
    /* compiled from: WindowInsetsCompat */
    public static class f extends k {
        public static boolean h = false;
        public static Method i;
        public static Class<?> j;
        public static Class<?> k;
        public static Field l;
        public static Field m;
        public final WindowInsets c;
        public b6[] d;
        public b6 e = null;
        public c9 f;
        public b6 g;

        public f(c9 c9Var, WindowInsets windowInsets) {
            super(c9Var);
            this.c = windowInsets;
        }

        @Override // defpackage.c9.k
        public void d(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!h) {
                    try {
                        i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                        j = Class.forName("android.view.ViewRootImpl");
                        Class<?> cls = Class.forName("android.view.View$AttachInfo");
                        k = cls;
                        l = cls.getDeclaredField("mVisibleInsets");
                        m = j.getDeclaredField("mAttachInfo");
                        l.setAccessible(true);
                        m.setAccessible(true);
                    } catch (ReflectiveOperationException e2) {
                        e2.getMessage();
                    }
                    h = true;
                }
                Method method = i;
                b6 b6Var = null;
                if (!(method == null || k == null || l == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke != null) {
                            Rect rect = (Rect) l.get(m.get(invoke));
                            if (rect != null) {
                                b6Var = b6.a(rect.left, rect.top, rect.right, rect.bottom);
                            }
                        }
                    } catch (ReflectiveOperationException e3) {
                        e3.getMessage();
                    }
                }
                if (b6Var == null) {
                    b6Var = b6.e;
                }
                this.g = b6Var;
                return;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // defpackage.c9.k
        public void e(c9 c9Var) {
            c9Var.f535a.p(this.f);
            c9Var.f535a.o(this.g);
        }

        @Override // defpackage.c9.k
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.g, ((f) obj).g);
        }

        @Override // defpackage.c9.k
        public final b6 j() {
            if (this.e == null) {
                this.e = b6.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // defpackage.c9.k
        public c9 k(int i2, int i3, int i4, int i5) {
            e eVar;
            c9 j2 = c9.j(this.c);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                eVar = new d(j2);
            } else if (i6 >= 29) {
                eVar = new c(j2);
            } else {
                eVar = new b(j2);
            }
            eVar.c(c9.f(j(), i2, i3, i4, i5));
            eVar.b(c9.f(h(), i2, i3, i4, i5));
            return eVar.a();
        }

        @Override // defpackage.c9.k
        public boolean m() {
            return this.c.isRound();
        }

        @Override // defpackage.c9.k
        public void n(b6[] b6VarArr) {
            this.d = b6VarArr;
        }

        @Override // defpackage.c9.k
        public void o(b6 b6Var) {
            this.g = b6Var;
        }

        @Override // defpackage.c9.k
        public void p(c9 c9Var) {
            this.f = c9Var;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(c9 c9Var, f fVar) {
            super(c9Var);
            WindowInsets windowInsets = new WindowInsets(fVar.c);
            this.c = windowInsets;
        }
    }

    /* renamed from: c9$i */
    /* compiled from: WindowInsetsCompat */
    public static class i extends h {
        public b6 o = null;
        public b6 p = null;
        public b6 q = null;

        public i(c9 c9Var, WindowInsets windowInsets) {
            super(c9Var, windowInsets);
        }

        @Override // defpackage.c9.k
        public b6 g() {
            if (this.p == null) {
                this.p = b6.b(this.c.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // defpackage.c9.k
        public b6 i() {
            if (this.o == null) {
                this.o = b6.b(this.c.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // defpackage.c9.k, defpackage.c9.f
        public c9 k(int i, int i2, int i3, int i4) {
            return c9.j(this.c.inset(i, i2, i3, i4));
        }

        @Override // defpackage.c9.k, defpackage.c9.g
        public void q(b6 b6Var) {
        }

        public i(c9 c9Var, i iVar) {
            super(c9Var, iVar);
        }
    }

    public c9(c9 c9Var) {
        if (c9Var != null) {
            k kVar = c9Var.f535a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (kVar instanceof j)) {
                this.f535a = new j(this, (j) kVar);
            } else if (i2 >= 29 && (kVar instanceof i)) {
                this.f535a = new i(this, (i) kVar);
            } else if (i2 >= 28 && (kVar instanceof h)) {
                this.f535a = new h(this, (h) kVar);
            } else if (kVar instanceof g) {
                this.f535a = new g(this, (g) kVar);
            } else if (kVar instanceof f) {
                this.f535a = new f(this, (f) kVar);
            } else {
                this.f535a = new k(this);
            }
            kVar.e(this);
            return;
        }
        this.f535a = new k(this);
    }

    /* renamed from: c9$b */
    /* compiled from: WindowInsetsCompat */
    public static class b extends e {
        public static Field d = null;
        public static boolean e = false;
        public static Constructor<WindowInsets> f = null;
        public static boolean g = false;
        public WindowInsets b;
        public b6 c;

        public b() {
            if (!e) {
                try {
                    d = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                e = true;
            }
            Field field = d;
            WindowInsets windowInsets = null;
            if (field != null) {
                try {
                    WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                    if (windowInsets2 != null) {
                        windowInsets = new WindowInsets(windowInsets2);
                        this.b = windowInsets;
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!g) {
                try {
                    f = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                g = true;
            }
            Constructor<WindowInsets> constructor = f;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            this.b = windowInsets;
        }

        @Override // defpackage.c9.e
        public c9 a() {
            c9 j = c9.j(this.b);
            j.f535a.n(null);
            j.f535a.q(this.c);
            return j;
        }

        @Override // defpackage.c9.e
        public void b(b6 b6Var) {
            this.c = b6Var;
        }

        @Override // defpackage.c9.e
        public void c(b6 b6Var) {
            WindowInsets windowInsets = this.b;
            if (windowInsets != null) {
                this.b = windowInsets.replaceSystemWindowInsets(b6Var.f386a, b6Var.b, b6Var.c, b6Var.d);
            }
        }

        public b(c9 c9Var) {
            super(c9Var);
            this.b = c9Var.i();
        }
    }
}
