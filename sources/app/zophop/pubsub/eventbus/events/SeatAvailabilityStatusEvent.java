package app.zophop.pubsub.eventbus.events;

import app.zophop.models.SeatInfo;
import java.util.List;

public class SeatAvailabilityStatusEvent {
    public String error;
    public String paymentMethods;
    public ad1 responseType;
    public List<SeatInfo> seatInfoList;

    public String getError() {
        return this.error;
    }

    public String getPaymentMethods() {
        return this.paymentMethods;
    }

    public ad1 getResponseType() {
        return this.responseType;
    }

    public List<SeatInfo> getSeatInfoList() {
        return this.seatInfoList;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setPaymentMethods(String str) {
        this.paymentMethods = str;
    }

    public void setResponseType(ad1 ad1) {
        this.responseType = ad1;
    }

    public void setSeatInfoList(List<SeatInfo> list) {
        this.seatInfoList = list;
    }
}
