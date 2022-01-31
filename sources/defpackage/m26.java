package defpackage;

import defpackage.h26;
import java.util.List;

/* renamed from: m26  reason: default package */
/* compiled from: -InterceptorChain.kt */
public final class m26 implements h26.a {

    /* renamed from: a  reason: collision with root package name */
    public final List<h26> f2313a;
    public final int b;
    public final f26 c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends h26> */
    /* JADX WARN: Multi-variable type inference failed */
    public m26(List<? extends h26> list, int i, f26 f26) {
        n86.f(list, "interceptors");
        n86.f(f26, "request");
        this.f2313a = list;
        this.b = i;
        this.c = f26;
    }

    @Override // defpackage.h26.a
    public g26 a(f26 f26) {
        n86.f(f26, "request");
        if (this.b < this.f2313a.size()) {
            return this.f2313a.get(this.b).intercept(new m26(this.f2313a, this.b + 1, f26));
        }
        throw new AssertionError("no interceptors added to the chain");
    }

    @Override // defpackage.h26.a
    public f26 request() {
        return this.c;
    }
}
