package defpackage;

import java.util.Objects;

/* renamed from: r66  reason: default package */
/* compiled from: IntrinsicsJvm.kt */
public final class r66 extends w66 {
    public int f;
    public final /* synthetic */ k66 g;
    public final /* synthetic */ m66 h;
    public final /* synthetic */ s76 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r66(k66 k66, m66 m66, k66 k662, m66 m662, s76 s76) {
        super(k662, m662);
        this.g = k66;
        this.h = m66;
        this.i = s76;
    }

    @Override // defpackage.u66
    public Object invokeSuspend(Object obj) {
        int i2 = this.f;
        if (i2 == 0) {
            this.f = 1;
            hd3.Y2(obj);
            s76 s76 = this.i;
            Objects.requireNonNull(s76, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            b96.b(s76, 1);
            return s76.invoke(this);
        } else if (i2 == 1) {
            this.f = 2;
            hd3.Y2(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
