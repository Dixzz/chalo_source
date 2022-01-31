package defpackage;

import android.view.View;
import defpackage.gw0;

/* renamed from: zr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zr0 implements View.OnClickListener {
    public final /* synthetic */ gw0 f;

    public /* synthetic */ zr0(gw0 gw0) {
        this.f = gw0;
    }

    public final void onClick(View view) {
        gw0 gw0 = this.f;
        n86.e(gw0, "this$0");
        gw0.a aVar = gw0.h;
        if (aVar != null) {
            aVar.b();
        }
        gw0.dismiss();
    }
}
