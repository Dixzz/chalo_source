package defpackage;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* renamed from: zm4  reason: default package */
/* compiled from: FloatingActionButtonImpl */
public class zm4 implements TypeEvaluator<Float> {

    /* renamed from: a  reason: collision with root package name */
    public FloatEvaluator f4189a = new FloatEvaluator();

    public zm4(ym4 ym4) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Float f2, Float f3) {
        float floatValue = this.f4189a.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
