package server.zophop.GpsAnalytics;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import server.zophop.models.Stop;
import server.zophop.utils.DistanceUtils;

public class StopOnRouteOnRouteValidator implements IStopOnRouteValidator {
    private StopUtils _stopUtils = StopUtils.getInstance();

    private boolean isCurrentStopArrivalBeforePrev(List<GroupedStopArrivals> list, RouteAccuracy routeAccuracy, List<String> list2, int i, int i2) {
        return !routeAccuracy.getRoute().getReverseRouteId().equals(routeAccuracy.getRoute().getId()) && list2.indexOf(list.get(i2).getStop().getId()) < i;
    }

    private boolean isStopOutOfRange(Agency agency, List<GroupedStopArrivals> list, int i, int i2) {
        return list.get(i2).getPoints().get(0).getDistanceCovered() - list.get(i).getPoints().get(0).getDistanceCovered() > getDistanceBetweenTwoStops(agency.getCity(), "bus", list.get(i).getStop().getId(), list.get(i2).getStop().getId()) * 3.0d;
    }

    public double getDistanceBetweenTwoStops(String str, String str2, String str3, String str4) {
        try {
            Stop fetchStop = this._stopUtils.fetchStop(str, str3);
            Stop fetchStop2 = this._stopUtils.fetchStop(str, str4);
            return DistanceUtils.straightDistance(fetchStop.getLat(), fetchStop.getLon(), fetchStop2.getLat(), fetchStop2.getLon());
        } catch (Exception e) {
            e.printStackTrace();
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }

    @Override // server.zophop.GpsAnalytics.IStopOnRouteValidator
    public boolean validate(Agency agency, List<GroupedStopArrivals> list, RouteAccuracy routeAccuracy, List<String> list2, int i, int i2, int i3) {
        if (!isCurrentStopArrivalBeforePrev(list, routeAccuracy, list2, i2, i3) && !isStopOutOfRange(agency, list, i, i3)) {
            return true;
        }
        return false;
    }
}
