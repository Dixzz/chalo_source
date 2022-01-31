package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: zk  reason: default package */
/* compiled from: RecyclerViewAccessibilityDelegate */
public class zk extends z7 {
    public final RecyclerView d;
    public final a e;

    /* renamed from: zk$a */
    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class a extends z7 {
        public final zk d;
        public Map<View, z7> e = new WeakHashMap();

        public a(zk zkVar) {
            this.d = zkVar;
        }

        @Override // defpackage.z7
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                return z7Var.a(view, accessibilityEvent);
            }
            return this.f4141a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // defpackage.z7
        public f9 b(View view) {
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                return z7Var.b(view);
            }
            return super.b(view);
        }

        @Override // defpackage.z7
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                z7Var.c(view, accessibilityEvent);
            } else {
                this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            if (this.d.j() || this.d.d.getLayoutManager() == null) {
                this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
                return;
            }
            this.d.d.getLayoutManager().x0(view, e9Var);
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                z7Var.d(view, e9Var);
            } else {
                this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            }
        }

        @Override // defpackage.z7
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                z7Var.e(view, accessibilityEvent);
            } else {
                this.f4141a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.z7
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            z7 z7Var = this.e.get(viewGroup);
            if (z7Var != null) {
                return z7Var.f(viewGroup, view, accessibilityEvent);
            }
            return this.f4141a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // defpackage.z7
        public boolean g(View view, int i, Bundle bundle) {
            if (this.d.j() || this.d.d.getLayoutManager() == null) {
                return super.g(view, i, bundle);
            }
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                if (z7Var.g(view, i, bundle)) {
                    return true;
                }
            } else if (super.g(view, i, bundle)) {
                return true;
            }
            RecyclerView.m layoutManager = this.d.d.getLayoutManager();
            RecyclerView.t tVar = layoutManager.g.g;
            return layoutManager.P0();
        }

        @Override // defpackage.z7
        public void h(View view, int i) {
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                z7Var.h(view, i);
            } else {
                this.f4141a.sendAccessibilityEvent(view, i);
            }
        }

        @Override // defpackage.z7
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            z7 z7Var = this.e.get(view);
            if (z7Var != null) {
                z7Var.i(view, accessibilityEvent);
            } else {
                this.f4141a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public zk(RecyclerView recyclerView) {
        this.d = recyclerView;
        a aVar = this.e;
        if (aVar != null) {
            this.e = aVar;
        } else {
            this.e = new a(this);
        }
    }

    @Override // defpackage.z7
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !j()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().u0(accessibilityEvent);
            }
        }
    }

    @Override // defpackage.z7
    public void d(View view, e9 e9Var) {
        this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
        if (!j() && this.d.getLayoutManager() != null) {
            RecyclerView.m layoutManager = this.d.getLayoutManager();
            RecyclerView recyclerView = layoutManager.g;
            layoutManager.w0(recyclerView.g, recyclerView.n0, e9Var);
        }
    }

    @Override // defpackage.z7
    public boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        if (j() || this.d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.m layoutManager = this.d.getLayoutManager();
        RecyclerView recyclerView = layoutManager.g;
        return layoutManager.O0(recyclerView.g, recyclerView.n0, i, bundle);
    }

    public boolean j() {
        return this.d.M();
    }
}
