package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* renamed from: n10  reason: default package */
/* compiled from: FirebaseFeature */
public class n10 implements m20 {

    /* renamed from: a  reason: collision with root package name */
    public final xj1 f2505a;
    public final Map<String, t10> b = new HashMap();
    public t10 c;

    public n10(xj1 xj1) {
        this.f2505a = xj1;
    }

    @Override // defpackage.m20
    public void a(String str) {
        t10 t10 = this.b.get(str);
        if (t10 != null) {
            t10.d();
            this.b.remove(str);
        }
    }

    @Override // defpackage.m20
    public String b(String str, String str2) {
        String uuid = UUID.randomUUID().toString();
        t10 t10 = new t10(this.f2505a, uuid, str2);
        this.c = t10;
        t10.b = new q10(t10, str);
        HandlerThread handlerThread = new HandlerThread(t10.c);
        t10.f3292a = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(t10.f3292a.getLooper());
        t10.d = handler;
        handler.post(t10.b);
        this.b.put(uuid, this.c);
        return uuid;
    }

    @Override // defpackage.m20
    public void c(String str) {
        Iterator<Map.Entry<String, t10>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, t10> next = it.next();
            t10 value = next.getValue();
            if (value != null && value.e.equalsIgnoreCase(str)) {
                next.getKey();
                value.d();
                it.remove();
            }
        }
    }

    @Override // defpackage.m20
    public void d() {
        Iterator<Map.Entry<String, t10>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, t10> next = it.next();
            t10 value = next.getValue();
            if (value != null) {
                next.getKey();
                value.d();
                it.remove();
            }
        }
    }
}
