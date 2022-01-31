package defpackage;

import java.util.concurrent.CountDownLatch;

/* renamed from: xv5  reason: default package */
/* compiled from: PushProviderBridge */
public class xv5 implements Runnable {
    public final /* synthetic */ CountDownLatch f;

    public xv5(yv5 yv5, CountDownLatch countDownLatch) {
        this.f = countDownLatch;
    }

    public void run() {
        this.f.countDown();
    }
}
