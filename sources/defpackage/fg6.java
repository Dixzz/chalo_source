package defpackage;

import defpackage.m66;
import java.util.Objects;

/* renamed from: fg6  reason: default package */
/* compiled from: ThreadContext.kt */
public final class fg6 {

    /* renamed from: a  reason: collision with root package name */
    public static final dg6 f1122a = new dg6("NO_THREAD_ELEMENTS");
    public static final w76<Object, m66.a, Object> b = a.f;
    public static final w76<ld6<?>, m66.a, ld6<?>> c = b.f;
    public static final w76<ig6, m66.a, ig6> d = c.f;

    /* renamed from: fg6$a */
    /* compiled from: ThreadContext.kt */
    public static final class a extends o86 implements w76<Object, m66.a, Object> {
        public static final a f = new a();

        public a() {
            super(2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(Object obj, m66.a aVar) {
            m66.a aVar2 = aVar;
            if (!(aVar2 instanceof ld6)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num == null ? 1 : num.intValue();
            return intValue == 0 ? aVar2 : Integer.valueOf(intValue + 1);
        }
    }

    /* renamed from: fg6$b */
    /* compiled from: ThreadContext.kt */
    public static final class b extends o86 implements w76<ld6<?>, m66.a, ld6<?>> {
        public static final b f = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public ld6<?> invoke(ld6<?> ld6, m66.a aVar) {
            ld6<?> ld62 = ld6;
            m66.a aVar2 = aVar;
            if (ld62 != null) {
                return ld62;
            }
            if (aVar2 instanceof ld6) {
                return (ld6) aVar2;
            }
            return null;
        }
    }

    /* renamed from: fg6$c */
    /* compiled from: ThreadContext.kt */
    public static final class c extends o86 implements w76<ig6, m66.a, ig6> {
        public static final c f = new c();

        public c() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public ig6 invoke(ig6 ig6, m66.a aVar) {
            ig6 ig62 = ig6;
            m66.a aVar2 = aVar;
            if (aVar2 instanceof ld6) {
                ld6<Object> ld6 = (ld6) aVar2;
                Object w = ld6.w(ig62.f1517a);
                Object[] objArr = ig62.b;
                int i = ig62.d;
                objArr[i] = w;
                ld6<Object>[] ld6Arr = ig62.c;
                ig62.d = i + 1;
                ld6Arr[i] = ld6;
            }
            return ig62;
        }
    }

    public static final void a(m66 m66, Object obj) {
        if (obj != f1122a) {
            if (obj instanceof ig6) {
                ig6 ig6 = (ig6) obj;
                int length = ig6.c.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        ld6<Object> ld6 = ig6.c[length];
                        n86.c(ld6);
                        ld6.p(m66, ig6.b[length]);
                        if (i >= 0) {
                            length = i;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                Object fold = m66.fold(null, c);
                Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                ((ld6) fold).p(m66, obj);
            }
        }
    }

    public static final Object b(m66 m66, Object obj) {
        if (obj == null) {
            obj = m66.fold(0, b);
            n86.c(obj);
        }
        if (obj == 0) {
            return f1122a;
        }
        if (obj instanceof Integer) {
            return m66.fold(new ig6(m66, ((Number) obj).intValue()), d);
        }
        return ((ld6) obj).w(m66);
    }
}
