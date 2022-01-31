package defpackage;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;
import java.util.List;

/* renamed from: zo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zo0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMPassPurchaseFragment f;
    public final /* synthetic */ MPass g;

    public /* synthetic */ zo0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment, MPass mPass) {
        this.f = confirmMPassPurchaseFragment;
        this.g = mPass;
    }

    public final void onClick(View view) {
        List<String> list;
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f;
        MPass mPass = this.g;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        n86.e(mPass, "$lMPass");
        confirmMPassPurchaseFragment.o();
        ed1 ed1 = new ed1("terms and conditions open", Long.MIN_VALUE);
        confirmMPassPurchaseFragment.j(ed1);
        ui1.m0(ed1);
        ve activity = confirmMPassPurchaseFragment.c();
        if (activity != null) {
            on0 on0 = on0.g;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            ProductConfiguration productConfiguration = confirmMPassPurchaseFragment.k().n;
            if (productConfiguration == null) {
                list = null;
            } else {
                list = productConfiguration.getProductTerms();
            }
            if (list == null) {
                list = b66.f;
            }
            on0.d(supportFragmentManager, list, new bu0(confirmMPassPurchaseFragment, mPass));
        }
    }
}
