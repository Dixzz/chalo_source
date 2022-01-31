package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.util.Map;

public class MTicketPassengerInfo implements Parcelable {
    public static final Parcelable.Creator<MTicketPassengerInfo> CREATOR = new Parcelable.Creator<MTicketPassengerInfo>() {
        /* class app.zophop.models.mTicketing.MTicketPassengerInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MTicketPassengerInfo createFromParcel(Parcel parcel) {
            return new MTicketPassengerInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MTicketPassengerInfo[] newArray(int i) {
            return new MTicketPassengerInfo[i];
        }
    };
    public static final int ROUNDING_LOGIC_NO_ROUNDING = 0;
    public static final int ROUNDING_LOGIC_ROUND_TO_CEILING = 2;
    public static final int ROUNDING_LOGIC_ROUND_TO_FLOOR = 1;
    public static final int ROUNDING_LOGIC_ROUND_TO_NEAREST_INT = 3;
    private Map<String, Double> _addMap;
    private double _discountPercentage;
    private double _fare;
    private int _passengerCount;
    private int _roundingLogic = 0;
    private Map<String, Double> _subMap;
    private double _totalFare;

    public MTicketPassengerInfo(double d, double d2, int i, int i2) {
        this._fare = d;
        this._discountPercentage = d2;
        this._passengerCount = i;
        this._roundingLogic = i2;
    }

    public static MTicketPassengerInfo fromString(String str) {
        if (str == null) {
            return null;
        }
        return (MTicketPassengerInfo) hj1.s(str, MTicketPassengerInfo.class);
    }

    public static String toString(MTicketPassengerInfo mTicketPassengerInfo) {
        if (mTicketPassengerInfo == null) {
            return null;
        }
        return new Gson().toJson(mTicketPassengerInfo);
    }

    public void decrementPassengerCount() {
        int i = this._passengerCount;
        if (i > 0) {
            this._passengerCount = i - 1;
        }
    }

    public int describeContents() {
        return 0;
    }

    public double getDiscountFare() {
        return getFare() * ((100.0d - getDiscountPercentage()) / 100.0d);
    }

    public double getDiscountPercentage() {
        return this._discountPercentage;
    }

    public double getFare() {
        return this._fare;
    }

    public double getIndividualTotalFareInPaisa() {
        return (double) (getTotalFareInPaisa() * ((long) getPassengerCount()));
    }

    public double getInvidualTotalFare() {
        return get_totalFare() * ((double) getPassengerCount());
    }

    public int getPassengerCount() {
        return this._passengerCount;
    }

    public int getRoundingLogic() {
        return this._roundingLogic;
    }

    public double getTotalFare() {
        return getDiscountFare() * ((double) getPassengerCount());
    }

    public long getTotalFareInPaisa() {
        return (long) ((new Double(this._totalFare).isNaN() ? getDiscountFare() : this._totalFare) * 100.0d);
    }

    public double getTotalFareWithoutDiscount() {
        return getFare() * ((double) getPassengerCount());
    }

    public Map<String, Double> get_addMap() {
        return this._addMap;
    }

    public Map<String, Double> get_subMap() {
        return this._subMap;
    }

    public double get_totalFare() {
        return new Double(this._totalFare).isNaN() ? getDiscountFare() : this._totalFare;
    }

    public void incrementPassengerCount() {
        this._passengerCount++;
    }

    public void setDiscountPercentage(double d) {
        this._discountPercentage = d;
    }

    public void setFare(double d) {
        this._fare = d;
    }

    public void setPassengerCount(int i) {
        this._passengerCount = i;
    }

    public void setRoundingLogic(int i) {
        this._roundingLogic = i;
    }

    public void set_addMap(Map<String, Double> map) {
        this._addMap = map;
    }

    public void set_subMap(Map<String, Double> map) {
        this._subMap = map;
    }

    public void set_totalFare(double d) {
        this._totalFare = d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this._fare);
        parcel.writeInt(this._passengerCount);
        parcel.writeDouble(this._discountPercentage);
        parcel.writeDouble(this._totalFare);
        parcel.writeMap(this._addMap);
        parcel.writeMap(this._subMap);
    }

    public MTicketPassengerInfo(Parcel parcel) {
        this._fare = parcel.readDouble();
        this._passengerCount = parcel.readInt();
        this._discountPercentage = parcel.readDouble();
        this._totalFare = parcel.readDouble();
        this._addMap = parcel.readHashMap(getClass().getClassLoader());
        this._subMap = parcel.readHashMap(getClass().getClassLoader());
    }
}
