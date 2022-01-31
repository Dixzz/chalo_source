package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import defpackage.c9;
import defpackage.e9;
import defpackage.z7;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: r8  reason: default package */
/* compiled from: ViewCompat */
public class r8 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f3055a = new AtomicInteger(1);
    public static WeakHashMap<View, y8> b = null;
    public static Field c;
    public static boolean d = false;
    public static ThreadLocal<Rect> e;
    public static final int[] f = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final o8 g = new a();

    /* renamed from: r8$a */
    /* compiled from: ViewCompat */
    public class a implements o8 {
        @Override // defpackage.o8
        public b8 onReceiveContent(b8 b8Var) {
            return b8Var;
        }
    }

    /* renamed from: r8$c */
    /* compiled from: ViewCompat */
    public interface c {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* renamed from: r8$d */
    /* compiled from: ViewCompat */
    public static class d {
        public static final ArrayList<WeakReference<View>> d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        public WeakHashMap<View, Boolean> f3057a = null;
        public SparseArray<WeakReference<View>> b = null;
        public WeakReference<KeyEvent> c = null;

        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f3057a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View a2 = a(viewGroup.getChildAt(childCount), keyEvent);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                }
                if (b(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((c) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        new WeakHashMap();
    }

    public static void a(View view, e9.a aVar) {
        z7 g2 = g(view);
        if (g2 == null) {
            g2 = new z7();
        }
        v(view, g2);
        s(aVar.a(), view);
        j(view).add(aVar);
        m(view, 0);
    }

    public static y8 b(View view) {
        if (b == null) {
            b = new WeakHashMap<>();
        }
        y8 y8Var = b.get(view);
        if (y8Var != null) {
            return y8Var;
        }
        y8 y8Var2 = new y8(view);
        b.put(view, y8Var2);
        return y8Var2;
    }

    public static void c(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                x((View) parent);
            }
        }
    }

    public static void d(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                x((View) parent);
            }
        }
    }

    public static c9 e(View view, c9 c9Var) {
        WindowInsets i = c9Var.i();
        if (i != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(i);
            if (!dispatchApplyWindowInsets.equals(i)) {
                return c9.k(dispatchApplyWindowInsets, view);
            }
        }
        return c9Var;
    }

    public static boolean f(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = d.d;
        int i = R.id.tag_unhandled_key_event_manager;
        d dVar = (d) view.getTag(i);
        if (dVar == null) {
            dVar = new d();
            view.setTag(i, dVar);
        }
        if (keyEvent.getAction() == 0) {
            Boolean bool = Boolean.TRUE;
            WeakHashMap<View, Boolean> weakHashMap = dVar.f3057a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = d.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (dVar.f3057a == null) {
                        dVar.f3057a = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = d.d;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            dVar.f3057a.put(view2, bool);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                dVar.f3057a.put((View) parent, bool);
                            }
                        }
                    }
                }
            }
        }
        View a2 = dVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (dVar.b == null) {
                    dVar.b = new SparseArray<>();
                }
                dVar.b.put(keyCode, new WeakReference<>(a2));
            }
        }
        if (a2 != null) {
            return true;
        }
        return false;
    }

    public static z7 g(View view) {
        View.AccessibilityDelegate h = h(view);
        if (h == null) {
            return null;
        }
        if (h instanceof z7.a) {
            return ((z7.a) h).f4142a;
        }
        return new z7(h);
    }

    public static View.AccessibilityDelegate h(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (d) {
            return null;
        }
        if (c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                d = true;
                return null;
            }
        }
        try {
            Object obj = c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            d = true;
            return null;
        }
    }

    public static CharSequence i(View view) {
        return (CharSequence) new t8(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view);
    }

    public static List<e9.a> j(View view) {
        int i = R.id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i, arrayList2);
        return arrayList2;
    }

    public static Rect k() {
        if (e == null) {
            e = new ThreadLocal<>();
        }
        Rect rect = e.get();
        if (rect == null) {
            rect = new Rect();
            e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static c9 l(View view) {
        c9.e eVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            c9 j = c9.j(rootWindowInsets);
            j.f535a.p(j);
            j.f535a.d(view.getRootView());
            return j;
        } else if (!c9.a.d || !view.isAttachedToWindow()) {
            return null;
        } else {
            try {
                Object obj = c9.a.f536a.get(view.getRootView());
                if (obj == null) {
                    return null;
                }
                Rect rect = (Rect) c9.a.b.get(obj);
                Rect rect2 = (Rect) c9.a.c.get(obj);
                if (rect == null || rect2 == null) {
                    return null;
                }
                if (i >= 30) {
                    eVar = new c9.d();
                } else if (i >= 29) {
                    eVar = new c9.c();
                } else {
                    eVar = new c9.b();
                }
                eVar.b(b6.a(rect.left, rect.top, rect.right, rect.bottom));
                eVar.c(b6.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
                c9 a2 = eVar.a();
                a2.f535a.p(a2);
                a2.f535a.d(view.getRootView());
                return a2;
            } catch (IllegalAccessException e2) {
                e2.getMessage();
                return null;
            }
        }
    }

    public static void m(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = i(view) != null && view.getVisibility() == 0;
            int i2 = 32;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i2 = 2048;
                }
                obtain.setEventType(i2);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(i(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        } else if (((View) parent).getImportantForAccessibility() == 4) {
                            view.setImportantForAccessibility(2);
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(i(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError unused) {
                    view.getParent().getClass().getSimpleName();
                }
            }
        }
    }

    public static void n(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        Rect k = k();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            k.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !k.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        c(view, i);
        if (z && k.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(k);
        }
    }

    public static void o(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        Rect k = k();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            k.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !k.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        d(view, i);
        if (z && k.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(k);
        }
    }

    public static c9 p(View view, c9 c9Var) {
        WindowInsets i = c9Var.i();
        if (i != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(i);
            if (!onApplyWindowInsets.equals(i)) {
                return c9.k(onApplyWindowInsets, view);
            }
        }
        return c9Var;
    }

    public static b8 q(View view, b8 b8Var) {
        o8 o8Var;
        o8 o8Var2;
        if (Log.isLoggable("ViewCompat", 3)) {
            String str = "performReceiveContent: " + b8Var + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]";
        }
        n8 n8Var = (n8) view.getTag(R.id.tag_on_receive_content_listener);
        if (n8Var != null) {
            b8 a2 = n8Var.a(view, b8Var);
            if (a2 == null) {
                return null;
            }
            if (view instanceof o8) {
                o8Var2 = (o8) view;
            } else {
                o8Var2 = g;
            }
            return o8Var2.onReceiveContent(a2);
        }
        if (view instanceof o8) {
            o8Var = (o8) view;
        } else {
            o8Var = g;
        }
        return o8Var.onReceiveContent(b8Var);
    }

    public static void r(View view, int i) {
        s(i, view);
        m(view, 0);
    }

    public static void s(int i, View view) {
        List<e9.a> j = j(view);
        for (int i2 = 0; i2 < j.size(); i2++) {
            if (j.get(i2).a() == i) {
                j.remove(i2);
                return;
            }
        }
    }

    public static void t(View view, e9.a aVar, CharSequence charSequence, g9 g9Var) {
        if (g9Var == null) {
            s(aVar.a(), view);
            m(view, 0);
            return;
        }
        a(view, new e9.a(null, aVar.b, null, g9Var, aVar.c));
    }

    public static void u(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void v(View view, z7 z7Var) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (z7Var == null && (h(view) instanceof z7.a)) {
            z7Var = new z7();
        }
        if (z7Var == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = z7Var.b;
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static void w(View view, m8 m8Var) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, m8Var);
        }
        if (m8Var == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new w8(view, m8Var));
        }
    }

    public static void x(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: r8$b */
    /* compiled from: ViewCompat */
    public static abstract class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f3056a;
        public final Class<T> b;
        public final int c;
        public final int d;

        public b(int i, Class<T> cls, int i2) {
            this.f3056a = i;
            this.b = cls;
            this.d = 0;
            this.c = i2;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            boolean z;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (bool2 == null) {
                z = false;
            } else {
                z = bool2.booleanValue();
            }
            if (booleanValue == z) {
                return true;
            }
            return false;
        }

        public abstract T b(View view);

        public abstract void c(View view, T t);

        public T d(View view) {
            if (Build.VERSION.SDK_INT >= this.c) {
                return b(view);
            }
            T t = (T) view.getTag(this.f3056a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public void e(View view, T t) {
            if (Build.VERSION.SDK_INT >= this.c) {
                c(view, t);
            } else if (f(d(view), t)) {
                z7 g = r8.g(view);
                if (g == null) {
                    g = new z7();
                }
                r8.v(view, g);
                view.setTag(this.f3056a, t);
                r8.m(view, this.d);
            }
        }

        public abstract boolean f(T t, T t2);

        public b(int i, Class<T> cls, int i2, int i3) {
            this.f3056a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }
    }
}
