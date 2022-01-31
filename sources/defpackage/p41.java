package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import app.zophop.ui.utils.DatePickerUtils;
import j$.util.DesugarTimeZone;
import java.util.Calendar;

/* renamed from: p41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class p41 implements View.OnClickListener {
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f;

    public /* synthetic */ p41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f = confirmSuperPassPurchaseFragment;
    }

    public final void onClick(View view) {
        em4<Long> em4;
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        ed1 ed1 = new ed1("change pass start date clicked", Long.MIN_VALUE);
        confirmSuperPassPurchaseFragment.k(ed1);
        ui1.m0(ed1);
        String str = confirmSuperPassPurchaseFragment.l().f;
        if (n86.a(str, "flowPaymentPostVerification")) {
            long j = confirmSuperPassPurchaseFragment.l().m;
            long j2 = j - 86400000;
            long noOfDays = confirmSuperPassPurchaseFragment.l().n - (((long) confirmSuperPassPurchaseFragment.l().l.getSelectedProductFareMapping().getNoOfDays()) * 86400000);
            if (confirmSuperPassPurchaseFragment.l().n == -1) {
                Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
                instance.setTimeInMillis(j2);
                instance.add(5, 30);
                noOfDays = instance.getTimeInMillis();
            }
            String string = confirmSuperPassPurchaseFragment.getString(R.string.select_pass_start_date);
            n86.d(string, "getString(R.string.select_pass_start_date)");
            em4 = DatePickerUtils.b(string, j, j2, noOfDays);
        } else if (n86.a(str, "flowRenewPass")) {
            long j3 = confirmSuperPassPurchaseFragment.l().m;
            long j4 = j3 - 86400000;
            long noOfDays2 = confirmSuperPassPurchaseFragment.l().n - (((long) confirmSuperPassPurchaseFragment.l().l.getSelectedProductFareMapping().getNoOfDays()) * 86400000);
            if (confirmSuperPassPurchaseFragment.l().n == -1) {
                Calendar instance2 = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
                instance2.setTimeInMillis(j4);
                instance2.add(5, 30);
                noOfDays2 = instance2.getTimeInMillis();
            }
            String string2 = confirmSuperPassPurchaseFragment.getString(R.string.select_pass_start_date);
            n86.d(string2, "getString(R.string.select_pass_start_date)");
            em4 = DatePickerUtils.b(string2, j3, j4, noOfDays2);
        } else {
            long j5 = confirmSuperPassPurchaseFragment.l().m;
            long Q = ui1.Q() - 86400000;
            long a2 = DatePickerUtils.a(Q, 30);
            String string3 = confirmSuperPassPurchaseFragment.getString(R.string.select_pass_start_date);
            n86.d(string3, "getString(R.string.select_pass_start_date)");
            em4 = DatePickerUtils.b(string3, j5, Q, a2);
        }
        em4.f.add(new v41(em4, confirmSuperPassPurchaseFragment));
        ve activity = confirmSuperPassPurchaseFragment.c();
        if (activity != null) {
            em4.show(activity.getSupportFragmentManager(), "tagCalenderPassStartDateSelection");
        }
    }
}
