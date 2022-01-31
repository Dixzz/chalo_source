package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;

public class ScanPayTicket implements Parcelable {
    public static final Parcelable.Creator<ScanPayTicket> CREATOR = new Parcelable.Creator<ScanPayTicket>() {
        /* class app.zophop.models.ScanPayTicket.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ScanPayTicket createFromParcel(Parcel parcel) {
            return new ScanPayTicket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScanPayTicket[] newArray(int i) {
            return new ScanPayTicket[i];
        }
    };
    public String _agencyName;
    public ScanPayBookingDetails _bookingDetails;
    private long _bookingTime;
    private List<CardDetails> _cardDetails;
    private String _cityName;
    private String _customerId;
    public String _deviceId;
    public double _discountedFare;
    private long _expirationTime;
    public double _fare;
    private boolean _isExpired;
    private String _orderId;
    private String _qrCode;
    private List<RecentPaymentMethod> _recentPaymentMethod;
    private String _status;
    private String _tone;
    public String _transactionId;
    public String _userId;
    public String _uuid;

    public ScanPayTicket(String str, double d, double d2, String str2, String str3, ScanPayBookingDetails scanPayBookingDetails, String str4) {
        this._uuid = str;
        this._fare = d;
        this._discountedFare = d2;
        this._userId = str2;
        this._deviceId = str3;
        this._bookingDetails = scanPayBookingDetails;
        this._agencyName = str4;
    }

    public int describeContents() {
        return 0;
    }

    public String get_agencyName() {
        return this._agencyName;
    }

    public ScanPayBookingDetails get_bookingDetails() {
        return this._bookingDetails;
    }

    public long get_bookingTime() {
        return this._bookingTime;
    }

    public List<CardDetails> get_cardDetails() {
        return this._cardDetails;
    }

    public String get_cityName() {
        return this._cityName;
    }

    public String get_customerId() {
        return this._customerId;
    }

    public String get_deviceId() {
        return this._deviceId;
    }

    public double get_discountedFare() {
        return this._discountedFare;
    }

    public long get_expirationTime() {
        return this._expirationTime;
    }

    public double get_fare() {
        return this._fare;
    }

    public String get_orderId() {
        return this._orderId;
    }

    public String get_qrCode() {
        return this._qrCode;
    }

    public List<RecentPaymentMethod> get_recentPaymentMethod() {
        return this._recentPaymentMethod;
    }

    public String get_status() {
        return this._status;
    }

    public String get_tone() {
        if (AnalyticsConstants.NULL.equalsIgnoreCase(this._tone)) {
            return null;
        }
        return this._tone;
    }

    public String get_transactionId() {
        return this._transactionId;
    }

    public String get_userId() {
        return this._userId;
    }

    public String get_uuid() {
        return this._uuid;
    }

    public boolean isScanPayTicketExpired() {
        if (!this._isExpired && get_expirationTime() >= ui1.Q() && !xt.f3961a.c().Z(this._transactionId) && get_bookingTime() + 7200000 >= ui1.Q()) {
            return false;
        }
        return true;
    }

    public boolean is_isExpired() {
        return this._isExpired;
    }

    public void set_agencyName(String str) {
        this._agencyName = str;
    }

    public void set_bookingDetails(ScanPayBookingDetails scanPayBookingDetails) {
        this._bookingDetails = scanPayBookingDetails;
    }

    public void set_bookingTime(long j) {
        this._bookingTime = j;
    }

    public void set_cardDetails(List<CardDetails> list) {
        this._cardDetails = list;
    }

    public void set_cityName(String str) {
        this._cityName = str;
    }

    public void set_customerId(String str) {
        this._customerId = str;
    }

    public void set_deviceId(String str) {
        this._deviceId = str;
    }

    public void set_discountedFare(double d) {
        this._discountedFare = d;
    }

    public void set_expirationTime(long j) {
        this._expirationTime = j;
    }

    public void set_fare(double d) {
        this._fare = d;
    }

    public void set_isExpired(boolean z) {
        this._isExpired = z;
    }

    public void set_orderId(String str) {
        this._orderId = str;
    }

    public void set_qrCode(String str) {
        this._qrCode = str;
    }

    public void set_recentPaymentMethod(List<RecentPaymentMethod> list) {
        this._recentPaymentMethod = list;
    }

    public void set_status(String str) {
        this._status = str;
    }

    public void set_tone(String str) {
        this._tone = str;
    }

    public void set_transactionId(String str) {
        this._transactionId = str;
    }

    public void set_userId(String str) {
        this._userId = str;
    }

    public void set_uuid(String str) {
        this._uuid = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._uuid);
        parcel.writeDouble(this._fare);
        parcel.writeDouble(this._discountedFare);
        parcel.writeString(this._userId);
        parcel.writeString(this._deviceId);
        parcel.writeString(this._agencyName);
        parcel.writeValue(this._bookingDetails);
        parcel.writeString(this._transactionId);
        parcel.writeLong(this._bookingTime);
        parcel.writeLong(this._expirationTime);
        if (this._recentPaymentMethod == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._recentPaymentMethod);
        }
        if (this._cardDetails == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._cardDetails);
        }
        parcel.writeString(this._customerId);
        parcel.writeString(this._orderId);
        parcel.writeString(this._status);
        parcel.writeString(this._qrCode);
        parcel.writeString(this._tone);
    }

    public ScanPayTicket(Parcel parcel) {
        this._uuid = parcel.readString();
        this._fare = parcel.readDouble();
        this._discountedFare = parcel.readDouble();
        this._userId = parcel.readString();
        this._deviceId = parcel.readString();
        this._agencyName = parcel.readString();
        this._bookingDetails = (ScanPayBookingDetails) parcel.readValue(ScanPayBookingDetails.class.getClassLoader());
        this._transactionId = parcel.readString();
        this._bookingTime = parcel.readLong();
        this._expirationTime = parcel.readLong();
        if (parcel.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this._recentPaymentMethod = arrayList;
            parcel.readList(arrayList, RecentPaymentMethod.class.getClassLoader());
        } else {
            this._recentPaymentMethod = null;
        }
        if (parcel.readByte() == 1) {
            ArrayList arrayList2 = new ArrayList();
            this._cardDetails = arrayList2;
            parcel.readList(arrayList2, CardDetails.class.getClassLoader());
        } else {
            this._cardDetails = null;
        }
        this._customerId = parcel.readString();
        this._orderId = parcel.readString();
        this._status = parcel.readString();
        this._qrCode = parcel.readString();
        this._tone = parcel.readString();
    }
}
