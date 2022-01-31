package defpackage;

import android.view.ViewTreeObserver;
import com.google.android.material.timepicker.ClockFaceView;
import com.google.android.material.timepicker.ClockHandView;

/* renamed from: cq4  reason: default package */
/* compiled from: ClockFaceView */
public class cq4 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ClockFaceView f;

    public cq4(ClockFaceView clockFaceView) {
        this.f = clockFaceView;
    }

    public boolean onPreDraw() {
        if (!this.f.isShown()) {
            return true;
        }
        this.f.getViewTreeObserver().removeOnPreDrawListener(this);
        ClockFaceView clockFaceView = this.f;
        int height = ((this.f.getHeight() / 2) - clockFaceView.z.l) - clockFaceView.G;
        if (height != clockFaceView.x) {
            clockFaceView.x = height;
            clockFaceView.j();
            ClockHandView clockHandView = clockFaceView.z;
            clockHandView.t = clockFaceView.x;
            clockHandView.invalidate();
        }
        return true;
    }
}
