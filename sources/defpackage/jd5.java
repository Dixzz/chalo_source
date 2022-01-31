package defpackage;

import android.view.View;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;

/* renamed from: jd5  reason: default package */
/* compiled from: TakeoverInAppActivity */
public class jd5 implements View.OnClickListener {
    public final /* synthetic */ TakeoverInAppActivity f;

    public jd5(TakeoverInAppActivity takeoverInAppActivity) {
        this.f = takeoverInAppActivity;
    }

    public void onClick(View view) {
        this.f.finish();
        UpdateDisplayState.c(this.f.h);
    }
}
