package server.zophop.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.rabbitmq.client.StringRpcServer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import server.zophop.models.Point;
import server.zophop.models.Stop;

public class PolylineUtils {
    private static List<Point> filtersPolyPointsBetweenStops(List<LatLng> list, Stop stop, Stop stop2) throws Exception {
        ArrayList arrayList = new ArrayList();
        double d = 1000.0d;
        double d2 = 1000.0d;
        double d3 = -1.0d;
        double d4 = -1.0d;
        int i = 0;
        for (Iterator<LatLng> it = list.iterator(); it.hasNext(); it = it) {
            LatLng next = it.next();
            double straightDistance = DistanceUtils.straightDistance(next.lat, next.lng, stop.getLat(), stop.getLon());
            if (straightDistance < d) {
                d3 = (double) i;
                d = straightDistance;
            } else {
                d = d;
            }
            double straightDistance2 = DistanceUtils.straightDistance(next.lat, next.lng, stop2.getLat(), stop2.getLon());
            if (straightDistance2 < d2) {
                d4 = (double) i;
                d2 = straightDistance2;
            }
            i++;
        }
        if (d3 == -1.0d || d4 == -1.0d) {
            throw new Exception("stop not found");
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            double d5 = (double) i2;
            if (d5 >= d3 && d5 <= d4) {
                arrayList.add(new Point(list.get(i2).lat, list.get(i2).lng, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            }
        }
        return arrayList;
    }

    public static List<Point> getPointsBetweenStops(String str, Stop stop, Stop stop2) {
        Exception e;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                return filtersPolyPointsBetweenStops(getPointsFromPoly(str), stop, stop2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            arrayList.add(new Point(stop.getLat(), stop.getLon(), 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            arrayList.add(new Point(stop2.getLat(), stop2.getLon(), 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            return arrayList;
        }
    }

    private static List<LatLng> getPointsFromPoly(String str) throws UnsupportedEncodingException {
        return new EncodedPolyline(URLDecoder.decode(str, StringRpcServer.STRING_ENCODING)).decodePath();
    }
}
