package a;

import j$.util.function.s;
import java.util.function.DoublePredicate;

public final /* synthetic */ class M implements DoublePredicate {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f27a;

    private /* synthetic */ M(s sVar) {
        this.f27a = sVar;
    }

    public static /* synthetic */ DoublePredicate a(s sVar) {
        if (sVar == null) {
            return null;
        }
        return sVar instanceof L ? ((L) sVar).f25a : new M(sVar);
    }

    public /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
        return a(L.a(((L) this.f27a).f25a.and(a(L.a(doublePredicate)))));
    }

    public /* synthetic */ DoublePredicate negate() {
        return a(L.a(((L) this.f27a).f25a.negate()));
    }

    public /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
        return a(L.a(((L) this.f27a).f25a.or(a(L.a(doublePredicate)))));
    }

    public /* synthetic */ boolean test(double d) {
        return ((L) this.f27a).f25a.test(d);
    }
}
