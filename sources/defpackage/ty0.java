package defpackage;

import android.content.Context;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.ui.fragments.cardRecharge.CardRechargeConfirmPaymentFragment;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;
import defpackage.on0;

/* renamed from: ty0  reason: default package */
/* compiled from: CardRechargeConfirmPaymentFragment.kt */
public final class ty0 implements on0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeConfirmPaymentFragment f3420a;

    public ty0(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment) {
        this.f3420a = cardRechargeConfirmPaymentFragment;
    }

    @Override // defpackage.on0.a
    public void a() {
        CardRechargeConfirmPaymentFragment.i(this.f3420a, true);
        o91 o91 = this.f3420a.h;
        if (o91 != null) {
            o91.d(true);
            CardRechargeActivitySharedViewModel l = this.f3420a.l();
            CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment = this.f3420a;
            o91 o912 = cardRechargeConfirmPaymentFragment.h;
            if (o912 != null) {
                CardRechargeConfiguration cardRechargeConfiguration = o912.f;
                Context requireContext = cardRechargeConfirmPaymentFragment.requireContext();
                n86.d(requireContext, "requireContext()");
                l.onPaymentBtnClicked(cardRechargeConfiguration, requireContext);
                return;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.on0.a
    public void b() {
        CardRechargeConfirmPaymentFragment.i(this.f3420a, false);
    }
}
