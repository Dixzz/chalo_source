package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0131h implements C {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f1672a;
    public final /* synthetic */ C b;

    public /* synthetic */ C0131h(C c, C c2) {
        this.f1672a = c;
        this.b = c2;
    }

    @Override // j$.util.function.C
    public final void accept(long j) {
        C c = this.f1672a;
        C c2 = this.b;
        c.accept(j);
        c2.accept(j);
    }

    @Override // j$.util.function.C
    public C g(C c) {
        Objects.requireNonNull(c);
        return new C0131h(this, c);
    }
}
