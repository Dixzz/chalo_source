package defpackage;

import android.os.Bundle;
import defpackage.wi;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: xi  reason: default package */
/* compiled from: NavArgsLazy.kt */
public final class xi<Args extends wi> implements j56<Args> {
    public Args f;
    public final n96<Args> g;
    public final h76<Bundle> h;

    public xi(n96<Args> n96, h76<Bundle> h76) {
        n86.f(n96, "navArgsClass");
        n86.f(h76, "argumentProducer");
        this.g = n96;
        this.h = h76;
    }

    @Override // defpackage.j56
    public Object getValue() {
        Args args = this.f;
        if (args != null) {
            return args;
        }
        Bundle invoke = this.h.invoke();
        Class<Bundle>[] clsArr = yi.f4050a;
        n2<n96<? extends wi>, Method> n2Var = yi.b;
        Method method = n2Var.get(this.g);
        if (method == null) {
            n96<Args> n96 = this.g;
            n86.e(n96, "$this$java");
            Class<?> a2 = ((g86) n96).a();
            Objects.requireNonNull(a2, "null cannot be cast to non-null type java.lang.Class<T>");
            Class<Bundle>[] clsArr2 = yi.f4050a;
            method = a2.getMethod("fromBundle", (Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
            n2Var.put(this.g, method);
            n86.b(method, "navArgsClass.java.getMet…hod\n                    }");
        }
        Object invoke2 = method.invoke(null, invoke);
        if (invoke2 != null) {
            Args args2 = (Args) ((wi) invoke2);
            this.f = args2;
            return args2;
        }
        throw new p56("null cannot be cast to non-null type Args");
    }
}
