package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.RtlSpacingHelper;
import butterknife.internal.ButterKnifeProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: aa  reason: default package */
/* compiled from: ExploreByTouchHelper */
public abstract class aa extends z7 {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
    public static final ba<e9> o = new a();
    public static final ca<v2<e9>, e9> p = new b();
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public final AccessibilityManager h;
    public final View i;
    public c j;
    public int k = RtlSpacingHelper.UNDEFINED;
    public int l = RtlSpacingHelper.UNDEFINED;
    private int m = RtlSpacingHelper.UNDEFINED;

    /* renamed from: aa$a */
    /* compiled from: ExploreByTouchHelper */
    public class a implements ba<e9> {
        public void a(Object obj, Rect rect) {
            ((e9) obj).f942a.getBoundsInParent(rect);
        }
    }

    /* renamed from: aa$b */
    /* compiled from: ExploreByTouchHelper */
    public class b implements ca<v2<e9>, e9> {
    }

    /* renamed from: aa$c */
    /* compiled from: ExploreByTouchHelper */
    public class c extends f9 {
        public c() {
        }

        @Override // defpackage.f9
        public e9 a(int i) {
            return new e9(AccessibilityNodeInfo.obtain(aa.this.q(i).f942a));
        }

        @Override // defpackage.f9
        public e9 b(int i) {
            int i2 = i == 2 ? aa.this.k : aa.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return new e9(AccessibilityNodeInfo.obtain(aa.this.q(i2).f942a));
        }

        @Override // defpackage.f9
        public boolean c(int i, int i2, Bundle bundle) {
            int i3;
            aa aaVar = aa.this;
            if (i != -1) {
                boolean z = true;
                if (i2 == 1) {
                    return aaVar.v(i);
                }
                if (i2 == 2) {
                    return aaVar.k(i);
                }
                if (i2 == 64) {
                    if (!aaVar.h.isEnabled() || !aaVar.h.isTouchExplorationEnabled() || (i3 = aaVar.k) == i) {
                        z = false;
                    } else {
                        if (i3 != Integer.MIN_VALUE) {
                            aaVar.j(i3);
                        }
                        aaVar.k = i;
                        aaVar.i.invalidate();
                        aaVar.w(i, 32768);
                    }
                    return z;
                } else if (i2 != 128) {
                    return aaVar.r(i, i2, bundle);
                } else {
                    return aaVar.j(i);
                }
            } else {
                View view = aaVar.i;
                AtomicInteger atomicInteger = r8.f3055a;
                return view.performAccessibilityAction(i2, bundle);
            }
        }
    }

    public aa(View view) {
        if (view != null) {
            this.i = view;
            this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            AtomicInteger atomicInteger = r8.f3055a;
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // defpackage.z7
    public f9 b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // defpackage.z7
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // defpackage.z7
    public void d(View view, e9 e9Var) {
        this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
        s(e9Var);
    }

    public final boolean j(int i2) {
        if (this.k != i2) {
            return false;
        }
        this.k = RtlSpacingHelper.UNDEFINED;
        this.i.invalidate();
        w(i2, 65536);
        return true;
    }

    public final boolean k(int i2) {
        if (this.l != i2) {
            return false;
        }
        this.l = RtlSpacingHelper.UNDEFINED;
        u(i2, false);
        w(i2, 8);
        return true;
    }

    public final e9 l(int i2) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        e9 e9Var = new e9(obtain);
        obtain.setEnabled(true);
        e9Var.f942a.setFocusable(true);
        e9Var.f942a.setClassName(ButterKnifeProcessor.VIEW_TYPE);
        Rect rect = n;
        e9Var.f942a.setBoundsInParent(rect);
        e9Var.f942a.setBoundsInScreen(rect);
        e9Var.p(this.i);
        t(i2, e9Var);
        if (e9Var.i() == null && e9Var.g() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        e9Var.f942a.getBoundsInParent(this.e);
        if (!this.e.equals(rect)) {
            int d2 = e9Var.d();
            if ((d2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((d2 & 128) == 0) {
                e9Var.f942a.setPackageName(this.i.getContext().getPackageName());
                View view = this.i;
                e9Var.c = i2;
                e9Var.f942a.setSource(view, i2);
                boolean z = false;
                if (this.k == i2) {
                    e9Var.f942a.setAccessibilityFocused(true);
                    e9Var.f942a.addAction(128);
                } else {
                    e9Var.f942a.setAccessibilityFocused(false);
                    e9Var.f942a.addAction(64);
                }
                boolean z2 = this.l == i2;
                if (z2) {
                    e9Var.f942a.addAction(2);
                } else if (e9Var.f942a.isFocusable()) {
                    e9Var.f942a.addAction(1);
                }
                e9Var.f942a.setFocused(z2);
                this.i.getLocationOnScreen(this.g);
                e9Var.f942a.getBoundsInScreen(this.d);
                if (this.d.equals(rect)) {
                    e9Var.f942a.getBoundsInParent(this.d);
                    if (e9Var.b != -1) {
                        e9 e9Var2 = new e9(AccessibilityNodeInfo.obtain());
                        for (int i3 = e9Var.b; i3 != -1; i3 = e9Var2.b) {
                            View view2 = this.i;
                            e9Var2.b = -1;
                            e9Var2.f942a.setParent(view2, -1);
                            e9Var2.f942a.setBoundsInParent(n);
                            t(i3, e9Var2);
                            e9Var2.f942a.getBoundsInParent(this.e);
                            Rect rect2 = this.d;
                            Rect rect3 = this.e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        e9Var2.f942a.recycle();
                    }
                    this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                }
                if (this.i.getLocalVisibleRect(this.f)) {
                    this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                    if (this.d.intersect(this.f)) {
                        e9Var.f942a.setBoundsInScreen(this.d);
                        Rect rect4 = this.d;
                        if (rect4 != null && !rect4.isEmpty() && this.i.getWindowVisibility() == 0) {
                            ViewParent parent = this.i.getParent();
                            while (true) {
                                if (parent instanceof View) {
                                    View view3 = (View) parent;
                                    if (view3.getAlpha() <= 0.0f || view3.getVisibility() != 0) {
                                        break;
                                    }
                                    parent = view3.getParent();
                                } else if (parent != null) {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            e9Var.f942a.setVisibleToUser(true);
                        }
                    }
                }
                return e9Var;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    public final boolean m(MotionEvent motionEvent) {
        int i2;
        if (this.h.isEnabled() && this.h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int n2 = n(motionEvent.getX(), motionEvent.getY());
                int i3 = this.m;
                if (i3 != n2) {
                    this.m = n2;
                    w(n2, 128);
                    w(i3, 256);
                }
                if (n2 != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action != 10 || (i2 = this.m) == Integer.MIN_VALUE) {
                return false;
            } else {
                if (i2 != Integer.MIN_VALUE) {
                    this.m = RtlSpacingHelper.UNDEFINED;
                    w(RtlSpacingHelper.UNDEFINED, 128);
                    w(i2, 256);
                }
                return true;
            }
        }
        return false;
    }

    public abstract int n(float f2, float f3);

    public abstract void o(List<Integer> list);

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014a, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L_0x014c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0156 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p(int r20, android.graphics.Rect r21) {
        /*
        // Method dump skipped, instructions count: 500
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aa.p(int, android.graphics.Rect):boolean");
    }

    public e9 q(int i2) {
        if (i2 != -1) {
            return l(i2);
        }
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.i);
        e9 e9Var = new e9(obtain);
        View view = this.i;
        AtomicInteger atomicInteger = r8.f3055a;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        o(arrayList);
        if (e9Var.f942a.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                e9Var.f942a.addChild(this.i, ((Integer) arrayList.get(i3)).intValue());
            }
            return e9Var;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public abstract boolean r(int i2, int i3, Bundle bundle);

    public void s(e9 e9Var) {
    }

    public abstract void t(int i2, e9 e9Var);

    public void u(int i2, boolean z) {
    }

    public final boolean v(int i2) {
        int i3;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i3 = this.l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            k(i3);
        }
        if (i2 == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i2;
        u(i2, true);
        w(i2, 8);
        return true;
    }

    public final boolean w(int i2, int i3) {
        ViewParent parent;
        AccessibilityEvent accessibilityEvent;
        if (i2 == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        if (i2 != -1) {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            e9 q = q(i2);
            accessibilityEvent.getText().add(q.i());
            accessibilityEvent.setContentDescription(q.g());
            accessibilityEvent.setScrollable(q.f942a.isScrollable());
            accessibilityEvent.setPassword(q.f942a.isPassword());
            accessibilityEvent.setEnabled(q.j());
            accessibilityEvent.setChecked(q.f942a.isChecked());
            if (!accessibilityEvent.getText().isEmpty() || accessibilityEvent.getContentDescription() != null) {
                accessibilityEvent.setClassName(q.e());
                accessibilityEvent.setSource(this.i, i2);
                accessibilityEvent.setPackageName(this.i.getContext().getPackageName());
            } else {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
        } else {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            this.i.onInitializeAccessibilityEvent(accessibilityEvent);
        }
        return parent.requestSendAccessibilityEvent(this.i, accessibilityEvent);
    }

    public final void x(int i2) {
        int i3 = this.m;
        if (i3 != i2) {
            this.m = i2;
            w(i2, 128);
            w(i3, 256);
        }
    }
}
