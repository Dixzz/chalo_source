package defpackage;

import android.view.View;
import defpackage.gw0;

/* renamed from: as0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class as0 implements View.OnClickListener {
    public final /* synthetic */ gw0 f;
    public final /* synthetic */ String g;

    public /* synthetic */ as0(gw0 gw0, String str) {
        this.f = gw0;
        this.g = str;
    }

    public final void onClick(View view) {
        gw0 gw0 = this.f;
        String str = this.g;
        n86.e(gw0, "this$0");
        gw0.a aVar = gw0.h;
        if (aVar != null) {
            aVar.c(str);
        }
        gw0.dismiss();
    }
}
