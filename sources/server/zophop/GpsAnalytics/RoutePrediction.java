package server.zophop.GpsAnalytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.Point;
import server.zophop.models.Route;

public class RoutePrediction {
    public static final int GPS_DURATION_INTERVAL_IN_MINS = 30;
    private static DataContainer _container;
    private StopArrival _stopArrival = new StopArrival();
    public Map<String, List<String>> _vehicleRoutesMap = new HashMap();

    public RoutePrediction() {
        _container = DataContainer.getDataContainer();
    }

    public Route execute(String str, String str2, String str3, String str4) throws Exception {
        ConfigSettings configSettings = new ConfigSettings(30);
        Map<String, Route> fetchAllRoutes = _container.fetchAllRoutes(str, "bus");
        ElasticGpsFetcher elasticGpsFetcher = new ElasticGpsFetcher();
        List<Point> list = (List) elasticGpsFetcher.parse((Object) elasticGpsFetcher.fetch(str, str2, "bus", str4, configSettings));
        ElasticTripFetcher elasticTripFetcher = new ElasticTripFetcher();
        if (this._vehicleRoutesMap.size() == 0) {
            this._vehicleRoutesMap = elasticTripFetcher.parse(elasticTripFetcher.fetch(str, str2, "bus", "", configSettings));
        }
        if (list.size() == 0 || !this._vehicleRoutesMap.containsKey(str4)) {
            System.out.println("bus halted");
            return null;
        }
        List<GroupedStopArrivals> allApproxStopwiseArrivals = this._stopArrival.getAllApproxStopwiseArrivals(str4, str, str2, list);
        ArrayList arrayList = new ArrayList();
        for (GroupedStopArrivals groupedStopArrivals : allApproxStopwiseArrivals) {
            arrayList.add(groupedStopArrivals.getStop().getId());
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (String str5 : this._vehicleRoutesMap.get(str4)) {
            Route route = fetchAllRoutes.get(str5);
            ArrayList<String> lcs = LongestCommonSubsequence.lcs(route.getStopSequence(), arrayList);
            if (lcs.size() == i) {
                arrayList2.add(route);
            } else if (lcs.size() > i) {
                arrayList2 = new ArrayList();
                arrayList2.add(route);
                i = lcs.size();
            }
        }
        if (arrayList2.size() == 1) {
            return (Route) arrayList2.get(0);
        }
        throw new Exception("Can not predict a route");
    }
}
