package defpackage;

import com.urbanairship.iam.InAppMessage;
import defpackage.gr5;

/* renamed from: vs5  reason: default package */
/* compiled from: ModalAdapterFactory */
public class vs5 implements gr5.a {
    @Override // defpackage.gr5.a
    public gr5 a(InAppMessage inAppMessage) {
        ws5 ws5 = (ws5) inAppMessage.c();
        if (ws5 != null) {
            return new us5(inAppMessage, ws5);
        }
        throw new IllegalArgumentException("Invalid message for adapter: " + inAppMessage);
    }
}
