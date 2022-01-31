package defpackage;

import java.net.InetAddress;

/* renamed from: nd5  reason: default package */
/* compiled from: HttpService */
public class nd5 implements Runnable {
    public nd5(od5 od5) {
    }

    public void run() {
        boolean z;
        try {
            InetAddress byName = InetAddress.getByName("api.mixpanel.com");
            InetAddress byName2 = InetAddress.getByName("decide.mixpanel.com");
            if (!byName.isLoopbackAddress() && !byName.isAnyLocalAddress() && !byName2.isLoopbackAddress()) {
                if (!byName2.isAnyLocalAddress()) {
                    z = false;
                    od5.f2679a = z;
                }
            }
            z = true;
            od5.f2679a = z;
        } catch (Exception unused) {
        }
    }
}
