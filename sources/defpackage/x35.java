package defpackage;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;

/* renamed from: x35  reason: default package */
/* compiled from: AmbientLightManager */
public final class x35 implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public la5 f3880a;
    public ma5 b;
    public Context c;
    public Handler d = new Handler();

    public x35(Context context, la5 la5, ma5 ma5) {
        this.c = context;
        this.f3880a = la5;
        this.b = ma5;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.f3880a == null) {
            return;
        }
        if (f <= 45.0f) {
            this.d.post(new w35(this, true));
        } else if (f >= 450.0f) {
            this.d.post(new w35(this, false));
        }
    }
}
