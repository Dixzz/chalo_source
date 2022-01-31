package j$.util.stream;

import j$.util.function.Predicate;
import j$.util.function.k;
import j$.util.function.l;
import j$.util.function.m;
import j$.util.o;
import java.util.Objects;

public final /* synthetic */ class S0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ S0 f1730a = new S0();

    private /* synthetic */ S0() {
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
        return ((o) obj).c();
    }
}
