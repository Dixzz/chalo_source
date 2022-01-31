package defpackage;

import android.view.View;
import app.zophop.ui.fragments.UserDetailsFragment;

/* renamed from: dx0  reason: default package */
/* compiled from: UserDetailsFragment */
public class dx0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ UserDetailsFragment g;

    public dx0(UserDetailsFragment userDetailsFragment, int i) {
        this.g = userDetailsFragment;
        this.f = i;
    }

    public void onClick(View view) {
        ed1 ed1 = new ed1("proof clicked", Long.MIN_VALUE);
        ed1.a("proofPosition", Integer.valueOf(this.f));
        jz5.b().g(ed1);
        UserDetailsFragment userDetailsFragment = this.g;
        userDetailsFragment.z = this.f;
        if (UserDetailsFragment.a(userDetailsFragment)) {
            UserDetailsFragment userDetailsFragment2 = this.g;
            if (userDetailsFragment2.o) {
                userDetailsFragment2.y = vn.S0(userDetailsFragment2);
            }
        }
    }
}
