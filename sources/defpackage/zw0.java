package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.ui.fragments.UserDetailsFragment;
import defpackage.i61;

/* renamed from: zw0  reason: default package */
/* compiled from: UserDetailsFragment */
public class zw0 implements View.OnClickListener {
    public final /* synthetic */ UserDetailsFragment f;

    public zw0(UserDetailsFragment userDetailsFragment) {
        this.f = userDetailsFragment;
    }

    public void onClick(View view) {
        String str;
        UserDetailsFragment userDetailsFragment = this.f;
        Gender gender = userDetailsFragment.i;
        if (gender == null) {
            str = "";
        } else {
            str = userDetailsFragment.getString(gender.getResId());
        }
        jz5.b().g(hj1.l("gender changed", Long.MIN_VALUE, SuperPassJsonKeys.GENDER, str));
        UserDetailsFragment userDetailsFragment2 = this.f;
        ln0.a(userDetailsFragment2, userDetailsFragment2.getFragmentManager(), this.f.getString(R.string.select_gender), i61.a.GENDER, str, this.f.q);
        jz5.b().g(new ed1("gender change event", Long.MIN_VALUE));
    }
}
