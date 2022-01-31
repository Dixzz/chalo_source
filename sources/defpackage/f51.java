package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.models.mTicketing.Gender;
import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;
import java.util.ArrayList;

/* renamed from: f51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class f51 implements View.OnClickListener {
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f;

    public /* synthetic */ f51(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f = superPassBasicUserDetailsFragment;
    }

    public final void onClick(View view) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        superPassBasicUserDetailsFragment.k();
        ve activity = superPassBasicUserDetailsFragment.c();
        String str = null;
        FragmentManager supportFragmentManager = activity == null ? null : activity.getSupportFragmentManager();
        Gender d = superPassBasicUserDetailsFragment.j().h().d();
        if (d != null) {
            str = d.name();
        }
        ArrayList<Gender> arrayList = superPassBasicUserDetailsFragment.j().d;
        a61 a61 = new a61(superPassBasicUserDetailsFragment);
        n86.e("Select Gender", "lTitle");
        n86.e(arrayList, "radioOptions");
        n86.e(a61, "lCallback");
        mm0 mm0 = new mm0();
        Bundle c = hj1.c("dialog_title", "Select Gender", "current_selection", str);
        c.putParcelableArrayList("radio_options", arrayList);
        mm0.setArguments(c);
        mm0.i = a61;
        if (supportFragmentManager != null) {
            mm0.show(supportFragmentManager, ln0.m);
        }
    }
}
