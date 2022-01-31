package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.ui.activities.BookingSuccessActivity;

/* renamed from: pc0  reason: default package */
/* compiled from: BookingSuccessActivity */
public class pc0 implements View.OnClickListener {
    public final /* synthetic */ BookingSuccessActivity f;

    public pc0(BookingSuccessActivity bookingSuccessActivity) {
        this.f = bookingSuccessActivity;
    }

    public void onClick(View view) {
        BookingSuccessActivity bookingSuccessActivity = this.f;
        int i = BookingSuccessActivity.t;
        bookingSuccessActivity.k0("booking success use now");
        Intent intent = new Intent();
        intent.putExtra(SuperPassJsonKeys.QR_CODE, this.f.getIntent().getStringExtra(SuperPassJsonKeys.QR_CODE));
        this.f.setResult(-1, intent);
        this.f.finish();
    }
}
