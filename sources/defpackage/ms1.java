package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ms1  reason: default package */
/* compiled from: ResourceEncoderRegistry */
public class ms1 {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?>> f2431a = new ArrayList();

    /* renamed from: ms1$a */
    /* compiled from: ResourceEncoderRegistry */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f2432a;
        public final hm1<T> b;

        public a(Class<T> cls, hm1<T> hm1) {
            this.f2432a = cls;
            this.b = hm1;
        }
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: hm1<T>, hm1<Z> */
    public synchronized <Z> hm1<Z> a(Class<Z> cls) {
        int size = this.f2431a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.f2431a.get(i);
            if (aVar.f2432a.isAssignableFrom(cls)) {
                return (hm1<T>) aVar.b;
            }
        }
        return null;
    }
}
