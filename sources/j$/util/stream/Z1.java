package j$.util.stream;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.time.chrono.b;
import j$.util.function.C0128e;
import j$.util.function.C0129f;
import j$.util.function.Consumer;
import j$.util.function.p;
import j$.util.function.q;
import j$.util.o;
import j$.util.stream.A2;
import java.util.Objects;

class Z1 implements AbstractC0216u2<Double, o, Z1>, A2.e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1765a;
    private double b;
    final /* synthetic */ p c;

    Z1(p pVar) {
        this.c = pVar;
    }

    @Override // j$.util.function.q, j$.util.stream.A2.e, j$.util.stream.A2
    public void accept(double d) {
        if (this.f1765a) {
            this.f1765a = false;
        } else {
            d = this.c.applyAsDouble(this.b, d);
        }
        this.b = d;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(int i) {
        b.a(this);
        throw null;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ void accept(long j) {
        b.b(this);
        throw null;
    }

    /* renamed from: b */
    public /* synthetic */ void accept(Double d) {
        Q1.a(this, d);
    }

    @Override // j$.util.function.Consumer
    public Consumer f(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0128e(this, consumer);
    }

    @Override // j$.util.function.J
    public Object get() {
        return this.f1765a ? o.a() : o.d(this.b);
    }

    @Override // j$.util.stream.AbstractC0216u2
    public void i(AbstractC0216u2 u2Var) {
        Z1 z1 = (Z1) u2Var;
        if (!z1.f1765a) {
            accept(z1.b);
        }
    }

    @Override // j$.util.function.q
    public q k(q qVar) {
        Objects.requireNonNull(qVar);
        return new C0129f(this, qVar);
    }

    @Override // j$.util.stream.A2
    public void m() {
    }

    @Override // j$.util.stream.A2
    public void n(long j) {
        this.f1765a = true;
        this.b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // j$.util.stream.A2
    public /* synthetic */ boolean p() {
        return false;
    }
}
