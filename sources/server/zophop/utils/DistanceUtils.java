package server.zophop.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import java.util.List;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.Stop;

public class DistanceUtils {
    private static final double SPEED = 100.0d;

    public static double distance(List<Point> list) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        while (i < list.size() - 1) {
            i++;
            d += straightDistance(list.get(i).getLatitude(), list.get(i).getLongitude(), list.get(i).getLatitude(), list.get(i).getLongitude());
        }
        return d;
    }

    private static int getClosestStopIndex(Point point, Route route, String str, String str2, DataContainer dataContainer) {
        double d = 9.223372036854776E18d;
        int i = 0;
        for (int i2 = 0; i2 < route.getStopSequence().size(); i2++) {
            double distance = getDistance(point, dataContainer.getStop(str, str2, route.getStopSequence().get(i2)));
            if (distance < d) {
                i = i2;
                d = distance;
            }
        }
        return i;
    }

    private static double getDistance(Point point, Stop stop) {
        return straightDistance(point.getLatitude(), point.getLongitude(), stop.getLat(), stop.getLon());
    }

    public static double getDistanceCoveredByPoints(List<Point> list) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        while (i < list.size() - 1) {
            i++;
            d += straightDistance(list.get(i).getLatitude(), list.get(i).getLongitude(), list.get(i).getLatitude(), list.get(i).getLongitude());
        }
        return d;
    }

    public static int getDistanceToClosestStop(DataContainer dataContainer, Route route, String str, String str2, Point point) {
        return (int) getDistance(point, dataContainer.getStop(str, str2, route.getStopSequence().get(getClosestStopIndex(point, route, str, str2, dataContainer))));
    }

    public static double getFilteredDistanceCoveredByPoints(List<Point> list) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        for (int i = 0; i < list.size() - 1; i++) {
            try {
                int i2 = i + 1;
                d2 = straightDistance(list.get(i).getLatitude(), list.get(i).getLongitude(), list.get(i2).getLatitude(), list.get(i2).getLongitude());
                if ((d2 / ((double) (list.get(i2).getTime() - list.get(i).getTime()))) * 3600.0d > 100.0d) {
                }
            } catch (ArithmeticException unused) {
            }
            d += d2;
        }
        return d;
    }

    public static List<LatLng> getLatLngsFromPolyline(String str) {
        return new EncodedPolyline(str.replace("\"", "")).decodePath();
    }

    public static double straightDistance(double d, double d2, double d3, double d4) {
        double d5 = d / 57.2958d;
        double d6 = d2 / 57.2958d;
        double d7 = d3 / 57.2958d;
        double d8 = d4 / 57.2958d;
        if (d5 == d7 && d6 == d8) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double sin = Math.sin(d5);
        return Math.acos((Math.cos(d6 - d8) * Math.cos(d7) * Math.cos(d5)) + (Math.sin(d7) * sin)) * 6371.0d * 1000.0d;
    }
}
