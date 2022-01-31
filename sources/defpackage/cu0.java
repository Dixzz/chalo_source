package defpackage;

import app.zophop.models.mTicketing.MPass;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;
import defpackage.on0;

/* renamed from: cu0  reason: default package */
/* compiled from: ConfirmMPassPurchaseFragment.kt */
public final class cu0 implements on0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMPassPurchaseFragment f752a;
    public final /* synthetic */ MPass b;

    public cu0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment, MPass mPass) {
        this.f752a = confirmMPassPurchaseFragment;
        this.b = mPass;
    }

    @Override // defpackage.on0.a
    public void a() {
        ConfirmMPassPurchaseFragment.i(this.f752a, true);
        c81 c81 = this.f752a.h;
        if (c81 != null) {
            c81.d(true);
            if (this.b.is_isVerificationRequired()) {
                c81 c812 = this.f752a.h;
                if (c812 != null) {
                    c812.f = true;
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            this.f752a.k().h();
            return;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.on0.a
    public void b() {
        ConfirmMPassPurchaseFragment.i(this.f752a, false);
    }
}
