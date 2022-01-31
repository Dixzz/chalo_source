package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0216u2;
import java.util.concurrent.CountedCompleter;

/* access modifiers changed from: package-private */
/* renamed from: j$.util.stream.x2  reason: case insensitive filesystem */
public final class C0228x2<P_IN, P_OUT, R, S extends AbstractC0216u2<P_OUT, R, S>> extends AbstractC0176k1<P_IN, P_OUT, S, C0228x2<P_IN, P_OUT, R, S>> {
    private final AbstractC0224w2 h;

    C0228x2(AbstractC0224w2 w2Var, T1 t1, Spliterator spliterator) {
        super(t1, spliterator);
        this.h = w2Var;
    }

    C0228x2(C0228x2 x2Var, Spliterator spliterator) {
        super(x2Var, spliterator);
        this.h = x2Var.h;
    }

    /* access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0176k1
    public Object a() {
        T1 t1 = this.f1803a;
        AbstractC0216u2 a2 = this.h.a();
        t1.t0(a2, this.b);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0176k1
    public AbstractC0176k1 f(Spliterator spliterator) {
        return new C0228x2(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0176k1, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (!d()) {
            AbstractC0216u2 u2Var = (AbstractC0216u2) ((C0228x2) this.d).b();
            u2Var.i((AbstractC0216u2) ((C0228x2) this.e).b());
            g(u2Var);
        }
        this.b = null;
        this.e = null;
        this.d = null;
    }
}
