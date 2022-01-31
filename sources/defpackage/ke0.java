package defpackage;

import android.view.View;
import app.zophop.ui.activities.MTicketSelectionActivity;

/* renamed from: ke0  reason: default package */
/* compiled from: MTicketSelectionActivity */
public class ke0 implements View.OnClickListener {
    public final /* synthetic */ MTicketSelectionActivity f;

    public ke0(MTicketSelectionActivity mTicketSelectionActivity) {
        this.f = mTicketSelectionActivity;
    }

    public void onClick(View view) {
        MTicketSelectionActivity mTicketSelectionActivity = this.f;
        if (mTicketSelectionActivity.F != null) {
            mn0.a(mTicketSelectionActivity.getFragmentManager(), this.f.F.getMTicketConfiguration().getId());
        }
    }
}
