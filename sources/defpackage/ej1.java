package defpackage;

import android.animation.TypeEvaluator;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: ej1  reason: default package */
/* compiled from: ZophopMarkerAnimator */
public class ej1 implements TypeEvaluator<LatLng> {

    /* renamed from: a  reason: collision with root package name */
    public final DecelerateInterpolator f978a = new DecelerateInterpolator();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        float interpolation = this.f978a.getInterpolation(f);
        double d = (double) (1.0f - interpolation);
        double d2 = (double) interpolation;
        return new LatLng((latLng4.latitude * d2) + (latLng3.latitude * d), (latLng4.longitude * d2) + (latLng3.longitude * d));
    }
}
