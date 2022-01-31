package app.zophop.features;

import app.zophop.pubsub.eventbus.events.RazorpayPaymentFetchEvent;
import com.razorpay.PaymentMethodsCallback;

public class RazorpayFeature$1 implements PaymentMethodsCallback {
    @Override // com.razorpay.PaymentMethodsCallback
    public void onError(String str) {
        RazorpayPaymentFetchEvent razorpayPaymentFetchEvent = new RazorpayPaymentFetchEvent();
        razorpayPaymentFetchEvent.setResponse(ad1.FAILED);
        razorpayPaymentFetchEvent.setPaymentMethods(str);
        jz5.b().i(razorpayPaymentFetchEvent);
    }

    @Override // com.razorpay.PaymentMethodsCallback
    public void onPaymentMethodsReceived(String str) {
        RazorpayPaymentFetchEvent razorpayPaymentFetchEvent = new RazorpayPaymentFetchEvent();
        razorpayPaymentFetchEvent.setResponse(ad1.SUCCESS);
        razorpayPaymentFetchEvent.setPaymentMethods(str);
        jz5.b().i(razorpayPaymentFetchEvent);
    }
}
