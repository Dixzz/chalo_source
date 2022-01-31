package server.zophop.models;

import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Halt {
    public Long _detectionTime;
    public boolean _isHaltingDetected;
    public Point _startPoint;
    public Long _startTimeStamp;

    public Halt(Long l, Long l2, Point point, boolean z) {
        this._startTimeStamp = l;
        this._detectionTime = l2;
        this._startPoint = point;
        this._isHaltingDetected = z;
    }

    public static void showHalt(Halt halt) {
        System.out.println("show Halt");
        if (halt._detectionTime != null) {
            PrintStream printStream = System.out;
            StringBuilder i0 = hj1.i0("_detectionTime ");
            i0.append(halt._detectionTime);
            printStream.println(i0.toString());
        }
        if (halt._startPoint != null) {
            PrintStream printStream2 = System.out;
            StringBuilder i02 = hj1.i0("_startPoint Latitude : ");
            i02.append(halt._startPoint.getLatitude());
            printStream2.println(i02.toString());
            PrintStream printStream3 = System.out;
            StringBuilder i03 = hj1.i0("_startPoint Longitude :");
            i03.append(halt._startPoint.getLongitude());
            printStream3.println(i03.toString());
        }
        PrintStream printStream4 = System.out;
        StringBuilder i04 = hj1.i0("isHaltingDetected : ");
        i04.append(halt._isHaltingDetected);
        printStream4.println(i04.toString());
    }

    public Long getDetectionTime() {
        return this._detectionTime;
    }

    public Point getStartPoint() {
        return this._startPoint;
    }

    public Long getStartTimeStamp() {
        return this._startTimeStamp;
    }

    public boolean isHaltingDetected() {
        return this._isHaltingDetected;
    }

    public void setDetectionTime(Long l) {
        this._detectionTime = l;
    }

    public void setIsHaltingDetected(boolean z) {
        this._isHaltingDetected = z;
    }

    public Map toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(SuperPassJsonKeys.START_TIME, this._startTimeStamp);
        hashMap.put("detectionTime", this._detectionTime);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("lat", Double.valueOf(this._startPoint.getLatitude()));
        hashMap2.put("lon", Double.valueOf(this._startPoint.getLongitude()));
        hashMap.put("startPoint", hashMap2);
        return hashMap;
    }
}
