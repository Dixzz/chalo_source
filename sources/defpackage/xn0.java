package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: xn0  reason: default package */
/* compiled from: ZophopSosDialog */
public class xn0 extends DialogFragment {
    public View f;
    public View g;
    public String h;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sos_dialog, (ViewGroup) null, false);
        this.g = inflate.findViewById(R.id.edit_details);
        this.f = inflate.findViewById(R.id.sendSos);
        ((TextView) inflate.findViewById(R.id.sos_message)).setText(xt.f3961a.a0().g());
        this.h = getArguments().getString("source");
        this.f.setOnClickListener(new un0(this));
        this.g.setOnClickListener(new vn0(this));
        inflate.findViewById(R.id.close_dialog).setOnClickListener(new wn0(this));
        return inflate;
    }
}
