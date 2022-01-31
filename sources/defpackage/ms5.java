package defpackage;

import com.urbanairship.iam.InAppMessage;
import defpackage.gr5;

/* renamed from: ms5  reason: default package */
/* compiled from: FullScreenAdapterFactory */
public class ms5 implements gr5.a {
    @Override // defpackage.gr5.a
    public gr5 a(InAppMessage inAppMessage) {
        ns5 ns5 = (ns5) inAppMessage.c();
        if (ns5 != null) {
            return new ls5(inAppMessage, ns5);
        }
        throw new IllegalArgumentException("Invalid message for adapter: " + inAppMessage);
    }
}
