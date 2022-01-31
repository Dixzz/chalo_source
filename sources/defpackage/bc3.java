package defpackage;

import java.lang.Thread;

/* renamed from: bc3  reason: default package */
public final class bc3 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac3 f411a;

    public bc3(ac3 ac3) {
        this.f411a = ac3;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        sd3 sd3 = this.f411a.e;
        if (sd3 != null) {
            sd3.L("Job execution failed", th);
        }
    }
}
