package defpackage;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.fragments.cardRecharge.CardRechargeConfirmPaymentFragment;

/* renamed from: by0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class by0 implements View.OnClickListener {
    public final /* synthetic */ CardRechargeConfirmPaymentFragment f;

    public /* synthetic */ by0(CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment) {
        this.f = cardRechargeConfirmPaymentFragment;
    }

    public final void onClick(View view) {
        CardRechargeConfirmPaymentFragment cardRechargeConfirmPaymentFragment = this.f;
        int i = CardRechargeConfirmPaymentFragment.l;
        n86.e(cardRechargeConfirmPaymentFragment, "this$0");
        ed1 ed1 = new ed1("ocr make payment clicked", Long.MIN_VALUE);
        cardRechargeConfirmPaymentFragment.j(ed1);
        ui1.m0(ed1);
        ed1 ed12 = new ed1("terms and conditions open", Long.MIN_VALUE);
        cardRechargeConfirmPaymentFragment.j(ed12);
        ui1.m0(ed12);
        ve activity = cardRechargeConfirmPaymentFragment.c();
        if (activity != null) {
            on0 on0 = on0.g;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            o91 o91 = cardRechargeConfirmPaymentFragment.h;
            if (o91 != null) {
                on0.d(supportFragmentManager, o91.f.getTerms(), new ty0(cardRechargeConfirmPaymentFragment));
            } else {
                n86.l("viewModel");
                throw null;
            }
        }
    }
}
