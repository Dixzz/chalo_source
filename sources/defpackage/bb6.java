package defpackage;

/* renamed from: bb6  reason: default package */
/* compiled from: CompletableDeferred.kt */
public final class bb6<T> extends wc6 implements ab6<T> {
    public bb6(rc6 rc6) {
        super(true);
        M(rc6);
    }

    @Override // defpackage.wc6
    public boolean G() {
        return true;
    }

    @Override // defpackage.ab6
    public boolean q(Throwable th) {
        return O(new eb6(th, false, 2));
    }

    @Override // defpackage.ab6
    public boolean r(T t) {
        return O(t);
    }
}
