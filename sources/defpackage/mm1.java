package defpackage;

import defpackage.lm1;
import java.util.HashMap;
import java.util.Map;

/* renamed from: mm1  reason: default package */
/* compiled from: DataRewinderRegistry */
public class mm1 {
    public static final lm1.a<?> b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, lm1.a<?>> f2397a = new HashMap();

    /* renamed from: mm1$a */
    /* compiled from: DataRewinderRegistry */
    public static class a implements lm1.a<Object> {
        @Override // defpackage.lm1.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // defpackage.lm1.a
        public lm1<Object> b(Object obj) {
            return new b(obj);
        }
    }

    /* renamed from: mm1$b */
    /* compiled from: DataRewinderRegistry */
    public static class b implements lm1<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f2398a;

        public b(Object obj) {
            this.f2398a = obj;
        }

        @Override // defpackage.lm1
        public Object a() {
            return this.f2398a;
        }

        @Override // defpackage.lm1
        public void b() {
        }
    }
}
