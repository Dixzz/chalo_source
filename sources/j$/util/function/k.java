package j$.util.function;

import java.util.Objects;

public final /* synthetic */ class k implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f1675a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ k(Predicate predicate, Predicate predicate2) {
        this.f1675a = predicate;
        this.b = predicate2;
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
        return this.f1675a.test(obj) || this.b.test(obj);
    }
}
