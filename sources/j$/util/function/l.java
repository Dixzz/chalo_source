package j$.util.function;

import java.util.Objects;

public final /* synthetic */ class l implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f1676a;

    public /* synthetic */ l(Predicate predicate) {
        this.f1676a = predicate;
    }

    @Override // j$.util.function.Predicate
    public Predicate a(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new k(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate b(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new m(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate negate() {
        return new l(this);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        return !this.f1676a.test(obj);
    }
}
