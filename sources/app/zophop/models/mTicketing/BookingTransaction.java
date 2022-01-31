package app.zophop.models.mTicketing;

import app.zophop.models.ScanPayTicket;

public class BookingTransaction {
    private BookingPass _bookingPass;
    private GroupTicket _groupTicket;
    private boolean _isLpEligible;
    private String _lpId;
    private MPass _mPass;
    private MTicket _mTicket;
    private ProfileRequestInfo _requestInfo;
    private ScanPayTicket _scanPayTicket;
    private double _totalFare;
    private String _transactionId;

    public BookingPass getBookingPass() {
        return this._bookingPass;
    }

    public GroupTicket getGroupTicket() {
        return this._groupTicket;
    }

    public String getLpId() {
        return this._lpId;
    }

    public MTicket getMTicket() {
        return this._mTicket;
    }

    public MPass getMagicPass() {
        return this._mPass;
    }

    public ProfileRequestInfo getRequestInfo() {
        return this._requestInfo;
    }

    public double getTotalFare() {
        return this._totalFare;
    }

    public String getTransactionId() {
        return this._transactionId;
    }

    public ScanPayTicket get_scanPayTicket() {
        return this._scanPayTicket;
    }

    public boolean isLpEligible() {
        return this._isLpEligible;
    }

    public void setBookingPass(BookingPass bookingPass) {
        this._bookingPass = bookingPass;
    }

    public void setGroupTicket(GroupTicket groupTicket) {
        this._groupTicket = groupTicket;
    }

    public void setIsLpEligible(boolean z) {
        this._isLpEligible = z;
    }

    public void setLpId(String str) {
        this._lpId = str;
    }

    public void setMTicket(MTicket mTicket) {
        this._mTicket = mTicket;
    }

    public void setMagicPass(MPass mPass) {
        this._mPass = mPass;
    }

    public void setRequestInfo(ProfileRequestInfo profileRequestInfo) {
        this._requestInfo = profileRequestInfo;
    }

    public void setScanPayTicket(ScanPayTicket scanPayTicket) {
        this._scanPayTicket = scanPayTicket;
    }

    public void setTotalFare(double d) {
        this._totalFare = d;
    }

    public void setTransactionId(String str) {
        this._transactionId = str;
    }
}
