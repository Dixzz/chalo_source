package server.zophop.routeValidation;

import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stop;
import server.zophop.utils.DistanceUtils;

public class RouteDirectionValidator implements IValidator {
    private static final long CURRENT_STOP_THRESHOLD_DISTANCE = 100;
    private static final long CURRENT_STOP_THRESHOLD_DISTANCE_END_POINTS = 150;
    private static final long INTERCITY_CURRENT_STOP_THRESHOLD_DISTANCE = 10000;
    private static final int MAX_REVERSAL_COUNT = 3;
    private static final int MAX_REVERSAL_COUNT_END_POINTS = 1;
    private DataContainer _dataContainer;

    public enum INTERCITY {
        UTTARPRADESH
    }

    public RouteDirectionValidator(DataContainer dataContainer) {
        this._dataContainer = dataContainer;
    }

    private Stop getCurrentStopId(Point point, Route route, String str) {
        Stop stop = null;
        int i = 0;
        for (String str2 : route.getStopSequence()) {
            Stop stop2 = this._dataContainer.getStop(str, route.getStationType(), str2);
            if (isAtStop(route, i, DistanceUtils.straightDistance(stop2.getLat(), stop2.getLon(), point.getLatitude(), point.getLongitude()), str)) {
                stop = stop2;
            }
            i++;
        }
        return stop;
    }

    private boolean isAtStop(Route route, int i, double d, String str) {
        if (isCityIntercity(str)) {
            if (d <= 10000.0d || (isNearLastStop(route, i) && d <= 150.0d)) {
                return true;
            }
            return false;
        } else if (d <= 100.0d || (isNearLastStop(route, i) && d <= 150.0d)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isCityIntercity(String str) {
        return str.toLowerCase().equals(INTERCITY.UTTARPRADESH.toString().toLowerCase());
    }

    private boolean isNearLastStop(Route route, int i) {
        int size = route.getStopSequence().size() - 1;
        return i == size || i == size + -1;
    }

    private boolean isTerminalStop(int i, Route route) {
        return i == 0 || i == route.getStopSequence().size() - 1;
    }

    private boolean isTerminalStopForFerry(int i, Route route, String str) {
        boolean z = i == route.getStopSequence().size() - 1;
        boolean equalsIgnoreCase = route.getStationType().equalsIgnoreCase("ferry");
        if (!z || !equalsIgnoreCase) {
            return false;
        }
        return true;
    }

    private boolean shouldReverse(Route route, int i, int i2) {
        if (i2 >= 3) {
            return true;
        }
        return i2 >= 1 && isNearLastStop(route, i);
    }

    private boolean validatedReversingStops(int i, int i2, Route route, String str, String str2) {
        if (isTerminalStop(i, route) || isTerminalStop(i2, route)) {
            return true;
        }
        Stop stop = this._dataContainer.getStop(str, str2, route.getStopSequence().get(i));
        Stop stop2 = this._dataContainer.getStop(str, str2, route.getStopSequence().get(i2));
        Stop stop3 = this._dataContainer.getStop(str, str2, route.getStopSequence().get(i + 1));
        if (DistanceUtils.straightDistance(stop3.getLat(), stop3.getLon(), stop2.getLat(), stop2.getLon()) > DistanceUtils.straightDistance(stop3.getLat(), stop3.getLon(), stop.getLat(), stop.getLon())) {
            return true;
        }
        return false;
    }

    @Override // server.zophop.routeValidation.IValidator
    public boolean validate(VehicleGPSInfo vehicleGPSInfo, VehicleCheckinInfo vehicleCheckinInfo, Route route, Point point) {
        String city = vehicleGPSInfo.getCity();
        Stop currentStopId = getCurrentStopId(point, route, city);
        if (currentStopId == null) {
            StringBuilder i0 = hj1.i0("nearest stop null, doing nothing for bus number ");
            i0.append(vehicleGPSInfo.getVehicleId());
            SimpleLogger.info(i0.toString());
            return true;
        }
        String lastVisitedStopId = vehicleGPSInfo.getLastVisitedStopId();
        if (lastVisitedStopId == null || !route.getStopSequence().contains(lastVisitedStopId)) {
            StringBuilder i02 = hj1.i0("updating last visited stop Id = ");
            i02.append(currentStopId.getId());
            i02.append(" ");
            i02.append(currentStopId.getName());
            i02.append(" for bus number ");
            i02.append(vehicleGPSInfo.getVehicleId());
            SimpleLogger.info(i02.toString());
            vehicleGPSInfo.setLastVisitedStopId(currentStopId.getId());
            vehicleGPSInfo.setLastVisitedStopName(currentStopId.getName());
            return true;
        }
        int intValue = route.getIndex(currentStopId.getId()).intValue();
        int intValue2 = route.getIndex(lastVisitedStopId).intValue();
        if (intValue == intValue2 && !isTerminalStopForFerry(intValue, route, city)) {
            StringBuilder i03 = hj1.i0("still at same stop, do nothing or bus number = ");
            i03.append(vehicleGPSInfo.getVehicleId());
            SimpleLogger.info(i03.toString());
            return true;
        } else if (intValue > intValue2 && !isTerminalStopForFerry(intValue, route, city)) {
            StringBuilder i04 = hj1.i0("updating last visited stop Id = ");
            i04.append(currentStopId.getId());
            i04.append(" ");
            i04.append(currentStopId.getName());
            i04.append(" for bus number ");
            i04.append(vehicleGPSInfo.getVehicleId());
            SimpleLogger.info(i04.toString());
            vehicleGPSInfo.setReversalCount(0);
            vehicleGPSInfo.setLastVisitedStopId(currentStopId.getId());
            vehicleGPSInfo.setLastVisitedStopName(currentStopId.getName());
            return true;
        } else if (city.equalsIgnoreCase("kochi") && !validatedReversingStops(intValue2, intValue, route, city, vehicleCheckinInfo.getMode())) {
            return true;
        } else {
            vehicleGPSInfo.setReversalCount(vehicleGPSInfo.getReversalCount() + 1);
            if (shouldReverse(route, intValue2, vehicleGPSInfo.getReversalCount())) {
                StringBuilder i05 = hj1.i0("Reverse direction detected for bus number ");
                i05.append(vehicleGPSInfo.getVehicleId());
                SimpleLogger.info(i05.toString());
                vehicleGPSInfo.setReversalCount(0);
                vehicleGPSInfo.setLastVisitedStopId(null);
                return false;
            }
            StringBuilder i06 = hj1.i0("updating reversal count  = ");
            i06.append(vehicleGPSInfo.getReversalCount());
            i06.append(" for bus number ");
            i06.append(vehicleGPSInfo.getVehicleId());
            SimpleLogger.info(i06.toString());
            return true;
        }
    }
}
