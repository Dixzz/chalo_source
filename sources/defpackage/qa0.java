package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.SuperPassValidationActivity;

/* renamed from: qa0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qa0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ SuperPassValidationActivity g;

    public /* synthetic */ qa0(du0 du0, SuperPassValidationActivity superPassValidationActivity) {
        this.f = du0;
        this.g = superPassValidationActivity;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        SuperPassValidationActivity superPassValidationActivity = this.g;
        int i = SuperPassValidationActivity.l;
        n86.e(du0, "$lBottomSheet");
        n86.e(superPassValidationActivity, "this$0");
        du0.dismiss();
        du0.f = true;
        Intent intent = new Intent(superPassValidationActivity, HomeActivity.class);
        intent.setFlags(268468224);
        superPassValidationActivity.startActivity(intent);
    }
}
