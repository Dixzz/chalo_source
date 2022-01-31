package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C;
import j$.util.function.Consumer;
import j$.util.function.J;
import j$.util.r;
import j$.util.stream.S2;
import java.util.Objects;

final class b3<P_IN> extends W2<P_IN, Long, S2.d> implements Spliterator.c {
    b3(T1 t1, Spliterator spliterator, boolean z) {
        super(t1, spliterator, z);
    }

    b3(T1 t1, J j, boolean z) {
        super(t1, j, z);
    }

    @Override // j$.util.Spliterator.c, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return r.g(this, consumer);
    }

    @Override // j$.util.Spliterator.c
    /* renamed from: d */
    public void forEachRemaining(C c) {
        if (this.h != null || this.i) {
            do {
            } while (tryAdvance(c));
            return;
        }
        Objects.requireNonNull(c);
        g();
        this.b.t0(new V0(c), this.d);
        this.i = true;
    }

    @Override // j$.util.Spliterator.c, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        r.c(this, consumer);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.W2
    public void i() {
        S2.d dVar = new S2.d();
        this.h = dVar;
        this.e = this.b.u0(new C0187n0(dVar));
        this.f = new A0(this);
    }

    @Override // j$.util.Spliterator.c
    /* renamed from: j */
    public boolean tryAdvance(C c) {
        Objects.requireNonNull(c);
        boolean a2 = a();
        if (a2) {
            S2.d dVar = (S2.d) this.h;
            long j = this.g;
            int w = dVar.w(j);
            c.accept((dVar.c == 0 && w == 0) ? ((long[]) dVar.e)[(int) j] : ((long[][]) dVar.f)[w][(int) (j - dVar.d[w])]);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.W2
    public W2 k(Spliterator spliterator) {
        return new b3(this.b, spliterator, this.f1755a);
    }

    @Override // j$.util.Spliterator.d, j$.util.Spliterator.c, j$.util.Spliterator, j$.util.stream.W2
    public Spliterator.c trySplit() {
        return (Spliterator.c) super.trySplit();
    }
}
