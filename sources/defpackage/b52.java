package defpackage;

import android.os.Looper;
import android.os.Message;

/* renamed from: b52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class b52 extends ve2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d52 f381a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b52(d52 d52, Looper looper) {
        super(looper);
        this.f381a = d52;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            d52 d52 = this.f381a;
            d52.b.lock();
            try {
                if (d52.u()) {
                    d52.z();
                }
            } finally {
                d52.b.unlock();
            }
        } else if (i == 2) {
            d52.x(this.f381a);
        }
    }
}
