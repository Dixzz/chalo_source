package defpackage;

import android.view.View;
import app.zophop.scanPay.ScanPayPaymentActivity;

/* renamed from: s80  reason: default package */
/* compiled from: ScanPayPaymentActivity */
public class s80 implements View.OnClickListener {
    public final /* synthetic */ ScanPayPaymentActivity f;

    public s80(ScanPayPaymentActivity scanPayPaymentActivity) {
        this.f = scanPayPaymentActivity;
    }

    public void onClick(View view) {
        ScanPayPaymentActivity scanPayPaymentActivity = this.f;
        int i = ScanPayPaymentActivity.s;
        scanPayPaymentActivity.j0("scan pay terms clicked", null);
        mn0.a(this.f.getFragmentManager(), "-1");
    }
}
