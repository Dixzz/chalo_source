package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.ui.activities.MTicketSelectionActivity;
import defpackage.cb1;
import java.util.HashMap;

/* renamed from: bb1  reason: default package */
/* compiled from: MTicketPassengerDetailsView */
public class bb1 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ cb1 g;

    public bb1(cb1 cb1, String str) {
        this.g = cb1;
        this.f = str;
    }

    public void onClick(View view) {
        int i;
        cb1.a aVar = this.g.g;
        MTicketSelectionActivity mTicketSelectionActivity = (MTicketSelectionActivity) aVar;
        mTicketSelectionActivity.s.get(this.f).decrementPassengerCount();
        mTicketSelectionActivity.x.a();
        HashMap<String, MTicketPassengerInfo> hashMap = mTicketSelectionActivity.s;
        if (hashMap == null || hashMap.size() == 0) {
            i = 0;
        } else {
            i = 0;
            for (String str : mTicketSelectionActivity.s.keySet()) {
                if (mTicketSelectionActivity.s.get(str).getPassengerCount() == 0) {
                    i++;
                }
            }
        }
        if (i == mTicketSelectionActivity.s.size()) {
            mTicketSelectionActivity.B0(false);
        } else {
            mTicketSelectionActivity.B0(true);
        }
    }
}
