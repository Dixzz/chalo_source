package defpackage;

import android.content.Context;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import defpackage.on0;

/* renamed from: y51  reason: default package */
/* compiled from: ConfirmSuperPassPurchaseFragment.kt */
public final class y51 implements on0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f4003a;

    public y51(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f4003a = confirmSuperPassPurchaseFragment;
    }

    @Override // defpackage.on0.a
    public void a() {
        ConfirmSuperPassPurchaseFragment.i(this.f4003a, true);
        ba1 ba1 = this.f4003a.h;
        if (ba1 != null) {
            ba1.d(true);
            ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f4003a;
            ba1 ba12 = confirmSuperPassPurchaseFragment.h;
            if (ba12 != null) {
                ba12.f = false;
                SuperPassPurchaseSharedViewModel l = confirmSuperPassPurchaseFragment.l();
                Context requireContext = this.f4003a.requireContext();
                n86.d(requireContext, "requireContext()");
                l.h(requireContext);
                return;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.on0.a
    public void b() {
        ConfirmSuperPassPurchaseFragment.i(this.f4003a, false);
    }
}
