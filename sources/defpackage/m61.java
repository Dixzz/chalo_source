package defpackage;

import android.view.View;
import app.zophop.ui.utils.FrequencyRouteHelper;

/* renamed from: m61  reason: default package */
/* compiled from: FrequencyRouteHelper */
public class m61 implements View.OnClickListener {
    public final /* synthetic */ FrequencyRouteHelper f;

    public m61(FrequencyRouteHelper frequencyRouteHelper) {
        this.f = frequencyRouteHelper;
    }

    public void onClick(View view) {
        this.f.h.onBackPressed();
    }
}
