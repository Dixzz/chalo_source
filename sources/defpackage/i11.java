package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;

/* renamed from: i11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class i11 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;
    public final /* synthetic */ SuperPass g;
    public final /* synthetic */ hm0 h;

    public /* synthetic */ i11(hm0 hm0, SuperPass superPass, hm0 hm02) {
        this.f = hm0;
        this.g = superPass;
        this.h = hm02;
    }

    public final void onClick(View view) {
        hm0 hm0 = this.f;
        SuperPass superPass = this.g;
        hm0 hm02 = this.h;
        ActiveSuperPassVisualValidationFragment.a aVar = ActiveSuperPassVisualValidationFragment.i;
        hj1.E0(superPass, "$lSuperPass", hm02, "$this_apply", hm0);
        gi1.h(gi1.f1265a, "activation duration expired dialog ok clicked", superPass, "Active Super Pass Visual validation Fragment", 0, 8);
        Intent intent = new Intent(hm02.getContext(), HomeActivity.class);
        intent.setFlags(268468224);
        hm02.startActivity(intent);
    }
}
