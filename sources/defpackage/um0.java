package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: um0  reason: default package */
/* compiled from: RadioOptionsDialogFragment.kt */
public abstract class um0 extends ue {
    public TextView f;
    public RadioGroup g;
    public String h;

    public void d(Bundle bundle) {
        this.h = bundle == null ? null : bundle.getString("dialog_title");
    }

    public abstract void e();

    public abstract void f(LayoutInflater layoutInflater);

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.radio_dialog, (ViewGroup) null, false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        d(getArguments());
        n86.d(inflate, "lView");
        this.f = (TextView) inflate.findViewById(R.id.done);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel);
        this.g = (RadioGroup) inflate.findViewById(R.id.radio_group);
        ((TextView) inflate.findViewById(R.id.title)).setText(this.h);
        f(layoutInflater);
        e();
        return inflate;
    }
}
