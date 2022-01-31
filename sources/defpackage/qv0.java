package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.ui.fragments.ProfileFragment;

/* renamed from: qv0  reason: default package */
/* compiled from: ProfileFragment */
public class qv0 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ ProfileRequestInfo g;
    public final /* synthetic */ ProfileFragment h;

    public qv0(ProfileFragment profileFragment, lm0 lm0, ProfileRequestInfo profileRequestInfo) {
        this.h = profileFragment;
        this.f = lm0;
        this.g = profileRequestInfo;
    }

    public void onClick(View view) {
        this.f.dismiss();
        xt.f3961a.L().g(this.g);
        ProfileFragment profileFragment = this.h;
        int i = ProfileFragment.H;
        profileFragment.v();
    }
}
