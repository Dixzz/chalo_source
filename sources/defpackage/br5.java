package defpackage;

import com.razorpay.AnalyticsConstants;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: br5  reason: default package */
/* compiled from: DisplayEvent */
public class br5 extends hr5 {
    public final InAppMessage k;

    public br5(String str, InAppMessage inAppMessage, JsonValue jsonValue) {
        super(str, inAppMessage.m, jsonValue);
        this.k = inAppMessage;
    }

    @Override // defpackage.ll5
    public final String f() {
        return "in_app_display";
    }

    @Override // defpackage.hr5
    public zt5.b i(zt5.b bVar) {
        bVar.i(AnalyticsConstants.LOCALE, this.k.n);
        return bVar;
    }
}
