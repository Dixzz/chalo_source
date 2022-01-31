package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: el  reason: default package */
/* compiled from: ViewInfoStore */
public class el {

    /* renamed from: a  reason: collision with root package name */
    public final u2<RecyclerView.a0, a> f987a = new u2<>();
    public final r2<RecyclerView.a0> b = new r2<>();

    /* renamed from: el$a */
    /* compiled from: ViewInfoStore */
    public static class a {
        public static v7<a> d = new w7(20);

        /* renamed from: a  reason: collision with root package name */
        public int f988a;
        public RecyclerView.j.c b;
        public RecyclerView.j.c c;

        public static a a() {
            a b2 = d.b();
            return b2 == null ? new a() : b2;
        }

        public static void b(a aVar) {
            aVar.f988a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }
    }

    /* renamed from: el$b */
    /* compiled from: ViewInfoStore */
    public interface b {
    }

    public void a(RecyclerView.a0 a0Var) {
        a orDefault = this.f987a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f987a.put(a0Var, orDefault);
        }
        orDefault.f988a |= 1;
    }

    public void b(RecyclerView.a0 a0Var, RecyclerView.j.c cVar) {
        a orDefault = this.f987a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f987a.put(a0Var, orDefault);
        }
        orDefault.c = cVar;
        orDefault.f988a |= 8;
    }

    public void c(RecyclerView.a0 a0Var, RecyclerView.j.c cVar) {
        a orDefault = this.f987a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f987a.put(a0Var, orDefault);
        }
        orDefault.b = cVar;
        orDefault.f988a |= 4;
    }

    public boolean d(RecyclerView.a0 a0Var) {
        a orDefault = this.f987a.getOrDefault(a0Var, null);
        if (orDefault == null || (orDefault.f988a & 1) == 0) {
            return false;
        }
        return true;
    }

    public final RecyclerView.j.c e(RecyclerView.a0 a0Var, int i) {
        a l;
        RecyclerView.j.c cVar;
        int e = this.f987a.e(a0Var);
        if (e >= 0 && (l = this.f987a.l(e)) != null) {
            int i2 = l.f988a;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                l.f988a = i3;
                if (i == 4) {
                    cVar = l.b;
                } else if (i == 8) {
                    cVar = l.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.f987a.j(e);
                    a.b(l);
                }
                return cVar;
            }
        }
        return null;
    }

    public void f(RecyclerView.a0 a0Var) {
        a orDefault = this.f987a.getOrDefault(a0Var, null);
        if (orDefault != null) {
            orDefault.f988a &= -2;
        }
    }

    public void g(RecyclerView.a0 a0Var) {
        int l = this.b.l() - 1;
        while (true) {
            if (l < 0) {
                break;
            } else if (a0Var == this.b.m(l)) {
                r2<RecyclerView.a0> r2Var = this.b;
                Object[] objArr = r2Var.h;
                Object obj = objArr[l];
                Object obj2 = r2.j;
                if (obj != obj2) {
                    objArr[l] = obj2;
                    r2Var.f = true;
                }
            } else {
                l--;
            }
        }
        a remove = this.f987a.remove(a0Var);
        if (remove != null) {
            a.b(remove);
        }
    }
}
