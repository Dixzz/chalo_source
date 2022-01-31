package app.zophop.pubsub.eventbus.events;

public class LpInitiatePayResponseEvent {
    private ad1 _responseType;
    public String checkoutUrl;
    public String lpTd;

    public LpInitiatePayResponseEvent(String str, String str2) {
        this.checkoutUrl = str;
        this.lpTd = str2;
    }

    public String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public String getLpTd() {
        return this.lpTd;
    }

    public ad1 get_responseType() {
        return this._responseType;
    }

    public void set_responseType(ad1 ad1) {
        this._responseType = ad1;
    }

    public LpInitiatePayResponseEvent() {
    }
}
