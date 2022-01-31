package a;

import j$.util.stream.AbstractC0180l1;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

public final /* synthetic */ class P0 implements BaseStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AbstractC0180l1 f34a;

    private /* synthetic */ P0(AbstractC0180l1 l1Var) {
        this.f34a = l1Var;
    }

    public static /* synthetic */ BaseStream m0(AbstractC0180l1 l1Var) {
        if (l1Var == null) {
            return null;
        }
        return l1Var instanceof O0 ? ((O0) l1Var).f32a : new P0(l1Var);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f34a.close();
    }

    public /* synthetic */ boolean isParallel() {
        return this.f34a.isParallel();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ Iterator iterator() {
        return this.f34a.iterator();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return m0(this.f34a.onClose(runnable));
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream parallel() {
        return m0(this.f34a.parallel());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream sequential() {
        return m0(this.f34a.sequential());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ Spliterator spliterator() {
        return C0101o.a(this.f34a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream unordered() {
        return m0(this.f34a.unordered());
    }
}
