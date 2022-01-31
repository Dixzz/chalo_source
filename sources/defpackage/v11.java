package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: v11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class v11 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;
    public final /* synthetic */ SuperPass g;
    public final /* synthetic */ hm0 h;

    public /* synthetic */ v11(hm0 hm0, SuperPass superPass, hm0 hm02) {
        this.f = hm0;
        this.g = superPass;
        this.h = hm02;
    }

    public final void onClick(View view) {
        hm0 hm0 = this.f;
        SuperPass superPass = this.g;
        hm0 hm02 = this.h;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        hj1.E0(superPass, "$lSuperPass", hm02, "$this_apply", hm0);
        gi1.h(gi1.f1265a, "activation duration expired dialog ok clicked", superPass, "sound fragment", 0, 8);
        Intent intent = new Intent(hm02.getContext(), HomeActivity.class);
        intent.setFlags(268468224);
        hm02.startActivity(intent);
    }
}
