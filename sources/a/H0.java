package a;

import j$.util.function.J;
import java.util.function.Supplier;

public final /* synthetic */ class H0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ J f18a;

    private /* synthetic */ H0(J j) {
        this.f18a = j;
    }

    public static /* synthetic */ Supplier a(J j) {
        if (j == null) {
            return null;
        }
        return j instanceof G0 ? ((G0) j).f16a : new H0(j);
    }

    @Override // java.util.function.Supplier
    public /* synthetic */ Object get() {
        return this.f18a.get();
    }
}
