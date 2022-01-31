package a;

import java.util.function.Predicate;

public final /* synthetic */ class F0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$.util.function.Predicate f14a;

    private /* synthetic */ F0(j$.util.function.Predicate predicate) {
        this.f14a = predicate;
    }

    public static /* synthetic */ Predicate a(j$.util.function.Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        return predicate instanceof E0 ? ((E0) predicate).f12a : new F0(predicate);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return a(this.f14a.b(E0.c(predicate)));
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        return a(this.f14a.negate());
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return a(this.f14a.a(E0.c(predicate)));
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return this.f14a.test(obj);
    }
}
