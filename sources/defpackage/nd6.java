package defpackage;

/* renamed from: nd6  reason: default package */
/* compiled from: Unconfined.kt */
public final class nd6 extends kb6 {
    public static final nd6 g = new nd6();

    @Override // defpackage.kb6
    public void m(m66 m66, Runnable runnable) {
        if (((qd6) m66.get(qd6.f)) == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    @Override // defpackage.kb6
    public boolean n(m66 m66) {
        return false;
    }

    @Override // defpackage.kb6
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
