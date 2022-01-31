package server.zophop.models;

import server.zophop.gpsIntegration.models.VehicleGPSInfo;

public interface IHaltValidation {
    HaltState validate(VehicleGPSInfo vehicleGPSInfo, Point point);
}
