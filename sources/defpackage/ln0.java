package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import defpackage.i61;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ln0  reason: default package */
/* compiled from: SelectDialog */
public class ln0 extends tm0 {
    public static final String m = ln0.class.getSimpleName();
    public i61 i;
    public i61.a j;
    public String k;
    public List<String> l;

    public static void a(Fragment fragment, FragmentManager fragmentManager, String str, i61.a aVar, String str2, ArrayList<String> arrayList) {
        ln0 ln0 = new ln0();
        Bundle bundle = new Bundle();
        bundle.putString("dialog_title", str);
        bundle.putString("input_type", aVar.name());
        bundle.putStringArrayList("radio_options", arrayList);
        if (str2 != null) {
            bundle.putString("current_input", str2);
        }
        ln0.setArguments(bundle);
        ln0.setTargetFragment(fragment, 0);
        ln0.show(fragmentManager, m);
    }

    @Override // defpackage.tm0
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        getDialog().setCanceledOnTouchOutside(true);
        ((LinearLayout) this.f.getParent()).setVisibility(8);
        return onCreateView;
    }
}
