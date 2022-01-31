package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;

/* renamed from: rx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class rx0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardDetailsFragment f3143a;

    public /* synthetic */ rx0(CardDetailsFragment cardDetailsFragment) {
        this.f3143a = cardDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        FragmentManager supportFragmentManager;
        CardDetailsFragment cardDetailsFragment = this.f3143a;
        Boolean bool = (Boolean) obj;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        n86.d(bool, "lShouldShow");
        if (bool.booleanValue()) {
            ve activity = cardDetailsFragment.c();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                Fragment I = supportFragmentManager.I("TagCardDetailsFragmentLoader");
                if (I != null) {
                    cardDetailsFragment.k = (gv0) I;
                }
                if (cardDetailsFragment.k == null) {
                    cardDetailsFragment.k = vn.U(null, cardDetailsFragment.getString(R.string.loading_pass), true, false);
                }
                gv0 gv0 = cardDetailsFragment.k;
                if (gv0 != null) {
                    gv0.show(supportFragmentManager, "TagCardDetailsFragmentLoader");
                    return;
                }
                return;
            }
            return;
        }
        gv0 gv02 = cardDetailsFragment.k;
        if (gv02 != null) {
            gv02.dismiss();
        }
    }
}
