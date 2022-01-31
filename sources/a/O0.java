package a;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0180l1;
import java.util.Iterator;
import java.util.stream.BaseStream;

public final /* synthetic */ class O0 implements AbstractC0180l1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseStream f32a;

    private /* synthetic */ O0(BaseStream baseStream) {
        this.f32a = baseStream;
    }

    public static /* synthetic */ AbstractC0180l1 m0(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof P0 ? ((P0) baseStream).f34a : new O0(baseStream);
    }

    @Override // j$.util.stream.AbstractC0180l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.f32a.close();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ boolean isParallel() {
        return this.f32a.isParallel();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ Iterator iterator() {
        return this.f32a.iterator();
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 onClose(Runnable runnable) {
        return m0(this.f32a.onClose(runnable));
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 parallel() {
        return m0(this.f32a.parallel());
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 sequential() {
        return m0(this.f32a.sequential());
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ Spliterator spliterator() {
        return C0099n.a(this.f32a.spliterator());
    }

    @Override // j$.util.stream.AbstractC0180l1
    public /* synthetic */ AbstractC0180l1 unordered() {
        return m0(this.f32a.unordered());
    }
}
