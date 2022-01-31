package zophop.models;

import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Point;
import com.google.common.geometry.S2Polyline;
import com.graphhopper.GHResponse;
import java.util.ArrayList;

public class Polyline {
    private S2Polyline polyline;
    private String polyline_string;

    public static Polyline generatePolyline(Route route, City city) {
        throw null;
    }

    public Coordinate getNearestCoordinate(Coordinate coordinate) {
        S2Point point = S2LatLng.fromDegrees(coordinate.lat, coordinate.lon).toPoint();
        S2Polyline s2Polyline = this.polyline;
        S2LatLng s2LatLng = new S2LatLng(s2Polyline.projectToEdge(point, s2Polyline.getNearestEdgeIndex(point)));
        Coordinate coordinate2 = new Coordinate();
        coordinate2.lat = s2LatLng.latRadians();
        coordinate2.lon = s2LatLng.lngDegrees();
        return coordinate2;
    }

    public String toString() {
        return this.polyline_string;
    }

    public static Polyline generatePolyline(GHResponse gHResponse) {
        String b = po6.b(gHResponse);
        ArrayList arrayList = new ArrayList();
        if (gHResponse.getPoints().size() == 0) {
            return null;
        }
        for (Double[] dArr : gHResponse.getPoints().toGeoJson()) {
            arrayList.add(S2LatLng.fromDegrees(dArr[1].doubleValue(), dArr[0].doubleValue()).toPoint());
        }
        S2Polyline s2Polyline = new S2Polyline(arrayList);
        Polyline polyline2 = new Polyline();
        polyline2.polyline = s2Polyline;
        polyline2.polyline_string = b;
        return polyline2;
    }
}
