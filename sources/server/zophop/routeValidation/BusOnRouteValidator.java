package server.zophop.routeValidation;

import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;

public class BusOnRouteValidator implements IValidator {
    private DataContainer _dataContainer;
    public RouteValidationUtils routeValidationUtils;

    public BusOnRouteValidator(DataContainer dataContainer) {
        this.routeValidationUtils = new RouteValidationUtils(dataContainer);
        this._dataContainer = dataContainer;
    }

    @Override // server.zophop.routeValidation.IValidator
    public boolean validate(VehicleGPSInfo vehicleGPSInfo, VehicleCheckinInfo vehicleCheckinInfo, Route route, Point point) {
        String stationType = route.getStationType();
        String city = vehicleGPSInfo.getCity();
        int closestStopIndex = this.routeValidationUtils.getClosestStopIndex(vehicleGPSInfo.getLastPoint(), route, city, stationType);
        return this.routeValidationUtils.getDistance(vehicleGPSInfo.getLastPoint(), this._dataContainer.getStop(city, stationType, route.getStopSequence().get(closestStopIndex))) <= this.routeValidationUtils.getMaxDistance(closestStopIndex, route, city, stationType) && !this.routeValidationUtils.checkIfBusInDepot(vehicleGPSInfo.getLastPoint(), city);
    }
}
