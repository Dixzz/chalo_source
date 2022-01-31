package defpackage;

import android.view.View;
import app.zophop.service.LocationTrackingService;

/* renamed from: cm0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class cm0 implements View.OnClickListener {
    public final /* synthetic */ km0 f;

    public /* synthetic */ cm0(km0 km0) {
        this.f = km0;
    }

    public final void onClick(View view) {
        km0 km0 = this.f;
        int i = km0.q;
        n86.e(km0, "this$0");
        km0.dismiss();
        LocationTrackingService.b();
    }
}
