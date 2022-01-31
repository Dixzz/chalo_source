package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: pc6  reason: default package */
/* compiled from: JobSupport.kt */
public final class pc6 extends tc6 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(pc6.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;
    public final s76<Throwable, s56> j;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s76<? super java.lang.Throwable, s56> */
    /* JADX WARN: Multi-variable type inference failed */
    public pc6(s76<? super Throwable, s56> s76) {
        this.j = s76;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public /* bridge */ /* synthetic */ s56 invoke(Throwable th) {
        v(th);
        return s56.f3190a;
    }

    @Override // defpackage.gb6
    public void v(Throwable th) {
        if (k.compareAndSet(this, 0, 1)) {
            this.j.invoke(th);
        }
    }
}
