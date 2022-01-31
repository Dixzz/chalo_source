package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

public class FareBreakdown implements Parcelable {
    public static final Parcelable.Creator<FareBreakdown> CREATOR = new Parcelable.Creator<FareBreakdown>() {
        /* class app.zophop.models.mTicketing.FareBreakdown.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public FareBreakdown createFromParcel(Parcel parcel) {
            return new FareBreakdown(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FareBreakdown[] newArray(int i) {
            return new FareBreakdown[i];
        }
    };
    private double _amount;
    private String _displayName;
    private String _type;

    public FareBreakdown(Parcel parcel) {
        this._displayName = parcel.readString();
        this._amount = parcel.readDouble();
        this._type = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public double get_amount() {
        return this._amount;
    }

    public String get_displayName() {
        return this._displayName;
    }

    public String get_type() {
        return this._type;
    }

    public void set_amount(double d) {
        this._amount = d;
    }

    public void set_displayName(String str) {
        this._displayName = str;
    }

    public void set_type(String str) {
        this._type = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._displayName);
        parcel.writeDouble(this._amount);
        parcel.writeString(this._type);
    }

    public FareBreakdown(String str, double d, String str2) {
        this._displayName = str;
        this._amount = d;
        this._type = str2;
    }
}
