package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ik  reason: default package */
/* compiled from: DefaultItemAnimator */
public class ik extends al {
    public static TimeInterpolator s;
    public ArrayList<RecyclerView.a0> h = new ArrayList<>();
    public ArrayList<RecyclerView.a0> i = new ArrayList<>();
    public ArrayList<b> j = new ArrayList<>();
    public ArrayList<a> k = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.a0>> l = new ArrayList<>();
    public ArrayList<ArrayList<b>> m = new ArrayList<>();
    public ArrayList<ArrayList<a>> n = new ArrayList<>();
    public ArrayList<RecyclerView.a0> o = new ArrayList<>();
    public ArrayList<RecyclerView.a0> p = new ArrayList<>();
    public ArrayList<RecyclerView.a0> q = new ArrayList<>();
    public ArrayList<RecyclerView.a0> r = new ArrayList<>();

    /* renamed from: ik$a */
    /* compiled from: DefaultItemAnimator */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.a0 f1525a;
        public RecyclerView.a0 b;
        public int c;
        public int d;
        public int e;
        public int f;

        public a(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, int i, int i2, int i3, int i4) {
            this.f1525a = a0Var;
            this.b = a0Var2;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("ChangeInfo{oldHolder=");
            i0.append(this.f1525a);
            i0.append(", newHolder=");
            i0.append(this.b);
            i0.append(", fromX=");
            i0.append(this.c);
            i0.append(", fromY=");
            i0.append(this.d);
            i0.append(", toX=");
            i0.append(this.e);
            i0.append(", toY=");
            return hj1.W(i0, this.f, '}');
        }
    }

    /* renamed from: ik$b */
    /* compiled from: DefaultItemAnimator */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.a0 f1526a;
        public int b;
        public int c;
        public int d;
        public int e;

        public b(RecyclerView.a0 a0Var, int i, int i2, int i3, int i4) {
            this.f1526a = a0Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void e(RecyclerView.a0 a0Var) {
        View view = a0Var.itemView;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.j.get(size).f1526a == a0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(a0Var);
                this.j.remove(size);
            }
        }
        l(this.k, a0Var);
        if (this.h.remove(a0Var)) {
            view.setAlpha(1.0f);
            c(a0Var);
        }
        if (this.i.remove(a0Var)) {
            view.setAlpha(1.0f);
            c(a0Var);
        }
        int size2 = this.n.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<a> arrayList = this.n.get(size2);
            l(arrayList, a0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<b> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f1526a == a0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(a0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                }
            }
        }
        int size5 = this.l.size();
        while (true) {
            size5--;
            if (size5 >= 0) {
                ArrayList<RecyclerView.a0> arrayList3 = this.l.get(size5);
                if (arrayList3.remove(a0Var)) {
                    view.setAlpha(1.0f);
                    c(a0Var);
                    if (arrayList3.isEmpty()) {
                        this.l.remove(size5);
                    }
                }
            } else {
                this.q.remove(a0Var);
                this.o.remove(a0Var);
                this.r.remove(a0Var);
                this.p.remove(a0Var);
                k();
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void f() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.j.get(size);
            View view = bVar.f1526a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(bVar.f1526a);
            this.j.remove(size);
        }
        int size2 = this.h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            c(this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.a0 a0Var = this.i.get(size3);
            a0Var.itemView.setAlpha(1.0f);
            c(a0Var);
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            a aVar = this.k.get(size4);
            RecyclerView.a0 a0Var2 = aVar.f1525a;
            if (a0Var2 != null) {
                m(aVar, a0Var2);
            }
            RecyclerView.a0 a0Var3 = aVar.b;
            if (a0Var3 != null) {
                m(aVar, a0Var3);
            }
        }
        this.k.clear();
        if (g()) {
            int size5 = this.m.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList<b> arrayList = this.m.get(size5);
                int size6 = arrayList.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        b bVar2 = arrayList.get(size6);
                        View view2 = bVar2.f1526a.itemView;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        c(bVar2.f1526a);
                        arrayList.remove(size6);
                        if (arrayList.isEmpty()) {
                            this.m.remove(arrayList);
                        }
                    }
                }
            }
            int size7 = this.l.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList<RecyclerView.a0> arrayList2 = this.l.get(size7);
                int size8 = arrayList2.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.a0 a0Var4 = arrayList2.get(size8);
                        a0Var4.itemView.setAlpha(1.0f);
                        c(a0Var4);
                        arrayList2.remove(size8);
                        if (arrayList2.isEmpty()) {
                            this.l.remove(arrayList2);
                        }
                    }
                }
            }
            int size9 = this.n.size();
            while (true) {
                size9--;
                if (size9 >= 0) {
                    ArrayList<a> arrayList3 = this.n.get(size9);
                    int size10 = arrayList3.size();
                    while (true) {
                        size10--;
                        if (size10 >= 0) {
                            a aVar2 = arrayList3.get(size10);
                            RecyclerView.a0 a0Var5 = aVar2.f1525a;
                            if (a0Var5 != null) {
                                m(aVar2, a0Var5);
                            }
                            RecyclerView.a0 a0Var6 = aVar2.b;
                            if (a0Var6 != null) {
                                m(aVar2, a0Var6);
                            }
                            if (arrayList3.isEmpty()) {
                                this.n.remove(arrayList3);
                            }
                        }
                    }
                } else {
                    j(this.q);
                    j(this.p);
                    j(this.o);
                    j(this.r);
                    d();
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public boolean g() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    @Override // defpackage.al
    public boolean i(RecyclerView.a0 a0Var, int i2, int i3, int i4, int i5) {
        View view = a0Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) a0Var.itemView.getTranslationY());
        n(a0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            c(a0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.j.add(new b(a0Var, translationX, translationY, i4, i5));
        return true;
    }

    public void j(List<RecyclerView.a0> list) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                list.get(size).itemView.animate().cancel();
            } else {
                return;
            }
        }
    }

    public void k() {
        if (!g()) {
            d();
        }
    }

    public final void l(List<a> list, RecyclerView.a0 a0Var) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                a aVar = list.get(size);
                if (m(aVar, a0Var) && aVar.f1525a == null && aVar.b == null) {
                    list.remove(aVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean m(a aVar, RecyclerView.a0 a0Var) {
        if (aVar.b == a0Var) {
            aVar.b = null;
        } else if (aVar.f1525a != a0Var) {
            return false;
        } else {
            aVar.f1525a = null;
        }
        a0Var.itemView.setAlpha(1.0f);
        a0Var.itemView.setTranslationX(0.0f);
        a0Var.itemView.setTranslationY(0.0f);
        c(a0Var);
        return true;
    }

    public final void n(RecyclerView.a0 a0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        a0Var.itemView.animate().setInterpolator(s);
        e(a0Var);
    }
}
