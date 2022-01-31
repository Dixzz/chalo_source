package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import defpackage.cl;
import defpackage.fl;
import java.util.Objects;

/* renamed from: qk  reason: default package */
/* compiled from: NestedAdapterWrapper */
public class qk {

    /* renamed from: a  reason: collision with root package name */
    public final fl.b f2948a;
    public final cl.d b;
    public final RecyclerView.e<RecyclerView.a0> c;
    public final b d;
    public int e;
    public RecyclerView.g f = new a();

    /* renamed from: qk$a */
    /* compiled from: NestedAdapterWrapper */
    public class a extends RecyclerView.g {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a() {
            qk qkVar = qk.this;
            qkVar.e = qkVar.c.getItemCount();
            zj zjVar = (zj) qk.this.d;
            zjVar.f4179a.notifyDataSetChanged();
            zjVar.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void b(int i, int i2) {
            qk qkVar = qk.this;
            zj zjVar = (zj) qkVar.d;
            zjVar.f4179a.notifyItemRangeChanged(i + zjVar.b(qkVar), i2, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void c(int i, int i2, Object obj) {
            qk qkVar = qk.this;
            zj zjVar = (zj) qkVar.d;
            zjVar.f4179a.notifyItemRangeChanged(i + zjVar.b(qkVar), i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void d(int i, int i2) {
            qk qkVar = qk.this;
            qkVar.e += i2;
            zj zjVar = (zj) qkVar.d;
            zjVar.f4179a.notifyItemRangeInserted(i + zjVar.b(qkVar), i2);
            qk qkVar2 = qk.this;
            if (qkVar2.e > 0 && qkVar2.c.getStateRestorationPolicy() == RecyclerView.e.a.PREVENT_WHEN_EMPTY) {
                ((zj) qk.this.d).a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void e(int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 1) {
                z = false;
            }
            h.m(z, "moving more than 1 item is not supported in RecyclerView");
            qk qkVar = qk.this;
            zj zjVar = (zj) qkVar.d;
            int b = zjVar.b(qkVar);
            zjVar.f4179a.notifyItemMoved(i + b, i2 + b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void f(int i, int i2) {
            qk qkVar = qk.this;
            qkVar.e -= i2;
            zj zjVar = (zj) qkVar.d;
            zjVar.f4179a.notifyItemRangeRemoved(i + zjVar.b(qkVar), i2);
            qk qkVar2 = qk.this;
            if (qkVar2.e < 1 && qkVar2.c.getStateRestorationPolicy() == RecyclerView.e.a.PREVENT_WHEN_EMPTY) {
                ((zj) qk.this.d).a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void g() {
            ((zj) qk.this.d).a();
        }
    }

    /* renamed from: qk$b */
    /* compiled from: NestedAdapterWrapper */
    public interface b {
    }

    public qk(RecyclerView.e<RecyclerView.a0> eVar, b bVar, fl flVar, cl.d dVar) {
        this.c = eVar;
        this.d = bVar;
        fl.a aVar = (fl.a) flVar;
        Objects.requireNonNull(aVar);
        this.f2948a = new fl.a.C0022a(this);
        this.b = dVar;
        this.e = eVar.getItemCount();
        eVar.registerAdapterDataObserver(this.f);
    }
}
