package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.fragments.UserProofsOverviewFragment;
import com.razorpay.AnalyticsConstants;

/* renamed from: bt0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bt0 implements View.OnClickListener {
    public final /* synthetic */ UserProofsOverviewFragment f;

    public /* synthetic */ bt0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f = userProofsOverviewFragment;
    }

    public final void onClick(View view) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f;
        int i = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        ed1 ed1 = new ed1("userProofsOverview reapply clicked", Long.MIN_VALUE);
        ed1.a(AnalyticsConstants.FLOW, userProofsOverviewFragment.j().f);
        userProofsOverviewFragment.i(ed1);
        ui1.m0(ed1);
        ve activity = userProofsOverviewFragment.c();
        if (activity != null) {
            Intent intent = new Intent(activity, ProductSelectionActivity.class);
            intent.putExtra("source", "Home Screen");
            activity.startActivity(intent);
            activity.finish();
        }
    }
}
