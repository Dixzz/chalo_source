package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.razorpay.AnalyticsConstants;
import com.truecaller.android.sdk.clients.VerificationCallback;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: sh5  reason: default package */
/* compiled from: TruecallerOtpReceiver */
public class sh5 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<VerificationCallback> f3213a;

    public sh5(VerificationCallback verificationCallback) {
        this.f3213a = new WeakReference<>(verificationCallback);
    }

    public void onReceive(Context context, Intent intent) {
        context.unregisterReceiver(this);
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).g == 0) {
                Matcher matcher = Pattern.compile("\\b\\d{6,}\\b").matcher((String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE"));
                bh5 bh5 = new bh5();
                if (matcher.find()) {
                    bh5.f433a.put(AnalyticsConstants.OTP, matcher.group());
                }
                if (this.f3213a.get() != null) {
                    this.f3213a.get().onRequestSuccess(2, bh5);
                }
            }
        }
    }
}
