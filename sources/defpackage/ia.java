package defpackage;

/* renamed from: ia  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class ia<T> extends xa<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f1499a;
    public final int b;

    public ia(T t, int i) {
        super(null);
        this.f1499a = t;
        this.b = i;
    }

    public final void a() {
        T t = this.f1499a;
        boolean z = false;
        if ((t != null ? t.hashCode() : 0) == this.b) {
            z = true;
        }
        if (!z) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }
}
