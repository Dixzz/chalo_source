package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import com.razorpay.AnalyticsConstants;

/* renamed from: r51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class r51 implements View.OnClickListener {
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f;

    public /* synthetic */ r51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f = superPassUserProofsOverviewFragment;
    }

    public final void onClick(View view) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f;
        int i = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        ed1 ed1 = new ed1("userProofsOverview reapply clicked", Long.MIN_VALUE);
        ed1.a(AnalyticsConstants.FLOW, superPassUserProofsOverviewFragment.j().f);
        superPassUserProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        ve activity = superPassUserProofsOverviewFragment.c();
        if (activity != null) {
            Intent intent = new Intent(activity, ProductSelectionActivity.class);
            intent.putExtra("source", "Home Screen");
            activity.startActivity(intent);
            activity.finish();
        }
    }
}
