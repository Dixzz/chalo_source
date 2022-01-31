package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import defpackage.jk;
import defpackage.uj;
import defpackage.vj;
import java.util.List;
import java.util.concurrent.Executors;

/* renamed from: ok  reason: default package */
/* compiled from: ListAdapter */
public abstract class ok<T, VH extends RecyclerView.a0> extends RecyclerView.e<VH> {

    /* renamed from: a  reason: collision with root package name */
    public final vj<T> f2701a;
    public final vj.b<T> b;

    /* renamed from: ok$a */
    /* compiled from: ListAdapter */
    public class a implements vj.b<T> {
        public a() {
        }

        @Override // defpackage.vj.b
        public void a(List<T> list, List<T> list2) {
            ok.this.c(list, list2);
        }
    }

    public ok(jk.e<T> eVar) {
        a aVar = new a();
        this.b = aVar;
        tj tjVar = new tj(this);
        uj.a aVar2 = new uj.a(eVar);
        if (aVar2.f3512a == null) {
            synchronized (uj.a.c) {
                if (uj.a.d == null) {
                    uj.a.d = Executors.newFixedThreadPool(2);
                }
            }
            aVar2.f3512a = uj.a.d;
        }
        vj<T> vjVar = new vj<>(tjVar, new uj(null, aVar2.f3512a, aVar2.b));
        this.f2701a = vjVar;
        vjVar.d.add(aVar);
    }

    public void c(List<T> list, List<T> list2) {
    }

    public void d(List<T> list) {
        this.f2701a.b(null, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.f2701a.f.size();
    }
}
