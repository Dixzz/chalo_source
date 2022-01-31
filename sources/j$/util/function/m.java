package j$.util.function;

import java.util.Objects;

public final /* synthetic */ class m implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f1677a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ m(Predicate predicate, Predicate predicate2) {
        this.f1677a = predicate;
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
        return this.f1677a.test(obj) && this.b.test(obj);
    }
}
