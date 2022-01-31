package defpackage;

import java.util.Objects;

/* renamed from: t66  reason: default package */
/* compiled from: IntrinsicsJvm.kt */
public final class t66 extends w66 {
    public int f;
    public final /* synthetic */ k66 g;
    public final /* synthetic */ m66 h;
    public final /* synthetic */ w76 i;
    public final /* synthetic */ Object j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t66(k66 k66, m66 m66, k66 k662, m66 m662, w76 w76, Object obj) {
        super(k662, m662);
        this.g = k66;
        this.h = m66;
        this.i = w76;
        this.j = obj;
    }

    @Override // defpackage.u66
    public Object invokeSuspend(Object obj) {
        int i2 = this.f;
        if (i2 == 0) {
            this.f = 1;
            hd3.Y2(obj);
            w76 w76 = this.i;
            Objects.requireNonNull(w76, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            b96.b(w76, 2);
            return w76.invoke(this.j, this);
        } else if (i2 == 1) {
            this.f = 2;
            hd3.Y2(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
