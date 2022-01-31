package defpackage;

import android.view.View;
import androidx.lifecycle.LiveData;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;

/* renamed from: vo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vo0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMPassPurchaseFragment f;

    public /* synthetic */ vo0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f = confirmMPassPurchaseFragment;
    }

    public final void onClick(View view) {
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        c81 c81 = confirmMPassPurchaseFragment.h;
        if (c81 != null) {
            wh whVar = c81.c;
            Object value = c81.d.getValue();
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
