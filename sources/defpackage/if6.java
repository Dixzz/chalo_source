package defpackage;

import defpackage.m66;

/* renamed from: if6  reason: default package */
/* compiled from: SafeCollector.kt */
public final class if6<T> extends w66 implements re6<T>, x66 {
    public final re6<T> f;
    public final m66 g;
    public final int h;
    public m66 i;
    public k66<? super s56> j;

    /* renamed from: if6$a */
    /* compiled from: SafeCollector.kt */
    public static final class a extends o86 implements w76<Integer, m66.a, Integer> {
        public static final a f = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Integer invoke(Integer num, m66.a aVar) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: re6<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public if6(re6<? super T> re6, m66 m66) {
        super(gf6.f, o66.f);
        this.f = re6;
        this.g = m66;
        this.h = ((Number) m66.fold(0, a.f)).intValue();
    }

    @Override // defpackage.re6
    public Object a(T t, k66<? super s56> k66) {
        try {
            Object c = c(k66, t);
            p66 p66 = p66.COROUTINE_SUSPENDED;
            if (c == p66) {
                n86.e(k66, "frame");
            }
            if (c == p66) {
                return c;
            }
            return s56.f3190a;
        } catch (Throwable th) {
            this.i = new ff6(th);
            throw th;
        }
    }

    public final Object c(k66<? super s56> k66, T t) {
        m66 context = k66.getContext();
        ec6.n(context);
        m66 m66 = this.i;
        if (m66 != context) {
            if (m66 instanceof ff6) {
                StringBuilder i0 = hj1.i0("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                i0.append(((ff6) m66).f);
                i0.append(", but then emission attempt of value '");
                i0.append((Object) t);
                i0.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                throw new IllegalStateException(ea6.L(i0.toString()).toString());
            } else if (((Number) context.fold(0, new kf6(this))).intValue() == this.h) {
                this.i = context;
            } else {
                StringBuilder i02 = hj1.i0("Flow invariant is violated:\n\t\tFlow was collected in ");
                i02.append(this.g);
                i02.append(",\n\t\tbut emission happened in ");
                i02.append(context);
                i02.append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
                throw new IllegalStateException(i02.toString().toString());
            }
        }
        this.j = k66;
        return jf6.f1919a.e(this.f, t, this);
    }

    @Override // defpackage.u66, defpackage.x66
    public x66 getCallerFrame() {
        k66<? super s56> k66 = this.j;
        if (k66 instanceof x66) {
            return (x66) k66;
        }
        return null;
    }

    @Override // defpackage.w66, defpackage.k66
    public m66 getContext() {
        k66<? super s56> k66 = this.j;
        m66 context = k66 == null ? null : k66.getContext();
        return context == null ? o66.f : context;
    }

    @Override // defpackage.u66
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // defpackage.u66
    public Object invokeSuspend(Object obj) {
        Throwable a2 = n56.a(obj);
        if (a2 != null) {
            this.i = new ff6(a2);
        }
        k66<? super s56> k66 = this.j;
        if (k66 != null) {
            k66.resumeWith(obj);
        }
        return p66.COROUTINE_SUSPENDED;
    }

    @Override // defpackage.u66, defpackage.w66
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
