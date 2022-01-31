package j$.util.stream;

import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0130g;
import j$.util.function.Consumer;
import j$.util.function.v;
import j$.util.function.w;
import j$.util.p;
import j$.util.stream.A2;
import java.util.Objects;

/* renamed from: j$.util.stream.n2  reason: case insensitive filesystem */
class C0189n2 implements AbstractC0216u2<Integer, p, C0189n2>, A2.f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1812a;
    private int b;
    final /* synthetic */ v c;

    C0189n2(v vVar) {
        this.c = vVar;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(double d) {
        b.c(this);
        throw null;
    }

    @Override // j$.util.stream.A2.f, j$.util.function.w, j$.util.stream.A2
    public void accept(int i) {
        if (this.f1812a) {
            this.f1812a = false;
        } else {
            i = this.c.applyAsInt(this.b, i);
        }
        this.b = i;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j) {
        b.b(this);
        throw null;
    }

    /* renamed from: b */
    public /* synthetic */ void accept(Integer num) {
        Q1.b(this, num);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.function.J
    public Object get() {
        return this.f1812a ? p.a() : p.d(this.b);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        C0189n2 n2Var = (C0189n2) u2Var;
        if (!n2Var.f1812a) {
            accept(n2Var.b);
        }
    }

    @Override // j$.util.function.w
    public w l(w wVar) {
        Objects.requireNonNull(wVar);
        return new C0130g(this, wVar);
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
        this.f1812a = true;
        this.b = 0;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
