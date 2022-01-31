package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;
import app.zophop.ui.activities.MPassPurchaseActivity;

/* renamed from: sc0  reason: default package */
/* compiled from: BookingSummaryMagicPassActivity */
public class sc0 implements View.OnClickListener {
    public final /* synthetic */ BookingSummaryMagicPassActivity f;

    public sc0(BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity) {
        this.f = bookingSummaryMagicPassActivity;
    }

    public void onClick(View view) {
        if (!BookingSummaryMagicPassActivity.h0(this.f)) {
            if (!PassApplicationActionRequired.INVALID.equals(BookingSummaryMagicPassActivity.o.get_passApplicationActionRequired())) {
                MPassPurchaseActivity.s0(view.getContext(), "sourceBookingSummaryMagicPassActivity", "flowReapplication", BookingSummaryMagicPassActivity.o, null);
                return;
            }
            Intent intent = new Intent(view.getContext(), ProductSelectionActivity.class);
            intent.putExtra("magic_pass_info", BookingSummaryMagicPassActivity.o);
            intent.putExtra("src", BookingSummaryMagicPassActivity.p);
            this.f.startActivity(intent);
        }
    }
}
