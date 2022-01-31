package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;
import app.zophop.ui.utils.DatePickerUtils;
import j$.util.DesugarTimeZone;
import java.util.Calendar;

/* renamed from: to0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class to0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMPassPurchaseFragment f;

    public /* synthetic */ to0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f = confirmMPassPurchaseFragment;
    }

    public final void onClick(View view) {
        em4<Long> em4;
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        ed1 ed1 = new ed1("change pass start date clicked", Long.MIN_VALUE);
        confirmMPassPurchaseFragment.j(ed1);
        ui1.m0(ed1);
        if (n86.a(confirmMPassPurchaseFragment.k().f, "flowPaymentPostVerification")) {
            long startingTime = confirmMPassPurchaseFragment.k().g.getStartingTime();
            long j = startingTime - 86400000;
            long verificationExpiryTime = confirmMPassPurchaseFragment.k().g.getVerificationExpiryTime() - (((long) confirmMPassPurchaseFragment.k().g.getNoOfDays()) * 86400000);
            if (verificationExpiryTime < j) {
                Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
                instance.setTimeInMillis(j);
                instance.add(5, 30);
                verificationExpiryTime = instance.getTimeInMillis();
            }
            String string = confirmMPassPurchaseFragment.getString(R.string.select_pass_start_date);
            n86.d(string, "getString(R.string.select_pass_start_date)");
            em4 = DatePickerUtils.b(string, startingTime, j, verificationExpiryTime);
        } else {
            long startingTime2 = confirmMPassPurchaseFragment.k().g.getStartingTime();
            long Q = ui1.Q() - 86400000;
            long a2 = DatePickerUtils.a(Q, 30);
            String string2 = confirmMPassPurchaseFragment.getString(R.string.select_pass_start_date);
            n86.d(string2, "getString(R.string.select_pass_start_date)");
            em4 = DatePickerUtils.b(string2, startingTime2, Q, a2);
        }
        em4.f.add(new wo0(em4, confirmMPassPurchaseFragment));
        ve activity = confirmMPassPurchaseFragment.c();
        if (activity != null) {
            em4.show(activity.getSupportFragmentManager(), "tagCalenderPassStartDateSelection");
        }
    }
}
