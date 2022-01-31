package app.zophop.models.autoCabBooking;

public class BookingVehicleInfo {
    private final String _carModel;
    private final String _carNumberPlate;
    private final String _driverName;
    private final String _driverNumber;
    private final double _driverRating;
    private final String _imageUrl;

    public BookingVehicleInfo(String str, String str2, double d, String str3, String str4, String str5) {
        this._driverName = str;
        this._driverNumber = str2;
        this._driverRating = d;
        this._carModel = str4;
        this._carNumberPlate = str3;
        this._imageUrl = str5;
    }

    public String getCarModel() {
        return this._carModel;
    }

    public String getCarNumberPlate() {
        return this._carNumberPlate;
    }

    public String getDriverName() {
        return this._driverName;
    }

    public String getDriverNumber() {
        return this._driverNumber;
    }

    public double getDriverRating() {
        return this._driverRating;
    }

    public String getImageUrl() {
        return this._imageUrl;
    }
}
