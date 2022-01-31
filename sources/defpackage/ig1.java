package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import app.zophop.utilities.R;

/* renamed from: ig1  reason: default package */
/* compiled from: FavoriteDialog */
public abstract class ig1 extends DialogFragment {
    public a f;
    public TextView g;
    public EditText h;
    public RadioGroup i;
    public TextView j;

    /* renamed from: ig1$a */
    /* compiled from: FavoriteDialog */
    public enum a {
        EDIT_FAVORITE,
        RECENT
    }

    public abstract void a(View view, mf1 mf1);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.saved_destination_desc_dialog, (ViewGroup) null, true);
        getDialog().setCanceledOnTouchOutside(false);
        Bundle arguments = getArguments();
        String string = arguments.getString("descriptive_location_key");
        this.f = a.valueOf(arguments.getString("favorite_dialog_trigger_origin"));
        mf1 a2 = mf1.a(string);
        String str = a2.c;
        pn0 pn0 = (pn0) this;
        pn0.i = (RadioGroup) inflate.findViewById(R.id.radioGroup);
        pn0.j = (TextView) inflate.findViewById(R.id.negative);
        pn0.h = (EditText) inflate.findViewById(R.id.ET_saved_desc);
        pn0.g = (TextView) inflate.findViewById(R.id.positive);
        if (pn0.f.equals(a.EDIT_FAVORITE)) {
            pn0.h.setText(str);
        }
        if (str.equals("Home")) {
            pn0.i.check(R.id.radio_home);
            pn0.h.setVisibility(8);
            pn0.h.setText(pn0.getString(R.string.saved_destination_dialog_home));
        } else if (str.equals("Work")) {
            pn0.i.check(R.id.radio_work);
            pn0.h.setVisibility(8);
            pn0.h.setText(pn0.getString(R.string.saved_destination_dialog_work));
        } else {
            pn0.i.check(R.id.radio_other);
        }
        pn0.g.setTextColor(pn0.getResources().getColor(app.zophop.R.color.orange_primary));
        this.h.setOnEditorActionListener(new fg1(this, a2));
        this.g.setOnClickListener(new gg1(this, a2));
        this.j.setOnClickListener(new eg1(this));
        this.i.setOnCheckedChangeListener(new hg1(this));
        return inflate;
    }
}
