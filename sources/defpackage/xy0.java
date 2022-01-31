package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassHistory.DigitalTripReceiptHistoryFragment;

/* renamed from: xy0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xy0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DigitalTripReceiptHistoryFragment f3978a;

    public /* synthetic */ xy0(DigitalTripReceiptHistoryFragment digitalTripReceiptHistoryFragment) {
        this.f3978a = digitalTripReceiptHistoryFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        DigitalTripReceiptHistoryFragment digitalTripReceiptHistoryFragment = this.f3978a;
        SuperPass superPass = (SuperPass) obj;
        int i = DigitalTripReceiptHistoryFragment.k;
        n86.e(digitalTripReceiptHistoryFragment, "this$0");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("superPass trip receipt history screen opened", Long.MIN_VALUE);
        digitalTripReceiptHistoryFragment.i(ed1);
        gi1.f1265a.f(ed1, superPass);
        ui1.m0(ed1);
        ((u91) digitalTripReceiptHistoryFragment.g.getValue()).d(superPass);
    }
}
