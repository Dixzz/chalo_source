package defpackage;

import java.util.concurrent.CountDownLatch;

/* renamed from: fy4  reason: default package */
public final class fy4 implements px4, ox4 {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f1187a = new CountDownLatch(1);

    public /* synthetic */ fy4(byte[] bArr) {
    }

    @Override // defpackage.ox4
    public final void onFailure(Exception exc) {
        this.f1187a.countDown();
    }

    @Override // defpackage.px4
    public final void onSuccess(Object obj) {
        this.f1187a.countDown();
    }
}
