package defpackage;

import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import com.mixpanel.android.mpmetrics.InAppButton;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;

/* renamed from: kd5  reason: default package */
/* compiled from: TakeoverInAppActivity */
public class kd5 implements View.OnTouchListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ GradientDrawable g;
    public final /* synthetic */ InAppButton h;

    public kd5(TakeoverInAppActivity takeoverInAppActivity, int i, GradientDrawable gradientDrawable, InAppButton inAppButton) {
        this.f = i;
        this.g = gradientDrawable;
        this.h = inAppButton;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g.setColor(this.f);
            return false;
        }
        this.g.setColor(this.h.i);
        return false;
    }
}
