package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* renamed from: ao6  reason: default package */
/* compiled from: InvalidationHandler */
public class ao6 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<wn6> f272a;

    public ao6(wn6 wn6) {
        super(Looper.getMainLooper());
        this.f272a = new WeakReference<>(wn6);
    }

    public void handleMessage(Message message) {
        wn6 wn6 = this.f272a.get();
        if (wn6 != null) {
            if (message.what == -1) {
                wn6.invalidateSelf();
                return;
            }
            Iterator<un6> it = wn6.m.iterator();
            while (it.hasNext()) {
                it.next().a(message.what);
            }
        }
    }
}
