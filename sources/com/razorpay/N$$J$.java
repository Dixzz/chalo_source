package com.razorpay;

import android.app.Activity;
import android.content.IntentFilter;
import com.google.firebase.appindexing.Indexable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SmsAgent */
public class N$$J$ {
    private static N$$J$ c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<SmsAgentInterface> f681a = new ArrayList<>();
    private SmsReceiver b;

    public static N$$J$ a() {
        if (c == null) {
            c = new N$$J$();
        }
        return c;
    }

    public final void b(Activity activity) {
        a(false);
        SmsReceiver smsReceiver = this.b;
        if (smsReceiver != null) {
            try {
                activity.unregisterReceiver(smsReceiver);
            } catch (Exception e) {
                AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getMessage());
            }
            this.b = null;
        }
    }

    public final void a(Activity activity) {
        if (this.b == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
            this.b = new SmsReceiver(this);
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            activity.registerReceiver(this.b, intentFilter);
        }
    }

    public final void a(boolean z) {
        Iterator<SmsAgentInterface> it = this.f681a.iterator();
        while (it.hasNext()) {
            it.next().setSmsPermission(z);
        }
    }
}
