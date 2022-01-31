package app.zophop.pubsub.eventbus.events;

import android.os.Parcel;
import android.os.Parcelable;

public class RazorPayOrderData implements Parcelable {
    public static final Parcelable.Creator<RazorPayOrderData> CREATOR = new Parcelable.Creator<RazorPayOrderData>() {
        /* class app.zophop.pubsub.eventbus.events.RazorPayOrderData.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public RazorPayOrderData createFromParcel(Parcel parcel) {
            return new RazorPayOrderData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RazorPayOrderData[] newArray(int i) {
            return new RazorPayOrderData[i];
        }
    };
    private final double _amount;
    private long _amountInPaisa;
    private final String _merchantKey;
    private final String _orderId;
    private String _receiptId;
    private final String _transactionId;

    public RazorPayOrderData(double d, String str, String str2, long j, String str3) {
        this._merchantKey = str3;
        this._amount = d;
        this._orderId = str;
        this._transactionId = str2;
    }

    public int describeContents() {
        return 0;
    }

    public long getAmountInPaisa() {
        return this._amountInPaisa;
    }

    public String getMerchantKey() {
        return this._merchantKey;
    }

    public double get_amount() {
        return this._amount;
    }

    public String get_orderId() {
        return this._orderId;
    }

    public String get_receiptId() {
        return this._receiptId;
    }

    public String get_transactionId() {
        return this._transactionId;
    }

    public void setAmountInPaisa(long j) {
        this._amountInPaisa = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this._amount);
        parcel.writeString(this._orderId);
        parcel.writeString(this._receiptId);
        parcel.writeString(this._transactionId);
        parcel.writeString(this._merchantKey);
    }

    public RazorPayOrderData(Parcel parcel) {
        this._amount = parcel.readDouble();
        this._orderId = parcel.readString();
        this._receiptId = parcel.readString();
        this._transactionId = parcel.readString();
        this._merchantKey = parcel.readString();
    }
}
