package defpackage;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.activities.SuperPassBookingSuccessActivity;
import app.zophop.ui.activities.SuperPassValidationActivity;
import com.razorpay.AnalyticsConstants;

/* renamed from: ka0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ka0 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBookingSuccessActivity f;

    public /* synthetic */ ka0(SuperPassBookingSuccessActivity superPassBookingSuccessActivity) {
        this.f = superPassBookingSuccessActivity;
    }

    public final void onClick(View view) {
        SuperPassBookingSuccessActivity superPassBookingSuccessActivity = this.f;
        int i = SuperPassBookingSuccessActivity.n;
        n86.e(superPassBookingSuccessActivity, "this$0");
        ed1 ed1 = new ed1("booking success use now clicked", Long.MIN_VALUE);
        ed1.a("canActivate", Boolean.valueOf(superPassBookingSuccessActivity.m));
        superPassBookingSuccessActivity.s0(ed1);
        ui1.m0(ed1);
        if (superPassBookingSuccessActivity.m) {
            SuperPassSubType t0 = superPassBookingSuccessActivity.t0();
            String str = superPassBookingSuccessActivity.k;
            if (str != null) {
                n86.e(superPassBookingSuccessActivity, AnalyticsConstants.CONTEXT);
                n86.e(t0, "superPassSubType");
                n86.e(str, "superPassId");
                n86.e("sourceSuperPassBookingSuccessActivity", "source");
                Intent intent = new Intent(superPassBookingSuccessActivity, SuperPassValidationActivity.class);
                intent.putExtra("arg_super_pass_sub_type", (Parcelable) t0);
                intent.putExtra("arg_super_pass_id", str);
                intent.putExtra("arg_source", "sourceSuperPassBookingSuccessActivity");
                superPassBookingSuccessActivity.startActivity(intent);
                return;
            }
            n86.l("superPassId");
            throw null;
        }
        superPassBookingSuccessActivity.u0();
    }
}
