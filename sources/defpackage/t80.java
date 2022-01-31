package defpackage;

import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.scanPay.ScanPayPaymentActivity;

/* renamed from: t80  reason: default package */
/* compiled from: ScanPayPaymentActivity */
public class t80 implements TextWatcher {
    public final /* synthetic */ ScanPayPaymentActivity f;

    public t80(ScanPayPaymentActivity scanPayPaymentActivity) {
        this.f = scanPayPaymentActivity;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f.m.removeMessages(1);
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("bundle:querySearch", charSequence.toString());
        message.what = 1;
        message.setData(bundle);
        if (charSequence.length() == 0) {
            this.f._payBtn.setVisibility(8);
        } else {
            this.f._payBtn.setVisibility(0);
        }
        this.f.m.sendMessageDelayed(message, 300);
    }
}
