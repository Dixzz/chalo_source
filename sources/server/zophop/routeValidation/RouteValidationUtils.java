package server.zophop.routeValidation;

import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.Stop;
import server.zophop.utils.DistanceUtils;
import server.zophop.utils.RouteDeviationUtils;

public class RouteValidationUtils {
    public static final long MIN_THRESHOLD = 300;
    public static final long MIN_THRESHOLD_FIRST_STOP = 1200;
    public static final long MIN_THRESHOLD_LAST_STOP = 1200;
    private DataContainer _dataContainer;

    public RouteValidationUtils(DataContainer dataContainer) {
        this._dataContainer = dataContainer;
    }

    public boolean checkIfBusInDepot(Point point, String str) {
        return RouteDeviationUtils.checkIfBusInDepot(str, point.getLatitude(), point.getLongitude());
    }

    public int getClosestStopIndex(Point point, Route route, String str, String str2) {
        double d = 9.223372036854776E18d;
        int i = 0;
        for (int i2 = 0; i2 < route.getStopSequence().size(); i2++) {
            double distance = getDistance(point, this._dataContainer.getStop(str, str2, route.getStopSequence().get(i2)));
            if (distance < d) {
                i = i2;
                d = distance;
            }
        }
        return i;
    }

    public double getDistance(Point point, Stop stop) {
        return DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop.getLat(), stop.getLon());
    }

    public double getMaxDistance(int i, Route route, String str, String str2) {
        if (i == 0) {
            return Math.max(getDistance(i, i + 1, route, str, str2), 1200.0d);
        }
        if (i == route.getStopSequence().size() - 1) {
            return Math.max(getDistance(i, i - 1, route, str, str2), 1200.0d);
        }
        return Math.max(Math.max(getDistance(i, i + 1, route, str, str2), getDistance(i, i - 1, route, str, str2)), 300.0d);
    }

    public double getDistance(int i, int i2, Route route, String str, String str2) {
        Stop stop = this._dataContainer.getStop(str, str2, route.getStopSequence().get(i));
        Stop stop2 = this._dataContainer.getStop(str, str2, route.getStopSequence().get(i2));
        return DistanceUtils.straightDistance(stop.getLat(), stop.getLon(), stop2.getLat(), stop2.getLon());
    }
}
