package defpackage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: vh6  reason: default package */
/* compiled from: Dns.kt */
public final class vh6 implements wh6 {
    @Override // defpackage.wh6
    public List<InetAddress> a(String str) {
        n86.f(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            n86.b(allByName, "InetAddress.getAllByName(hostname)");
            n86.e(allByName, "$this$toList");
            int length = allByName.length;
            if (length == 0) {
                return b66.f;
            }
            if (length == 1) {
                return hd3.c2(allByName[0]);
            }
            n86.e(allByName, "$this$toMutableList");
            n86.e(allByName, "$this$asCollection");
            return new ArrayList(new w56(allByName, false));
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException(hj1.S("Broken system behaviour for dns lookup of ", str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
