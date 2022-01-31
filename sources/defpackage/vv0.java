package defpackage;

import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.fragments.ProfileFragment;

/* renamed from: vv0  reason: default package */
/* compiled from: ProfileFragment */
public class vv0 implements View.OnClickListener {
    public final /* synthetic */ ProfileFragment f;

    public vv0(ProfileFragment profileFragment) {
        this.f = profileFragment;
    }

    public void onClick(View view) {
        Toast.makeText(this.f.getActivity(), this.f.getString(R.string.no_option), 1).show();
    }
}
