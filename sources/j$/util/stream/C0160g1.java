package j$.util.stream;

import j$.util.Optional;
import j$.util.function.Predicate;
import j$.util.function.k;
import j$.util.function.l;
import j$.util.function.m;
import java.util.Objects;

/* renamed from: j$.util.stream.g1  reason: case insensitive filesystem */
public final /* synthetic */ class C0160g1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0160g1 f1791a = new C0160g1();

    private /* synthetic */ C0160g1() {
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
        return ((Optional) obj).c();
    }
}
