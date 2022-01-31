package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: qf5  reason: default package */
/* compiled from: Utils */
public final class qf5 extends Handler {
    public qf5(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        sendMessageDelayed(obtainMessage(), 1000);
    }
}
