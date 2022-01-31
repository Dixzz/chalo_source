package defpackage;

import defpackage.ro1;

/* renamed from: qo1  reason: default package */
/* compiled from: LruResourceCache */
public class qo1 extends ot1<dm1, rn1<?>> implements ro1 {
    public ro1.a d;

    public qo1(int i) {
        super(i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ot1
    public int b(rn1<?> rn1) {
        return rn1.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.ot1
    public void c(dm1 dm1, rn1<?> rn1) {
        rn1<?> rn12 = rn1;
        ro1.a aVar = this.d;
        if (aVar != null) {
            rt1.a();
            ((hn1) aVar).f.a(rn12);
        }
    }
}
