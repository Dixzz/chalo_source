package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.t6;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: bg  reason: default package */
/* compiled from: SpecialEffectsController */
public abstract class bg {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f423a;
    public final ArrayList<d> b = new ArrayList<>();
    public final ArrayList<d> c = new ArrayList<>();
    public boolean d = false;
    public boolean e = false;

    /* renamed from: bg$a */
    /* compiled from: SpecialEffectsController */
    public class a implements Runnable {
        public final /* synthetic */ c f;

        public a(c cVar) {
            this.f = cVar;
        }

        public void run() {
            if (bg.this.b.contains(this.f)) {
                c cVar = this.f;
                cVar.f424a.applyState(cVar.c.mView);
            }
        }
    }

    /* renamed from: bg$b */
    /* compiled from: SpecialEffectsController */
    public class b implements Runnable {
        public final /* synthetic */ c f;

        public b(c cVar) {
            this.f = cVar;
        }

        public void run() {
            bg.this.b.remove(this.f);
            bg.this.c.remove(this.f);
        }
    }

    /* renamed from: bg$c */
    /* compiled from: SpecialEffectsController */
    public static class c extends d {
        public final kf h;

        public c(d.c cVar, d.b bVar, kf kfVar, t6 t6Var) {
            super(cVar, bVar, kfVar.c, t6Var);
            this.h = kfVar;
        }

        @Override // defpackage.bg.d
        public void b() {
            super.b();
            this.h.k();
        }

        @Override // defpackage.bg.d
        public void d() {
            if (this.b == d.b.ADDING) {
                Fragment fragment = this.h.c;
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (FragmentManager.O(2)) {
                        String str = "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment;
                    }
                }
                View requireView = this.c.requireView();
                if (requireView.getParent() == null) {
                    this.h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            }
        }
    }

    public bg(ViewGroup viewGroup) {
        this.f423a = viewGroup;
    }

    public static bg f(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return g(viewGroup, fragmentManager.M());
    }

    public static bg g(ViewGroup viewGroup, cg cgVar) {
        int i = R.id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i);
        if (tag instanceof bg) {
            return (bg) tag;
        }
        Objects.requireNonNull((FragmentManager.f) cgVar);
        le leVar = new le(viewGroup);
        viewGroup.setTag(i, leVar);
        return leVar;
    }

    public final void a(d.c cVar, d.b bVar, kf kfVar) {
        synchronized (this.b) {
            t6 t6Var = new t6();
            d d2 = d(kfVar.c);
            if (d2 != null) {
                d2.c(cVar, bVar);
                return;
            }
            c cVar2 = new c(cVar, bVar, kfVar, t6Var);
            this.b.add(cVar2);
            cVar2.d.add(new a(cVar2));
            cVar2.d.add(new b(cVar2));
        }
    }

    public abstract void b(List<d> list, boolean z);

    public void c() {
        if (!this.e) {
            ViewGroup viewGroup = this.f423a;
            AtomicInteger atomicInteger = r8.f3055a;
            if (!viewGroup.isAttachedToWindow()) {
                e();
                this.d = false;
                return;
            }
            synchronized (this.b) {
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.c);
                    this.c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (FragmentManager.O(2)) {
                            String str = "SpecialEffectsController: Cancelling operation " + dVar;
                        }
                        dVar.a();
                        if (!dVar.g) {
                            this.c.add(dVar);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((d) it2.next()).d();
                    }
                    b(arrayList2, this.d);
                    this.d = false;
                }
            }
        }
    }

    public final d d(Fragment fragment) {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.c.equals(fragment) && !next.f) {
                return next;
            }
        }
        return null;
    }

    public void e() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f423a;
        AtomicInteger atomicInteger = r8.f3055a;
        boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.b) {
            i();
            Iterator<d> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            Iterator it2 = new ArrayList(this.c).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (FragmentManager.O(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f423a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(dVar);
                    sb.toString();
                }
                dVar.a();
            }
            Iterator it3 = new ArrayList(this.b).iterator();
            while (it3.hasNext()) {
                d dVar2 = (d) it3.next();
                if (FragmentManager.O(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.f423a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(dVar2);
                    sb2.toString();
                }
                dVar2.a();
            }
        }
    }

    public void h() {
        synchronized (this.b) {
            i();
            this.e = false;
            int size = this.b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = this.b.get(size);
                d.c from = d.c.from(dVar.c.mView);
                d.c cVar = dVar.f424a;
                d.c cVar2 = d.c.VISIBLE;
                if (cVar == cVar2 && from != cVar2) {
                    this.e = dVar.c.isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public final void i() {
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.b == d.b.ADDING) {
                next.c(d.c.from(next.c.requireView().getVisibility()), d.b.NONE);
            }
        }
    }

    /* renamed from: bg$d */
    /* compiled from: SpecialEffectsController */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public c f424a;
        public b b;
        public final Fragment c;
        public final List<Runnable> d = new ArrayList();
        public final HashSet<t6> e = new HashSet<>();
        public boolean f = false;
        public boolean g = false;

        /* renamed from: bg$d$a */
        /* compiled from: SpecialEffectsController */
        public class a implements t6.a {
            public a() {
            }

            @Override // defpackage.t6.a
            public void a() {
                d.this.a();
            }
        }

        /* renamed from: bg$d$b */
        /* compiled from: SpecialEffectsController */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        public d(c cVar, b bVar, Fragment fragment, t6 t6Var) {
            this.f424a = cVar;
            this.b = bVar;
            this.c = fragment;
            t6Var.b(new a());
        }

        public final void a() {
            if (!this.f) {
                this.f = true;
                if (this.e.isEmpty()) {
                    b();
                    return;
                }
                Iterator it = new ArrayList(this.e).iterator();
                while (it.hasNext()) {
                    ((t6) it.next()).a();
                }
            }
        }

        public void b() {
            if (!this.g) {
                if (FragmentManager.O(2)) {
                    String str = "SpecialEffectsController: " + this + " has called complete.";
                }
                this.g = true;
                for (Runnable runnable : this.d) {
                    runnable.run();
                }
            }
        }

        public final void c(c cVar, b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        if (FragmentManager.O(2)) {
                            StringBuilder i0 = hj1.i0("SpecialEffectsController: For fragment ");
                            i0.append(this.c);
                            i0.append(" mFinalState = ");
                            i0.append(this.f424a);
                            i0.append(" -> REMOVED. mLifecycleImpact  = ");
                            i0.append(this.b);
                            i0.append(" to REMOVING.");
                            i0.toString();
                        }
                        this.f424a = c.REMOVED;
                        this.b = b.REMOVING;
                    }
                } else if (this.f424a == c.REMOVED) {
                    if (FragmentManager.O(2)) {
                        StringBuilder i02 = hj1.i0("SpecialEffectsController: For fragment ");
                        i02.append(this.c);
                        i02.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        i02.append(this.b);
                        i02.append(" to ADDING.");
                        i02.toString();
                    }
                    this.f424a = c.VISIBLE;
                    this.b = b.ADDING;
                }
            } else if (this.f424a != c.REMOVED) {
                if (FragmentManager.O(2)) {
                    StringBuilder i03 = hj1.i0("SpecialEffectsController: For fragment ");
                    i03.append(this.c);
                    i03.append(" mFinalState = ");
                    i03.append(this.f424a);
                    i03.append(" -> ");
                    i03.append(cVar);
                    i03.append(". ");
                    i03.toString();
                }
                this.f424a = cVar;
            }
        }

        public void d() {
        }

        public String toString() {
            StringBuilder k0 = hj1.k0("Operation ", "{");
            k0.append(Integer.toHexString(System.identityHashCode(this)));
            k0.append("} ");
            k0.append("{");
            k0.append("mFinalState = ");
            k0.append(this.f424a);
            k0.append("} ");
            k0.append("{");
            k0.append("mLifecycleImpact = ");
            k0.append(this.b);
            k0.append("} ");
            k0.append("{");
            k0.append("mFragment = ");
            return hj1.Y(k0, this.c, "}");
        }

        /* renamed from: bg$d$c */
        /* compiled from: SpecialEffectsController */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c from(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return from(view.getVisibility());
            }

            public void applyState(View view) {
                int ordinal = ordinal();
                if (ordinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.O(2)) {
                            String str = "SpecialEffectsController: Removing view " + view + " from container " + viewGroup;
                        }
                        viewGroup.removeView(view);
                    }
                } else if (ordinal == 1) {
                    if (FragmentManager.O(2)) {
                        String str2 = "SpecialEffectsController: Setting view " + view + " to VISIBLE";
                    }
                    view.setVisibility(0);
                } else if (ordinal == 2) {
                    if (FragmentManager.O(2)) {
                        String str3 = "SpecialEffectsController: Setting view " + view + " to GONE";
                    }
                    view.setVisibility(8);
                } else if (ordinal == 3) {
                    if (FragmentManager.O(2)) {
                        String str4 = "SpecialEffectsController: Setting view " + view + " to INVISIBLE";
                    }
                    view.setVisibility(4);
                }
            }

            public static c from(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException(hj1.I("Unknown visibility ", i));
            }
        }
    }
}
