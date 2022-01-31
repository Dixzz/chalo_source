package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.models.mTicketing.Gender;
import app.zophop.ui.fragments.BasicUserDetailsFragment;
import java.util.ArrayList;

/* renamed from: ho0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ho0 implements View.OnClickListener {
    public final /* synthetic */ BasicUserDetailsFragment f;

    public /* synthetic */ ho0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f = basicUserDetailsFragment;
    }

    public final void onClick(View view) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        basicUserDetailsFragment.k();
        ve activity = basicUserDetailsFragment.c();
        String str = null;
        FragmentManager supportFragmentManager = activity == null ? null : activity.getSupportFragmentManager();
        Gender d = basicUserDetailsFragment.j().h().d();
        if (d != null) {
            str = d.name();
        }
        ArrayList<Gender> arrayList = basicUserDetailsFragment.j().d;
        gt0 gt0 = new gt0(basicUserDetailsFragment);
        n86.e("Select Gender", "lTitle");
        n86.e(arrayList, "radioOptions");
        n86.e(gt0, "lCallback");
        mm0 mm0 = new mm0();
        Bundle c = hj1.c("dialog_title", "Select Gender", "current_selection", str);
        c.putParcelableArrayList("radio_options", arrayList);
        mm0.setArguments(c);
        mm0.i = gt0;
        if (supportFragmentManager != null) {
            mm0.show(supportFragmentManager, ln0.m);
        }
    }
}
