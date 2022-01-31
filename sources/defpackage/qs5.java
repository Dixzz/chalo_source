package defpackage;

import com.urbanairship.iam.InAppMessage;
import defpackage.gr5;

/* renamed from: qs5  reason: default package */
/* compiled from: HtmlAdapterFactory */
public class qs5 implements gr5.a {
    @Override // defpackage.gr5.a
    public gr5 a(InAppMessage inAppMessage) {
        ss5 ss5 = (ss5) inAppMessage.c();
        if (ss5 != null) {
            return new rs5(inAppMessage, ss5);
        }
        throw new IllegalArgumentException("Invalid message for adapter: " + inAppMessage);
    }
}
