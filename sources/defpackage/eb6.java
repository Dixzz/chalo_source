package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: eb6  reason: default package */
/* compiled from: CompletionState.kt */
public class eb6 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(eb6.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f955a;

    public eb6(Throwable th, boolean z) {
        this.f955a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r1 = this;
            int r0 = r1._handled
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.eb6.a():boolean");
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + this.f955a + ']';
    }

    public eb6(Throwable th, boolean z, int i) {
        z = (i & 2) != 0 ? false : z;
        this.f955a = th;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        this._handled = i2;
    }
}
