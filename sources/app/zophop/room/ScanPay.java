package app.zophop.room;

import app.zophop.models.ScanPayTicket;

public class ScanPay {
    public String bookingId;
    public ScanPayTicket scanPayTicket;

    public String getBookingId() {
        return this.bookingId;
    }

    public ScanPayTicket getScanPayTicket() {
        return this.scanPayTicket;
    }

    public void setBookingId(String str) {
        this.bookingId = str;
    }

    public void setScanPayTicket(ScanPayTicket scanPayTicket2) {
        this.scanPayTicket = scanPayTicket2;
    }
}
