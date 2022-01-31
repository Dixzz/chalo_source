package server.zophop.routeValidation;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.model.LatLng;
import java.io.PrintStream;
import java.util.List;
import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.utils.DistanceUtils;

public class RoutePolylineDirectionValidator implements IValidator {
    private static final long CURRENT_POLYLINE_THRESHOLD_DISTANCE = 75;
    private static final long CURRENT_POLYLINE_THRESHOLD_DISTANCE_END_POINTS = 150;
    private static final int MAX_REVERSAL_COUNT = 3;
    private static final int MAX_REVERSAL_COUNT_END_POINTS = 2;

    private LatLng getCurrentPolylinePoint(Point point, Route route, String str) {
        List<LatLng> polylinePointSequence = route.getPolylinePointSequence();
        double straightDistance = DistanceUtils.straightDistance(polylinePointSequence.get(0).lat, polylinePointSequence.get(0).lng, point.getLatitude(), point.getLongitude());
        LatLng latLng = null;
        int i = 0;
        for (int i2 = 0; i2 < polylinePointSequence.size(); i2++) {
            double straightDistance2 = DistanceUtils.straightDistance(polylinePointSequence.get(i2).lat, polylinePointSequence.get(i2).lng, point.getLatitude(), point.getLongitude());
            if (isNearPoylinePoint(route, i, straightDistance2, str) && straightDistance2 < straightDistance) {
                latLng = polylinePointSequence.get(i2);
                straightDistance = straightDistance2;
            }
            i++;
        }
        return latLng;
    }

    private boolean isNearLastPolylinePoint(Route route, int i) {
        int size = route.getPolylinePointSequence().size() - 1;
        return i == size || i == size + -1;
    }

    private boolean isNearPoylinePoint(Route route, int i, double d, String str) {
        return d <= 75.0d || (isNearLastPolylinePoint(route, i) && d <= 150.0d);
    }

    private boolean isTerminalPolylinePoint(int i, Route route, String str) {
        boolean z = i == route.getPolylinePointSequence().size() - 1;
        boolean equalsIgnoreCase = route.getStationType().equalsIgnoreCase("ferry");
        if (!z || !equalsIgnoreCase) {
            return false;
        }
        return true;
    }

    private boolean shouldReverseByPolyline(Route route, int i, int i2) {
        if (i2 >= 3) {
            return true;
        }
        return i2 >= 2 && isNearLastPolylinePoint(route, i);
    }

    @Override // server.zophop.routeValidation.IValidator
    public boolean validate(VehicleGPSInfo vehicleGPSInfo, VehicleCheckinInfo vehicleCheckinInfo, Route route, Point point) {
        String city = vehicleGPSInfo.getCity();
        LatLng currentPolylinePoint = getCurrentPolylinePoint(point, route, city);
        int intValue = currentPolylinePoint != null ? route.getPolylinePointIndex(currentPolylinePoint).intValue() : 0;
        LatLng lastVisitedPolylinePoint = vehicleGPSInfo.getLastVisitedPolylinePoint();
        int intValue2 = !lastVisitedPolylinePoint.equals(new LatLng(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) ? route.getPolylinePointIndex(lastVisitedPolylinePoint).intValue() : 0;
        if (currentPolylinePoint == null) {
            PrintStream printStream = System.out;
            printStream.print("nerest polyline index,NOT_FOUND,previous polyline point index," + intValue2 + ",no nearest point found");
            return true;
        } else if (route.getPolylinePointSequence().contains(lastVisitedPolylinePoint)) {
            int intValue3 = route.getPolylinePointIndex(currentPolylinePoint).intValue();
            int intValue4 = route.getPolylinePointIndex(lastVisitedPolylinePoint).intValue();
            PrintStream printStream2 = System.out;
            printStream2.print("nerest polyline index," + intValue3 + ",previous polyline point index," + intValue4);
            if (intValue3 == intValue4 && !isTerminalPolylinePoint(intValue3, route, city)) {
                System.out.print(",bus is at same point");
                return true;
            } else if (intValue3 <= intValue4 || isTerminalPolylinePoint(intValue3, route, city)) {
                vehicleGPSInfo.setReversalCount(vehicleGPSInfo.getReversalCount() + 1);
                if (shouldReverseByPolyline(route, intValue4, vehicleGPSInfo.getReversalCount())) {
                    System.out.print(",route reversed");
                    vehicleGPSInfo.setReversalCount(0);
                    vehicleGPSInfo.setLastVisitedPolylineId(new LatLng((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                    return false;
                }
                PrintStream printStream3 = System.out;
                StringBuilder i0 = hj1.i0(",count increased,now count is ");
                i0.append(vehicleGPSInfo.getReversalCount());
                printStream3.print(i0.toString());
                vehicleGPSInfo.setLastVisitedPolylineId(currentPolylinePoint);
                return true;
            } else {
                System.out.print(",bus is moving  forward");
                vehicleGPSInfo.setReversalCount(0);
                vehicleGPSInfo.setLastVisitedPolylineId(currentPolylinePoint);
                return true;
            }
        } else {
            PrintStream printStream4 = System.out;
            printStream4.print("nerest polyline index," + intValue + ",previous polyline point index," + intValue + ",PREVIOUS POINT NOT FOUND");
            vehicleGPSInfo.setLastVisitedPolylineId(currentPolylinePoint);
            return true;
        }
    }
}
