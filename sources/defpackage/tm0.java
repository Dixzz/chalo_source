package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import app.zophop.R;
import defpackage.i61;
import java.util.List;

/* renamed from: tm0  reason: default package */
/* compiled from: RadioDialogFragment */
public abstract class tm0 extends DialogFragment {
    public TextView f;
    public RadioGroup g;
    public String h;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.radio_dialog, (ViewGroup) null, false);
        getDialog().setCanceledOnTouchOutside(false);
        Bundle arguments = getArguments();
        ln0 ln0 = (ln0) this;
        ln0.l = arguments.getStringArrayList("radio_options");
        ln0.h = arguments.getString("dialog_title");
        ln0.j = i61.a.valueOf(arguments.getString("input_type"));
        if (arguments.getString("current_input") != null) {
            ln0.k = arguments.getString("current_input");
        }
        if (ln0.getTargetFragment() != null) {
            ln0.i = (i61) ln0.getTargetFragment();
        } else {
            ln0.i = (i61) ln0.getActivity();
        }
        this.f = (TextView) inflate.findViewById(R.id.done);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel);
        this.g = (RadioGroup) inflate.findViewById(R.id.radio_group);
        ((TextView) inflate.findViewById(R.id.title)).setText(this.h);
        List<String> list = ln0.l;
        if (list != null) {
            for (String str : list) {
                RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.dialog_radio_button, (ViewGroup) null);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
                layoutParams.setMargins(10, 10, 10, 10);
                radioButton.setLayoutParams(layoutParams);
                radioButton.setText(str);
                radioButton.setTag(Integer.valueOf(i));
                ln0.g.addView(radioButton);
                if (str.equalsIgnoreCase(ln0.k)) {
                    radioButton.setChecked(true);
                }
                radioButton.setOnClickListener(new kn0(ln0));
                i++;
            }
        }
        return inflate;
    }
}
