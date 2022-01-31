package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0129f implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f1670a;
    public final /* synthetic */ q b;

    public /* synthetic */ C0129f(q qVar, q qVar2) {
        this.f1670a = qVar;
        this.b = qVar2;
    }

    @Override // j$.util.function.q
    public final void accept(double d) {
        q qVar = this.f1670a;
        q qVar2 = this.b;
        qVar.accept(d);
        qVar2.accept(d);
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
    }
}
