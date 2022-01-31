package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: nf6  reason: default package */
/* compiled from: Atomic.kt */
public abstract class nf6<T> extends zf6 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2549a = AtomicReferenceFieldUpdater.newUpdater(nf6.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = mf6.f2371a;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.zf6
    public final Object a(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = mf6.f2371a;
        if (obj2 == obj3) {
            obj2 = c(obj);
            Object obj4 = this._consensus;
            if (obj4 != obj3) {
                obj2 = obj4;
            } else if (!f2549a.compareAndSet(this, obj3, obj2)) {
                obj2 = this._consensus;
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(T t, Object obj);

    public abstract Object c(T t);
}
