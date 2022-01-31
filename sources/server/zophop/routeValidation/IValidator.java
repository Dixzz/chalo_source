package server.zophop.routeValidation;

import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.models.Point;
import server.zophop.models.Route;

public interface IValidator {
    boolean validate(VehicleGPSInfo vehicleGPSInfo, VehicleCheckinInfo vehicleCheckinInfo, Route route, Point point);
}
