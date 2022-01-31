package defpackage;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.ui.fragments.cardRecharge.CardRechargeAmountFragment;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;
import java.util.Objects;

/* renamed from: ay0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ay0 implements View.OnClickListener {
    public final /* synthetic */ CardRechargeAmountFragment f;

    public /* synthetic */ ay0(CardRechargeAmountFragment cardRechargeAmountFragment) {
        this.f = cardRechargeAmountFragment;
    }

    public final void onClick(View view) {
        CardRechargeAmountFragment cardRechargeAmountFragment = this.f;
        int i = CardRechargeAmountFragment.j;
        n86.e(cardRechargeAmountFragment, "this$0");
        ve activity = cardRechargeAmountFragment.c();
        if (activity != null) {
            n86.e(activity, "<this>");
            n86.e(activity, "lContext");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            Object systemService = activity.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            currentFocus.clearFocus();
        }
        CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel = (CardRechargeActivitySharedViewModel) cardRechargeAmountFragment.g.getValue();
        long j = cardRechargeAmountFragment.j().i;
        cardRechargeActivitySharedViewModel.j = j;
        cardRechargeActivitySharedViewModel.d.b("keyRechargeAmount", Long.valueOf(j));
        long j2 = cardRechargeAmountFragment.j().i;
        ed1 ed1 = new ed1("ocr enterAmount next clicked", Long.MIN_VALUE);
        ed1.a("rechargeAmount", Long.valueOf(j2));
        ed1.a(CardRechargeJsonKeys.CARD_NO, cardRechargeAmountFragment.j().g);
        ui1.m0(ed1);
        sy0 sy0 = new sy0(cardRechargeAmountFragment.j().f, cardRechargeAmountFragment.j().i, cardRechargeAmountFragment.j().g, null);
        n86.d(sy0, "actionCardRechargeAmount…iewModel.cardNo\n        )");
        vh1 vh1 = vh1.f3649a;
        n86.f(cardRechargeAmountFragment, "$this$findNavController");
        NavController d = NavHostFragment.d(cardRechargeAmountFragment);
        n86.b(d, "NavHostFragment.findNavController(this)");
        vh1.a(d, sy0);
    }
}
