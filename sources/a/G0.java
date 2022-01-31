package a;

import j$.util.function.J;
import java.util.function.Supplier;

public final /* synthetic */ class G0 implements J {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Supplier f16a;

    private /* synthetic */ G0(Supplier supplier) {
        this.f16a = supplier;
    }

    public static /* synthetic */ J a(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier instanceof H0 ? ((H0) supplier).f18a : new G0(supplier);
    }

    @Override // j$.util.function.J
    public /* synthetic */ Object get() {
        return this.f16a.get();
    }
}
