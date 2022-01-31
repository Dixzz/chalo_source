package defpackage;

/* renamed from: a76  reason: default package */
/* compiled from: ContinuationImpl.kt */
public abstract class a76 extends u66 {
    public a76(k66<Object> k66) {
        super(k66);
        if (k66 != null) {
            if (!(k66.getContext() == o66.f)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // defpackage.k66
    public m66 getContext() {
        return o66.f;
    }
}
