package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: kr1  reason: default package */
/* compiled from: TranscoderRegistry */
public class kr1 {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?, ?>> f2108a = new ArrayList();

    /* renamed from: kr1$a */
    /* compiled from: TranscoderRegistry */
    public static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<Z> f2109a;
        public final Class<R> b;
        public final jr1<Z, R> c;

        public a(Class<Z> cls, Class<R> cls2, jr1<Z, R> jr1) {
            this.f2109a = cls;
            this.b = cls2;
            this.c = jr1;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f2109a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized <Z, R> List<Class<R>> a(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f2108a) {
            if (aVar.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }
}
