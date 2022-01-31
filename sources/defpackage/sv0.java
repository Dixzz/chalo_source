package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.Gender;
import app.zophop.ui.fragments.ProfileFragment;
import defpackage.i61;

/* renamed from: sv0  reason: default package */
/* compiled from: ProfileFragment */
public class sv0 implements View.OnClickListener {
    public final /* synthetic */ ProfileFragment f;

    public sv0(ProfileFragment profileFragment) {
        this.f = profileFragment;
    }

    public void onClick(View view) {
        String str;
        ProfileFragment profileFragment = this.f;
        Gender gender = profileFragment.j;
        if (gender == null) {
            str = "";
        } else {
            str = profileFragment.getString(gender.getResId());
        }
        ProfileFragment profileFragment2 = this.f;
        ln0.a(profileFragment2, profileFragment2.getFragmentManager(), this.f.getString(R.string.select_gender), i61.a.GENDER, str, this.f.r);
    }
}
