package defpackage;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: kn  reason: default package */
/* compiled from: Transition */
public abstract class kn implements Cloneable {
    public static final hn A = new a();
    public static ThreadLocal<n2<Animator, b>> B = new ThreadLocal<>();
    public static final int[] z = {2, 1, 3, 4};
    public String f = getClass().getName();
    public long g = -1;
    public long h = -1;
    public TimeInterpolator i = null;
    public ArrayList<Integer> j = new ArrayList<>();
    public ArrayList<View> k = new ArrayList<>();
    public tn l = new tn();
    public tn m = new tn();
    public qn n = null;
    public int[] o = z;
    public ArrayList<sn> p;
    public ArrayList<sn> q;
    public ArrayList<Animator> r = new ArrayList<>();
    public int s = 0;
    public boolean t = false;
    public boolean u = false;
    public ArrayList<d> v = null;
    public ArrayList<Animator> w = new ArrayList<>();
    public c x;
    public hn y = A;

    /* renamed from: kn$a */
    /* compiled from: Transition */
    public static class a extends hn {
        @Override // defpackage.hn
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* renamed from: kn$b */
    /* compiled from: Transition */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f2084a;
        public String b;
        public sn c;
        public go d;
        public kn e;

        public b(View view, String str, kn knVar, go goVar, sn snVar) {
            this.f2084a = view;
            this.b = str;
            this.c = snVar;
            this.d = goVar;
            this.e = knVar;
        }
    }

    /* renamed from: kn$c */
    /* compiled from: Transition */
    public static abstract class c {
    }

    /* renamed from: kn$d */
    /* compiled from: Transition */
    public interface d {
        void a(kn knVar);

        void b(kn knVar);

        void c(kn knVar);

        void d(kn knVar);

        void e(kn knVar);
    }

    public static void c(tn tnVar, View view, sn snVar) {
        tnVar.f3379a.put(view, snVar);
        int id = view.getId();
        if (id >= 0) {
            if (tnVar.b.indexOfKey(id) >= 0) {
                tnVar.b.put(id, null);
            } else {
                tnVar.b.put(id, view);
            }
        }
        AtomicInteger atomicInteger = r8.f3055a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            if (tnVar.d.e(transitionName) >= 0) {
                tnVar.d.put(transitionName, null);
            } else {
                tnVar.d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                r2<View> r2Var = tnVar.c;
                if (r2Var.f) {
                    r2Var.e();
                }
                if (q2.b(r2Var.g, r2Var.i, itemIdAtPosition) >= 0) {
                    View f2 = tnVar.c.f(itemIdAtPosition);
                    if (f2 != null) {
                        f2.setHasTransientState(false);
                        tnVar.c.j(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                tnVar.c.j(itemIdAtPosition, view);
            }
        }
    }

    public static n2<Animator, b> p() {
        n2<Animator, b> n2Var = B.get();
        if (n2Var != null) {
            return n2Var;
        }
        n2<Animator, b> n2Var2 = new n2<>();
        B.set(n2Var2);
        return n2Var2;
    }

    public static boolean u(sn snVar, sn snVar2, String str) {
        Object obj = snVar.f3229a.get(str);
        Object obj2 = snVar2.f3229a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public kn A(long j2) {
        this.h = j2;
        return this;
    }

    public void B(c cVar) {
        this.x = cVar;
    }

    public kn C(TimeInterpolator timeInterpolator) {
        this.i = timeInterpolator;
        return this;
    }

    public void D(hn hnVar) {
        if (hnVar == null) {
            this.y = A;
        } else {
            this.y = hnVar;
        }
    }

    public void E(pn pnVar) {
    }

    public kn F(long j2) {
        this.g = j2;
        return this;
    }

    public void G() {
        if (this.s == 0) {
            ArrayList<d> arrayList = this.v;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.v.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).a(this);
                }
            }
            this.u = false;
        }
        this.s++;
    }

    public String H(String str) {
        StringBuilder i0 = hj1.i0(str);
        i0.append(getClass().getSimpleName());
        i0.append("@");
        i0.append(Integer.toHexString(hashCode()));
        i0.append(": ");
        String sb = i0.toString();
        if (this.h != -1) {
            StringBuilder k0 = hj1.k0(sb, "dur(");
            k0.append(this.h);
            k0.append(") ");
            sb = k0.toString();
        }
        if (this.g != -1) {
            StringBuilder k02 = hj1.k0(sb, "dly(");
            k02.append(this.g);
            k02.append(") ");
            sb = k02.toString();
        }
        if (this.i != null) {
            StringBuilder k03 = hj1.k0(sb, "interp(");
            k03.append(this.i);
            k03.append(") ");
            sb = k03.toString();
        }
        if (this.j.size() <= 0 && this.k.size() <= 0) {
            return sb;
        }
        String S = hj1.S(sb, "tgts(");
        if (this.j.size() > 0) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                if (i2 > 0) {
                    S = hj1.S(S, ", ");
                }
                StringBuilder i02 = hj1.i0(S);
                i02.append(this.j.get(i2));
                S = i02.toString();
            }
        }
        if (this.k.size() > 0) {
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                if (i3 > 0) {
                    S = hj1.S(S, ", ");
                }
                StringBuilder i03 = hj1.i0(S);
                i03.append(this.k.get(i3));
                S = i03.toString();
            }
        }
        return hj1.S(S, ")");
    }

    public kn a(d dVar) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(dVar);
        return this;
    }

    public kn b(View view) {
        this.k.add(view);
        return this;
    }

    public void cancel() {
        for (int size = this.r.size() - 1; size >= 0; size--) {
            this.r.get(size).cancel();
        }
        ArrayList<d> arrayList = this.v;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.v.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((d) arrayList2.get(i2)).d(this);
            }
        }
    }

    public abstract void d(sn snVar);

    public final void e(View view, boolean z2) {
        if (view != null) {
            view.getId();
            if (view.getParent() instanceof ViewGroup) {
                sn snVar = new sn(view);
                if (z2) {
                    g(snVar);
                } else {
                    d(snVar);
                }
                snVar.c.add(this);
                f(snVar);
                if (z2) {
                    c(this.l, view, snVar);
                } else {
                    c(this.m, view, snVar);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    e(viewGroup.getChildAt(i2), z2);
                }
            }
        }
    }

    public void f(sn snVar) {
    }

    public abstract void g(sn snVar);

    public void h(ViewGroup viewGroup, boolean z2) {
        i(z2);
        if (this.j.size() > 0 || this.k.size() > 0) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.j.get(i2).intValue());
                if (findViewById != null) {
                    sn snVar = new sn(findViewById);
                    if (z2) {
                        g(snVar);
                    } else {
                        d(snVar);
                    }
                    snVar.c.add(this);
                    f(snVar);
                    if (z2) {
                        c(this.l, findViewById, snVar);
                    } else {
                        c(this.m, findViewById, snVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                View view = this.k.get(i3);
                sn snVar2 = new sn(view);
                if (z2) {
                    g(snVar2);
                } else {
                    d(snVar2);
                }
                snVar2.c.add(this);
                f(snVar2);
                if (z2) {
                    c(this.l, view, snVar2);
                } else {
                    c(this.m, view, snVar2);
                }
            }
            return;
        }
        e(viewGroup, z2);
    }

    public void i(boolean z2) {
        if (z2) {
            this.l.f3379a.clear();
            this.l.b.clear();
            this.l.c.b();
            return;
        }
        this.m.f3379a.clear();
        this.m.b.clear();
        this.m.c.b();
    }

    /* renamed from: j */
    public kn clone() {
        try {
            kn knVar = (kn) super.clone();
            knVar.w = new ArrayList<>();
            knVar.l = new tn();
            knVar.m = new tn();
            knVar.p = null;
            knVar.q = null;
            return knVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, sn snVar, sn snVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, tn tnVar, tn tnVar2, ArrayList<sn> arrayList, ArrayList<sn> arrayList2) {
        int i2;
        Animator k2;
        Animator animator;
        sn snVar;
        View view;
        sn snVar2;
        Animator animator2;
        n2<Animator, b> p2 = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            sn snVar3 = arrayList.get(i3);
            sn snVar4 = arrayList2.get(i3);
            if (snVar3 != null && !snVar3.c.contains(this)) {
                snVar3 = null;
            }
            if (snVar4 != null && !snVar4.c.contains(this)) {
                snVar4 = null;
            }
            if (!(snVar3 == null && snVar4 == null)) {
                if ((snVar3 == null || snVar4 == null || s(snVar3, snVar4)) && (k2 = k(viewGroup, snVar3, snVar4)) != null) {
                    if (snVar4 != null) {
                        View view2 = snVar4.b;
                        String[] q2 = q();
                        if (q2 != null && q2.length > 0) {
                            snVar2 = new sn(view2);
                            sn snVar5 = tnVar2.f3379a.get(view2);
                            if (snVar5 != null) {
                                int i4 = 0;
                                while (i4 < q2.length) {
                                    snVar2.f3229a.put(q2[i4], snVar5.f3229a.get(q2[i4]));
                                    i4++;
                                    k2 = k2;
                                    size = size;
                                    snVar5 = snVar5;
                                }
                            }
                            i2 = size;
                            int i5 = p2.h;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= i5) {
                                    animator2 = k2;
                                    break;
                                }
                                b bVar = p2.get(p2.h(i6));
                                if (bVar.c != null && bVar.f2084a == view2 && bVar.b.equals(this.f) && bVar.c.equals(snVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i2 = size;
                            animator2 = k2;
                            snVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        snVar = snVar2;
                    } else {
                        i2 = size;
                        view = snVar3.b;
                        animator = k2;
                        snVar = null;
                    }
                    if (animator != null) {
                        String str = this.f;
                        co coVar = wn.f3805a;
                        p2.put(animator, new b(view, str, this, new fo(viewGroup), snVar));
                        this.w.add(animator);
                    }
                    i3++;
                    size = i2;
                }
            }
            i2 = size;
            i3++;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.w.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay(animator3.getStartDelay() + (((long) sparseIntArray.valueAt(i7)) - Long.MAX_VALUE));
            }
        }
    }

    public void m() {
        int i2 = this.s - 1;
        this.s = i2;
        if (i2 == 0) {
            ArrayList<d> arrayList = this.v;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.v.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((d) arrayList2.get(i3)).c(this);
                }
            }
            for (int i4 = 0; i4 < this.l.c.l(); i4++) {
                View m2 = this.l.c.m(i4);
                if (m2 != null) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    m2.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < this.m.c.l(); i5++) {
                View m3 = this.m.c.m(i5);
                if (m3 != null) {
                    AtomicInteger atomicInteger2 = r8.f3055a;
                    m3.setHasTransientState(false);
                }
            }
            this.u = true;
        }
    }

    public sn o(View view, boolean z2) {
        qn qnVar = this.n;
        if (qnVar != null) {
            return qnVar.o(view, z2);
        }
        ArrayList<sn> arrayList = z2 ? this.p : this.q;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            sn snVar = arrayList.get(i3);
            if (snVar == null) {
                return null;
            }
            if (snVar.b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.q : this.p).get(i2);
    }

    public String[] q() {
        return null;
    }

    public sn r(View view, boolean z2) {
        qn qnVar = this.n;
        if (qnVar != null) {
            return qnVar.r(view, z2);
        }
        return (z2 ? this.l : this.m).f3379a.getOrDefault(view, null);
    }

    public boolean s(sn snVar, sn snVar2) {
        if (snVar == null || snVar2 == null) {
            return false;
        }
        String[] q2 = q();
        if (q2 != null) {
            for (String str : q2) {
                if (!u(snVar, snVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : snVar.f3229a.keySet()) {
            if (u(snVar, snVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public boolean t(View view) {
        int id = view.getId();
        if ((this.j.size() != 0 || this.k.size() != 0) && !this.j.contains(Integer.valueOf(id)) && !this.k.contains(view)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return H("");
    }

    public void v(View view) {
        if (!this.u) {
            n2<Animator, b> p2 = p();
            int i2 = p2.h;
            co coVar = wn.f3805a;
            fo foVar = new fo(view);
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                b l2 = p2.l(i3);
                if (l2.f2084a != null && foVar.equals(l2.d)) {
                    p2.h(i3).pause();
                }
            }
            ArrayList<d> arrayList = this.v;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.v.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((d) arrayList2.get(i4)).b(this);
                }
            }
            this.t = true;
        }
    }

    public kn w(d dVar) {
        ArrayList<d> arrayList = this.v;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.v.size() == 0) {
            this.v = null;
        }
        return this;
    }

    public kn x(View view) {
        this.k.remove(view);
        return this;
    }

    public void y(View view) {
        if (this.t) {
            if (!this.u) {
                n2<Animator, b> p2 = p();
                int i2 = p2.h;
                co coVar = wn.f3805a;
                fo foVar = new fo(view);
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    b l2 = p2.l(i3);
                    if (l2.f2084a != null && foVar.equals(l2.d)) {
                        p2.h(i3).resume();
                    }
                }
                ArrayList<d> arrayList = this.v;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.v.clone();
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((d) arrayList2.get(i4)).e(this);
                    }
                }
            }
            this.t = false;
        }
    }

    public void z() {
        G();
        n2<Animator, b> p2 = p();
        Iterator<Animator> it = this.w.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (p2.containsKey(next)) {
                G();
                if (next != null) {
                    next.addListener(new ln(this, p2));
                    long j2 = this.h;
                    if (j2 >= 0) {
                        next.setDuration(j2);
                    }
                    long j3 = this.g;
                    if (j3 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.i;
                    if (timeInterpolator != null) {
                        next.setInterpolator(timeInterpolator);
                    }
                    next.addListener(new mn(this));
                    next.start();
                }
            }
        }
        this.w.clear();
        m();
    }
}
