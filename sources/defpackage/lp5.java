package defpackage;

import com.razorpay.AnalyticsConstants;
import java.util.List;

/* renamed from: lp5  reason: default package */
/* compiled from: AirshipChannel */
public class lp5 extends iq5 {
    public final /* synthetic */ kp5 b;

    public lp5(kp5 kp5) {
        this.b = kp5;
    }

    @Override // defpackage.iq5
    public boolean b(String str) {
        if (!this.b.p || !AnalyticsConstants.DEVICE.equals(str)) {
            return true;
        }
        yj5.c("Unable to add tags to `%s` tag group when `channelTagRegistrationEnabled` is true.", AnalyticsConstants.DEVICE);
        return false;
    }

    @Override // defpackage.iq5
    public void d(List<jq5> list) {
        if (!this.b.i.d(32)) {
            yj5.i("AirshipChannel - Unable to apply tag edits when opted out of tags and attributes.", new Object[0]);
        } else if (!list.isEmpty()) {
            this.b.m.a(list);
            this.b.i();
        }
    }
}
