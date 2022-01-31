package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;
import app.zophop.ui.activities.MPassVerificationStatusActivity;

/* renamed from: x90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class x90 implements View.OnClickListener {
    public final /* synthetic */ MPassVerificationStatusActivity f;

    public /* synthetic */ x90(MPassVerificationStatusActivity mPassVerificationStatusActivity) {
        this.f = mPassVerificationStatusActivity;
    }

    public final void onClick(View view) {
        MPassVerificationStatusActivity mPassVerificationStatusActivity = this.f;
        int i = MPassVerificationStatusActivity.m;
        n86.e(mPassVerificationStatusActivity, "this$0");
        ed1 ed1 = new ed1("mPass verification status view details clicked", Long.MIN_VALUE);
        ed1.a("source", mPassVerificationStatusActivity.u0());
        mPassVerificationStatusActivity.s0(ed1);
        ui1.m0(ed1);
        BookingSummaryMagicPassActivity.p = MPassVerificationStatusActivity.class.getSimpleName();
        Intent intent = new Intent(mPassVerificationStatusActivity, BookingSummaryMagicPassActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("magic_pass_info", mPassVerificationStatusActivity.t0());
        mPassVerificationStatusActivity.startActivity(intent);
        mPassVerificationStatusActivity.finish();
    }
}
