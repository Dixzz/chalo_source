package defpackage;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.bg;
import defpackage.t2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: le  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public class le extends bg {

    /* renamed from: le$a */
    /* compiled from: DefaultSpecialEffectsController */
    public class a implements Runnable {
        public final /* synthetic */ List f;
        public final /* synthetic */ bg.d g;

        public a(List list, bg.d dVar) {
            this.f = list;
            this.g = dVar;
        }

        public void run() {
            if (this.f.contains(this.g)) {
                this.f.remove(this.g);
                le leVar = le.this;
                bg.d dVar = this.g;
                Objects.requireNonNull(leVar);
                dVar.f424a.applyState(dVar.c.mView);
            }
        }
    }

    /* renamed from: le$b */
    /* compiled from: DefaultSpecialEffectsController */
    public static class b extends c {
        public boolean c;
        public boolean d = false;
        public ze e;

        public b(bg.d dVar, t6 t6Var, boolean z) {
            super(dVar, t6Var);
            this.c = z;
        }

        public ze c(Context context) {
            if (this.d) {
                return this.e;
            }
            bg.d dVar = this.f2200a;
            ze e0 = h.e0(context, dVar.c, dVar.f424a == bg.d.c.VISIBLE, this.c);
            this.e = e0;
            this.d = true;
            return e0;
        }
    }

    /* renamed from: le$c */
    /* compiled from: DefaultSpecialEffectsController */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final bg.d f2200a;
        public final t6 b;

        public c(bg.d dVar, t6 t6Var) {
            this.f2200a = dVar;
            this.b = t6Var;
        }

        public void a() {
            bg.d dVar = this.f2200a;
            if (dVar.e.remove(this.b) && dVar.e.isEmpty()) {
                dVar.b();
            }
        }

        public boolean b() {
            bg.d.c cVar;
            bg.d.c from = bg.d.c.from(this.f2200a.c.mView);
            bg.d.c cVar2 = this.f2200a.f424a;
            return from == cVar2 || !(from == (cVar = bg.d.c.VISIBLE) || cVar2 == cVar);
        }
    }

    /* renamed from: le$d */
    /* compiled from: DefaultSpecialEffectsController */
    public static class d extends c {
        public final Object c;
        public final boolean d;
        public final Object e;

        public d(bg.d dVar, t6 t6Var, boolean z, boolean z2) {
            super(dVar, t6Var);
            Object obj;
            Object obj2;
            boolean z3;
            if (dVar.f424a == bg.d.c.VISIBLE) {
                if (z) {
                    obj2 = dVar.c.getReenterTransition();
                } else {
                    obj2 = dVar.c.getEnterTransition();
                }
                this.c = obj2;
                if (z) {
                    z3 = dVar.c.getAllowReturnTransitionOverlap();
                } else {
                    z3 = dVar.c.getAllowEnterTransitionOverlap();
                }
                this.d = z3;
            } else {
                if (z) {
                    obj = dVar.c.getReturnTransition();
                } else {
                    obj = dVar.c.getExitTransition();
                }
                this.c = obj;
                this.d = true;
            }
            if (!z2) {
                this.e = null;
            } else if (z) {
                this.e = dVar.c.getSharedElementReturnTransition();
            } else {
                this.e = dVar.c.getSharedElementEnterTransition();
            }
        }

        public final vf c(Object obj) {
            if (obj == null) {
                return null;
            }
            vf vfVar = tf.b;
            if (obj instanceof Transition) {
                return vfVar;
            }
            vf vfVar2 = tf.c;
            if (vfVar2 != null && vfVar2.e(obj)) {
                return vfVar2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Transition ");
            sb.append(obj);
            sb.append(" for fragment ");
            throw new IllegalArgumentException(hj1.Y(sb, this.f2200a.c, " is not a valid framework Transition or AndroidX Transition"));
        }
    }

    public le(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // defpackage.bg
    public void b(List<bg.d> list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        HashMap hashMap;
        Iterator it;
        View view;
        bg.d dVar;
        Boolean bool;
        View view2;
        Object obj;
        Object obj2;
        Boolean bool2;
        n2 n2Var;
        ArrayList arrayList3;
        Boolean bool3;
        ArrayList<View> arrayList4;
        HashMap hashMap2;
        ArrayList<View> arrayList5;
        vf vfVar;
        Rect rect;
        bg.d dVar2;
        View view3;
        o5 o5Var;
        o5 o5Var2;
        View view4;
        int i;
        Object obj3;
        View view5;
        boolean z2 = z;
        Boolean bool4 = Boolean.TRUE;
        bg.d dVar3 = null;
        bg.d dVar4 = null;
        for (bg.d dVar5 : list) {
            bg.d.c from = bg.d.c.from(dVar5.c.mView);
            int ordinal = dVar5.f424a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (from != bg.d.c.VISIBLE) {
                    dVar4 = dVar5;
                }
            }
            if (from == bg.d.c.VISIBLE && dVar3 == null) {
                dVar3 = dVar5;
            }
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList(list);
        Iterator<bg.d> it2 = list.iterator();
        while (it2.hasNext()) {
            bg.d next = it2.next();
            t6 t6Var = new t6();
            next.d();
            next.e.add(t6Var);
            arrayList6.add(new b(next, t6Var, z2));
            t6 t6Var2 = new t6();
            next.d();
            next.e.add(t6Var2);
            arrayList7.add(new d(next, t6Var2, z2, !z2 ? next == dVar4 : next == dVar3));
            next.d.add(new a(arrayList8, next));
        }
        Boolean bool5 = Boolean.FALSE;
        HashMap hashMap3 = new HashMap();
        Iterator it3 = arrayList7.iterator();
        vf vfVar2 = null;
        while (it3.hasNext()) {
            d dVar6 = (d) it3.next();
            if (!dVar6.b()) {
                vf c2 = dVar6.c(dVar6.c);
                vf c3 = dVar6.c(dVar6.e);
                if (c2 == null || c3 == null || c2 == c3) {
                    if (c2 == null) {
                        c2 = c3;
                    }
                    if (vfVar2 == null) {
                        vfVar2 = c2;
                    } else if (!(c2 == null || vfVar2 == c2)) {
                        StringBuilder i0 = hj1.i0("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                        i0.append(dVar6.f2200a.c);
                        i0.append(" returned Transition ");
                        i0.append(dVar6.c);
                        i0.append(" which uses a different Transition  type than other Fragments.");
                        throw new IllegalArgumentException(i0.toString());
                    }
                } else {
                    StringBuilder i02 = hj1.i0("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    i02.append(dVar6.f2200a.c);
                    i02.append(" returned Transition ");
                    i02.append(dVar6.c);
                    i02.append(" which uses a different Transition  type than its shared element transition ");
                    i02.append(dVar6.e);
                    throw new IllegalArgumentException(i02.toString());
                }
            }
        }
        if (vfVar2 == null) {
            Iterator it4 = arrayList7.iterator();
            while (it4.hasNext()) {
                d dVar7 = (d) it4.next();
                hashMap3.put(dVar7.f2200a, bool5);
                dVar7.a();
            }
            arrayList2 = arrayList6;
            arrayList = arrayList8;
            hashMap = hashMap3;
        } else {
            View view6 = new View(this.f423a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList9 = new ArrayList<>();
            ArrayList<View> arrayList10 = new ArrayList<>();
            n2 n2Var2 = new n2();
            Iterator it5 = arrayList7.iterator();
            Rect rect3 = rect2;
            arrayList2 = arrayList6;
            Object obj4 = null;
            View view7 = null;
            boolean z3 = false;
            View view8 = view6;
            bg.d dVar8 = dVar3;
            bg.d dVar9 = dVar4;
            while (it5.hasNext()) {
                Object obj5 = ((d) it5.next()).e;
                if (!(obj5 != null) || dVar8 == null || dVar9 == null) {
                    n2Var = n2Var2;
                    vfVar = vfVar2;
                    arrayList3 = arrayList7;
                    bool3 = bool5;
                    hashMap2 = hashMap3;
                    rect = rect3;
                    arrayList4 = arrayList9;
                    dVar2 = dVar4;
                } else {
                    Object y = vfVar2.y(vfVar2.g(obj5));
                    ArrayList<String> sharedElementSourceNames = dVar9.c.getSharedElementSourceNames();
                    ArrayList<String> sharedElementSourceNames2 = dVar8.c.getSharedElementSourceNames();
                    bool3 = bool5;
                    arrayList3 = arrayList7;
                    int i2 = 0;
                    for (ArrayList<String> sharedElementTargetNames = dVar8.c.getSharedElementTargetNames(); i2 < sharedElementTargetNames.size(); sharedElementTargetNames = sharedElementTargetNames) {
                        int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                        if (indexOf != -1) {
                            sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i2));
                        }
                        i2++;
                    }
                    ArrayList<String> sharedElementTargetNames2 = dVar9.c.getSharedElementTargetNames();
                    if (!z2) {
                        o5Var2 = dVar8.c.getExitTransitionCallback();
                        o5Var = dVar9.c.getEnterTransitionCallback();
                    } else {
                        o5Var2 = dVar8.c.getEnterTransitionCallback();
                        o5Var = dVar9.c.getExitTransitionCallback();
                    }
                    int size = sharedElementSourceNames.size();
                    int i3 = 0;
                    while (i3 < size) {
                        n2Var2.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                        i3++;
                        size = size;
                        y = y;
                    }
                    n2<String, View> n2Var3 = new n2<>();
                    k(n2Var3, dVar8.c.mView);
                    t2.k(n2Var3, sharedElementSourceNames);
                    if (o5Var2 == null) {
                        t2.k(n2Var2, n2Var3.keySet());
                        n2<String, View> n2Var4 = new n2<>();
                        k(n2Var4, dVar9.c.mView);
                        t2.k(n2Var4, sharedElementTargetNames2);
                        t2.k(n2Var4, n2Var2.values());
                        if (o5Var == null) {
                            tf.n(n2Var2, n2Var4);
                            l(n2Var3, n2Var2.keySet());
                            l(n2Var4, n2Var2.values());
                            if (n2Var2.isEmpty()) {
                                arrayList9.clear();
                                arrayList10.clear();
                                obj4 = null;
                                rect = rect3;
                                n2Var = n2Var2;
                                arrayList4 = arrayList9;
                                dVar2 = dVar4;
                                vfVar = vfVar2;
                                bool4 = bool4;
                                hashMap2 = hashMap3;
                            } else {
                                tf.c(dVar9.c, dVar8.c, z2, n2Var3, true);
                                n2Var = n2Var2;
                                arrayList4 = arrayList9;
                                vfVar = vfVar2;
                                arrayList5 = arrayList10;
                                p8.a(this.f423a, new qe(this, dVar4, dVar3, z, n2Var4));
                                arrayList4.addAll(n2Var3.values());
                                if (!sharedElementSourceNames.isEmpty()) {
                                    i = 0;
                                    view4 = n2Var3.get(sharedElementSourceNames.get(0));
                                    obj3 = y;
                                    vfVar.t(obj3, view4);
                                } else {
                                    obj3 = y;
                                    i = 0;
                                    view4 = view7;
                                }
                                arrayList5.addAll(n2Var4.values());
                                if (sharedElementTargetNames2.isEmpty() || (view5 = n2Var4.get(sharedElementTargetNames2.get(i))) == null) {
                                    rect = rect3;
                                } else {
                                    rect = rect3;
                                    p8.a(this.f423a, new re(this, vfVar, view5, rect));
                                    z3 = true;
                                }
                                view3 = view8;
                                vfVar.w(obj3, view3, arrayList4);
                                vfVar.r(obj3, null, null, null, null, obj3, arrayList5);
                                bool4 = bool4;
                                hashMap2 = hashMap3;
                                hashMap2.put(dVar3, bool4);
                                dVar2 = dVar4;
                                hashMap2.put(dVar2, bool4);
                                obj4 = obj3;
                                dVar8 = dVar3;
                                view7 = view4;
                                dVar9 = dVar2;
                                view8 = view3;
                                rect3 = rect;
                                vfVar2 = vfVar;
                                arrayList10 = arrayList5;
                                arrayList8 = arrayList8;
                                bool5 = bool3;
                                n2Var2 = n2Var;
                                z2 = z;
                                dVar4 = dVar2;
                                arrayList9 = arrayList4;
                                hashMap3 = hashMap2;
                                arrayList7 = arrayList3;
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                }
                arrayList5 = arrayList10;
                view3 = view8;
                view8 = view3;
                rect3 = rect;
                vfVar2 = vfVar;
                arrayList10 = arrayList5;
                arrayList8 = arrayList8;
                bool5 = bool3;
                n2Var2 = n2Var;
                z2 = z;
                dVar4 = dVar2;
                arrayList9 = arrayList4;
                hashMap3 = hashMap2;
                arrayList7 = arrayList3;
            }
            arrayList = arrayList8;
            Boolean bool6 = bool5;
            hashMap = hashMap3;
            View view9 = view8;
            ArrayList arrayList11 = new ArrayList();
            Iterator it6 = arrayList7.iterator();
            Object obj6 = null;
            Object obj7 = null;
            while (it6.hasNext()) {
                d dVar10 = (d) it6.next();
                if (dVar10.b()) {
                    it = it6;
                    obj2 = obj6;
                    bool2 = bool6;
                    hashMap.put(dVar10.f2200a, bool2);
                    dVar10.a();
                    obj = obj7;
                } else {
                    it = it6;
                    obj2 = obj6;
                    bool2 = bool6;
                    Object g = vfVar2.g(dVar10.c);
                    obj = obj7;
                    bg.d dVar11 = dVar10.f2200a;
                    boolean z4 = obj4 != null && (dVar11 == dVar8 || dVar11 == dVar9);
                    if (g != null) {
                        bool = bool2;
                        ArrayList<View> arrayList12 = new ArrayList<>();
                        dVar = dVar9;
                        j(arrayList12, dVar11.c.mView);
                        if (z4) {
                            if (dVar11 == dVar8) {
                                arrayList12.removeAll(arrayList9);
                            } else {
                                arrayList12.removeAll(arrayList10);
                            }
                        }
                        if (arrayList12.isEmpty()) {
                            vfVar2.a(g, view9);
                            view = view9;
                        } else {
                            vfVar2.b(g, arrayList12);
                            vfVar2.r(g, g, arrayList12, null, null, null, null);
                            view = view9;
                            if (dVar11.f424a == bg.d.c.GONE) {
                                arrayList.remove(dVar11);
                                ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                                arrayList13.remove(dVar11.c.mView);
                                vfVar2.q(g, dVar11.c.mView, arrayList13);
                                p8.a(this.f423a, new se(this, arrayList12));
                            }
                        }
                        if (dVar11.f424a == bg.d.c.VISIBLE) {
                            arrayList11.addAll(arrayList12);
                            if (z3) {
                                vfVar2.s(g, rect3);
                            }
                            view2 = view7;
                        } else {
                            view2 = view7;
                            vfVar2.t(g, view2);
                        }
                        hashMap.put(dVar11, bool4);
                        if (dVar10.d) {
                            obj7 = vfVar2.m(obj, g, null);
                            obj6 = obj2;
                        } else {
                            obj7 = obj;
                            obj6 = vfVar2.m(obj2, g, null);
                        }
                        it6 = it;
                        view7 = view2;
                        bool6 = bool;
                        dVar9 = dVar;
                        view9 = view;
                    } else if (!z4) {
                        hashMap.put(dVar11, bool2);
                        dVar10.a();
                    }
                }
                view = view9;
                bool = bool2;
                dVar = dVar9;
                obj6 = obj2;
                view2 = view7;
                obj7 = obj;
                it6 = it;
                view7 = view2;
                bool6 = bool;
                dVar9 = dVar;
                view9 = view;
            }
            bg.d dVar12 = dVar9;
            Object l = vfVar2.l(obj7, obj6, obj4);
            Iterator it7 = arrayList7.iterator();
            while (it7.hasNext()) {
                d dVar13 = (d) it7.next();
                if (!dVar13.b()) {
                    Object obj8 = dVar13.c;
                    bg.d dVar14 = dVar13.f2200a;
                    boolean z5 = obj4 != null && (dVar14 == dVar8 || dVar14 == dVar12);
                    if (obj8 != null || z5) {
                        ViewGroup viewGroup = this.f423a;
                        AtomicInteger atomicInteger = r8.f3055a;
                        if (!viewGroup.isLaidOut()) {
                            if (FragmentManager.O(2)) {
                                StringBuilder i03 = hj1.i0("SpecialEffectsController: Container ");
                                i03.append(this.f423a);
                                i03.append(" has not been laid out. Completing operation ");
                                i03.append(dVar14);
                                i03.toString();
                            }
                            dVar13.a();
                        } else {
                            vfVar2.u(dVar13.f2200a.c, l, dVar13.b, new te(this, dVar13));
                        }
                    }
                    dVar12 = dVar12;
                }
            }
            ViewGroup viewGroup2 = this.f423a;
            AtomicInteger atomicInteger2 = r8.f3055a;
            if (viewGroup2.isLaidOut()) {
                tf.p(arrayList11, 4);
                ArrayList<String> n = vfVar2.n(arrayList10);
                vfVar2.c(this.f423a, l);
                vfVar2.v(this.f423a, arrayList9, arrayList10, n, n2Var2);
                tf.p(arrayList11, 0);
                vfVar2.x(obj4, arrayList9, arrayList10);
            }
        }
        boolean containsValue = hashMap.containsValue(bool4);
        ViewGroup viewGroup3 = this.f423a;
        Context context = viewGroup3.getContext();
        ArrayList arrayList14 = new ArrayList();
        Iterator it8 = arrayList2.iterator();
        boolean z6 = false;
        while (it8.hasNext()) {
            b bVar = (b) it8.next();
            if (bVar.b()) {
                bVar.a();
            } else {
                ze c4 = bVar.c(context);
                if (c4 == null) {
                    bVar.a();
                } else {
                    Animator animator = c4.b;
                    if (animator == null) {
                        arrayList14.add(bVar);
                    } else {
                        bg.d dVar15 = bVar.f2200a;
                        Fragment fragment = dVar15.c;
                        if (bool4.equals(hashMap.get(dVar15))) {
                            if (FragmentManager.O(2)) {
                                String str = "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.";
                            }
                            bVar.a();
                        } else {
                            boolean z7 = dVar15.f424a == bg.d.c.GONE;
                            if (z7) {
                                arrayList.remove(dVar15);
                            }
                            View view10 = fragment.mView;
                            viewGroup3.startViewTransition(view10);
                            animator.addListener(new me(this, viewGroup3, view10, z7, dVar15, bVar));
                            animator.setTarget(view10);
                            animator.start();
                            bVar.b.b(new ne(this, animator));
                            z6 = true;
                            arrayList = arrayList;
                            bool4 = bool4;
                            hashMap = hashMap;
                        }
                    }
                }
            }
        }
        Iterator it9 = arrayList14.iterator();
        while (it9.hasNext()) {
            b bVar2 = (b) it9.next();
            bg.d dVar16 = bVar2.f2200a;
            Fragment fragment2 = dVar16.c;
            if (containsValue) {
                if (FragmentManager.O(2)) {
                    String str2 = "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.";
                }
                bVar2.a();
            } else if (z6) {
                if (FragmentManager.O(2)) {
                    String str3 = "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.";
                }
                bVar2.a();
            } else {
                View view11 = fragment2.mView;
                ze c5 = bVar2.c(context);
                Objects.requireNonNull(c5);
                Animation animation = c5.f4164a;
                Objects.requireNonNull(animation);
                if (dVar16.f424a != bg.d.c.REMOVED) {
                    view11.startAnimation(animation);
                    bVar2.a();
                } else {
                    viewGroup3.startViewTransition(view11);
                    af afVar = new af(animation, viewGroup3, view11);
                    afVar.setAnimationListener(new oe(this, viewGroup3, view11, bVar2));
                    view11.startAnimation(afVar);
                }
                bVar2.b.b(new pe(this, view11, viewGroup3, bVar2));
            }
        }
        Iterator it10 = arrayList.iterator();
        while (it10.hasNext()) {
            bg.d dVar17 = (bg.d) it10.next();
            dVar17.f424a.applyState(dVar17.c.mView);
        }
        arrayList.clear();
    }

    public void j(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!viewGroup.isTransitionGroup()) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        j(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void k(Map<String, View> map, View view) {
        AtomicInteger atomicInteger = r8.f3055a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    k(map, childAt);
                }
            }
        }
    }

    public void l(n2<String, View> n2Var, Collection<String> collection) {
        Iterator it = ((t2.b) n2Var.entrySet()).iterator();
        while (true) {
            t2.d dVar = (t2.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                AtomicInteger atomicInteger = r8.f3055a;
                if (!collection.contains(((View) dVar.getValue()).getTransitionName())) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }
}
