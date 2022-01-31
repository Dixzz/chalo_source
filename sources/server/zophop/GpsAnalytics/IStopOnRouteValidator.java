package server.zophop.GpsAnalytics;

import java.util.List;

public interface IStopOnRouteValidator {
    boolean validate(Agency agency, List<GroupedStopArrivals> list, RouteAccuracy routeAccuracy, List<String> list2, int i, int i2, int i3);
}
