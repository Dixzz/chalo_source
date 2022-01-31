package app.zophop.models;

public class AutoCabInfo {
    private final String _currencyType;
    private final int _distance;
    private final int _eta;
    private final String _id;
    private final int _lowerFareAmount;
    private final int _maxJourneyTime;
    private final int _minJourneyTime;
    private final String _name;
    private final int _upperFareAmount;

    public AutoCabInfo(String str, int i, int i2, int i3, String str2, int i4, int i5, int i6, String str3) {
        this._name = str;
        this._eta = i;
        this._minJourneyTime = i2;
        this._maxJourneyTime = i3;
        this._currencyType = str2;
        this._lowerFareAmount = i4;
        this._upperFareAmount = i5;
        this._distance = i6;
        this._id = str3;
    }

    public String getCurrencyType() {
        return this._currencyType;
    }

    public int getDistance() {
        return this._distance;
    }

    public int getEta() {
        return this._eta;
    }

    public String getId() {
        return this._id;
    }

    public int getLowerFareAmount() {
        return this._lowerFareAmount;
    }

    public int getMaxJourneyTime() {
        return this._maxJourneyTime;
    }

    public int getMinJourneyTime() {
        return this._minJourneyTime;
    }

    public String getName() {
        return this._name;
    }

    public int getUpperFareAmount() {
        return this._upperFareAmount;
    }
}
