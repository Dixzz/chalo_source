package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: js1  reason: default package */
/* compiled from: LoadPathCache */
public class js1 {

    /* renamed from: a  reason: collision with root package name */
    public final n2<qt1, pn1<?, ?, ?>> f1976a = new n2<>();
    public final AtomicReference<qt1> b = new AtomicReference<>();

    public final qt1 a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        qt1 andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new qt1();
        }
        andSet.f2988a = cls;
        andSet.b = cls2;
        andSet.c = cls3;
        return andSet;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, pn1<?, ?, ?> pn1) {
        synchronized (this.f1976a) {
            this.f1976a.put(new qt1(cls, cls2, cls3), pn1);
        }
    }
}
