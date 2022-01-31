package defpackage;

import android.database.ContentObserver;

/* renamed from: of3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class of3 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ mf3 f2684a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public of3(mf3 mf3) {
        super(null);
        this.f2684a = mf3;
    }

    public final void onChange(boolean z) {
        mf3 mf3 = this.f2684a;
        synchronized (mf3.d) {
            mf3.e = null;
            yf3.i.incrementAndGet();
        }
        synchronized (mf3) {
            for (nf3 nf3 : mf3.f) {
                nf3.a();
            }
        }
    }
}
