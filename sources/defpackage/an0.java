package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: an0  reason: default package */
/* compiled from: RenewErrorDialog */
public class an0 extends DialogFragment {
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.renew_error_dialog, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.view_container);
        this.h = (TextView) inflate.findViewById(R.id.title);
        this.i = (TextView) inflate.findViewById(R.id.sub_title);
        this.f = (TextView) inflate.findViewById(R.id.renew_cancel);
        this.g = (TextView) inflate.findViewById(R.id.new_pass);
        inflate.findViewById(R.id.renew_cancel).setOnClickListener(new ym0(this));
        inflate.findViewById(R.id.new_pass).setOnClickListener(new zm0(this));
        String string = getArguments().getString("renew_title");
        String string2 = getArguments().getString("renew_subtitle");
        String string3 = getArguments().getString("renew_cancel_btn");
        String string4 = getArguments().getString("renew_buy_pass_btn");
        this.h.setText(string);
        this.i.setText(string2);
        this.f.setText(string3);
        this.g.setText(string4);
        if (string3.equalsIgnoreCase(getString(R.string.edit_renew_pass_details))) {
            this.f.setTextColor(getResources().getColor(R.color.loader_color));
        }
        getDialog().getWindow().requestFeature(1);
        getDialog().setCanceledOnTouchOutside(false);
        return inflate;
    }
}
