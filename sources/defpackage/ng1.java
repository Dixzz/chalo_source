package defpackage;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.utilities.R;

/* renamed from: ng1  reason: default package */
/* compiled from: ReportFragment */
public class ng1 extends DialogFragment {
    public EditText f;

    public void a() {
        throw null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.report_fragment, (ViewGroup) null);
        tn0 tn0 = (tn0) this;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.view_container);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.sub_title);
        int i = R.id.report_cancel;
        TextView textView3 = (TextView) inflate.findViewById(i);
        int i2 = R.id.report_us;
        TextView textView4 = (TextView) inflate.findViewById(i2);
        tn0.f = (EditText) inflate.findViewById(R.id.report_feedback);
        TextView textView5 = (TextView) inflate.findViewById(app.zophop.R.id.title);
        tn0.i = textView5;
        textView5.setText(tn0.getString(app.zophop.R.string.help_us_improve));
        tn0.i.setTextColor(Color.parseColor("#DE000000"));
        TextView textView6 = (TextView) inflate.findViewById(app.zophop.R.id.sub_title);
        tn0.j = textView6;
        textView6.setText(tn0.getString(app.zophop.R.string.better_route_suggestion_string));
        tn0.j.setTextColor(Color.parseColor("#96000000"));
        TextView textView7 = (TextView) inflate.findViewById(app.zophop.R.id.report_cancel);
        tn0.k = textView7;
        textView7.setText(app.zophop.R.string.CANCEL);
        TextView textView8 = (TextView) inflate.findViewById(app.zophop.R.id.report_us);
        tn0.l = textView8;
        textView8.setText(app.zophop.R.string.REPORT);
        inflate.findViewById(app.zophop.R.id.view_container).setBackgroundColor(-1);
        inflate.findViewById(i).setOnClickListener(new kg1(this));
        inflate.findViewById(i2).setOnClickListener(new lg1(this));
        this.f.requestFocus();
        getDialog().getWindow().setSoftInputMode(4);
        this.f.setOnEditorActionListener(new mg1(this));
        if (tn0.getArguments() != null) {
            tn0.g = tn0.getArguments().getString("extra:request");
            tn0.h = tn0.getArguments().getString("extra:from");
        }
        getDialog().getWindow().requestFeature(1);
        getDialog().setCanceledOnTouchOutside(false);
        return inflate;
    }
}
