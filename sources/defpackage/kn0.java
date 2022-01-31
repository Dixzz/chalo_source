package defpackage;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/* renamed from: kn0  reason: default package */
/* compiled from: SelectDialog */
public class kn0 implements View.OnClickListener {
    public final /* synthetic */ ln0 f;

    public kn0(ln0 ln0) {
        this.f = ln0;
    }

    public void onClick(View view) {
        ln0 ln0 = this.f;
        RadioGroup radioGroup = ln0.g;
        ln0.i.c(ln0.j, ((Integer) ((RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getTag()).intValue());
        ln0.dismiss();
    }
}
