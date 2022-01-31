package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.BookingSuccessActivity;
import app.zophop.ui.activities.HomeActivity;

/* renamed from: oc0  reason: default package */
/* compiled from: BookingSuccessActivity */
public class oc0 implements View.OnClickListener {
    public final /* synthetic */ BookingSuccessActivity f;

    public oc0(BookingSuccessActivity bookingSuccessActivity) {
        this.f = bookingSuccessActivity;
    }

    public void onClick(View view) {
        BookingSuccessActivity bookingSuccessActivity = this.f;
        int i = BookingSuccessActivity.t;
        bookingSuccessActivity.k0("booking success use later");
        Intent intent = new Intent(this.f, HomeActivity.class);
        intent.setFlags(268468224);
        this.f.startActivity(intent);
    }
}
