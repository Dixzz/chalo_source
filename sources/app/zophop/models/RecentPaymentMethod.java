package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;

public class RecentPaymentMethod implements Parcelable {
    public static final Parcelable.Creator<RecentPaymentMethod> CREATOR = new Parcelable.Creator<RecentPaymentMethod>() {
        /* class app.zophop.models.RecentPaymentMethod.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public RecentPaymentMethod createFromParcel(Parcel parcel) {
            return new RecentPaymentMethod(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RecentPaymentMethod[] newArray(int i) {
            return new RecentPaymentMethod[i];
        }
    };
    private String _paymentAppName;
    private String _paymentDetails;
    private String _paymentMethod;

    public RecentPaymentMethod(Parcel parcel) {
        this._paymentMethod = parcel.readString();
        this._paymentDetails = parcel.readString();
        this._paymentAppName = parcel.readString();
    }

    public static RecentPaymentMethod fromString(String str) {
        if (str == null) {
            return null;
        }
        return (RecentPaymentMethod) hj1.s(str, RecentPaymentMethod.class);
    }

    public static String toString(RecentPaymentMethod recentPaymentMethod) {
        if (recentPaymentMethod == null) {
            return null;
        }
        return new Gson().toJson(recentPaymentMethod);
    }

    public int describeContents() {
        return 0;
    }

    public String getPaymentAppName() {
        return this._paymentAppName;
    }

    public String getPaymentDetails() {
        return this._paymentDetails;
    }

    public String getPaymentMethod() {
        return this._paymentMethod;
    }

    public void setPaymentAppName(String str) {
        this._paymentAppName = str;
    }

    public void setPaymentDetails(String str) {
        this._paymentDetails = str;
    }

    public void setPaymentMethod(String str) {
        this._paymentMethod = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._paymentMethod);
        parcel.writeString(this._paymentDetails);
        parcel.writeString(this._paymentAppName);
    }

    public RecentPaymentMethod() {
    }
}
