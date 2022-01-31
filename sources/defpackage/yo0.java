package defpackage;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;
import java.util.List;

/* renamed from: yo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yo0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMPassPurchaseFragment f;
    public final /* synthetic */ MPass g;

    public /* synthetic */ yo0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment, MPass mPass) {
        this.f = confirmMPassPurchaseFragment;
        this.g = mPass;
    }

    public final void onClick(View view) {
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f;
        MPass mPass = this.g;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        n86.e(mPass, "$lMPass");
        MPass mPass2 = confirmMPassPurchaseFragment.k().g;
        ed1 ed1 = new ed1("mPass proof submit button clicked", Long.MIN_VALUE);
        ed1.a("passengerType", mPass2.getPassengerType());
        ed1.a(SuperPassJsonKeys.FARE, String.valueOf(mPass2.getFare()));
        ed1.a("noOfDays", String.valueOf(mPass2.getNoOfDays()));
        ed1.a("startDate", jh1.c(mPass2.getStartingTime()));
        confirmMPassPurchaseFragment.j(ed1);
        ui1.m0(ed1);
        List<String> list = null;
        zz zzVar = new zz("submit proof for verification clicked", null, 2);
        zzVar.a("product type", mPass2.get_bookingPassType());
        ui1.l0(zzVar);
        ed1 ed12 = new ed1("terms and conditions open", Long.MIN_VALUE);
        confirmMPassPurchaseFragment.j(ed12);
        ui1.m0(ed12);
        ve activity = confirmMPassPurchaseFragment.c();
        if (activity != null) {
            on0 on0 = on0.g;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            ProductConfiguration productConfiguration = confirmMPassPurchaseFragment.k().n;
            if (productConfiguration != null) {
                list = productConfiguration.getProductTerms();
            }
            if (list == null) {
                list = b66.f;
            }
            on0.d(supportFragmentManager, list, new cu0(confirmMPassPurchaseFragment, mPass));
        }
    }
}
