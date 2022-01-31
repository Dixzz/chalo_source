package defpackage;

import defpackage.ip1;
import defpackage.km1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: lp1  reason: default package */
/* compiled from: MultiModelLoader */
public class lp1<Model, Data> implements ip1<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final List<ip1<Model, Data>> f2254a;
    public final v7<List<Exception>> b;

    /* renamed from: lp1$a */
    /* compiled from: MultiModelLoader */
    public static class a<Data> implements km1<Data>, km1.a<Data> {
        public final List<km1<Data>> f;
        public final v7<List<Exception>> g;
        public int h;
        public kl1 i;
        public km1.a<? super Data> j;
        public List<Exception> k;

        public a(List<km1<Data>> list, v7<List<Exception>> v7Var) {
            this.g = v7Var;
            if (!list.isEmpty()) {
                this.f = list;
                this.h = 0;
                return;
            }
            throw new IllegalArgumentException("Must not be empty.");
        }

        @Override // defpackage.km1
        public Class<Data> a() {
            return this.f.get(0).a();
        }

        @Override // defpackage.km1
        public void b() {
            List<Exception> list = this.k;
            if (list != null) {
                this.g.a(list);
            }
            this.k = null;
            for (km1<Data> km1 : this.f) {
                km1.b();
            }
        }

        @Override // defpackage.km1.a
        public void c(Exception exc) {
            this.k.add(exc);
            f();
        }

        @Override // defpackage.km1
        public void cancel() {
            for (km1<Data> km1 : this.f) {
                km1.cancel();
            }
        }

        @Override // defpackage.km1
        public xl1 d() {
            return this.f.get(0).d();
        }

        @Override // defpackage.km1
        public void e(kl1 kl1, km1.a<? super Data> aVar) {
            this.i = kl1;
            this.j = aVar;
            this.k = this.g.b();
            this.f.get(this.h).e(kl1, this);
        }

        public final void f() {
            if (this.h < this.f.size() - 1) {
                this.h++;
                e(this.i, this.j);
                return;
            }
            this.j.c(new nn1("Fetch failed", new ArrayList(this.k)));
        }

        @Override // defpackage.km1.a
        public void g(Data data) {
            if (data != null) {
                this.j.g(data);
            } else {
                f();
            }
        }
    }

    public lp1(List<ip1<Model, Data>> list, v7<List<Exception>> v7Var) {
        this.f2254a = list;
        this.b = v7Var;
    }

    @Override // defpackage.ip1
    public boolean a(Model model) {
        for (ip1<Model, Data> ip1 : this.f2254a) {
            if (ip1.a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ip1
    public ip1.a<Data> b(Model model, int i, int i2, fm1 fm1) {
        ip1.a<Data> b2;
        int size = this.f2254a.size();
        ArrayList arrayList = new ArrayList(size);
        dm1 dm1 = null;
        for (int i3 = 0; i3 < size; i3++) {
            ip1<Model, Data> ip1 = this.f2254a.get(i3);
            if (ip1.a(model) && (b2 = ip1.b(model, i, i2, fm1)) != null) {
                dm1 = b2.f1550a;
                arrayList.add(b2.c);
            }
        }
        if (!arrayList.isEmpty()) {
            return new ip1.a<>(dm1, new a(arrayList, this.b));
        }
        return null;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MultiModelLoader{modelLoaders=");
        List<ip1<Model, Data>> list = this.f2254a;
        i0.append(Arrays.toString(list.toArray(new ip1[list.size()])));
        i0.append('}');
        return i0.toString();
    }
}
