package defpackage;

import android.content.Intent;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.b;

/* renamed from: yq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yq0 implements nx4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f4079a;
    public final /* synthetic */ hx4 b;

    public /* synthetic */ yq0(HomeScreenMainFragment homeScreenMainFragment, hx4 hx4) {
        this.f4079a = homeScreenMainFragment;
        this.b = hx4;
    }

    @Override // defpackage.nx4
    public final void a(ey4 ey4) {
        HomeScreenMainFragment homeScreenMainFragment = this.f4079a;
        hx4 hx4 = this.b;
        n86.e(homeScreenMainFragment, "this$0");
        n86.e(hx4, "$lManager");
        n86.e(ey4, "task");
        if (ey4.f()) {
            ui1.m0(new ed1("in app ratings opened successfully", Long.MIN_VALUE));
            Object e = ey4.e();
            n86.d(e, "task.result");
            ReviewInfo reviewInfo = (ReviewInfo) e;
            ve activity = homeScreenMainFragment.c();
            if (activity != null) {
                Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
                intent.putExtra("confirmation_intent", reviewInfo.a());
                intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
                ay4 ay4 = new ay4();
                intent.putExtra("result_receiver", new b(hx4.b, ay4));
                activity.startActivity(intent);
                ey4<ResultT> ey42 = ay4.f348a;
                n86.d(ey42, "lManager.launchReviewFlow(it, lReviewInfo)");
                xq0 xq0 = xq0.f3952a;
                ey42.b.a(new tx4(rx4.f3146a, xq0));
                ey42.d();
                return;
            }
            return;
        }
        ui1.m0(new ed1("in app ratings failed", Long.MIN_VALUE));
        HomeScreenMainFragment.h(homeScreenMainFragment);
    }
}
