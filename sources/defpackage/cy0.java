package defpackage;

import android.view.View;
import androidx.lifecycle.LiveData;
import app.zophop.ui.fragments.cardRecharge.CardRechargeConfirmPaymentFragment;

/* renamed from: cy0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class cy0 implements View.OnClickListener {
    public final /* synthetic */ CardRechargeConfirmPaymentFragment f;

    public /* synthetic */ cy0(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment) {
        this.f = cardRechargeConfirmPaymentFragment;
    }

    public final void onClick(View view) {
        CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment = this.f;
        int i = CardRechargeConfirmPaymentFragment.l;
        n86.e(cardRechargeConfirmPaymentFragment, "this$0");
        ed1 ed1 = new ed1("ocr fare split expanded", Long.MIN_VALUE);
        cardRechargeConfirmPaymentFragment.j(ed1);
        ui1.m0(ed1);
        o91 o91 = cardRechargeConfirmPaymentFragment.h;
        if (o91 != null) {
            wh whVar = o91.d;
            Object value = o91.e.getValue();
            n86.d(value, "<get-isFareLayoutExpanded>(...)");
            Boolean bool = (Boolean) ((LiveData) value).d();
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            whVar.b("keyIsFareLayoutExpanded", Boolean.valueOf(!bool.booleanValue()));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
