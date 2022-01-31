package defpackage;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import app.zophop.ui.fragments.superPassHistory.DigitalTripReceiptHistoryFragment;

/* renamed from: a01  reason: default package */
/* compiled from: DigitalTripReceiptHistoryFragment.kt */
public final class a01 extends o86 implements s76<SuperPassTripReceipt, s56> {
    public final /* synthetic */ DigitalTripReceiptHistoryFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a01(DigitalTripReceiptHistoryFragment digitalTripReceiptHistoryFragment) {
        super(1);
        this.f = digitalTripReceiptHistoryFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(SuperPassTripReceipt superPassTripReceipt) {
        SuperPassTripReceipt superPassTripReceipt2 = superPassTripReceipt;
        n86.e(superPassTripReceipt2, "it");
        DigitalTripReceiptHistoryFragment digitalTripReceiptHistoryFragment = this.f;
        int i = DigitalTripReceiptHistoryFragment.k;
        ed1 ed1 = new ed1("superPass trip receipt clicked", Long.MIN_VALUE);
        digitalTripReceiptHistoryFragment.i(ed1);
        gi1.f1265a.g(ed1, superPassTripReceipt2);
        ui1.m0(ed1);
        r91 r91 = digitalTripReceiptHistoryFragment.h;
        if (r91 != null) {
            d01 d01 = new d01("sourceSuperPassTripHistoryScreen", r91.e, r91.f, superPassTripReceipt2.getActivationTimeStamp(), null);
            n86.d(d01, "actionDigitalTripReceipt…onTimeStamp\n            )");
            vh1 vh1 = vh1.f3649a;
            n86.f(digitalTripReceiptHistoryFragment, "$this$findNavController");
            NavController d = NavHostFragment.d(digitalTripReceiptHistoryFragment);
            n86.b(d, "NavHostFragment.findNavController(this)");
            vh1.a(d, d01);
            return s56.f3190a;
        }
        n86.l("viewModel");
        throw null;
    }
}
