package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;

/* renamed from: wz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wz0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBookingSummaryFragment f3864a;

    public /* synthetic */ wz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment) {
        this.f3864a = superPassBookingSummaryFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        FragmentManager supportFragmentManager;
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f3864a;
        Boolean bool = (Boolean) obj;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.d(bool, "lIsVisible");
        if (bool.booleanValue()) {
            ve activity = superPassBookingSummaryFragment.c();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                Fragment I = supportFragmentManager.I("TagBookingSummaryLoader");
                if (I != null) {
                    superPassBookingSummaryFragment.i = (gv0) I;
                }
                if (superPassBookingSummaryFragment.i == null) {
                    superPassBookingSummaryFragment.i = vn.U(null, superPassBookingSummaryFragment.getString(R.string.loading_pass), false, false);
                }
                gv0 gv0 = superPassBookingSummaryFragment.i;
                if (gv0 != null) {
                    gv0.show(supportFragmentManager, "TagBookingSummaryLoader");
                    return;
                }
                return;
            }
            return;
        }
        gv0 gv02 = superPassBookingSummaryFragment.i;
        if (gv02 != null) {
            gv02.dismiss();
        }
    }
}
