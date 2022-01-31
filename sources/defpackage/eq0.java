package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.UniversalPassActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.razorpay.AnalyticsConstants;

/* renamed from: eq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class eq0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ eq0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        n86.e("universal pass hook clicked", "lName");
        n86.e("HomeScreenMainFragment", "lSource");
        ed1 ed1 = new ed1("universal pass hook clicked", Long.MIN_VALUE);
        ed1.a("source", "HomeScreenMainFragment");
        ui1.m0(ed1);
        UniversalPassActivity.a aVar2 = UniversalPassActivity.m;
        Context requireContext = homeScreenMainFragment.requireContext();
        n86.d(requireContext, "requireContext()");
        n86.e(requireContext, AnalyticsConstants.CONTEXT);
        n86.e("HomeScreenMainFragment", "lSource");
        Intent intent = new Intent(requireContext, UniversalPassActivity.class);
        intent.putExtra("source", "HomeScreenMainFragment");
        requireContext.startActivity(intent);
    }
}
