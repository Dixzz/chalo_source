package a;

import j$.util.function.Predicate;

public final /* synthetic */ class E0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.function.Predicate f12a;

    private /* synthetic */ E0(java.util.function.Predicate predicate) {
        this.f12a = predicate;
    }

    public static /* synthetic */ Predicate c(java.util.function.Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        return predicate instanceof F0 ? ((F0) predicate).f14a : new E0(predicate);
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ Predicate a(Predicate predicate) {
        return c(this.f12a.or(F0.a(predicate)));
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ Predicate b(Predicate predicate) {
        return c(this.f12a.and(F0.a(predicate)));
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        return c(this.f12a.negate());
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return this.f12a.test(obj);
    }
}
