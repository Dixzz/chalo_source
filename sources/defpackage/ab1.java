package defpackage;

import android.view.View;
import app.zophop.ui.activities.MTicketSelectionActivity;
import defpackage.cb1;

/* renamed from: ab1  reason: default package */
/* compiled from: MTicketPassengerDetailsView */
public class ab1 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ cb1 g;

    public ab1(cb1 cb1, String str) {
        this.g = cb1;
        this.f = str;
    }

    public void onClick(View view) {
        cb1.a aVar = this.g.g;
        MTicketSelectionActivity mTicketSelectionActivity = (MTicketSelectionActivity) aVar;
        mTicketSelectionActivity.s.get(this.f).incrementPassengerCount();
        mTicketSelectionActivity.x.a();
        mTicketSelectionActivity.B0(true);
    }
}
