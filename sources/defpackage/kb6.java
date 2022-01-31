package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.l66;
import defpackage.m66;

/* renamed from: kb6  reason: default package */
/* compiled from: CoroutineDispatcher.kt */
public abstract class kb6 extends h66 implements l66 {
    public static final a f = new a(null);

    /* renamed from: kb6$a */
    /* compiled from: CoroutineDispatcher.kt */
    public static final class a extends i66<l66, kb6> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j86 j86) {
            super(l66.a.f, jb6.f);
            int i = l66.c;
        }
    }

    public kb6() {
        super(l66.a.f);
    }

    @Override // defpackage.l66
    public void e(k66<?> k66) {
        ((qf6) k66).o();
    }

    @Override // defpackage.l66
    public final <T> k66<T> f(k66<? super T> k66) {
        return new qf6(this, k66);
    }

    @Override // defpackage.m66.a, defpackage.h66, defpackage.m66
    public <E extends m66.a> E get(m66.b<E> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        if (bVar instanceof i66) {
            i66 i66 = (i66) bVar;
            m66.b<?> key = getKey();
            n86.e(key, AnalyticsConstants.KEY);
            if (!(key == i66 || i66.f == key)) {
                return null;
            }
            n86.e(this, "element");
            E invoke = i66.g.invoke(this);
            if (!(invoke instanceof m66.a)) {
                return null;
            }
            return invoke;
        } else if (l66.a.f == bVar) {
            return this;
        } else {
            return null;
        }
    }

    public abstract void m(m66 m66, Runnable runnable);

    @Override // defpackage.h66, defpackage.m66
    public m66 minusKey(m66.b<?> bVar) {
        o66 o66 = o66.f;
        n86.e(bVar, AnalyticsConstants.KEY);
        if (bVar instanceof i66) {
            i66 i66 = (i66) bVar;
            m66.b<?> key = getKey();
            n86.e(key, AnalyticsConstants.KEY);
            if (key == i66 || i66.f == key) {
                n86.e(this, "element");
                if (i66.g.invoke(this) != null) {
                    return o66;
                }
            }
        } else if (l66.a.f == bVar) {
            return o66;
        }
        return this;
    }

    public boolean n(m66 m66) {
        return true;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hd3.l1(this);
    }
}
