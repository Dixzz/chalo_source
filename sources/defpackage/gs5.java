package defpackage;

import com.urbanairship.iam.InAppMessage;
import defpackage.gr5;
import java.util.Map;

/* renamed from: gs5  reason: default package */
/* compiled from: BannerAdapterFactory */
public class gs5 implements gr5.a {
    @Override // defpackage.gr5.a
    public gr5 a(InAppMessage inAppMessage) {
        Map<Class, Integer> map = es5.j;
        hs5 hs5 = (hs5) inAppMessage.c();
        if (hs5 != null) {
            return new es5(inAppMessage, hs5);
        }
        throw new IllegalArgumentException("Invalid message for adapter: " + inAppMessage);
    }
}
