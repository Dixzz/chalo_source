package server.zophop.models;

import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.utils.DistanceUtils;

public class HaltValidate implements IHaltValidation {
    public static final int HALT_DISTANCE = 20;
    public static final int HARD_HALT_THRESHOLD_TIME = 900;
    public static final int SOFT_HALT_THRESHOLD_TIME = 300;
    public static final int TOTAL_HALT_DISTANCE = 100;

    private HaltStatus getHaltState(Point point, Point point2) {
        if (timeDifferenceBetweenTwoPoints(point, point2) > 900.0d) {
            return HaltStatus.HARD_HALT;
        }
        if (timeDifferenceBetweenTwoPoints(point, point2) > 300.0d) {
            return HaltStatus.SOFT_HALT;
        }
        return HaltStatus.HALT;
    }

    public double distanebetweenTwoPoints(Point point, Point point2) {
        return DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), point2.getLatitude(), point2.getLongitude());
    }

    public double timeDifferenceBetweenTwoPoints(Point point, Point point2) {
        return (double) Math.abs((point.getTime() - point2.getTime()) / 1000);
    }

    @Override // server.zophop.models.IHaltValidation
    public HaltState validate(VehicleGPSInfo vehicleGPSInfo, Point point) {
        double distanebetweenTwoPoints = distanebetweenTwoPoints(vehicleGPSInfo.getLastPoint(), point);
        double distanebetweenTwoPoints2 = distanebetweenTwoPoints(vehicleGPSInfo.getHaltState().getHaltPoint(), point);
        if (20.0d >= distanebetweenTwoPoints && 100.0d >= distanebetweenTwoPoints2) {
            return new HaltState(getHaltState(point, vehicleGPSInfo.getHaltState().getHaltPoint()), vehicleGPSInfo.getHaltState().getHaltPoint());
        }
        HaltStatus haltStatus = vehicleGPSInfo.getHaltState().getHaltStatus();
        HaltStatus haltStatus2 = HaltStatus.NO_HALT;
        if (!haltStatus.equals(haltStatus2)) {
            System.out.println();
        }
        return new HaltState(haltStatus2, point);
    }
}
