package defpackage;

import android.animation.ObjectAnimator;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;
import server.zophop.logicLayer.CsLogic;

/* renamed from: qc0  reason: default package */
/* compiled from: BookingSummaryMagicPassActivity */
public class qc0 implements View.OnClickListener {
    public final /* synthetic */ BookingSummaryMagicPassActivity f;

    public qc0(BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity) {
        this.f = bookingSummaryMagicPassActivity;
    }

    public void onClick(View view) {
        if (!this.f.n) {
            View findViewById = view.findViewById(R.id.viewExpansion);
            int i = this.f.m;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, "rotation", (float) i, (float) (i + CsLogic.ETA_FORCE_UPDATE_REDIS_TTL));
            ofFloat.setDuration(200L);
            ofFloat.start();
            BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity = this.f;
            int i2 = bookingSummaryMagicPassActivity.m + CsLogic.ETA_FORCE_UPDATE_REDIS_TTL;
            bookingSummaryMagicPassActivity.m = i2;
            bookingSummaryMagicPassActivity.m = i2 % 360;
            bookingSummaryMagicPassActivity.findViewById(R.id.attachment_layout).setVisibility(0);
            this.f.findViewById(R.id.attachments_container).setVisibility(0);
            this.f.n = true;
            return;
        }
        View findViewById2 = view.findViewById(R.id.viewExpansion);
        int i3 = this.f.m;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById2, "rotation", (float) i3, (float) (i3 - 180));
        ofFloat2.setDuration(200L);
        ofFloat2.start();
        BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity2 = this.f;
        int i4 = bookingSummaryMagicPassActivity2.m - 180;
        bookingSummaryMagicPassActivity2.m = i4;
        bookingSummaryMagicPassActivity2.m = i4 % 360;
        bookingSummaryMagicPassActivity2.findViewById(R.id.attachment_layout).setVisibility(8);
        this.f.findViewById(R.id.attachments_container).setVisibility(0);
        this.f.n = false;
    }
}
