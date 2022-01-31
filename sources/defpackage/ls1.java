package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ls1  reason: default package */
/* compiled from: ResourceDecoderRegistry */
public class ls1 {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?, ?>> f2262a = new ArrayList();

    /* renamed from: ls1$a */
    /* compiled from: ResourceDecoderRegistry */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f2263a;
        public final Class<R> b;
        public final gm1<T, R> c;

        public a(Class<T> cls, Class<R> cls2, gm1<T, R> gm1) {
            this.f2263a = cls;
            this.b = cls2;
            this.c = gm1;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f2263a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized <T, R> List<Class<R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (a<?, ?> aVar : this.f2262a) {
            if (aVar.a(cls, cls2)) {
                arrayList.add(aVar.b);
            }
        }
        return arrayList;
    }
}
