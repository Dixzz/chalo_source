package server.zophop.GpsAnalytics;

import java.util.List;
import java.util.Map;

public interface IRoutePrediction {
    List<RouteAccuracy> predictRoutes(String str, Map<String, GroupedStopArrivals> map);
}
