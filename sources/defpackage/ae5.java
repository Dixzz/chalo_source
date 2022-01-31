package defpackage;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import defpackage.ge5;

/* renamed from: ae5  reason: default package */
/* compiled from: FlipGesture */
public class ae5 implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public int f156a = -1;
    public int b = 0;
    public long c = -1;
    public final float[] d = new float[3];
    public final a e;

    /* renamed from: ae5$a */
    /* compiled from: FlipGesture */
    public interface a {
    }

    public ae5(a aVar) {
        this.e = aVar;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        int i = 0;
        while (i < 3) {
            float[] fArr2 = this.d;
            float f = i < fArr2.length ? fArr2[i] : 0.0f;
            fArr2[i] = hj1.a(fArr[i], f, 0.7f, f);
            i++;
        }
        float[] fArr3 = this.d;
        int i2 = this.b;
        float f2 = (fArr3[2] * fArr3[2]) + (fArr3[1] * fArr3[1]) + (fArr3[0] * fArr3[0]);
        this.b = 0;
        if (fArr3[2] > 7.8f && fArr3[2] < 11.8f) {
            this.b = -1;
        }
        if (fArr3[2] < -7.8f && fArr3[2] > -11.8f) {
            this.b = 1;
        }
        if (f2 < 60.840004f || f2 > 139.24f) {
            this.b = 0;
        }
        int i3 = this.b;
        if (i2 != i3) {
            this.c = sensorEvent.timestamp;
        }
        long j = sensorEvent.timestamp - this.c;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1 && j > 250000000 && this.f156a == 0) {
                    this.f156a = 1;
                }
            } else if (j > 1000000000 && this.f156a != 0) {
                this.f156a = 0;
            }
        } else if (j > 250000000 && this.f156a == 1) {
            this.f156a = 0;
            ge5.d dVar = (ge5.d) this.e;
            nc5 nc5 = ge5.this.c;
            if (!nc5.m() && !nc5.m()) {
                nc5.s("$ab_gesture3", null, false);
            }
            ge5.this.h.sendMessage(ge5.this.h.obtainMessage(1));
        }
    }
}
