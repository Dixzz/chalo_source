package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: kr  reason: default package */
/* compiled from: ConstraintController */
public abstract class kr<T> implements er<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f2107a = new ArrayList();
    public T b;
    public tr<T> c;
    public a d;

    /* renamed from: kr$a */
    /* compiled from: ConstraintController */
    public interface a {
    }

    public kr(tr<T> trVar) {
        this.c = trVar;
    }

    @Override // defpackage.er
    public void a(T t) {
        this.b = t;
        e(this.d, t);
    }

    public abstract boolean b(rs rsVar);

    public abstract boolean c(T t);

    public void d(Iterable<rs> iterable) {
        this.f2107a.clear();
        for (rs rsVar : iterable) {
            if (b(rsVar)) {
                this.f2107a.add(rsVar.f3122a);
            }
        }
        if (this.f2107a.isEmpty()) {
            this.c.b(this);
        } else {
            tr<T> trVar = this.c;
            synchronized (trVar.c) {
                if (trVar.d.add(this)) {
                    if (trVar.d.size() == 1) {
                        trVar.e = trVar.a();
                        tp.c().a(tr.f, String.format("%s: initial state = %s", trVar.getClass().getSimpleName(), trVar.e), new Throwable[0]);
                        trVar.d();
                    }
                    a(trVar.e);
                }
            }
        }
        e(this.d, this.b);
    }

    public final void e(a aVar, T t) {
        if (!(this.f2107a.isEmpty() || aVar == null)) {
            if (t == null || c(t)) {
                List<String> list = this.f2107a;
                hr hrVar = (hr) aVar;
                synchronized (hrVar.c) {
                    gr grVar = hrVar.f1414a;
                    if (grVar != null) {
                        grVar.b(list);
                    }
                }
                return;
            }
            List<String> list2 = this.f2107a;
            hr hrVar2 = (hr) aVar;
            synchronized (hrVar2.c) {
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    if (hrVar2.a(str)) {
                        tp.c().a(hr.d, String.format("Constraints met for %s", str), new Throwable[0]);
                        arrayList.add(str);
                    }
                }
                gr grVar2 = hrVar2.f1414a;
                if (grVar2 != null) {
                    grVar2.f(arrayList);
                }
            }
        }
    }
}
