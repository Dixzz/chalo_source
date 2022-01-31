package defpackage;

import android.content.Context;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import com.truecaller.multisim.SimInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: lj5  reason: default package */
/* compiled from: MultiSimManagerSamsungLollipopMr1 */
public class lj5 extends kj5 {
    public static final /* synthetic */ int o = 0;
    public final SubscriptionManager n;

    public lj5(Context context, TelecomManager telecomManager, SubscriptionManager subscriptionManager) throws Exception {
        super(context, telecomManager);
        this.n = subscriptionManager;
    }

    @Override // defpackage.kj5, defpackage.qi5
    public List<SimInfo> a() {
        if (!this.b.a("android.permission.READ_PHONE_STATE")) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        List<SubscriptionInfo> activeSubscriptionInfoList = this.n.getActiveSubscriptionInfoList();
        if (activeSubscriptionInfoList != null) {
            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                SimInfo b = b(String.valueOf(subscriptionInfo.getSubscriptionId()));
                if (b != null) {
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }
}
