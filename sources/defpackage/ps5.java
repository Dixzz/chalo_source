package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.urbanairship.iam.html.HtmlActivity;
import java.lang.ref.WeakReference;

/* renamed from: ps5  reason: default package */
/* compiled from: HtmlActivity */
public class ps5 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ WeakReference f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ boolean i;

    public ps5(HtmlActivity htmlActivity, WeakReference weakReference, int i2, int i3, boolean z) {
        this.f = weakReference;
        this.g = i2;
        this.h = i3;
        this.i = z;
    }

    public boolean onPreDraw() {
        int i2;
        View view = (View) this.f.get();
        if (view == null) {
            return true;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int min = Math.min(measuredWidth, this.g);
        int min2 = Math.min(measuredHeight, this.h);
        if (this.i && !(min == (i2 = this.g) && min2 == this.h)) {
            int i3 = this.h;
            float f2 = (float) measuredWidth;
            float f3 = (float) measuredHeight;
            if (f2 / f3 > ((float) i2) / ((float) i3)) {
                min = (int) ((((float) i2) * f3) / ((float) i3));
            } else {
                min2 = (int) ((((float) i3) * f2) / ((float) i2));
            }
        }
        if (min2 > 0) {
            layoutParams.height = min2;
        }
        if (min > 0) {
            layoutParams.width = min;
        }
        view.setLayoutParams(layoutParams);
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
