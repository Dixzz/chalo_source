package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: oo6  reason: default package */
/* compiled from: DistanceUtils */
public class oo6 {
    public static double a(double d, double d2, double d3, double d4) {
        double d5 = d / 57.2958d;
        double d6 = d2 / 57.2958d;
        double d7 = d3 / 57.2958d;
        double d8 = d4 / 57.2958d;
        if (d5 == d7 && d6 == d8) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double sin = Math.sin(d5);
        return Math.acos((Math.cos(d6 - d8) * Math.cos(d7) * Math.cos(d5)) + (Math.sin(d7) * sin)) * 6371.0d * 1000.0d;
    }
}
