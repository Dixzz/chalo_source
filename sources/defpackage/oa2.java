package defpackage;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import java.util.Objects;

/* renamed from: oa2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class oa2 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ pa2 f2670a;

    public /* synthetic */ oa2(pa2 pa2) {
        this.f2670a = pa2;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f2670a.c) {
                ma2 ma2 = (ma2) message.obj;
                na2 na2 = this.f2670a.c.get(ma2);
                if (na2 != null && na2.f2529a.isEmpty()) {
                    if (na2.c) {
                        na2.g.e.removeMessages(1, na2.e);
                        pa2 pa2 = na2.g;
                        pa2.f.c(pa2.d, na2);
                        na2.c = false;
                        na2.b = 2;
                    }
                    this.f2670a.c.remove(ma2);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f2670a.c) {
                ma2 ma22 = (ma2) message.obj;
                na2 na22 = this.f2670a.c.get(ma22);
                if (na22 != null && na22.b == 3) {
                    String.valueOf(ma22).length();
                    new Exception();
                    ComponentName componentName = na22.f;
                    if (componentName == null) {
                        Objects.requireNonNull(ma22);
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = ma22.b;
                        Objects.requireNonNull(str, "null reference");
                        componentName = new ComponentName(str, "unknown");
                    }
                    na22.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
