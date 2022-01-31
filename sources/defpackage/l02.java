package defpackage;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.api.Status;
import java.util.Set;

/* renamed from: l02  reason: default package */
public final class l02 implements g02 {
    public final b32<Status> a(a32 a32) {
        Context context = ((d52) a32).f;
        n02.f2502a.a("Revoking access", new Object[0]);
        i02.a(context).f("refreshToken");
        r02.b(context).a();
        Set<a32> set = a32.f103a;
        synchronized (set) {
        }
        for (a32 a322 : set) {
            a322.p();
        }
        synchronized (o32.r) {
            o32 o32 = o32.s;
            if (o32 != null) {
                o32.i.incrementAndGet();
                Handler handler = o32.n;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
        return a32.j(new o02(a32));
    }
}
