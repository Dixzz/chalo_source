package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import app.zophop.scanPay.ScanPayPaymentActivity;
import java.util.Objects;

/* renamed from: u80  reason: default package */
/* compiled from: ScanPayPaymentActivity */
public class u80 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScanPayPaymentActivity f3467a;

    public u80(ScanPayPaymentActivity scanPayPaymentActivity) {
        this.f3467a = scanPayPaymentActivity;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            Bundle data = message.getData();
            ScanPayPaymentActivity scanPayPaymentActivity = this.f3467a;
            String string = data.getString("bundle:querySearch");
            int i = ScanPayPaymentActivity.s;
            Objects.requireNonNull(scanPayPaymentActivity);
            int i2 = 8;
            if (TextUtils.isEmpty(string)) {
                scanPayPaymentActivity._discountSection.setVisibility(8);
                return;
            }
            scanPayPaymentActivity._discountSection.setVisibility(0);
            float i0 = scanPayPaymentActivity.i0(string);
            float parseFloat = Float.parseFloat(string) - i0;
            String format = String.format("%.02f", Float.valueOf(i0));
            String format2 = String.format("%.02f", Float.valueOf(parseFloat));
            scanPayPaymentActivity._discountAmount.setVisibility(i0 == 0.0f ? 8 : 0);
            int i3 = (parseFloat > 0.0f ? 1 : (parseFloat == 0.0f ? 0 : -1));
            scanPayPaymentActivity._discountSection.setVisibility(i3 > 0 ? 0 : 8);
            TextView textView = scanPayPaymentActivity._discountAmount;
            textView.setText(ui1.H() + format);
            TextView textView2 = scanPayPaymentActivity._finalFare;
            textView2.setText(ui1.H() + format2);
            TextView textView3 = scanPayPaymentActivity._payBtn;
            StringBuilder i02 = hj1.i0("PAY ");
            i02.append(ui1.H());
            i02.append(format2);
            textView3.setText(i02.toString());
            TextView textView4 = scanPayPaymentActivity._payBtn;
            if (i3 > 0) {
                i2 = 0;
            }
            textView4.setVisibility(i2);
        }
    }
}
