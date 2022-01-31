package app.zophop.pubsub.eventbus.events;

public class RazorpayPaymentFetchEvent {
    public String paymentMethods;
    public ad1 responseType;

    public String getPaymentMethods() {
        return this.paymentMethods;
    }

    public ad1 getResponseType() {
        return this.responseType;
    }

    public void setPaymentMethods(String str) {
        this.paymentMethods = str;
    }

    public void setResponse(ad1 ad1) {
        this.responseType = ad1;
    }
}
