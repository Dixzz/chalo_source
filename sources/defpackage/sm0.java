package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import app.zophop.R;
import com.google.firebase.appindexing.Indexable;
import com.razorpay.AnalyticsConstants;
import java.util.Objects;

/* renamed from: sm0  reason: default package */
/* compiled from: PreferenceDialogFragment */
public class sm0 extends DialogFragment implements View.OnClickListener {
    public TextView f;
    public TextView g;
    public CheckBox h;
    public CheckBox i;
    public int j;
    public int k;
    public final SeekBar.OnSeekBarChangeListener l = new a();

    /* renamed from: sm0$a */
    /* compiled from: PreferenceDialogFragment */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (seekBar.getId() == R.id.walk_distance_seekbar) {
                sm0 sm0 = sm0.this;
                Objects.requireNonNull(sm0);
                sm0.j = i * 100;
                sm0 sm02 = sm0.this;
                sm02.a(sm02.j, sm02.f, " meter");
                return;
            }
            sm0 sm03 = sm0.this;
            sm03.k = i;
            sm03.a(i, sm03.g, " km");
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* renamed from: sm0$b */
    /* compiled from: PreferenceDialogFragment */
    public static class b {
    }

    public final void a(int i2, TextView textView, String str) {
        if (i2 == 0 || i2 == 1) {
            textView.setText(i2 + str);
            return;
        }
        textView.setText(i2 + str + "s");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.preference_cancel:
                dismiss();
                return;
            case R.id.preference_done:
                boolean isChecked = this.h.isChecked();
                boolean isChecked2 = this.i.isChecked();
                sf1 sf1 = new sf1(getActivity().getSharedPreferences("tripPlannerPreferences", 0), AnalyticsConstants.PREFERENCES);
                sf1.put("pref_ac", String.valueOf(isChecked));
                sf1.put("pref_non_ac", String.valueOf(isChecked2));
                sf1.put("pref_walk_dist", String.valueOf(this.j));
                sf1.put("pre_auto_dist", String.valueOf(this.k * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
                jz5.b().i(new b());
                dismiss();
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.preference_screen, (ViewGroup) null);
        this.h = (CheckBox) inflate.findViewById(R.id.ac_checkbox);
        this.i = (CheckBox) inflate.findViewById(R.id.non_ac_checkbox);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.walk_distance_seekbar);
        seekBar.setOnSeekBarChangeListener(this.l);
        SeekBar seekBar2 = (SeekBar) inflate.findViewById(R.id.auto_distance_seekbar);
        seekBar2.setOnSeekBarChangeListener(this.l);
        this.f = (TextView) inflate.findViewById(R.id.walk_distance_value);
        this.g = (TextView) inflate.findViewById(R.id.auto_distance_value);
        inflate.findViewById(R.id.preference_cancel).setOnClickListener(this);
        inflate.findViewById(R.id.preference_done).setOnClickListener(this);
        sf1 sf1 = new sf1(getActivity().getSharedPreferences("tripPlannerPreferences", 0), AnalyticsConstants.PREFERENCES);
        if (vn.i0(sf1)) {
            this.h.setChecked(true);
        } else {
            this.h.setChecked(false);
        }
        if (vn.j0(sf1)) {
            this.i.setChecked(true);
        } else {
            this.i.setChecked(false);
        }
        this.k = vn.V(sf1) / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
        this.j = vn.W(sf1);
        seekBar2.setProgress(this.k);
        a(this.k, this.g, " km");
        seekBar.setProgress(this.j / 100);
        a(this.j, this.f, " meter");
        getDialog().getWindow().requestFeature(1);
        getDialog().setCanceledOnTouchOutside(false);
        return inflate;
    }
}
