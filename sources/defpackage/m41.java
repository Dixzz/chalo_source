package defpackage;

import android.view.View;
import androidx.lifecycle.LiveData;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;

/* renamed from: m41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m41 implements View.OnClickListener {
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f;

    public /* synthetic */ m41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f = confirmSuperPassPurchaseFragment;
    }

    public final void onClick(View view) {
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        ba1 ba1 = confirmSuperPassPurchaseFragment.h;
        if (ba1 != null) {
            wh whVar = ba1.c;
            Object value = ba1.d.getValue();
            n86.d(value, "<get-isFareLayoutExpanded>(...)");
            Object d = ((LiveData) value).d();
            n86.c(d);
            whVar.b("keyIsFareLayoutExpanded", Boolean.valueOf(!((Boolean) d).booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
