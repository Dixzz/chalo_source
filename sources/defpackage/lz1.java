package defpackage;

import android.util.Log;
import defpackage.jz1;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

/* renamed from: lz1  reason: default package */
public final class lz1 extends FutureTask<T> {
    public final /* synthetic */ jz1.a f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public lz1(jz1.a aVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f = aVar;
    }

    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = jz1.this.e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String.valueOf(th).length();
        }
        super.setException(th);
    }
}
