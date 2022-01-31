package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: oa5  reason: default package */
/* compiled from: CameraThread */
public class oa5 {
    public static oa5 e;

    /* renamed from: a  reason: collision with root package name */
    public Handler f2672a;
    public HandlerThread b;
    public int c = 0;
    public final Object d = new Object();

    public final void a() {
        synchronized (this.d) {
            if (this.f2672a == null) {
                if (this.c > 0) {
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.b = handlerThread;
                    handlerThread.start();
                    this.f2672a = new Handler(this.b.getLooper());
                } else {
                    throw new IllegalStateException("CameraThread is not open");
                }
            }
        }
    }

    public void b(Runnable runnable) {
        synchronized (this.d) {
            a();
            this.f2672a.post(runnable);
        }
    }
}
