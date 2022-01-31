package defpackage;

import java.util.Objects;

/* renamed from: q66  reason: default package */
/* compiled from: IntrinsicsJvm.kt */
public final class q66 extends a76 {
    public int f;
    public final /* synthetic */ k66 g;
    public final /* synthetic */ s76 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q66(k66 k66, k66 k662, s76 s76) {
        super(k662);
        this.g = k66;
        this.h = s76;
    }

    @Override // defpackage.u66
    public Object invokeSuspend(Object obj) {
        int i = this.f;
        if (i == 0) {
            this.f = 1;
            hd3.Y2(obj);
            s76 s76 = this.h;
            Objects.requireNonNull(s76, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            b96.b(s76, 1);
            return s76.invoke(this);
        } else if (i == 1) {
            this.f = 2;
            hd3.Y2(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
