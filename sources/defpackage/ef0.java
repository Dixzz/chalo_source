package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.MPassPurchaseActivity;
import app.zophop.ui.activities.RenewMagicPassActivity;

/* renamed from: ef0  reason: default package */
/* compiled from: RenewMagicPassActivity */
public class ef0 implements View.OnClickListener {
    public final /* synthetic */ RenewMagicPassActivity f;

    public ef0(RenewMagicPassActivity renewMagicPassActivity) {
        this.f = renewMagicPassActivity;
    }

    public void onClick(View view) {
        sa1 sa1;
        LinearLayout linearLayout = this.f._renewContainer;
        int i = 0;
        while (true) {
            if (i >= linearLayout.getChildCount()) {
                sa1 = null;
                break;
            }
            if (linearLayout.getChildAt(i) instanceof sa1) {
                sa1 = (sa1) linearLayout.getChildAt(i);
                if (sa1.i.isChecked()) {
                    break;
                }
            }
            i++;
        }
        if (sa1 == null) {
            Toast.makeText(this.f, "Please select a pass type", 0).show();
            return;
        }
        String numberOfDays = sa1.getNumberOfDays();
        this.f.m.setFare(sa1.getFare());
        this.f.m.setNoOfDays(Integer.parseInt(numberOfDays));
        RenewMagicPassActivity renewMagicPassActivity = this.f;
        long parseLong = (Long.parseLong(numberOfDays) * 86400000) + renewMagicPassActivity.r;
        if (renewMagicPassActivity.m.getVerificationExpiryTime() == -1) {
            RenewMagicPassActivity renewMagicPassActivity2 = this.f;
            MPassPurchaseActivity.s0(renewMagicPassActivity2, "sourceRenewMagicPassActivity", "flowRenewPass", renewMagicPassActivity2.m, null);
        } else if (parseLong > this.f.m.getVerificationExpiryTime()) {
            RenewMagicPassActivity renewMagicPassActivity3 = this.f;
            if (renewMagicPassActivity3.m.getVerificationExpiryTime() < (((long) this.f.m.getNoOfDays()) * 86400000) + renewMagicPassActivity3.s) {
                RenewMagicPassActivity renewMagicPassActivity4 = this.f;
                RenewMagicPassActivity.k0(renewMagicPassActivity4, renewMagicPassActivity4.getString(R.string.validity_expired), this.f.getString(R.string.validity_expired_desc), this.f.getString(R.string.cancel_capital), this.f.getString(R.string.buy_new_pass));
                return;
            }
            RenewMagicPassActivity renewMagicPassActivity5 = this.f;
            RenewMagicPassActivity.k0(renewMagicPassActivity5, renewMagicPassActivity5.getString(R.string.validity_expired), this.f.getString(R.string.validity_expired_desc), this.f.getString(R.string.edit_renew_pass_details), this.f.getString(R.string.buy_new_pass));
        } else {
            RenewMagicPassActivity renewMagicPassActivity6 = this.f;
            MPassPurchaseActivity.s0(renewMagicPassActivity6, "sourceRenewMagicPassActivity", "flowRenewPass", renewMagicPassActivity6.m, null);
        }
    }
}
