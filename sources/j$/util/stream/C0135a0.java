package j$.util.stream;

import j$.util.function.J;
import j$.util.function.s;

/* renamed from: j$.util.stream.a0  reason: case insensitive filesystem */
public final /* synthetic */ class C0135a0 implements J {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ N1 f1767a;
    public final /* synthetic */ s b;

    public /* synthetic */ C0135a0(N1 n1, s sVar) {
        this.f1767a = n1;
        this.b = sVar;
    }

    @Override // j$.util.function.J
    public final Object get() {
        return new L1(this.f1767a, this.b);
    }
}
