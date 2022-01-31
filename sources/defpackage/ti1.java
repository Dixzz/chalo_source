package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.zophop.models.autoCabBooking.BookingCode;

/* renamed from: ti1  reason: default package */
/* compiled from: Utils */
public class ti1 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ BookingCode g;
    public final /* synthetic */ Activity h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;

    public ti1(lm0 lm0, BookingCode bookingCode, Activity activity, String str, String str2) {
        this.f = lm0;
        this.g = bookingCode;
        this.h = activity;
        this.i = str;
        this.j = str2;
    }

    public void onClick(View view) {
        this.f.dismiss();
        if (this.g.equals(BookingCode.USER_BLOCKED_ISSUE)) {
            this.h.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.i)));
            return;
        }
        Activity activity = this.h;
        String str = this.j;
        String str2 = this.i;
        activity.getPackageManager();
        try {
            if (str.equalsIgnoreCase("Uber")) {
                Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage("com.ubercab");
                launchIntentForPackage.setFlags(268435456);
                activity.startActivity(launchIntentForPackage);
            }
        } catch (Exception unused) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
        }
    }
}
