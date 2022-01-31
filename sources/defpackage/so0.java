package defpackage;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;
import defpackage.xt;
import java.util.Objects;

/* renamed from: so0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class so0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMPassPurchaseFragment f3233a;

    public /* synthetic */ so0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f3233a = confirmMPassPurchaseFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        Intent intent;
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f3233a;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        if (activityResult.f == -1 && (intent = activityResult.g) != null) {
            if (n86.a(intent.getStringExtra("paymentMode"), SuperPassPaymentConstants.PAYMENT_MODE_CASH)) {
                p81 k = confirmMPassPurchaseFragment.k();
                Objects.requireNonNull(k);
                xt.t1 t1Var = xt.f3961a;
                t1Var.c().d0(k.g.getPassengerType(), SuperPassPaymentConstants.PAYMENT_MODE_CASH);
                t1Var.c().c0(k.g, SuperPassPaymentConstants.PAYMENT_MODE_CASH);
                return;
            }
            c81 c81 = confirmMPassPurchaseFragment.h;
            if (c81 != null) {
                c81.d(true);
            } else {
                n86.l("viewModel");
                throw null;
            }
        }
    }
}
