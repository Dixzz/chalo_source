package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.J;
import j$.util.function.w;
import j$.util.r;
import j$.util.stream.S2;
import java.util.Objects;

/* access modifiers changed from: package-private */
public final class a3<P_IN> extends W2<P_IN, Integer, S2.c> implements Spliterator.b {
    a3(T1 t1, Spliterator spliterator, boolean z) {
        super(t1, spliterator, z);
    }

    a3(T1 t1, J j, boolean z) {
        super(t1, j, z);
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return r.f(this, consumer);
    }

    @Override // j$.util.Spliterator.b
    /* renamed from: c */
    public void forEachRemaining(w wVar) {
        if (this.h != null || this.i) {
            do {
            } while (tryAdvance(wVar));
            return;
        }
        Objects.requireNonNull(wVar);
        g();
        this.b.t0(new C0150e(wVar), this.d);
        this.i = true;
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        r.b(this, consumer);
    }

    @Override // j$.util.Spliterator.b
    /* renamed from: h */
    public boolean tryAdvance(w wVar) {
        Objects.requireNonNull(wVar);
        boolean a2 = a();
        if (a2) {
            S2.c cVar = (S2.c) this.h;
            long j = this.g;
            int w = cVar.w(j);
            wVar.accept((cVar.c == 0 && w == 0) ? ((int[]) cVar.e)[(int) j] : ((int[][]) cVar.f)[w][(int) (j - cVar.d[w])]);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.W2
    public void i() {
        S2.c cVar = new S2.c();
        this.h = cVar;
        this.e = this.b.u0(new L0(cVar));
        this.f = new C0234z0(this);
    }

    /* access modifiers changed from: package-private */
    @Override // j$.util.stream.W2
    public W2 k(Spliterator spliterator) {
        return new a3(this.b, spliterator, this.f1755a);
    }

    @Override // j$.util.Spliterator.b, j$.util.Spliterator.d, j$.util.Spliterator, j$.util.stream.W2
    public Spliterator.b trySplit() {
        return (Spliterator.b) super.trySplit();
    }
}
