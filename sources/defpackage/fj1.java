package defpackage;

import android.animation.TypeEvaluator;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: fj1  reason: default package */
/* compiled from: ZophopMarkerAnimator */
public class fj1 implements TypeEvaluator<LatLng> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        double radians = Math.toRadians(latLng3.latitude);
        double radians2 = Math.toRadians(latLng3.longitude);
        double radians3 = Math.toRadians(latLng4.latitude);
        double radians4 = Math.toRadians(latLng4.longitude);
        double cos = Math.cos(radians);
        double cos2 = Math.cos(radians3);
        double d = radians2 - radians4;
        double pow = Math.pow(Math.sin((radians - radians3) / 2.0d), 2.0d);
        double cos3 = Math.cos(radians);
        double asin = Math.asin(Math.sqrt((Math.pow(Math.sin(d / 2.0d), 2.0d) * Math.cos(radians3) * cos3) + pow)) * 2.0d;
        double sin = Math.sin(asin);
        if (sin < 1.0E-6d) {
            return latLng3;
        }
        double sin2 = Math.sin(((double) (1.0f - f)) * asin) / sin;
        double sin3 = Math.sin(((double) f) * asin) / sin;
        double d2 = cos * sin2;
        double d3 = cos2 * sin3;
        double cos4 = (Math.cos(radians4) * d3) + (Math.cos(radians2) * d2);
        double sin4 = (Math.sin(radians4) * d3) + (Math.sin(radians2) * d2);
        return new LatLng(Math.toDegrees(Math.atan2((Math.sin(radians3) * sin3) + (Math.sin(radians) * sin2), Math.sqrt((sin4 * sin4) + (cos4 * cos4)))), Math.toDegrees(Math.atan2(sin4, cos4)));
    }
}
