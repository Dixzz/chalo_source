package server.zophop.logicLayer;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import java.util.Date;
import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.gpsIntegration.LiveDataHandler;
import server.zophop.models.Halt;
import server.zophop.models.Point;
import server.zophop.models.Stream;
import server.zophop.queue.RabbitMQ;
import server.zophop.utils.DistanceUtils;

public class HaltDataHandler {
    public LiveDataHandler _handler;

    public HaltDataHandler() {
        RabbitMQ rabbitMQ = new RabbitMQ(4, Constants.getExchange(), TaskCategory.APPLICATION);
        rabbitMQ.init();
        this._handler = new LiveDataHandler(rabbitMQ, DataContainer.getDataContainer());
    }

    private double getDistance(Point point, double d, double d2) {
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 100010.0d;
        }
        return DistanceUtils.straightDistance(d, d2, point.getLatitude(), point.getLongitude());
    }

    public boolean isHalted(Point point, Stream stream) {
        boolean z;
        boolean hasHalt = stream.hasHalt();
        double distance = getDistance(point, stream.getClat(), stream.getClon());
        Halt halt = stream.getHalt();
        System.out.println(distance);
        if (!hasHalt && distance < 10.0d) {
            Halt halt2 = new Halt(Long.valueOf(stream.getLastUpdated()), null, point, false);
            stream.setHalt(halt2);
            Halt.showHalt(halt2);
        } else if (halt != null) {
            double straightDistance = DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), halt.getStartPoint().getLatitude(), halt.getStartPoint().getLongitude());
            long time = point.getTime();
            long longValue = time - halt.getStartTimeStamp().longValue();
            PrintStream printStream = System.out;
            StringBuilder i0 = hj1.i0("getStartTimeStamp : ");
            i0.append(new Date(halt.getStartTimeStamp().longValue()));
            printStream.println(i0.toString());
            PrintStream printStream2 = System.out;
            StringBuilder i02 = hj1.i0("currentTime :");
            i02.append(new Date(time));
            printStream2.println(i02.toString());
            PrintStream printStream3 = System.out;
            printStream3.println("timeDiff : " + longValue);
            PrintStream printStream4 = System.out;
            printStream4.println("distance :" + distance);
            int i = (distance > 10.0d ? 1 : (distance == 10.0d ? 0 : -1));
            System.out.println(i < 0);
            int i2 = (straightDistance > 100.0d ? 1 : (straightDistance == 100.0d ? 0 : -1));
            System.out.println(i2 < 0);
            if (i >= 0 || i2 >= 0) {
                stream.setHalt(null);
            } else {
                if (longValue <= Constants.HALTING_TIMESTAMP_THRESHOLD || halt._isHaltingDetected) {
                    z = false;
                } else {
                    halt.setIsHaltingDetected(true);
                    halt.setDetectionTime(Long.valueOf(point.getTime()));
                    z = true;
                }
                if (longValue <= Constants.HALTING_CHECKOUT_TIMESTAMP_THRESHOLD) {
                    return z;
                }
                stream.getCity();
                stream.getAgency();
                stream.getUserId();
                System.currentTimeMillis();
                stream.getRouteId();
                return z;
            }
        }
        return false;
    }
}
