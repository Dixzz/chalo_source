package app.zophop.models.mTicketing;

import android.graphics.Bitmap;

public class ProofImageInfo {
    private final String _agency;
    private final Bitmap _bitmap;
    private final String _city;
    private final String _imageName;
    private final String _passengerType;

    public ProofImageInfo(String str, String str2, String str3, String str4, Bitmap bitmap) {
        this._agency = str;
        this._city = str2;
        this._passengerType = str4;
        this._bitmap = bitmap;
        this._imageName = str3;
    }

    public String getAgency() {
        return this._agency;
    }

    public Bitmap getBitmap() {
        return this._bitmap;
    }

    public String getCity() {
        return this._city;
    }

    public String getImageName() {
        return this._imageName;
    }

    public String getPassengerType() {
        return this._passengerType;
    }
}
