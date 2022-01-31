package defpackage;

import defpackage.zh;
import java.util.Objects;

/* renamed from: ai  reason: default package */
/* compiled from: ViewModelProvider.kt */
public final class ai<VM extends zh> implements j56<VM> {
    public VM f;
    public final n96<VM> g;
    public final h76<gi> h;
    public final h76<ci> i;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: h76<? extends gi> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: h76<? extends ci> */
    /* JADX WARN: Multi-variable type inference failed */
    public ai(n96<VM> n96, h76<? extends gi> h76, h76<? extends ci> h762) {
        n86.e(n96, "viewModelClass");
        n86.e(h76, "storeProducer");
        n86.e(h762, "factoryProducer");
        this.g = n96;
        this.h = h76;
        this.i = h762;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: zh */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.j56
    public Object getValue() {
        VM vm = this.f;
        if (vm == null) {
            ci invoke = this.i.invoke();
            gi invoke2 = this.h.invoke();
            n96<VM> n96 = this.g;
            n86.e(n96, "$this$java");
            Class<?> a2 = ((g86) n96).a();
            Objects.requireNonNull(a2, "null cannot be cast to non-null type java.lang.Class<T>");
            String canonicalName = a2.getCanonicalName();
            if (canonicalName != null) {
                String S = hj1.S("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                zh zhVar = invoke2.f1264a.get(S);
                if (a2.isInstance(zhVar)) {
                    if (invoke instanceof fi) {
                        ((fi) invoke).b(zhVar);
                    }
                    vm = (VM) zhVar;
                } else {
                    vm = invoke instanceof di ? (VM) ((di) invoke).c(S, a2) : (VM) invoke.a(a2);
                    zh put = invoke2.f1264a.put(S, vm);
                    if (put != null) {
                        put.b();
                    }
                }
                this.f = vm;
                n86.d(vm, "ViewModelProvider(store,…ed = it\n                }");
            } else {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
        }
        return vm;
    }
}
