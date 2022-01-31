package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: un1  reason: default package */
/* compiled from: ResourceRecycler */
public class un1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3527a;
    public final Handler b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: un1$a */
    /* compiled from: ResourceRecycler */
    public static class a implements Handler.Callback {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((rn1) message.obj).a();
            return true;
        }
    }

    public void a(rn1<?> rn1) {
        rt1.a();
        if (this.f3527a) {
            this.b.obtainMessage(1, rn1).sendToTarget();
            return;
        }
        this.f3527a = true;
        rn1.a();
        this.f3527a = false;
    }
}
