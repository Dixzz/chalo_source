package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;

/* renamed from: eu  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class eu implements View.OnClickListener {
    public final /* synthetic */ nu f;
    public final /* synthetic */ SuperPassTripReceipt g;

    public /* synthetic */ eu(nu nuVar, SuperPassTripReceipt superPassTripReceipt) {
        this.f = nuVar;
        this.g = superPassTripReceipt;
    }

    public final void onClick(View view) {
        nu nuVar = this.f;
        SuperPassTripReceipt superPassTripReceipt = this.g;
        n86.e(nuVar, "this$0");
        n86.e(superPassTripReceipt, "$lSuperPassTripReceipt");
        nuVar.c.invoke(superPassTripReceipt);
    }
}
