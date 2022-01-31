package com.razorpay;

import java.util.Timer;

/* compiled from: RazorpayUtils */
public final class B$$J$ implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PaymentCompleteInternalCallback f667a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public B$$J$(PaymentCompleteInternalCallback paymentCompleteInternalCallback, int i, String str, String str2) {
        this.f667a = paymentCompleteInternalCallback;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    @Override // com.razorpay.Callback
    public final void run(ResponseObject responseObject) {
        String responseResult = responseObject.getResponseResult();
        if ((responseResult != null && responseResult.contains(BaseRazorpay.RAZORPAY_PAYMENT_ID)) || responseResult.contains("error")) {
            this.f667a.oncomplete(responseObject.getResponseResult());
        } else if (this.b < 12) {
            new Timer().schedule(new H$_a_(this), 500);
        } else {
            this.f667a.oncomplete(responseResult);
        }
    }
}
