package j$.util.stream;

import j$.util.function.J;
import j$.util.function.Predicate;

/* renamed from: j$.util.stream.b0  reason: case insensitive filesystem */
public final /* synthetic */ class C0139b0 implements J {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ N1 f1770a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ C0139b0(N1 n1, Predicate predicate) {
        this.f1770a = n1;
        this.b = predicate;
    }

    @Override // j$.util.function.J
    public final Object get() {
        return new I1(this.f1770a, this.b);
    }
}
