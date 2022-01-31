package com.razorpay;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import java.util.Objects;

public class AutoReadOtpHelper extends BroadcastReceiver {
    private Activity activity;

    public AutoReadOtpHelper(Activity activity2) {
        this.activity = activity2;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_RECEIVED_SMS);
            int i = ((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).g;
            if (i == 0) {
                ComponentName callingActivity = this.activity.getCallingActivity();
                Objects.requireNonNull(callingActivity);
                if (callingActivity.getPackageName().equalsIgnoreCase(BuildConfig.APPLICATION_ID)) {
                    try {
                        this.activity.startActivityForResult((Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT"), BaseConstants.SMS_CONSENT_REQUEST);
                        AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_SHOWED_ONE_TIME_CONSENT);
                    } catch (ActivityNotFoundException e) {
                        AnalyticsUtil.reportError(e, AnalyticsConstants.CRITICAL, e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                }
            } else if (i == 15) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_TIMEOUT);
            }
        }
    }
}
