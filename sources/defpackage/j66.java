package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.m66;
import java.io.Serializable;
import java.util.Objects;

/* renamed from: j66  reason: default package */
/* compiled from: CoroutineContextImpl.kt */
public final class j66 implements m66, Serializable {
    public final m66 f;
    public final m66.a g;

    /* renamed from: j66$a */
    /* compiled from: CoroutineContextImpl.kt */
    public static final class a extends o86 implements w76<String, m66.a, String> {
        public static final a f = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public String invoke(String str, m66.a aVar) {
            String str2 = str;
            m66.a aVar2 = aVar;
            n86.e(str2, "acc");
            n86.e(aVar2, "element");
            if (str2.length() == 0) {
                return aVar2.toString();
            }
            return str2 + ", " + aVar2;
        }
    }

    public j66(m66 m66, m66.a aVar) {
        n86.e(m66, "left");
        n86.e(aVar, "element");
        this.f = m66;
        this.g = aVar;
    }

    public final int b() {
        int i = 2;
        j66 j66 = this;
        while (true) {
            m66 m66 = j66.f;
            if (!(m66 instanceof j66)) {
                m66 = null;
            }
            j66 = (j66) m66;
            if (j66 == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            if (!(obj instanceof j66)) {
                return false;
            }
            j66 j66 = (j66) obj;
            if (j66.b() != b()) {
                return false;
            }
            Objects.requireNonNull(j66);
            j66 j662 = this;
            while (true) {
                m66.a aVar = j662.g;
                if (n86.a(j66.get(aVar.getKey()), aVar)) {
                    m66 m66 = j662.f;
                    if (!(m66 instanceof j66)) {
                        Objects.requireNonNull(m66, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        m66.a aVar2 = (m66.a) m66;
                        z = n86.a(j66.get(aVar2.getKey()), aVar2);
                        break;
                    }
                    j662 = (j66) m66;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.m66
    public <R> R fold(R r, w76<? super R, ? super m66.a, ? extends R> w76) {
        n86.e(w76, "operation");
        return (R) w76.invoke((Object) this.f.fold(r, w76), this.g);
    }

    @Override // defpackage.m66
    public <E extends m66.a> E get(m66.b<E> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        j66 j66 = this;
        while (true) {
            E e = (E) j66.g.get(bVar);
            if (e != null) {
                return e;
            }
            m66 m66 = j66.f;
            if (!(m66 instanceof j66)) {
                return (E) m66.get(bVar);
            }
            j66 = (j66) m66;
        }
    }

    public int hashCode() {
        return this.g.hashCode() + this.f.hashCode();
    }

    @Override // defpackage.m66
    public m66 minusKey(m66.b<?> bVar) {
        n86.e(bVar, AnalyticsConstants.KEY);
        if (this.g.get(bVar) != null) {
            return this.f;
        }
        m66 minusKey = this.f.minusKey(bVar);
        if (minusKey == this.f) {
            return this;
        }
        if (minusKey == o66.f) {
            return this.g;
        }
        return new j66(minusKey, this.g);
    }

    @Override // defpackage.m66
    public m66 plus(m66 m66) {
        n86.e(m66, AnalyticsConstants.CONTEXT);
        n86.e(m66, AnalyticsConstants.CONTEXT);
        return m66 == o66.f ? this : (m66) m66.fold(this, n66.f);
    }

    public String toString() {
        return hj1.a0(hj1.i0("["), (String) fold("", a.f), "]");
    }
}
