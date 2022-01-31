package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.MTicketSelectionActivity;

/* renamed from: le0  reason: default package */
/* compiled from: MTicketSelectionActivity */
public class le0 implements View.OnClickListener {
    public final /* synthetic */ MTicketSelectionActivity f;

    public le0(MTicketSelectionActivity mTicketSelectionActivity) {
        this.f = mTicketSelectionActivity;
    }

    public void onClick(View view) {
        MTicketSelectionActivity mTicketSelectionActivity = this.f;
        mTicketSelectionActivity.E = mTicketSelectionActivity.C.c(mTicketSelectionActivity.getString(R.string.isTermsAndConditionSeen), false);
        MTicketSelectionActivity mTicketSelectionActivity2 = this.f;
        if (!mTicketSelectionActivity2.E) {
            mn0.a(mTicketSelectionActivity2.getFragmentManager(), this.f.F.getMTicketConfiguration().getId());
        } else {
            mTicketSelectionActivity2.w0();
        }
    }
}
