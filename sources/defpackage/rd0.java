package defpackage;

import app.zophop.models.PaymentItem;
import app.zophop.models.PaymentMethod.MethodDetails;
import app.zophop.ui.activities.CheckoutActivity;
import com.razorpay.AnalyticsConstants;
import com.razorpay.ApplicationDetails;
import com.razorpay.RzpUpiSupportedAppsCallback;
import java.util.List;
import java.util.Map;

/* renamed from: rd0  reason: default package */
/* compiled from: CheckoutActivity */
public class rd0 implements RzpUpiSupportedAppsCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f3067a;
    public final /* synthetic */ CheckoutActivity b;

    public rd0(CheckoutActivity checkoutActivity, Map map) {
        this.b = checkoutActivity;
        this.f3067a = map;
    }

    @Override // com.razorpay.RzpUpiSupportedAppsCallback
    public void onReceiveUpiSupportedApps(List<ApplicationDetails> list) {
        String str;
        boolean z;
        for (int i = 0; i < list.size(); i++) {
            ApplicationDetails applicationDetails = list.get(i);
            boolean z2 = true;
            if (this.f3067a.get(applicationDetails.getAppName()) != null) {
                MethodDetails methodDetails = (MethodDetails) this.f3067a.get(applicationDetails.getAppName());
                boolean methodStatus = methodDetails.getMethodStatus();
                boolean visibility = methodDetails.getVisibility();
                str = methodDetails.getWarning();
                z = methodStatus;
                z2 = visibility;
            } else {
                str = null;
                z = true;
            }
            PaymentItem paymentItem = new PaymentItem(applicationDetails.getIconBase64(), applicationDetails.getAppName(), AnalyticsConstants.UPI, z, str);
            paymentItem.setPackageName(applicationDetails.getPackageName());
            if (z2) {
                this.b.x.add(paymentItem);
            }
        }
    }
}
