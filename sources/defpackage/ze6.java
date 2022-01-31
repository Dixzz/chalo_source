package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ze6  reason: default package */
/* compiled from: StateFlow.kt */
public final class ze6 extends ef6<xe6<?>> {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4165a = AtomicReferenceFieldUpdater.newUpdater(ze6.class, Object.class, "_state");
    public volatile /* synthetic */ Object _state = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ef6
    public boolean a(xe6<?> xe6) {
        if (this._state != null) {
            return false;
        }
        this._state = ye6.f4040a;
        return true;
    }

    public k66[] b(Object obj) {
        xe6 xe6 = (xe6) obj;
        this._state = null;
        return df6.f830a;
    }
}
