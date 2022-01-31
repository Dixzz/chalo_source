package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.ui.activities.ConfirmMagicPassActivity;

/* renamed from: zd0  reason: default package */
/* compiled from: ConfirmMagicPassActivity */
public class zd0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMagicPassActivity f;

    public zd0(ConfirmMagicPassActivity confirmMagicPassActivity) {
        this.f = confirmMagicPassActivity;
    }

    public void onClick(View view) {
        ConfirmMagicPassActivity.v.getUserProfile().getAgencyInfo().get(ConfirmMagicPassActivity.v.getAgency());
        ConfirmMagicPassActivity.v.setDeviceId(xt.f3961a.n().a());
        if (ConfirmMagicPassActivity.v.getStatus() != null && ConfirmMagicPassActivity.v.getStatus().equals("VERIFIED")) {
            this.f.j0();
        } else if (this.f.getIntent().getStringExtra("src").equalsIgnoreCase("renew_pass")) {
            this.f.j0();
        } else {
            MPass mPass = ConfirmMagicPassActivity.v;
            if (mPass == null || mPass.getStatus() == null || !ConfirmMagicPassActivity.v.getStatus().equals("PAYMENT_PENDING")) {
                ConfirmMagicPassActivity confirmMagicPassActivity = this.f;
                MPass mPass2 = ConfirmMagicPassActivity.v;
                ProfileRequestInfo profileRequestInfo = ConfirmMagicPassActivity.w;
                confirmMagicPassActivity.n0();
                mn0.a(this.f.getFragmentManager(), ConfirmMagicPassActivity.v.getConfigId());
                return;
            }
            this.f.j0();
        }
    }
}
