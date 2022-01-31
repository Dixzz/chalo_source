package defpackage;

import android.view.View;
import app.zophop.ui.activities.MPassVerificationStatusActivity;

/* renamed from: y90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class y90 implements View.OnClickListener {
    public final /* synthetic */ MPassVerificationStatusActivity f;

    public /* synthetic */ y90(MPassVerificationStatusActivity mPassVerificationStatusActivity) {
        this.f = mPassVerificationStatusActivity;
    }

    public final void onClick(View view) {
        MPassVerificationStatusActivity mPassVerificationStatusActivity = this.f;
        int i = MPassVerificationStatusActivity.m;
        n86.e(mPassVerificationStatusActivity, "this$0");
        ed1 ed1 = new ed1("mPass verification status ok clicked", Long.MIN_VALUE);
        ed1.a("source", mPassVerificationStatusActivity.u0());
        mPassVerificationStatusActivity.s0(ed1);
        ui1.m0(ed1);
        mPassVerificationStatusActivity.onBackPressed();
    }
}
