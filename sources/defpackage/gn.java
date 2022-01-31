package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.transition.R;
import defpackage.kn;
import defpackage.on;
import defpackage.t6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"RestrictedApi"})
/* renamed from: gn  reason: default package */
/* compiled from: FragmentTransitionSupport */
public class gn extends vf {

    /* renamed from: gn$a */
    /* compiled from: FragmentTransitionSupport */
    public class a extends kn.c {
        public a(gn gnVar, Rect rect) {
        }
    }

    /* renamed from: gn$b */
    /* compiled from: FragmentTransitionSupport */
    public class b implements kn.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f1282a;
        public final /* synthetic */ ArrayList b;

        public b(gn gnVar, View view, ArrayList arrayList) {
            this.f1282a = view;
            this.b = arrayList;
        }

        @Override // defpackage.kn.d
        public void a(kn knVar) {
            knVar.w(this);
            knVar.a(this);
        }

        @Override // defpackage.kn.d
        public void b(kn knVar) {
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            knVar.w(this);
            this.f1282a.setVisibility(8);
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.b.get(i)).setVisibility(0);
            }
        }

        @Override // defpackage.kn.d
        public void d(kn knVar) {
        }

        @Override // defpackage.kn.d
        public void e(kn knVar) {
        }
    }

    /* renamed from: gn$c */
    /* compiled from: FragmentTransitionSupport */
    public class c extends nn {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f1283a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ ArrayList f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f1283a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // defpackage.nn, defpackage.kn.d
        public void a(kn knVar) {
            Object obj = this.f1283a;
            if (obj != null) {
                gn.this.p(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                gn.this.p(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                gn.this.p(obj3, this.f, null);
            }
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            knVar.w(this);
        }
    }

    /* renamed from: gn$d */
    /* compiled from: FragmentTransitionSupport */
    public class d implements t6.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kn f1284a;

        public d(gn gnVar, kn knVar) {
            this.f1284a = knVar;
        }

        @Override // defpackage.t6.a
        public void a() {
            this.f1284a.cancel();
        }
    }

    /* renamed from: gn$e */
    /* compiled from: FragmentTransitionSupport */
    public class e implements kn.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f1285a;

        public e(gn gnVar, Runnable runnable) {
            this.f1285a = runnable;
        }

        @Override // defpackage.kn.d
        public void a(kn knVar) {
        }

        @Override // defpackage.kn.d
        public void b(kn knVar) {
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            this.f1285a.run();
        }

        @Override // defpackage.kn.d
        public void d(kn knVar) {
        }

        @Override // defpackage.kn.d
        public void e(kn knVar) {
        }
    }

    /* renamed from: gn$f */
    /* compiled from: FragmentTransitionSupport */
    public class f extends kn.c {
        public f(gn gnVar, Rect rect) {
        }
    }

    public static boolean z(kn knVar) {
        return !vf.k(knVar.j) || !vf.k(null) || !vf.k(null);
    }

    @Override // defpackage.vf
    public void a(Object obj, View view) {
        if (obj != null) {
            ((kn) obj).b(view);
        }
    }

    @Override // defpackage.vf
    public void b(Object obj, ArrayList<View> arrayList) {
        kn knVar = (kn) obj;
        if (knVar != null) {
            int i = 0;
            if (knVar instanceof qn) {
                qn qnVar = (qn) knVar;
                int size = qnVar.C.size();
                while (i < size) {
                    b(qnVar.J(i), arrayList);
                    i++;
                }
            } else if (!z(knVar) && vf.k(knVar.k)) {
                int size2 = arrayList.size();
                while (i < size2) {
                    knVar.b(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    @Override // defpackage.vf
    public void c(ViewGroup viewGroup, Object obj) {
        kn knVar = (kn) obj;
        if (!on.c.contains(viewGroup)) {
            AtomicInteger atomicInteger = r8.f3055a;
            if (viewGroup.isLaidOut()) {
                on.c.add(viewGroup);
                if (knVar == null) {
                    knVar = on.f2712a;
                }
                kn j = knVar.clone();
                ArrayList<kn> orDefault = on.a().getOrDefault(viewGroup, null);
                if (orDefault != null && orDefault.size() > 0) {
                    Iterator<kn> it = orDefault.iterator();
                    while (it.hasNext()) {
                        it.next().v(viewGroup);
                    }
                }
                if (j != null) {
                    j.h(viewGroup, true);
                }
                int i = R.id.transition_current_scene;
                if (((jn) viewGroup.getTag(i)) == null) {
                    viewGroup.setTag(i, null);
                    if (j != null) {
                        on.a aVar = new on.a(j, viewGroup);
                        viewGroup.addOnAttachStateChangeListener(aVar);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    @Override // defpackage.vf
    public boolean e(Object obj) {
        return obj instanceof kn;
    }

    @Override // defpackage.vf
    public Object g(Object obj) {
        if (obj != null) {
            return ((kn) obj).clone();
        }
        return null;
    }

    @Override // defpackage.vf
    public Object l(Object obj, Object obj2, Object obj3) {
        kn knVar = (kn) obj;
        kn knVar2 = (kn) obj2;
        kn knVar3 = (kn) obj3;
        if (knVar != null && knVar2 != null) {
            qn qnVar = new qn();
            qnVar.I(knVar);
            qnVar.I(knVar2);
            qnVar.K(1);
            knVar = qnVar;
        } else if (knVar == null) {
            knVar = knVar2 != null ? knVar2 : null;
        }
        if (knVar3 == null) {
            return knVar;
        }
        qn qnVar2 = new qn();
        if (knVar != null) {
            qnVar2.I(knVar);
        }
        qnVar2.I(knVar3);
        return qnVar2;
    }

    @Override // defpackage.vf
    public Object m(Object obj, Object obj2, Object obj3) {
        qn qnVar = new qn();
        if (obj != null) {
            qnVar.I((kn) obj);
        }
        if (obj2 != null) {
            qnVar.I((kn) obj2);
        }
        if (obj3 != null) {
            qnVar.I((kn) obj3);
        }
        return qnVar;
    }

    @Override // defpackage.vf
    public void o(Object obj, View view) {
        if (obj != null) {
            ((kn) obj).x(view);
        }
    }

    @Override // defpackage.vf
    public void p(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i;
        kn knVar = (kn) obj;
        int i2 = 0;
        if (knVar instanceof qn) {
            qn qnVar = (qn) knVar;
            int size = qnVar.C.size();
            while (i2 < size) {
                p(qnVar.J(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!z(knVar)) {
            ArrayList<View> arrayList3 = knVar.k;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    knVar.b(arrayList2.get(i2));
                    i2++;
                }
                int size2 = arrayList.size();
                while (true) {
                    size2--;
                    if (size2 >= 0) {
                        knVar.x(arrayList.get(size2));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // defpackage.vf
    public void q(Object obj, View view, ArrayList<View> arrayList) {
        ((kn) obj).a(new b(this, view, arrayList));
    }

    @Override // defpackage.vf
    public void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((kn) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // defpackage.vf
    public void s(Object obj, Rect rect) {
        if (obj != null) {
            ((kn) obj).B(new f(this, rect));
        }
    }

    @Override // defpackage.vf
    public void t(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((kn) obj).B(new a(this, rect));
        }
    }

    @Override // defpackage.vf
    public void u(Fragment fragment, Object obj, t6 t6Var, Runnable runnable) {
        kn knVar = (kn) obj;
        t6Var.b(new d(this, knVar));
        knVar.a(new e(this, runnable));
    }

    @Override // defpackage.vf
    public void w(Object obj, View view, ArrayList<View> arrayList) {
        qn qnVar = (qn) obj;
        ArrayList<View> arrayList2 = qnVar.k;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            vf.d(arrayList2, arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(qnVar, arrayList);
    }

    @Override // defpackage.vf
    public void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        qn qnVar = (qn) obj;
        if (qnVar != null) {
            qnVar.k.clear();
            qnVar.k.addAll(arrayList2);
            p(qnVar, arrayList, arrayList2);
        }
    }

    @Override // defpackage.vf
    public Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        qn qnVar = new qn();
        qnVar.I((kn) obj);
        return qnVar;
    }
}
