package server.zophop.utils;

public class RouteDeviationUtils {
    public static double[][] BHOPAL_DEPOT_LATLONGS = {new double[]{23.229423d, 77.443689d}, new double[]{23.270896d, 77.326809d}};

    public static boolean checkIfBusInDepot(String str, double d, double d2) {
        if (str.equalsIgnoreCase("bhopal")) {
            int i = 0;
            while (true) {
                double[][] dArr = BHOPAL_DEPOT_LATLONGS;
                if (i >= dArr.length) {
                    break;
                } else if (DistanceUtils.straightDistance(dArr[i][0], dArr[i][1], d, d2) <= 50.0d) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
