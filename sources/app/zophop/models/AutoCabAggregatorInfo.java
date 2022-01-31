package app.zophop.models;

import java.util.List;

public class AutoCabAggregatorInfo {
    private final String _aggregatorName;
    private final List<AutoCabInfo> _autoCabs;
    private final VehicleType _vehicleType;

    public AutoCabAggregatorInfo(String str, VehicleType vehicleType, List<AutoCabInfo> list) {
        this._aggregatorName = str;
        this._vehicleType = vehicleType;
        this._autoCabs = list;
    }

    public String getAggregatorName() {
        return this._aggregatorName;
    }

    public List<AutoCabInfo> getAutoCabs() {
        return this._autoCabs;
    }

    public VehicleType getVehicleType() {
        return this._vehicleType;
    }
}
