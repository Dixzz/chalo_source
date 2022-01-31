package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: o63  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class o63 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final String f2655a;
    public final /* synthetic */ q63 b;

    public o63(q63 q63, String str) {
        this.b = q63;
        this.f2655a = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).g == 0) {
                String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                p63 p63 = this.b.c.get(this.f2655a);
                if (p63 == null) {
                    q63.d.b("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
                    String group = matcher.find() ? matcher.group() : null;
                    p63.e = group;
                    if (group == null) {
                        q63.d.b("Unable to extract verification code.", new Object[0]);
                    } else if (!gj1.x1(p63.d)) {
                        q63.f(this.b, this.f2655a);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
