package defpackage;

import android.os.Looper;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.locks.Lock;

/* renamed from: g52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class g52 extends ve2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h52 f1217a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g52(h52 h52, Looper looper) {
        super(looper);
        this.f1217a = h52;
    }

    public final void handleMessage(Message message) {
        Lock lock;
        int i = message.what;
        if (i == 1) {
            f52 f52 = (f52) message.obj;
            h52 h52 = this.f1217a;
            Objects.requireNonNull(f52);
            h52.f.lock();
            try {
                if (h52.p != f52.f1092a) {
                    lock = h52.f;
                } else {
                    f52.a();
                    lock = h52.f;
                }
                lock.unlock();
            } catch (Throwable th) {
                h52.f.unlock();
                throw th;
            }
        } else if (i == 2) {
            throw ((RuntimeException) message.obj);
        }
    }
}
