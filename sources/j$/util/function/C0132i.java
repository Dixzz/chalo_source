package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0132i implements F {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ F f1673a;
    public final /* synthetic */ F b;

    public /* synthetic */ C0132i(F f, F f2) {
        this.f1673a = f;
        this.b = f2;
    }

    @Override // j$.util.function.F
    public F a(F f) {
        Objects.requireNonNull(f);
        return new C0132i(this, f);
    }

    @Override // j$.util.function.F
    public final long applyAsLong(long j) {
        return this.b.applyAsLong(this.f1673a.applyAsLong(j));
    }

    @Override // j$.util.function.F
    public F b(F f) {
        Objects.requireNonNull(f);
        return new C0133j(this, f);
    }
}
