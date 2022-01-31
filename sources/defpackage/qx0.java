package defpackage;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;
import java.util.Objects;
import java.util.UUID;

/* renamed from: qx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qx0 implements View.OnClickListener {
    public final /* synthetic */ CardDetailsFragment f;

    public /* synthetic */ qx0(CardDetailsFragment cardDetailsFragment) {
        this.f = cardDetailsFragment;
    }

    public final void onClick(View view) {
        CardDetailsFragment cardDetailsFragment = this.f;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        ve activity = cardDetailsFragment.c();
        if (activity != null) {
            ed1 ed1 = new ed1("ocr cardDetails next clicked", Long.MIN_VALUE);
            ed1.a(CardRechargeJsonKeys.CARD_NO, cardDetailsFragment.j().g);
            ed1.a("source", "sourceCardDetailsScreen");
            ui1.m0(ed1);
            h91 j = cardDetailsFragment.j();
            Context requireContext = cardDetailsFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            n86.e(requireContext, "lContext");
            j.d.b("keyShouldShowLoader", Boolean.TRUE);
            String uuid = UUID.randomUUID().toString();
            n86.d(uuid, "randomUUID().toString()");
            j.m = uuid;
            v60.a(j.g, j.f, uuid, requireContext);
            Context requireContext2 = cardDetailsFragment.requireContext();
            n86.d(requireContext2, "requireContext()");
            n86.e(activity, "<this>");
            n86.e(requireContext2, "lContext");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(requireContext2);
            }
            Object systemService = activity.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            currentFocus.clearFocus();
        }
    }
}
