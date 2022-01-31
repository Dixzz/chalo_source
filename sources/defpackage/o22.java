package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: o22  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class o22 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2634a = false;
    public final BlockingQueue<IBinder> b = new LinkedBlockingQueue();

    @RecentlyNonNull
    public IBinder a(long j, @RecentlyNonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        gj1.k("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f2634a) {
            this.f2634a = true;
            IBinder poll = this.b.poll(j, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public final void onServiceConnected(@RecentlyNonNull ComponentName componentName, @RecentlyNonNull IBinder iBinder) {
        this.b.add(iBinder);
    }

    public final void onServiceDisconnected(@RecentlyNonNull ComponentName componentName) {
    }
}
