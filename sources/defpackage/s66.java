package defpackage;

import java.util.Objects;

/* renamed from: s66  reason: default package */
/* compiled from: IntrinsicsJvm.kt */
public final class s66 extends a76 {
    public int f;
    public final /* synthetic */ k66 g;
    public final /* synthetic */ w76 h;
    public final /* synthetic */ Object i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s66(k66 k66, k66 k662, w76 w76, Object obj) {
        super(k662);
        this.g = k66;
        this.h = w76;
        this.i = obj;
    }

    @Override // defpackage.u66
    public Object invokeSuspend(Object obj) {
        int i2 = this.f;
        if (i2 == 0) {
            this.f = 1;
            hd3.Y2(obj);
            w76 w76 = this.h;
            Objects.requireNonNull(w76, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            b96.b(w76, 2);
            return w76.invoke(this.i, this);
        } else if (i2 == 1) {
            this.f = 2;
            hd3.Y2(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
