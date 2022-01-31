package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.ec1;

/* renamed from: cc1  reason: default package */
/* compiled from: CollapseOnScrollView */
public class cc1 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ ec1 f;

    public cc1(ec1 ec1) {
        this.f = ec1;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        ec1.a aVar = this.f.i;
        aVar.g = 0.0f;
        aVar.f.fling(0, 0, 0, (int) f3, 0, 0, RtlSpacingHelper.UNDEFINED, Integer.MAX_VALUE);
        ec1.this.postOnAnimation(aVar);
        return true;
    }
}
