package defpackage;

import java.util.concurrent.CountDownLatch;

/* renamed from: bj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class bj4 implements cj4 {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f442a = new CountDownLatch(1);

    public /* synthetic */ bj4(xj4 xj4) {
    }

    @Override // defpackage.si4
    public final void onCanceled() {
        this.f442a.countDown();
    }

    @Override // defpackage.ui4
    public final void onFailure(Exception exc) {
        this.f442a.countDown();
    }

    @Override // defpackage.vi4
    public final void onSuccess(Object obj) {
        this.f442a.countDown();
    }
}
