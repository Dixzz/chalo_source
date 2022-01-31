package com.razorpay;

/* compiled from: RazorpayUtils */
public final class L$$C_ implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f679a;
    private /* synthetic */ String b;
    private /* synthetic */ PaymentCompleteInternalCallback c;

    public L$$C_(String str, String str2, PaymentCompleteInternalCallback paymentCompleteInternalCallback) {
        this.f679a = str;
        this.b = str2;
        this.c = paymentCompleteInternalCallback;
    }

    @Override // com.razorpay.Callback
    public final void run(ResponseObject responseObject) {
        b_$A$.b(this.f679a, this.b, 0, this.c);
    }
}
