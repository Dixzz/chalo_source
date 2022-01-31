package defpackage;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: lm0  reason: default package */
/* compiled from: ConfirmationDialog */
public class lm0 extends sn0 {
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public ImageView p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    public lm0(String str) {
        super(str);
    }

    public static lm0 a(FragmentManager fragmentManager, String str, String str2, String str3, String str4) {
        lm0 lm0 = new lm0();
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("extra:title_copy", str);
        }
        bundle.putString("extra:message_copy", str2);
        bundle.putString("extra:postive_action_copy", str3);
        if (str4 != null) {
            bundle.putString("extra:negative_action_copy", str4);
        }
        lm0.setArguments(bundle);
        lm0.show(fragmentManager, "confirmation_dialog");
        return lm0;
    }

    public static lm0 b(FragmentManager fragmentManager, String str, String str2, String str3, String str4, String str5) {
        lm0 lm0 = new lm0(null);
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("extra:title_copy", str);
        }
        bundle.putString("extra:message_copy", str2);
        bundle.putString("extra:postive_action_copy", str3);
        if (str4 != null) {
            bundle.putString("extra:negative_action_copy", str4);
        }
        lm0.setArguments(bundle);
        lm0.show(fragmentManager, "confirmation_dialog");
        return lm0;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.confirmation_dialog, (ViewGroup) null, false);
        Bundle arguments = getArguments();
        this.n = arguments.getString("extra:title_copy");
        this.l = arguments.getString("extra:postive_action_copy");
        this.k = arguments.getString("extra:negative_action_copy");
        this.m = arguments.getString("extra:message_copy");
        this.o = arguments.getInt("extra:drawable_resource_id");
        this.g = (TextView) inflate.findViewById(R.id.title);
        this.h = (TextView) inflate.findViewById(R.id.message);
        this.i = (TextView) inflate.findViewById(R.id.positive);
        this.j = (TextView) inflate.findViewById(R.id.negative);
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            this.i.setOnClickListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = this.r;
        if (onClickListener2 != null) {
            this.j.setOnClickListener(onClickListener2);
        }
        this.p = (ImageView) inflate.findViewById(R.id.confirmation_dialog_drawable);
        String str = this.n;
        if (str != null) {
            this.g.setText(str);
            this.g.setVisibility(0);
        } else {
            this.h.setAlpha(0.87f);
            this.g.setVisibility(8);
        }
        this.i.setText(this.l);
        this.j.setText(this.k);
        if (this.k != null) {
            this.j.setVisibility(0);
        }
        this.h.setText(this.m);
        if (this.o != 0) {
            this.p.setVisibility(0);
            ml1<zq1> k2 = gl1.d(getActivity()).k();
            k2.g(Integer.valueOf(this.o));
            k2.e(this.p);
        } else {
            this.p.setVisibility(8);
        }
        return inflate;
    }

    public lm0() {
    }
}
