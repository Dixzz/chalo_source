package j$.util.stream;

import j$.util.function.C0132i;
import j$.util.function.C0133j;
import j$.util.function.F;
import java.util.Objects;

public final /* synthetic */ class U implements F {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ U f1748a = new U();

    private /* synthetic */ U() {
    }

    @Override // j$.util.function.F
    public F a(F f) {
        Objects.requireNonNull(f);
        return new C0132i(this, f);
    }

    @Override // j$.util.function.F
    public final long applyAsLong(long j) {
        return 1;
    }

    @Override // j$.util.function.F
    public F b(F f) {
        Objects.requireNonNull(f);
        return new C0133j(this, f);
    }
}
