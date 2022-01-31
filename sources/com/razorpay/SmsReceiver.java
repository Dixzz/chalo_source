package com.razorpay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import java.util.Iterator;

public class SmsReceiver extends BroadcastReceiver {
    private N$$J$ smsAgent;

    public SmsReceiver() {
        this.smsAgent = null;
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                Object[] objArr = (Object[]) extras.get("pdus");
                if (objArr.length > 0) {
                    SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) objArr[0]);
                    String displayOriginatingAddress = createFromPdu.getDisplayOriginatingAddress();
                    String displayMessageBody = createFromPdu.getDisplayMessageBody();
                    N$$J$ n$$j$ = this.smsAgent;
                    if (n$$j$ != null) {
                        Iterator<SmsAgentInterface> it = n$$j$.f681a.iterator();
                        while (it.hasNext()) {
                            it.next().postSms(displayOriginatingAddress, displayMessageBody);
                        }
                        return;
                    }
                    Intent intent2 = new Intent("com.razorpay.events.SMS_PROCESSED");
                    intent2.putExtra("extra_sender", displayOriginatingAddress);
                    intent2.putExtra("extra_message", displayMessageBody);
                    context.sendBroadcast(intent2);
                }
            } catch (Exception e) {
                AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getMessage());
                String str = "SmsReceiver Exception smsReceiver" + e;
            }
        }
    }

    public SmsReceiver(N$$J$ n$$j$) {
        this.smsAgent = n$$j$;
    }
}
