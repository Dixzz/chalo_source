package defpackage;

import defpackage.ip1;
import defpackage.km1;

/* renamed from: qp1  reason: default package */
/* compiled from: UnitModelLoader */
public class qp1<Model> implements ip1<Model, Model> {

    /* renamed from: qp1$a */
    /* compiled from: UnitModelLoader */
    public static class a<Model> implements jp1<Model, Model> {
        @Override // defpackage.jp1
        public ip1<Model, Model> b(mp1 mp1) {
            return new qp1();
        }
    }

    /* renamed from: qp1$b */
    /* compiled from: UnitModelLoader */
    public static class b<Model> implements km1<Model> {
        public final Model f;

        public b(Model model) {
            this.f = model;
        }

        @Override // defpackage.km1
        public Class<Model> a() {
            return (Class<Model>) this.f.getClass();
        }

        @Override // defpackage.km1
        public void b() {
        }

        @Override // defpackage.km1
        public void cancel() {
        }

        @Override // defpackage.km1
        public xl1 d() {
            return xl1.LOCAL;
        }

        @Override // defpackage.km1
        public void e(kl1 kl1, km1.a<? super Model> aVar) {
            aVar.g(this.f);
        }
    }

    @Override // defpackage.ip1
    public boolean a(Model model) {
        return true;
    }

    @Override // defpackage.ip1
    public ip1.a<Model> b(Model model, int i, int i2, fm1 fm1) {
        return new ip1.a<>(new jt1(model), new b(model));
    }
}
